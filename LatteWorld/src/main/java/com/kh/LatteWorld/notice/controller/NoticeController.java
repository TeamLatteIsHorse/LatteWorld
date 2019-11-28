package com.kh.LatteWorld.notice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.exception.lwException;
import com.kh.LatteWorld.notice.model.service.NoticeService;
import com.kh.LatteWorld.notice.model.vo.Notice;
@Controller
public class NoticeController {
	
	@Autowired
	NoticeService nService;
	
	@RequestMapping("noticeListView.do")
	public ModelAndView noticeList(ModelAndView mv) {
		
		ArrayList<Notice> list = nService.selectList();
//		System.out.println(list);
		
		if(list != null) {
			mv.addObject("list",list);
			mv.setViewName("notice/noticeListView");
			
		}else {
			throw new lwException("공지사항 목록 보기 실패!!");
		}
		
		return mv;
	}
	
}
