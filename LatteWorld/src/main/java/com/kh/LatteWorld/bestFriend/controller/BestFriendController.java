package com.kh.LatteWorld.bestFriend.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.bestFriend.model.service.BestFriendService;
import com.kh.LatteWorld.bestFriend.model.vo.bfSearchCondition;

@Controller
public class BestFriendController {
	
	@Autowired
	BestFriendService bfService;
	
	@RequestMapping("bfFind.do")
	public String findBF(HttpSession session, Model model) {
		UserInfo u = (UserInfo)session.getAttribute("UserInfo");
		
		model.addAttribute("UserInfo", u);
		
		return "bestFriend/bfFind";
	}
	
	@RequestMapping("search.do")
	public String searchBF(bfSearchCondition bfsc, Model model) {
		if(bfsc.getBfType().equals("all")) {
			bfsc.setBfAll(bfsc.getBfValue());
		}else if(bfsc.getBfType().equals("name")) {
			bfsc.setBfName(bfsc.getBfValue());
		}else if(bfsc.getBfType().equals("id")){
			bfsc.setBfId(bfsc.getBfValue());
		}
		System.out.println(bfsc);
		ArrayList<UserInfo> bfList = bfService.searchUser(bfsc);
		
		System.out.println(bfList);
		
		model.addAttribute("bfsc", bfsc);
		model.addAttribute("bfList", bfList);
		
		return "bestFriend/bfFind";
	}
}
