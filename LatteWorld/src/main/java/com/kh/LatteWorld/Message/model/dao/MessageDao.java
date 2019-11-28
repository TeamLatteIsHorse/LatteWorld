package com.kh.LatteWorld.Message.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;

@Repository("mDao")
public class MessageDao {

		@Autowired
		SqlSessionTemplate sqlSession;

		public int getListCountReceive() {

			return sqlSession.selectOne("messageMapper.getListCountReceive");
		}

		public int getListCountSend() {
			return sqlSession.selectOne("messageMapper.getListCountSend");
		}

		public int getListCountErase() {
			return sqlSession.selectOne("messageMapper.getListCountErase");
		}

		public ArrayList<Message> selectListReceive(PageInfoMessage pi, String receiveId) {
			int offset = (pi.getCurrentPage()-1)*pi.getMessageLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getMessageLimit());
			
			return (ArrayList)sqlSession.selectList("messageMapper.selectListReceive",null,rowBounds);
		}

		public ArrayList<Message> selectListSend(PageInfoMessage pi, String sendId) {
			int offset = (pi.getCurrentPage()-1)*pi.getMessageLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getMessageLimit());
			
			return (ArrayList)sqlSession.selectList("messageMapper.selectListSend",null,rowBounds);
		}

		public ArrayList<Message> selectListErase(PageInfoMessage pi, String receiveId) {
			int offset = (pi.getCurrentPage()-1)*pi.getMessageLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getMessageLimit());
			
			return (ArrayList)sqlSession.selectList("messageMapper.selectListErase",null,rowBounds);
		}

		public Message receiveMessage(int messageNo) {
			return sqlSession.selectOne("messageMapper.receiveMessage");
		}

}
