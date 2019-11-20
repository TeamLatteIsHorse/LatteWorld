package com.kh.LatteWorld.UserInfo.model.service;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

public interface UserService {

	UserInfo loginUser(UserInfo u);

	int insertMember(UserInfo u);

	UserInfo selectUser(UserInfo u);

	int updateUser(UserInfo u);

}
