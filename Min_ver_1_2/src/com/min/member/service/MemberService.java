package com.min.member.service;

import java.util.List;

import com.min.domain.Member;
import com.min.domain.MemberCategory;

public interface MemberService {
	public List selectAll();
	public List selectAll(int membercategory_id);
	public Member select(int member_id);
	public int insert(Member member);
	public int delete(int member_id);
	public int update(Member member);
	public List getMemberCategoryAll();
	public MemberCategory getMemberCategory(int membercategory_id);
}
