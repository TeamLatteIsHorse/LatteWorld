package com.kh.LatteWorld.bestFriend.model.service;

import java.util.ArrayList;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;
import com.kh.LatteWorld.bestFriend.model.vo.bfSearchCondition;

public interface BestFriendService {

	ArrayList<UserInfo> searchUser(bfSearchCondition bfsc);

}
