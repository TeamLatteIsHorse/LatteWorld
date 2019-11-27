package com.kh.LatteWorld.item.model.vo;

public class Pagination {
	// PageInfo 객체를 리턴하는 static 메소드 추가
		public static ItemPageInfo getPageInfo(int currentPage, int listCount) {
			
			// 페이지 정보를 담아줄 ItemPageInfo 참조변수 선언
			ItemPageInfo pi = null;
			
			// currentPage와 listCount가 넘어온 상태이기 때문에
			// 페이징 처리에 필요한 나머지 변수만 선언함
			
			int pageLimit = 5;	// 한 페이지에서 보여질 페이징 수
			int maxPage;		// 전체 페이징 수 중 가장 마지막 페이지
			int startPage;		// 현재 페이지에서 보여질 페이징 버튼의 시작 페이지
			int endPage;		// 현재 페이지에서 보여질 페이징 버튼의 끝 페이지
			
			int boardLimit = 10; // 한 페이지에 보여질 게시글 갯수
			
			maxPage = (int)((double)listCount/boardLimit + 0.9);
			// case 1 : listCount가 1일 때 maxPage는 1이 되어야 한다.
			// case 2 : listCount가 10일 때 maxPage는 1이 되어야 한다.
			// case 3 : listCount가 11일 때 maxPage는 2가 되어야 한다.(다음 페이지 정도까지 생각해 보자)
		
			startPage = (((int)((double)currentPage/pageLimit + 0.8)) - 1) * pageLimit + 1;
			// pageLimit이 5일 때,
			// case 1 : currentPage가 1일 때 startPage는 1이 되어야 한다.
			// case 2 : currentPage가 5일 때 startPage는 1이 되어야 한다.
			// case 3 : currentPage가 6일 때 startPage는 6이 되어야 한다.
			// case 4 : currentPage가 10일 떄 startPage는 6이 되어야 한다.
			// 규칙을 보면 알겠지만 startPage는 pageLimit의 배수에 1을 더한 수라는 것을 알 수 있다.
			
			endPage = startPage + pageLimit -1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			
			pi = new ItemPageInfo(currentPage, listCount, pageLimit,
					maxPage, startPage, endPage, boardLimit);
			
			return pi;
		}
}
