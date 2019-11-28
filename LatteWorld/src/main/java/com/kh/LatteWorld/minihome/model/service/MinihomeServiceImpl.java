package com.kh.LatteWorld.minihome.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.minihome.model.dao.MinihomeDao;

@Service("miniService")
public class MinihomeServiceImpl implements MinihomeService{

	@Autowired
	MinihomeDao miniDao;
}
