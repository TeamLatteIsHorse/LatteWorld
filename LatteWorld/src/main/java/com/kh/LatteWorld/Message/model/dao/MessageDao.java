package com.kh.LatteWorld.Message.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;

@Repository("mDao")
public class MessageDao {

		@Autowired
		SqlSessionTemplate sqlSession;

		public int getListCountReceive(String receiveId) {

			return sqlSession.selectOne("messageMapper.getListCountReceive",receiveId);
		}

		public int getListCountSend(String sendId) {
			return sqlSession.selectOne("messageMapper.getListCountSend",sendId);
		}

		public int getListCountErase(String receiveId) {
			return sqlSession.selectOne("messageMapper.getListCountErase",receiveId);
		}

		public ArrayList<Message> selectListReceive(PageInfoMessage pi, String receiveId) {
			int offset = (pi.getCurrentPage()-1)*pi.getMessageLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getMessageLimit());
			
			return (ArrayList)sqlSession.selectList("messageMapper.selectListReceive",receiveId,rowBounds);
		}

		public ArrayList<Message> selectListSend(PageInfoMessage pi, String sendId) {
			int offset = (pi.getCurrentPage()-1)*pi.getMessageLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getMessageLimit());
			
			return (ArrayList)sqlSession.selectList("messageMapper.selectListSend",sendId,rowBounds);
		}

		public ArrayList<Message> selectListErase(PageInfoMessage pi, String receiveId) {
			int offset = (pi.getCurrentPage()-1)*pi.getMessageLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getMessageLimit());
			
			return (ArrayList)sqlSession.selectList("messageMapper.selectListErase",receiveId,rowBounds);
		}

		public Message receiveMessage(int messageNo) {
			return sqlSession.selectOne("messageMapper.receiveMessageDetail",messageNo);
		}

		public int eraseMessage(int messageNo) {
			return sqlSession.update("messageMapper.eraseMessage",messageNo);
		}

		public int deleteMessage(int messageNo) {
			return sqlSession.delete("messageMapper.deleteMessage",messageNo);
		}

		public int rewindMessage(int messageNo) {
			return sqlSession.update("messageMapper.rewindMessage",messageNo);
		}

		public Message sendMessageDetail(int messageNo) {
			return sqlSession.selectOne("messageMapper.sendMessageDetail",messageNo);
		}

		public int updateMessageStatus(int messageNo) {
			return sqlSession.update("messageMapper.updateMessageStatus",messageNo);
		}

		public ArrayList<BestFriend> searchBestFriend(String userId) {
			return (ArrayList)sqlSession.selectList("messageMapper.searchBestFriend",userId);
		}

}
