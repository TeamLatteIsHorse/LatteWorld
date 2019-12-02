package com.kh.LatteWorld.item.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;
import com.kh.LatteWorld.item.model.vo.KipItem;
import com.kh.LatteWorld.item.model.vo.UserItemList;

@Repository("itemDao")
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getItemListCount() {

		return sqlSession.selectOne("itemMapper.getItemListCount");
	}

	public ArrayList<ItemStore> selectItemList(ItemPageInfo pi) {
		int offset = (pi.getCurrentPage() -1)*pi.getBoardLimit();	// offset이 현재 페이지에 따라서 전체 게시글중 잘라날 갯수
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		// rowBounds는 offset과 보여질 게시글 수를 내부구조를 통해 몇번째의 리스트를 불러올지 정해주는것
		
		return (ArrayList)sqlSession.selectList("itemMapper.selectItemList", null, rowBounds);
	}

	public ArrayList<ItemStore> selectBestItemList(String itemCategory) {

		return (ArrayList)sqlSession.selectList("itemMapper.selectBestItemList", itemCategory);
	}

	public ItemStore buyItem(int itemNo) {

		return sqlSession.selectOne("itemMapper.buyItem",itemNo);
	}

	public ItemStore selectOneItem(int itemNo) {
		
		return sqlSession.selectOne("itemMapper.selectOneItem", itemNo);
	}
	
	public int insertkipItem(ItemStore item) {
		return sqlSession.insert("itemMapper.insertkipItem", item);
	}

	public int insertUser(String userId) {
		return sqlSession.update("itemMapper.updateNullUser", userId);
	}

	public int getkipItemListCount(String userId) {

		return sqlSession.selectOne("itemMapper.getkipItemListCount", userId);
	}

	public ArrayList<KipItem> selectKipItemlist(String userId) {

		return (ArrayList)sqlSession.selectList("itemMapper.selectKipItemlist", userId);
	}

	public ArrayList<ItemStore> selectAllItemList() {

		return (ArrayList)sqlSession.selectList("itemMapper.selectAllItemList");
	}

	public int insertItemList(String userId) {

		return sqlSession.insert("itemMapper.insertItemList", userId);
	}

	public int insertItemNo(int itemNo) {

		return sqlSession.update("itemMapper.insertItemNo", itemNo);
	}

	public int updateUserPoint(UserInfo loginUser) {

		return sqlSession.update("itemMapper.updateUserPoint", loginUser);
	}

	public ArrayList<UserItemList> selectUserItemList(String userId) {

		return (ArrayList)sqlSession.selectList("itemMapper.selectUserItemList", userId);
	}

	public int selectUserPoint(String userId) {

		return sqlSession.selectOne("itemMapper.selectUserPoint", userId);
	}

}
