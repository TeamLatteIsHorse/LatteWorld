package com.kh.LatteWorld.item.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.item.model.vo.ItemPageInfo;
import com.kh.LatteWorld.item.model.vo.ItemStore;

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
		// 여기서 null이 뭐더라?
	}

	public ArrayList<ItemStore> selectBestItemList(String itemCategory) {

		return (ArrayList)sqlSession.selectList("itemMapper.selectBestItemList", itemCategory);
	}

	public ItemStore buyItem(int itemNo) {

		return sqlSession.selectOne("itemMapper.buyItem",itemNo);
	}
}
