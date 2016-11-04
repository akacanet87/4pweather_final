package com.min.membercategory.dao;

import java.util.List;

import com.min.domain.MemberCategory;

public interface MemberCategoryDAO {
	public List<MemberCategory> selectAll();
	public MemberCategory select(int membercategory_id);
}
