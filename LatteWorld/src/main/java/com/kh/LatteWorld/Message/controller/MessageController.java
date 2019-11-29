package com.kh.LatteWorld.Message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.LatteWorld.Message.model.service.MessageService;
import com.kh.LatteWorld.exception.lwException;


@SessionAttributes("Message")
@Controller
public class MessageController {

	@Autowired
	private MessageService meService;
}
