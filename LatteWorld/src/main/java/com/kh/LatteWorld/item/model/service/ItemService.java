package com.kh.LatteWorld.item.model.service;

import java.util.ArrayList;

import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;

public interface ItemService {

	int getItemListCount();

	ArrayList<ItemStore> selectItemList(ItemPageInfo pi);

	ArrayList<ItemStore> selectBestItemList(String itemCategory);

	ItemStore buyItem(int itemNo);

}
