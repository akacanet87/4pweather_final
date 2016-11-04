package com.min.membercategory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.min.domain.MemberCategory;

@Repository
public class MemberCategoryDAOSpringJdbc implements MemberCategoryDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MemberCategory> selectAll() {
		String sql = "select * from membercategory order by membercategory_id asc";
		List<MemberCategory> list = jdbcTemplate.query(sql, new RowMapper<MemberCategory>() {
			@Override
			public MemberCategory mapRow(ResultSet rs, int row) throws SQLException {
				MemberCategory memberCategory = new MemberCategory();
				memberCategory.setMembercategory_id(rs.getInt("membercategory_id"));
				memberCategory.setName(rs.getString("name"));
				return memberCategory;
			}
		});
		return list;
	}

	@Override
	public MemberCategory select(int membercategory_id) {
		String sql = "select * from membercategory where membercategory_id=?";
		MemberCategory memberCategory = jdbcTemplate.queryForObject(sql, new RowMapper<MemberCategory>() {
			@Override
			public MemberCategory mapRow(ResultSet rs, int row) throws SQLException {
				MemberCategory memberCategory = new MemberCategory();
				memberCategory.setMembercategory_id(rs.getInt("membercategory_id"));
				memberCategory.setName(rs.getString("name"));
				return memberCategory;
			}
			
		}, membercategory_id);
		return memberCategory;
	}
	
}