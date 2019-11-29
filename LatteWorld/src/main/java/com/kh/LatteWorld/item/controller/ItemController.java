package com.kh.LatteWorld.item.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.exception.lwException;
import com.kh.LatteWorld.item.model.service.ItemService;
import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;
import com.kh.LatteWorld.item.model.vo.Pagination;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("itemStoreList.do")
	public ModelAndView itemStoreView(ModelAndView mv, 
								@RequestParam(value = "page", required=false) Integer page, String itemCategory) {
		
		int currentPage = 1;
		
		if(page != null) {
			currentPage = page;
		}
		
		int itemListCount = itemService.getItemListCount();	// 아이템 리스트 갯수
		/* System.out.println(itemListCount); */
		
		ItemPageInfo pi = Pagination.getPageInfo(currentPage, itemListCount);	// 페이징처리
		
		ArrayList<ItemStore> itemList = itemService.selectItemList(pi);	// 아이템 리스트
		
		if(itemCategory == null) {
			itemCategory = "펫";
		}
		
		ArrayList<ItemStore> bestItemList = itemService.selectBestItemList(itemCategory);	// 인기상품 리스트
		
		
		if((itemList != null && itemList.size() > 0) && (bestItemList != null && bestItemList.size() >0)) {
			mv.addObject("itemList", itemList);
			mv.addObject("bestItemList", bestItemList);
			mv.addObject("pi", pi);
			mv.setViewName("item/itemStoreView");
		}else {
			throw new lwException("아이템샵 불러오기 실패!");
		}
		
		return mv;
	}
	@RequestMapping("buyItem.do")
	public ModelAndView buyItem(int itemNo, ModelAndView mv) {
		
		ItemStore item = itemService.buyItem(itemNo);
		
		if(item == null) {
			throw new lwException("구매하기 페이지 이동 실패!");
		}else {
			mv.addObject("item",item);
			mv.setViewName("item/BuyItemView");
		}
		
		return mv;
	}
	
	
	
}
