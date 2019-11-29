package com.kh.LatteWorld.Message.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.Message.model.dao.MessageDao;
import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;

@Service("mService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDao mDao;

	//받은 메세지 전체 수 조회
	@Override
	public int getListCountReceive() {
		// TODO Auto-generated method stub
		return 0;
	}
	//보낸 메시지 전체 수 조회
	@Override
	public int getListCountSend() {
		// TODO Auto-generated method stub
		return 0;
	}

	//휴지통 전체 수 조회
	@Override
	public int getListCountErase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// 받은메세지함
	@Override
	public ArrayList<Message> selectListReceive(PageInfoMessage pi) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//보낸메세지함
	@Override
	public ArrayList<Message> selectListSend(PageInfoMessage pi) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//휴지통
	@Override
	public ArrayList<Message> selectListErase(PageInfoMessage pi) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//메세지 보내기
	@Override
	public int sendMessage(Message m, String sendId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//받은 메세지 조회
	@Override
	public Message recieveMessate(int messageNo, String receiveId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//휴지통으로 보내기
	@Override
	public int eraseMessage(Message m) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//복원하기
	@Override
	public int rewindMessage(Message m) {
		// TODO Auto-generated method stub
		return 0;
	}

	//삭제하기
	@Override
	public int deleteMessage(int messageNo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
