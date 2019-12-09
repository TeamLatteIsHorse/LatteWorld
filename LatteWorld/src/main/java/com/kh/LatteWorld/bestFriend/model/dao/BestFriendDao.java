package com.kh.LatteWorld.bestFriend.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;
import com.kh.LatteWorld.bestFriend.model.vo.bfSearchCondition;

@Repository("bfDao")
public class BestFriendDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public ArrayList<UserInfo> searchUser(bfSearchCondition bfsc) {
		
		return (ArrayList)sqlSession.selectList("bestfriendMapper.searchUser", bfsc);
	}

	public int checkBf(BestFriend bf) {

		return sqlSession.selectOne("bestfriendMapper.checkBF", bf);
	}

	public int insertBf(BestFriend bf) {

		return sqlSession.insert("bestfriendMapper.insertBF", bf);
	}
}
