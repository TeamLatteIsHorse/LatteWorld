package com.kh.LatteWorld.minihome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.LatteWorld.UserInfo.model.service.UserService;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.minihome.model.service.MinihomeService;

@SessionAttributes("UserInfo")
@Controller
public class MinihomeController {

	@Autowired
	UserService uService;
	
	@Autowired
	MinihomeService miniService;

	@RequestMapping("minihome.do")
	public String minihome(UserInfo u, Model model) {
		
		UserInfo user = uService.loginUser(u);
		model.addAttribute("UserInfo",user);
		
		return "minihome/miniHome";
	}
	
}
