package com.kh.LatteWorld.item.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println("kip : "+kipItemNo);
		System.out.println("buy : "+buyItemNo);
	
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
		int userPoint = itemService.selectUserPoint(userId);
		
		ItemStore item = itemService.selectOneItem(itemNo);	// 아이템 가격 뽑아오기 위해 객체 뽑아오기
		int itemMoney = item.getPrice();
		loginUser.setItemPoint(itemMoney);	// 로그인 유저 포인츠 차감위해서 userInfo값 하나 추가하고 setter사용
		
		System.out.println("userPoint : "+userPoint);
		System.out.println("itemMoney : "+itemMoney);
		
		if(item != null && userId != null) {
			//System.out.println("item, userId존재!");
			
			if(userPoint >= itemMoney) {
				int insertItem = itemService.insertItemList(userId);	// userId값 사용해서 itemList테이블에 값넣기(itemNo는 아직 null값!)
				int insertItemNo = itemService.insertItemNo(itemNo);	// null값 되어있는 itemList테이블에 itemNo넣기
				int updateUserPoint = itemService.updateUserPoint(loginUser);	// 해당 금액만큼 차단
				if(insertItem > 0 && insertItemNo > 0 && updateUserPoint > 0) {
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
	
	@RequestMapping(value = "kipItemView.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView kipItemView(String userId, ModelAndView mv) {
		System.out.println(userId);
		
		ArrayList<KipItem> kipItemList = itemService.selectKipItemlist(userId);
		
		if(kipItemList != null) {
			mv.addObject("kipItemList", kipItemList);
			mv.setViewName("item/kipItemListView");
			return mv;
		}else {
			throw new lwException("찜목록 불러오기 실패!");
		}
		
	}
	

}
