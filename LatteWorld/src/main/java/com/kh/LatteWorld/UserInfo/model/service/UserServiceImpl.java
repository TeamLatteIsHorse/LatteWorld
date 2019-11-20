package com.kh.LatteWorld.UserInfo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.UserInfo.model.dao.UserDao;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

@Service("uService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao uDao;

	@Override
	public UserInfo loginUser(UserInfo u) {
		return uDao.selectUser(u);
	}

	@Override
	public int insertMember(UserInfo u) {
		return uDao.insertUser(u);
	}

	@Override
	public UserInfo selectUser(UserInfo u) {
		
		return uDao.selectUser(u);
	}

	@Override
	public int updateUser(UserInfo u) {
		return uDao.updateUser(u);
	}
	
	
}
