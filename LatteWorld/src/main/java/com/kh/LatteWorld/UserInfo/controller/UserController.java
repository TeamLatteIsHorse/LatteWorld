package com.kh.LatteWorld.UserInfo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.LatteWorld.UserInfo.model.service.UserService;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.exception.lwException;

@SessionAttributes("UserInfo")
@Controller
public class UserController {

	@Autowired
	private UserService uService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String memberLogin(UserInfo u, Model model, SessionStatus status) {
		UserInfo user = uService.loginUser(u);
		if(bcryptPasswordEncoder.matches(u.getUserPwd(), user.getUserPwd())) {
			model.addAttribute("UserInfo",user);
		}else {
			throw new lwException("로그인 실패!");
		}
		
		return "home";
	}
	
	@RequestMapping("logout.do")
	public String userLogout(SessionStatus status) {
		status.setComplete();
		
		return "home";
	}
	
	@RequestMapping("mypage.do")
	public String userMypage(UserInfo u, Model model) {
		u = uService.selectUser(u);
		model.addAttribute("UserInfo", u);
		
		return "common/myPage";
	}
	
	@RequestMapping(value = "update.do", method=RequestMethod.POST)
	public String userUpdate(UserInfo u, Model model) {
		
		int result = uService.updateUser(u);
		
		
		return "home";
	}
	
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String userJoin(UserInfo u, Model model) {
		String encPwd =  bcryptPasswordEncoder.encode(u.getUserPwd());
		u.setUserPwd(encPwd);
		int result = uService.insertMember(u);
		
		if(result >0) {
			return "home";
		}else {
			throw new lwException("회원 가입 실패!");
		}
	}
	
	@RequestMapping("dupid.do")
	public void idDuplicateCheck(HttpServletResponse response, String userId) throws IOException {
		boolean isUsable = uService.checkIdDup(userId) == 0? true : false;
		
		response.getWriter().print(isUsable);
	}
	
}
