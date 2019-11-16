package com.kh.sClassCopy.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sClassCopy.member.model.vo.Member;

@Repository("mDao")
//	@Rapository라는 어느테이션 또한 DB와 접근하는 클래스에 부여하는 어노테이션으로
//	@Component의 구체화된 개념이다.
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member selectMember(Member m) {
		
		return (Member)sqlSession.selectOne("memberMapper.selectOne", m);
	}

}
