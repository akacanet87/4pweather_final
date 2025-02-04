package com.min.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.min.domain.Member;
import com.min.domain.MemberCategory;
import com.min.membercategory.dao.MemberCategoryDAO;
import com.min.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	@Qualifier("memberDAOSpringJdbc")
	private MemberDAO memberDAO;
	
	@Autowired
	@Qualifier("memberCategoryDAOSpringJdbc")
	private MemberCategoryDAO memberCategoryDAO;
	
	@Override
	public List<Member> selectAll() {
		return memberDAO.selectAll();
	}

	@Override
	public List<Member> selectAll(int membercategory_id) {
		return memberDAO.selectAll(membercategory_id);
	}

	@Override
	public Member select(int member_id) {
		return memberDAO.select(member_id);
	}

	@Override
	public int insert(Member member) {
		return memberDAO.insert(member);
	}

	@Override
	public int delete(int member_id) {
		return memberDAO.delete(member_id);
	}

	@Override
	public int update(Member member) {
		return memberDAO.update(member);
	}
	
	@Override
	public List<MemberCategory> getMemberCategoryAll() {
		return memberCategoryDAO.selectAll();
	}
	
	@Override
	public MemberCategory getMemberCategory(int membercategory_id) {
		return memberCategoryDAO.select(membercategory_id);
	}
}
