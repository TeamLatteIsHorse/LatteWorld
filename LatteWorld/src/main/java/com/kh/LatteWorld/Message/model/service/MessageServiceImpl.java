package com.kh.LatteWorld.Message.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.Message.model.dao.MessageDao;
import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;

@Service("meService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDao mDao;

	//받은 메세지 전체 수 조회
	@Override
	public int getListCountReceive() {
		
		return mDao.getListCountReceive();
	}
	//보낸 메시지 전체 수 조회
	@Override
	public int getListCountSend() {
		return mDao.getListCountSend();
	}

	//휴지통 전체 수 조회
	@Override
	public int getListCountErase() {
		return mDao.getListCountErase();
	}
	
	// 받은메세지함
	@Override
	public ArrayList<Message> selectListReceive(PageInfoMessage pi, String receiveId) {
		return mDao.selectListReceive(pi, receiveId);
	}
	
	//보낸메세지함
	@Override
	public ArrayList<Message> selectListSend(PageInfoMessage pi, String sendId) {
		return mDao.selectListSend(pi,sendId);
	}
	
	//휴지통
	@Override
	public ArrayList<Message> selectListErase(PageInfoMessage pi, String receiveId) {
		return mDao.selectListErase(pi,receiveId);
	}
	
	//메세지 보내기
	@Override
	public int sendMessage(Message m, String sendId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//받은 메세지 조회
	@Override
	public Message receiveMessage(int messageNo) {
		return mDao.receiveMessage(messageNo);
	}
	//보낸 메세지 보기
	@Override
	public Message sendMessageDetail(int messageNo, String sendId) {
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
