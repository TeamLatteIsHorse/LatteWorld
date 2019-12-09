package com.kh.LatteWorld.item.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.exception.lwException;
import com.kh.LatteWorld.item.model.service.ItemService;
import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;
import com.kh.LatteWorld.item.model.vo.KipItem;
import com.kh.LatteWorld.item.model.vo.Pagination;
import com.kh.LatteWorld.item.model.vo.Present;
import com.kh.LatteWorld.item.model.vo.UserItemList;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("itemStoreList.do")
	public ModelAndView itemStoreView(ModelAndView mv, 
								@RequestParam(value = "page", required=false) Integer page, String itemCategory, HttpSession session) {
		
		int currentPage = 1;
		String userId = "";
		
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
		
		if(loginUser == null) {
			userId = "";
		}else {
			userId = loginUser.getUserId();
		}
		
		// System.out.println(userId);
		
		if(page != null) {
			currentPage = page;
		}
		
		int itemListCount = itemService.getItemListCount();	// 아이템 리스트 갯수
		// System.out.println(itemListCount);
		
		ItemPageInfo pi = Pagination.getPageInfo(currentPage, itemListCount);	// 페이징처리
		
		ArrayList<ItemStore> allItemList = itemService.selectAllItemList();	
		// 매칭 넘버 비교하기위해서 아이템 리스트 전부를 불러와야한다. 
		// 밑에 itemList는 페이징처리된 아이템 리스트라서 다음페이지에있는 아이템중에 인기 상품이있으면 인기상품 버튼이 활성화 되어있을것이기 때문에
		
		
		ArrayList<ItemStore> itemList = itemService.selectItemList(pi);	// 아이템 리스트
		
		if(itemCategory == null) {
			itemCategory = "펫";
		}
		
		ArrayList<ItemStore> bestItemList = itemService.selectBestItemList(itemCategory);	// 인기상품 리스트
	
		int kipCount = itemService.getkipItemListCount(userId); // 찜목록 리스트 카운트
		// 이건 샵 페이징에서 찜목록 카운트가 10이상이면 추가 못하게하려고 추가한것
	
		ArrayList<KipItem> kipItemList = itemService.selectKipItemlist(userId);	// 찜목록 리스트 가져오기
		
		ArrayList kipItemNo = new ArrayList();
		
		for(int i = 0; i<allItemList.size(); i++) {
			for(int j = 0; j<kipItemList.size(); j++) {
				if(allItemList.get(i).getItemNo() == kipItemList.get(j).getItemNo()) {
					kipItemNo.add(kipItemList.get(j).getItemNo());
				}
			}
		}
		
		ArrayList<UserItemList> userItem = itemService.selectUserItemList(userId);	// 사용자 보유 아이템 리스트 불러오기
		
		ArrayList buyItemNo = new ArrayList();
		
		for(int i=0; i<userItem.size();i++) {
			buyItemNo.add(userItem.get(i).getItemNo());
		}
		/*
		 * System.out.println("kip : "+kipItemNo);
		 * System.out.println("buy : "+buyItemNo);
		 */
	
		if((itemList != null && itemList.size() > 0) && (bestItemList != null && bestItemList.size() >0)) {
			mv.addObject("itemList", itemList);
			mv.addObject("bestItemList", bestItemList);
			mv.addObject("pi", pi);
			mv.addObject("kipCount", kipCount);
			mv.addObject("kipItemList",kipItemList);
			mv.addObject("kipItemNo", kipItemNo);
			mv.addObject("buyItemNo", buyItemNo);
			mv.setViewName("item/itemStoreView");
		}else {
			throw new lwException("아이템샵 불러오기 실패!");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "buyItemView.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ModelAndView buyItemView(int itemNo, ModelAndView mv) {
		//System.out.println("서블릿 초기진입되니?");
		ItemStore item = itemService.buyItem(itemNo);
		//System.out.println("item은? : "+item);
		if(item == null) {
			throw new lwException("구매하기 페이지 이동 실패!");
		}else {
			//System.out.println("else문 들어오는거는?");
			mv.addObject("item",item);
			mv.setViewName("item/BuyItemView");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "kipItem.do", method = RequestMethod.POST)
	@ResponseBody
	public String kipItem(int itemNo, String userId) {
		ItemStore item = itemService.selectOneItem(itemNo);	// 찜목록 버튼 누른 해당 아이템 객체 가져오기
		// System.out.println(item);
		
		int insertItem = itemService.insertkipItem(item);	// 아이템 객체를 찜목록 테이블에 추가(이때 아이디값은 없으므로 null값)
		/* System.out.println("insertItem : "+insertItem); */
		
		int result = itemService.insertUser(userId);	// null처리되어있는 사용자 아이디 값 추가
		
		// System.out.println("result : "+result);
		
		if (result > 0) {
			return "ok";
		} else {
			throw new lwException("찜목록 저장 실패!");
		}
	}
	
	@RequestMapping(value = "buyItem.do", method = RequestMethod.POST)
	@ResponseBody
	public void buyItem(int itemNo, HttpSession session, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();		
		
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
		System.out.println(loginUser);
		String userId = loginUser.getUserId();
		int userPoint = itemService.selectUserPoint(userId);	// 로그인 되어있는 유저의 포인트 가져오기
		
		ItemStore item = itemService.selectOneItem(itemNo);	// 아이템 가격 뽑아오기 위해 객체 뽑아오기
		int itemMoney = item.getPrice();	//item가격 저장 변수
		loginUser.setItemPoint(itemMoney);	// 로그인 유저 포인츠 차감위해서 userInfo값 하나 추가하고 setter사용
		
		System.out.println("userPoint : "+userPoint);
		System.out.println("itemMoney : "+itemMoney);
		
		UserItemList insertItem = new UserItemList();	// 구매 아이템 객체 선언
		insertItem.setItemNo(itemNo);
		insertItem.setUserId(userId);
		
		if(item != null && userId != null) {
			//System.out.println("item, userId존재!");
			
			if(userPoint >= itemMoney) {
				int insertResult = itemService.insertBuyItem(insertItem);
				int updateUserPoint = itemService.updateUserPoint(loginUser);	// 해당 금액만큼 차단
				int updateAddItemCount = itemService.updateAddItemCount(itemNo);	// 구매 아이템 카운트 1증가!
				if(insertResult > 0 && updateUserPoint > 0 && updateAddItemCount > 0) {
					out.append("success");
					out.flush();
				}else {
					throw new lwException("itemList테이블 값 넣기 실패!");
				}
				
			}else {
				//System.out.println("여기까지 들어와야 정상!");
				out.append("lackPoint");	// 보유 금액 부족
				out.flush();
			}	
		}else {
			throw new lwException("구매하기 실패!");
		}		
		out.close();
	}
	
	@RequestMapping(value = "kipItemView.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ModelAndView kipItemView(String userId, ModelAndView mv) {
		//System.out.println(userId);
		
		ArrayList<KipItem> kipItemList = itemService.selectKipItemlist(userId);
		
		if(kipItemList != null) {
			mv.addObject("kipItemList", kipItemList);
			mv.setViewName("item/kipItemListView");
			return mv;
		}else {
			throw new lwException("찜목록 불러오기 실패!");
		}
		
	}
	
	@RequestMapping("delKipItem.do")
	public void deleteKipItem(int itemNo, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		int result = itemService.deleteKipItemList(itemNo);
		
		if(result > 0) {
			out.append("success");
			out.flush();
		}else {
			throw new lwException("찜목록 삭제 실패!");
		}
		out.close();
	}
	
	@RequestMapping("presentItem.do")
	public ModelAndView presentView(int itemNo, ModelAndView mv) {
		
		ItemStore item = itemService.selectOneItem(itemNo);
		
		if(item != null) {
			mv.addObject("item", item);
			mv.setViewName("item/PresentView");
		}else {
			throw new lwException("선물하기 뷰 화면 실패!");
		}	
		return mv;
	}
	
	@RequestMapping(value = "insertPresent.do", method = RequestMethod.POST)
	public void insertPresentItem(String presentUserId, int itemNo, String presentContent,
									HttpSession session, HttpServletResponse response) throws IOException{
		System.out.println("선물하기 버튼 누르고 들어와져?");
		PrintWriter out = response.getWriter();
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
		String userId = loginUser.getUserId();	// 선물 보낼 로그인 유저
		
		ItemStore item = itemService.selectOneItem(itemNo);	//해당 아이템 객체 생성
		System.out.println("선물할 아이템 객체 : "+itemNo);
		
		int userPoint = itemService.selectUserPoint(userId);	// 로그인 유저 금액 불러오기
		System.out.println("userPoint : "+userPoint);
		
		Present preItem = new Present();	// 선물 객체 생성
		preItem.setItemNo(itemNo);
		preItem.setPresentUserId(presentUserId);
		
		System.out.println("선물객체 1차 삽입 : "+preItem);
		
		UserItemList oneItem = new UserItemList();	// 선물받는 유저가 해당 아이템을 갖고있는지(아이템 번호랑 아이디값 넣어줘야됨)
		oneItem.setItemNo(itemNo);
		oneItem.setUserId(presentUserId);
		// setter로 필요한 값 삽입
		
		int haveItem = itemService.selecthaveOneItem(oneItem);	// 선물받는 유저가 이미 아이템을 갖고있는지
		System.out.println("이미갖고있니? : "+haveItem);
		int haveGift = itemService.selectOnePresentItem(preItem);	// 선물받을 유저가 선물함에 아이템이 있는지
		System.out.println("선물함에있니? : "+haveGift);
		if(haveItem <= 0) {
			if(haveGift <= 0) {	// 값이 0이여야 테이블에 아이템이 없는것!
				int itemMoney = item.getPrice();	//아이템 가격 저장
				System.out.println("itemMoney : "+itemMoney);
				
				if(userPoint >= itemMoney) {
					loginUser.setItemPoint(itemMoney);	//차감할 포인트 로그인유저에 저장
					
					preItem.setUserId(userId);
					preItem.setPresentContent(presentContent);
					preItem.setItemCategory(item.getItemCategory());
					preItem.setItemName(item.getItemName());
					preItem.setItemLink(item.getItemLink());
					// setter를 통해 선물객체 값 삽입
					System.out.println("선물객체 2차 삽입 후 : "+preItem);
					
					int updateUserPoint = itemService.updateUserPoint(loginUser);	// 해당 금액만큼 차감하기
					System.out.println("금액 차감 됬어? : "+updateUserPoint);
					int result = itemService.insertPresentItem(preItem);	// 선물 테이블에 담기
					System.out.println("선물 테이블값 넣기 성공? : "+result);
					int updateAddItemCount = itemService.updateAddItemCount(itemNo);	// 구매 아이템 카운트 1증가!
					
					if(updateUserPoint >0 && result > 0 && updateAddItemCount > 0) {
						out.append("success");
						out.flush();
					}else {
						throw new lwException("선물하기 실패!");
					}	
					
				}else {
					out.append("lackPoint");	// 포인트 부족!
					out.flush();
				}	
			}else {
				out.append("haveGift");	// 이미 선물함에 보유!
			}			
		}else {
			out.append("haveItem");	// 선물받는 유저가 해당 아이템 이미 보유!
		}
		out.close();	
	}
	
	@RequestMapping("sendItemView.do")
	public ModelAndView sendItem(@RequestParam(value = "userId") String userId, ModelAndView mv) {
		ArrayList<Present> sendList = itemService.selectSendItemList(userId);		
		if(sendList != null) {
			mv.addObject("sendList", sendList);
			mv.setViewName("item/sendItemView");
		}else {
			throw new lwException("보낸 선물함 리스트 불러오기 실패!");
		}
		return mv;
	}
	
	@RequestMapping("receiveItemView.do")
	public ModelAndView receiveItem(@RequestParam(value = "userId") String userId, ModelAndView mv) {
		ArrayList<Present> receiveItem = itemService.selectReceiveItemList(userId);
		
		if(receiveItem != null) {
			mv.addObject("receiveItem", receiveItem);
			mv.setViewName("item/receiveItemView");
		}
		
		return mv;
	}
	
	// 찜목록 포인트 비교 ajax
	@RequestMapping(value="checkPoint.do", method = RequestMethod.POST)
	public void checkPoint(HttpSession session, HttpServletResponse response, @RequestParam(value="list[]", required=false) List<String> list) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
		String userId = loginUser.getUserId();
		int userPoint = itemService.selectUserPoint(userId);
		PrintWriter out = response.getWriter();
		JSONObject job = new JSONObject();
		
		int itemNo=0;	//item번호
		int addPrice = 0;	// 총 합 가격
		String text = "";	// jsp로 같이 보낼 text(금액부족 확인차)
		if(list == null) {
			addPrice = 0;
		}else {
			for(String stringItemNo : list) {
				itemNo = Integer.valueOf(stringItemNo);
				
				ItemStore item = itemService.selectOneItem(itemNo);
				addPrice += item.getPrice();
			}
		}
		System.out.println("찜목록 체크 합한 가격 : "+addPrice);
		if(userPoint < addPrice) {
			text="warning";
			job.put("text",text);
		}else {
			text="hidewarning";
			job.put("text",text);
		}
		job.put("addPrice",addPrice);
		out.print(job);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "buyKipList.do", method = RequestMethod.POST)
	public void buyKipList(@RequestParam(value = "list[]", required = false) List<String> kipList,
							HttpSession session, HttpServletResponse response) throws IOException {
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");	// 아이템 넣을 로그인유저 객체 
		String userId = loginUser.getUserId();
		
		PrintWriter out = response.getWriter();
		
		int itemNo = 0;	// 뽑아온 리스트에서 아이템번호 담을 변수 선언
		int deleteResult = 0;	// 찜목록 삭제 확인 여부 변수
		int insertResult = 0;	// db테이블에 성공적으로 값 넣었는지 확인 차 변수
		int itemMoney = 0;		//item가격 저장 변수
		int updateUserPoint = 0;	// 금액차감 확인 변수
		int updateAddItemCount = 0; // 아이템 구매 카운트 증가 확인 변수
		
		KipItem delKipItem = new KipItem();	// 찜목록 아이템 삭제 위해 객체 선언
		delKipItem.setUserId(userId);
		
		UserItemList itemList = new UserItemList();	// 아이템 리스트넣을 객체 변수 선언(여기에 로그인 아이디, 아이템번호 들어감)
		itemList.setUserId(userId);// setter통해 아이디 삽입 
		
		if(kipList == null) {
			out.append("nullList");
			out.flush();
		}else {
			for(String stringItemNo : kipList) {
				itemNo = Integer.valueOf(stringItemNo);
				delKipItem.setItemNo(itemNo);	// 찜목록 삭제 아이템 번호
				deleteResult += itemService.deleteKipItemList(itemNo);
				
				itemList.setItemNo(itemNo);	// db에 들어갈 아이템 번호 삽입
				insertResult += itemService.insertBuyItem(itemList);
				
				ItemStore item = itemService.selectOneItem(itemNo);	// 아이템 가격 뽑아오기 위해 객체 뽑아오기
				itemMoney = item.getPrice();	// 뽑아온 객체의 아이템 가격 저장
				loginUser.setItemPoint(itemMoney);	// user객체에 선언한 변수에 아이템 가격 저장
				updateUserPoint = itemService.updateUserPoint(loginUser);	// 해당 금액만큼 차단
				updateAddItemCount = itemService.updateAddItemCount(itemNo);	// 구매 아이템 카운트 1증가!
			}
			if(deleteResult > 0 && insertResult > 0 && updateUserPoint > 0 && updateAddItemCount > 0) {
				out.append("success");
				out.flush();				
			}else {
				out.append("fail");
				out.flush();
			}
		}
		out.close();
	}

}
