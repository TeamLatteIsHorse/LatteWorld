package com.kh.LatteWorld.item.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.item.model.dao.ItemDao;
import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;
import com.kh.LatteWorld.item.model.vo.KipItem;
import com.kh.LatteWorld.item.model.vo.UserItemList;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public int getItemListCount() {

		return itemDao.getItemListCount();	// 아이템 샵 리스트 불러오기
	}

	@Override
	public ArrayList<ItemStore> selectItemList(ItemPageInfo pi) {

		return (ArrayList)itemDao.selectItemList(pi);	// 아이템샵 리스트 불러오기
	}

	@Override
	public ArrayList<ItemStore> selectBestItemList(String itemCategory) {
		
		return (ArrayList)itemDao.selectBestItemList(itemCategory);	//인기상품 리스트 불러오기
	}

	@Override
	public ItemStore buyItem(int itemNo) {

		return itemDao.buyItem(itemNo);	// 구매하기 버튼 눌렀을때
	}
	
	@Override
	public ItemStore selectOneItem(int itemNo) {

		return itemDao.selectOneItem(itemNo);	// 찜하기 눌렀을 때 해당 아이템의 정보 객체 불러오기
	}


	@Override
	public int insertkipItem(ItemStore item) {

		return itemDao.insertkipItem(item);	//찜목록 테이블에 값 추가(추가했을 때 아이디는 null이다(id값이 없어서))
	}

	@Override
	public int insertUser(String userId) {

		return itemDao.insertUser(userId);	// 찜목록에 null로있는 아이디값 추가
	}

	@Override
	public int getkipItemListCount(String userId) {

		return itemDao.getkipItemListCount(userId);	// 찜목록 리스트 갯수 추가
	}

	@Override
	public ArrayList<KipItem> selectKipItemlist(String userId) {	
		// 찜목록 리스트 불러오기(찜목록 리스트 확인 후 값 존재하면 이미 찜목록에 있는 아이템이라고 보여주기 위해서)
		return itemDao.selectKipItemlist(userId);
	}

	@Override
	public ArrayList<ItemStore> selectAllItemList() {	// 버튼 비활성화 시키기 위한 itemList전부 불러오기

		return itemDao.selectAllItemList();
	}

	@Override
	public int insertItemList(String userId) {	// 유저 보유 아이템 리스트에 값 넣기(itemNo는 아직 null)

		return itemDao.insertItemList(userId);
	}

	@Override
	public int insertItemNo(int itemNo) {	// null되어있는 아이템 번호 값 넣기

		return itemDao.insertItemNo(itemNo);
	}

	@Override
	public int updateUserPoint(UserInfo loginUser) {	// userPoint 차감

		return itemDao.updateUserPoint(loginUser);
	}

	@Override
	public ArrayList<UserItemList> selectUserItemList(String userId) {	// 로그인 유저 보융이템 리스트 불러오기

		return itemDao.selectUserItemList(userId);
	}

	@Override
	public int selectUserPoint(String userId) { 	// 로그인유저 보유금액 불러오기

		return itemDao.selectUserPoint(userId);
	}

}
