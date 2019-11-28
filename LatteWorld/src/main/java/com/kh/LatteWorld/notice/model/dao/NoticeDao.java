package com.kh.LatteWorld.notice.model.dao;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.notice.model.vo.Notice;
//DB와 연결하는 부분 
@Repository("nDao")
public class NoticeDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public ArrayList<Notice> selectList() {
		
		return (ArrayList)sqlSession.selectList("noticeMapper.selectList");
	}

	public Notice selectOne(int nId) {
		
		return sqlSession.selectOne("noticeMapper.selectOne", nId);
	}

	public int insertNotice(Notice n) {

		return sqlSession.insert("noticeMapper.insertNotice", n);
	}

	public int updateNotice(Notice n) {
		
		return sqlSession.update("noticeMapper.updateNotice", n);
	}

	public int deleteNotice(int nId) {
		
		return sqlSession.delete("noticeMapper.deleteNotice", nId);
	}
}
	
	
	
	
	
	
	
	
	
	
