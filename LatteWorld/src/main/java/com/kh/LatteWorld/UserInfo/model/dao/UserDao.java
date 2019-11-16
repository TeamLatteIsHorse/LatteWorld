package com.kh.LatteWorld.UserInfo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

@Repository("uDao")
public class UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public UserInfo selectUser(UserInfo u) {
		return (UserInfo)sqlSession.selectOne("userinfoMapper.selectUser", u);
	}

	public int insertUser(UserInfo u) {

		return sqlSession.insert("userinfoMapper.insertUser", u);
	}
	
}
