package com.kh.LatteWorld.Message.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.Message.model.dao.MessageDao;
import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;

@Service("meService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDao mDao;

	//받은 메세지 전체 수 조회
	@Override
	public int getListCountReceive(String receiveId) {
		
		return mDao.getListCountReceive(receiveId);
	}
	//보낸 메시지 전체 수 조회
	@Override
	public int getListCountSend(String sendId) {
		return mDao.getListCountSend(sendId);
	}

	//휴지통 전체 수 조회
	@Override
	public int getListCountErase(String receiveId) {
		return mDao.getListCountErase(receiveId);
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
	public Message receiveMessageDetail(int messageNo) {
		return mDao.receiveMessage(messageNo);
	}
	//보낸 메세지 보기
	@Override
	public Message sendMessageDetail(int messageNo) {
		return mDao.sendMessageDetail(messageNo);
	}
	//휴지통으로 보내기
	@Override
	public int eraseMessage(int messageNo) {
		System.out.println(messageNo);
		return mDao.eraseMessage(messageNo);
	}
	
	//복원하기
	@Override
	public int rewindMessage(int messageNo) {
		return mDao.rewindMessage(messageNo);
	}

	//삭제하기
	@Override
	public int deleteMessage(int messageNo) {
		return mDao.deleteMessage(messageNo);
	}
	
	@Override
	public int updateMessageStatus(int messageNo) {
		return mDao.updateMessageStatus(messageNo);
	}
	@Override
	public ArrayList<BestFriend> searchBestFriend(String userId) {
		return mDao.searchBestFriend(userId);
	}
}
