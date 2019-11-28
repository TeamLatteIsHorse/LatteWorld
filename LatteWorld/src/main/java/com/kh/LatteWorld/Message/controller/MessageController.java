package com.kh.LatteWorld.Message.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.Message.model.service.MessageService;
import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;
import com.kh.LatteWorld.Message.pagination_m.Pagination;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.exception.lwException;


//@SessionAttributes("Message")
@Controller
public class MessageController {

	@Autowired
	private MessageService meService;
	
	
	//받은메세지 리스트
	@RequestMapping("receivelist.do")
	public ModelAndView receiveMessageList(ModelAndView mv, HttpSession session,
										@RequestParam(value="page",required=false) Integer page) {
		
		UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
		String receiveId = loginUser.getUserId();
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = meService.getListCountReceive();
		
		PageInfoMessage pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Message> list = meService.selectListReceive(pi,receiveId);
		
		if(list != null && list.size()>0) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("message/receiveMessageList");
		}else {
			throw new lwException("보낸 쪽지함 조회 실패"); 
		}
		
		return mv;
	}
	//보낸 메세지 리스트
	@RequestMapping("sendlist.do")
	public ModelAndView sendMessageList(ModelAndView mv , HttpSession session,
										@RequestParam(value="page",required=false) Integer page) {
		
		UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
		String sendId = loginUser.getUserId();
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = meService.getListCountSend();
		
		PageInfoMessage pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Message> list = meService.selectListSend(pi, sendId);
		
		if(list != null && list.size()>0) {
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("message/sendMessageList");
		}else {
			throw new lwException("받은 쪽지함 조회 실패"); 
		}
		
		return mv;
	}
	//휴지통
		@RequestMapping("eraselist.do")
		public ModelAndView eraseMessageList(ModelAndView mv , HttpSession session,
											@RequestParam(value="page",required=false) Integer page) {
			
			UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
			String receiveId = loginUser.getUserId();
			int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			int listCount = meService.getListCountErase();
			
			PageInfoMessage pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Message> list = meService.selectListErase(pi,receiveId);
			
			if(list != null && list.size()>0) {
				mv.addObject("list",list);
				mv.addObject("pi",pi);
				mv.setViewName("message/eraseMessageList");
			}else {
				throw new lwException("휴지통 조회 실패"); 
			}
			
			return mv;
		}
		//받은 메세지 디테일 뷰
		@RequestMapping("receiveMessage.do")
		public ModelAndView receiveMessage(ModelAndView mv, int messageNo,
											@RequestParam("page") Integer page) {
			
			int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			Message m = meService.receiveMessage(messageNo);
			
			if(m != null) {
				mv.addObject("m",m);
				mv.addObject("currentPage",currentPage);
				mv.setViewName("message/receiveMessageView");
			}else {
				throw new lwException("받은 메세지 조회 실패");
			}
			
			
			return mv;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
