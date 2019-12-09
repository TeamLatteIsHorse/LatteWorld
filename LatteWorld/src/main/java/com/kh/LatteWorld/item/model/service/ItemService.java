package com.kh.LatteWorld.item.model.service;

import java.util.ArrayList;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;
import com.kh.LatteWorld.item.model.vo.KipItem;
import com.kh.LatteWorld.item.model.vo.Present;
import com.kh.LatteWorld.item.model.vo.UserItemList;

public interface ItemService {

	int getItemListCount();

	ArrayList<ItemStore> selectItemList(ItemPageInfo pi);

	ArrayList<ItemStore> selectBestItemList(String itemCategory);

	ItemStore buyItem(int itemNo);

	ItemStore selectOneItem(int itemNo);

	int insertkipItem(ItemStore item);

	int insertUser(String userId);

	int getkipItemListCount(String userId);

	ArrayList<KipItem> selectKipItemlist(String userId);

	ArrayList<ItemStore> selectAllItemList();

	int updateUserPoint(UserInfo loginUser);

	ArrayList<UserItemList> selectUserItemList(String userId);

	int selectUserPoint(String userId);

	int deleteKipItemList(int itemNo);

	int insertPresentItem(Present preItem);

	ArrayList<Present> selectSendItemList(String userId);

	ArrayList<Present> selectReceiveItemList(String userId);

	int selectOnePresentItem(Present preItem);

	int selecthaveOneItem(UserItemList oneItem);

	int updateAddItemCount(int itemNo);

	int insertBuyItem(UserItemList itemList);


}
