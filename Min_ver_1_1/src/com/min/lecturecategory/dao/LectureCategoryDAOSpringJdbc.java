package com.min.lecturecategory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.min.domain.LectureCategory;

@Repository
public class LectureCategoryDAOSpringJdbc implements LectureCategoryDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<LectureCategory> selectAll() {
		
		String sql = "select * from lecturecategory";
		
		List<LectureCategory> list = jdbcTemplate.query(sql, new RowMapper<LectureCategory>(){

			@Override
			public LectureCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				LectureCategory lectureCategory = new LectureCategory();
				
				lectureCategory.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lectureCategory.setTitle(rs.getString("title"));
				lectureCategory.setInstructor(rs.getString("instructor"));
				lectureCategory.setContent(rs.getString("content"));
				lectureCategory.setSummary(rs.getString("summary"));
				lectureCategory.setImg(rs.getString("img"));
				lectureCategory.setSummaryimg(rs.getString("summaryimg"));
				lectureCategory.setLang(rs.getString("lang"));
				lectureCategory.setIde(rs.getString("ide"));
				lectureCategory.setRank(rs.getInt("rank"));
				lectureCategory.setPrice(rs.getInt("price"));
				lectureCategory.setIssummary(rs.getInt("issummary"));
				lectureCategory.setNumoflecture(rs.getInt("numoflecture"));
				
				return lectureCategory;
				
			}
			
		});
		
		return list;
		
	}

	@Override
	public LectureCategory selectOne(int lecturecategory_id) {
		
		String sql = "select * from lecturecategory where lecturecategory_id=?";
		
		LectureCategory lectureCategory = jdbcTemplate.queryForObject(sql, new RowMapper<LectureCategory>(){

			@Override
			public LectureCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				LectureCategory lectureCategory = new LectureCategory();
				
				lectureCategory.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lectureCategory.setTitle(rs.getString("title"));
				lectureCategory.setInstructor(rs.getString("instructor"));
				lectureCategory.setContent(rs.getString("content"));
				lectureCategory.setSummary(rs.getString("summary"));
				lectureCategory.setImg(rs.getString("img"));
				lectureCategory.setSummaryimg(rs.getString("summaryimg"));
				lectureCategory.setLang(rs.getString("lang"));
				lectureCategory.setIde(rs.getString("ide"));
				lectureCategory.setRank(rs.getInt("rank"));
				lectureCategory.setPrice(rs.getInt("price"));
				lectureCategory.setIssummary(rs.getInt("issummary"));
				lectureCategory.setNumoflecture(rs.getInt("numoflecture"));
				
				return lectureCategory;
				
			}
			
		}, lecturecategory_id);
		
		return lectureCategory;
	
	}

	/*@Override
	public int insert(LectureCategory lectureCategory) {
		
		String sql = "insert into lecturecategory(title, instructor, content, summary, img, summaryimg, lang, ide, rank, price)";
		sql = sql + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				lectureCategory.getTitle(),
				lectureCategory.getInstructor(),
				lectureCategory.getContent(),
				lectureCategory.getSummary(),
				lectureCategory.getImg(),
				lectureCategory.getSummaryimg(),
				lectureCategory.getLang(),
				lectureCategory.getIde(),
				lectureCategory.getRank(),
				lectureCategory.getPrice()
				
		});
		
		return result;
		
	}

	@Override
	public int update(LectureCategory lectureCategory) {
		
		String sql = "update lecturecategory set title=?, instructor=?, content=?, summary=?, img=?, summaryimg=?, lang=?, ide=?, rank=?, price=?";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				lectureCategory.getTitle(),
				lectureCategory.getInstructor(),
				lectureCategory.getContent(),
				lectureCategory.getSummary(),
				lectureCategory.getImg(),
				lectureCategory.getSummaryimg(),
				lectureCategory.getLang(),
				lectureCategory.getIde(),
				lectureCategory.getRank(),
				lectureCategory.getPrice()
				
		});
		
		return result;
		
	}

	@Override
	public int delete(int lecturecategory_id) {
		
		String sql = "delete from lecturecategory where lecturecategory_id=?";

		int result = jdbcTemplate.update(sql, lecturecategory_id);
		
		return result;
		
	}*/

}
