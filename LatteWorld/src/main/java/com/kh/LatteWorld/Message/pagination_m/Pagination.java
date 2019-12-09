package com.kh.LatteWorld.Message.pagination_m;

import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;

public class Pagination {
	// PageInfo 객체를 리턴하는 static 메소드 추가
	public static PageInfoMessage getPageInfo(int currentPage, int listCount) {
		
		// 페이지 정보를 담아줄 PageInfo 참조변수 선언
		PageInfoMessage pi = null;
		
		// currentPage와 listCount가 넘어온 상태이기 때문에
		// 페이징 처리에 필요한 나머지 변수만 선언함
		
		int pageLimit = 10;	// 한 페이지에서 보여질 페이징 수
		int maxPage;		// 전체 페이징 수 중 가장 마지막 페이지
		int startPage;		// 현재 페이지에서 보여질 페이징 버튼의 시작 페이지
		int endPage;		// 현재 페이지에서 보여질 페이징 버튼의 끝 페이지
		

		int messageLimit = 20; // 한 페이지에 보여질 게시글 갯수
		
		/* maxPage = (int)((double)listCount/boardLimit + 0.8); */
		maxPage = (int)((double)listCount/messageLimit + 0.95);
		// case 1 : listCount가 1일 때 maxPage는 1이 되어야 한다.
		// case 2 : listCount가 5일 때 maxPage는 1이 되어야 한다.
		// case 3 : listCount가 6일 때 maxPage는 2가 되어야 한다.(다음 페이지 정도까지 생각해 보자)
	
		startPage = (((int)((double)currentPage/pageLimit + 0.95)) - 1) * pageLimit + 1;
		// pageLimit이 10일 때,
		// case 1 : currentPage가 1일 때 startPage는 1이 되어야 한다.
		// case 2 : currentPage가 10일 때 startPage는 1이 되어야 한다.
		// case 3 : currentPage가 11일 때 startPage는 11이 되어야 한다.
		// case 4 : currentPage가 20일 떄 startPage는 11이 되어야 한다.
		// 규칙을 보면 알겠지만 startPage는 pageLimit의 배수에 1을 더한 수라는 것을 알 수 있다.
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		pi = new PageInfoMessage(currentPage, listCount, pageLimit,
				maxPage, startPage, endPage, messageLimit);

		
		return pi;
		
		// SelectBoardListServlet으로 다시 ㄱㄱ씽~!
	}
}
