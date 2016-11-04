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
	public List selectAll() {
		String sql = "select * from lecturecategory order by lecturecategory_id desc";
		List list = jdbcTemplate.query(sql, new RowMapper<LectureCategory>() {
			@Override
			public LectureCategory mapRow(ResultSet rs, int row) throws SQLException {
				LectureCategory lectureCategory = new LectureCategory();
				lectureCategory.setLectureCategory_id(rs.getInt("lecturecategory_id"));
				lectureCategory.setTitle(rs.getString("title"));
				lectureCategory.setInstructor(rs.getString("instructor"));
				lectureCategory.setContent(rs.getString("content"));
				lectureCategory.setSummary(rs.getString("summary"));
				lectureCategory.setLang(rs.getString("lang"));
				lectureCategory.setIde(rs.getString("ide"));
				lectureCategory.setImg(rs.getString("img"));
				lectureCategory.setSummaryimg(rs.getString("summaryimg"));
				lectureCategory.setPrice(rs.getInt("price"));
				lectureCategory.setRank(rs.getInt("rank"));
				lectureCategory.setIsSummary(rs.getInt("issummary"));
				lectureCategory.setNumOfLecture(rs.getInt("numoflecture"));
				lectureCategory.setSort(rs.getInt("sort"));
				return lectureCategory;
			}
			
		});
		return list;
	}

	@Override
	public LectureCategory select(int lectureCategory_id) {
		String sql = "select * from lecturecategory where lecturecategory_id=?";
		LectureCategory lectureCategory = jdbcTemplate.queryForObject(sql, new RowMapper<LectureCategory>() {

			@Override
			public LectureCategory mapRow(ResultSet rs, int row) throws SQLException {
				LectureCategory lectureCategory = new LectureCategory();
				lectureCategory.setLectureCategory_id(rs.getInt("lecturecategory_id"));
				lectureCategory.setTitle(rs.getString("title"));
				lectureCategory.setInstructor(rs.getString("instructor"));
				lectureCategory.setContent(rs.getString("content"));
				lectureCategory.setSummary(rs.getString("summary"));
				lectureCategory.setLang(rs.getString("lang"));
				lectureCategory.setIde(rs.getString("ide"));
				lectureCategory.setImg(rs.getString("img"));
				lectureCategory.setSummaryimg(rs.getString("summaryimg"));
				lectureCategory.setPrice(rs.getInt("price"));
				lectureCategory.setRank(rs.getInt("rank"));
				lectureCategory.setIsSummary(rs.getInt("issummary"));
				lectureCategory.setNumOfLecture(rs.getInt("numoflecture"));
				lectureCategory.setSort(rs.getInt("sort"));
				return lectureCategory;
			}
		}, lectureCategory_id);
		
		return lectureCategory;
	}

	@Override
	public int insert(LectureCategory lectureCategory) {
		String sql = "insert into lecturecategory(title, instructor, content, summary, lang, ide, price, issummary, sort)";
		sql += " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, new Object[]{
				lectureCategory.getTitle(),
				lectureCategory.getInstructor(),
				lectureCategory.getContent(),
				lectureCategory.getSummary(),
				lectureCategory.getLang(),
				lectureCategory.getIde(),
				lectureCategory.getPrice(),
				lectureCategory.getIsSummary(),
				lectureCategory.getSort()
		});
		return result;
	}

	@Override
	public int delete(int lectureCategory_id) {
		String sql = "delete from lecturecategory where lecturecategory_id=?";
		int result = jdbcTemplate.update(sql, lectureCategory_id);
		return result;
	}

	@Override
	public int update(LectureCategory lectureCategory) {
		String sql = "update lecturecategory set title=?, instructor=?, content=?, summary=?, lang=?, ide=?, price=?, issummary=?, img=?, summaryimg=?, sort=?";
		sql += " where lecturecategory_id=?";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				lectureCategory.getTitle(),
				lectureCategory.getInstructor(),
				lectureCategory.getContent(),
				lectureCategory.getSummary(),
				lectureCategory.getLang(),
				lectureCategory.getIde(),
				lectureCategory.getPrice(),
				lectureCategory.getIsSummary(),
				lectureCategory.getImg(),
				lectureCategory.getSummaryimg(),
				lectureCategory.getSort(),
				lectureCategory.getLectureCategory_id()
		});
		return result;
	}
	
	@Override
	public int lastInsertId() {
		String sql = "select last_insert_id()";
		int result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}
	
	@Override
	public int increaseNumOfLecture(int lectureCategory_id) {
		String sql = "select numoflecture from lecturecategory where lecturecategory_id=?";
		int numOfLecture = jdbcTemplate.queryForObject(sql, Integer.class, lectureCategory_id);
		sql = "update lecturecategory set numOfLecture=? where lecturecategory_id=?";
		int reulst = jdbcTemplate.update(sql, numOfLecture+1, lectureCategory_id);
		return reulst;
	}
	@Override
	public int decreaseNumOfLecture(int lectureCategory_id) {
		String sql = "select numoflecture from lecturecategory where lecturecategory_id=?";
		int numOfLecture = jdbcTemplate.queryForObject(sql, Integer.class, lectureCategory_id);
		sql = "update lecturecategory set numOfLecture=? where lecturecategory_id=?";
		int reulst = jdbcTemplate.update(sql, numOfLecture-1, lectureCategory_id);
		return reulst;
	}
}
