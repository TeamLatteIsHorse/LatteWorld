package com.kh.LatteWorld.Message.model.service;

import java.util.ArrayList;

import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;

public interface MessageService {
	
	/*
	 * 0_1 받은메세지 전체 수 조회
	 */
	public int getListCountReceive(String receiveId);
	
	/*
	 * 0_2보낸메세지 전체 수 조회
	 */
	public int getListCountSend(String sendId);
	/*
	 * 0_3휴지통 전체 수 조회
	 */
	public int getListCountErase(String receiveId);
	/*
	 * 1_1 받은 메세지 전체조회
	 */
	public ArrayList<Message> selectListReceive(PageInfoMessage pi, String receiveId);
	/*
	 * 1_2 보낸 메세지 전체조회
	 */
	public ArrayList<Message> selectListSend(PageInfoMessage pi, String sendId);
	/*
	 * 1_3 휴지통
	 */
	public ArrayList<Message> selectListErase(PageInfoMessage pi, String receiveId);
	/*
	 * 2_1 메세지 보내기(insert)
	 */
	public int sendMessage(Message m, String sendId );
	/*
	 * 2_2 메세지 불러오기(detail view)
	 */
	public Message receiveMessageDetail(int messageNo);
	/*
	 * 2_3 보낸 매세지 보기(detail view)
	 */
	public Message sendMessageDetail(int messageNo);
	/*
	 * 3_1 메세지 휴지통으로 보내기(update)
	 */
	public int eraseMessage(int messageNo);
	/*
	 * 3_2 메세지 복원하기(update)
	 */
	public int rewindMessage(int messageNo);
	/*
	 * 3_3 메세지 삭제(delete)
	 */
	public int deleteMessage(int messageNo);

	//메세지 상태 업데이트
	public int updateMessageStatus(int messageNo);

	//1촌 찾기
	public ArrayList<BestFriend> searchBestFriend(String userId);

}
