package com.kh.LatteWorld.bestFriend.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.bestFriend.model.dao.BestFriendDao;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;
import com.kh.LatteWorld.bestFriend.model.vo.bfSearchCondition;

@Service("bfService")
public class BestFriendServiceImpl implements BestFriendService{

	@Autowired
	BestFriendDao bfDao;

	@Override
	public ArrayList<UserInfo> searchUser(bfSearchCondition bfsc) {
		
		return bfDao.searchUser(bfsc);
	}

	@Override
	public int checkBF(BestFriend bf) {

		return bfDao.checkBf(bf);
	}
}
