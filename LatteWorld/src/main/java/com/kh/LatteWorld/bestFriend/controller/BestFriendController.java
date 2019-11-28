package com.kh.LatteWorld.bestFriend.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.bestFriend.model.service.BestFriendService;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;
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
	public String searchBF(bfSearchCondition bfsc, Model model, HttpSession session) {
		UserInfo u = (UserInfo)session.getAttribute("UserInfo");
		
		if(bfsc.getBfType().equals("all")) {
			bfsc.setBfAll(bfsc.getBfValue());
		}else if(bfsc.getBfType().equals("name")) {
			bfsc.setBfName(bfsc.getBfValue());
		}else if(bfsc.getBfType().equals("id")){
			bfsc.setBfId(bfsc.getBfValue());
		}
		ArrayList<UserInfo> bfList = bfService.searchUser(bfsc);
		
		model.addAttribute("bfsc", bfsc);
		model.addAttribute("bfList", bfList);
		
		return "bestFriend/bfFind";
	}
	
	@RequestMapping("bfApply.do")
	public String applyBF(BestFriend bf, Model model, HttpSession session,
						 String bfAppliedName) {
		UserInfo u = (UserInfo)session.getAttribute("UserInfo");
		
		int result = bfService.checkBF(bf);
		
		if(result > 0) {
			model.addAttribute("msg", "이미 BestFriend 입니다.");
		}else {
			model.addAttribute("bf", bf);
			model.addAttribute("UserInfo", u);
			model.addAttribute("bfName", bfAppliedName);
		}
		return "bestFriend/applyBf";
	}
}
