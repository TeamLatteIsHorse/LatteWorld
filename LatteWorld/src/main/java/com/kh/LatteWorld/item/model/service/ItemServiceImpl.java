package com.kh.LatteWorld.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.item.model.dao.ItemDao;
import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public int getItemListCount() {

		return itemDao.getItemListCount();
	}

	@Override
	public ArrayList<ItemStore> selectItemList(ItemPageInfo pi) {

		return (ArrayList)itemDao.selectItemList(pi);
	}

	@Override
	public ArrayList<ItemStore> selectBestItemList(String itemCategory) {
		
		return (ArrayList)itemDao.selectBestItemList(itemCategory);
	}
}
