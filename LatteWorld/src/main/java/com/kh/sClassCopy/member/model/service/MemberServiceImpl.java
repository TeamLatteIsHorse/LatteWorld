package com.kh.sClassCopy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sClassCopy.member.model.dao.MemberDao;
import com.kh.sClassCopy.member.model.vo.Member;

//	@Component는 단순한 빈으로 등록하기 위한 어노테이션이지만
//	@Service는 보다 구체화 된 즉, Service의 의미를 가지는 클래스라는 걸 보여주기 위한 어노테이션
//	("  ")를 통해 빈으로 등록할 때의 이름을 지정해 줄 수 있다.

@Service("mService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao mDao;

	@Override
	public Member loginMember(Member m) {
		//	스프링 적용 이후 service에서 sqlSession을 생성하지 않는다.
		//	dao에서 DI를 통해 sqlSession을 생성한다.
		return mDao.selectMember(m);
	}
}
