package com.kh.LatteWorld.Message.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mDao")
public class MessageDao {

		@Autowired
		SqlSessionTemplate sqlSession;
}
