package com.kh.LatteWorld.minihome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

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
		model.addAttribute("owner",user);
		
		return "minihome/miniHome";
	}
	
	@RequestMapping("visitHome.do")
	public String visitMiniHome(UserInfo u, Model model, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		UserInfo user = uService.loginUser(u);
		model.addAttribute("owner",user);
		
		return "minihome/miniHome";
	}
	
}
