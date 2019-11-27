package com.kh.LatteWorld.UserInfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.LatteWorld.exception.lwException;
import com.kh.LatteWorld.UserInfo.model.service.UserService;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

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
	
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String userJoin(UserInfo u, Model model,
							@RequestParam("email1") String email1,
							@RequestParam("email2") String email2) {
		
		String encPwd =  bcryptPasswordEncoder.encode(u.getUserPwd());

		u.setUserPwd(encPwd);	// 패스워드 암호화 넣기
		String userId = email1 + email2;

		u.setUserId(userId);	// 유저 아이디는 email합친것들
		
		u.setMinihomeCode(email1);
		int result = uService.insertMember(u);
		
		if(result >0) {
			return "home";
		}else {
			throw new lwException("회원 가입 실패!");
		}
	}
	
}
