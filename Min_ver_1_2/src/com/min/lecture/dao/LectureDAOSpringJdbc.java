package com.min.lecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.min.domain.Lecture;

@Repository
public class LectureDAOSpringJdbc implements LectureDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List selectAll() {
		String sql = "select * from lecture order by lecture_id desc";
		List list = jdbcTemplate.query(sql, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int row) throws SQLException {
				Lecture lecture = new Lecture();
				lecture.setLecture_id(rs.getInt("lecture_id"));
				lecture.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lecture.setTitle(rs.getString("title"));
				lecture.setContent(rs.getString("content"));
				lecture.setLink(rs.getString("link"));
				lecture.setThumbnail(rs.getString("thumbnail"));
				lecture.setLecturefile(rs.getString("lecturefile"));
				lecture.setHomework(rs.getString("homework"));
				lecture.setRegdate(rs.getString("regdate"));
				lecture.setHit(rs.getInt("hit"));
				return lecture;
			}
		});
		return list;
	}
	
	@Override
	public List selectAll(int lecturecategory_id) {
		String sql = "select * from lecture where lecturecategory_id=? order by lecture_id desc";
		List list = jdbcTemplate.query(sql, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int row) throws SQLException {
				Lecture lecture = new Lecture();
				lecture.setLecture_id(rs.getInt("lecture_id"));
				lecture.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lecture.setTitle(rs.getString("title"));
				lecture.setContent(rs.getString("content"));
				lecture.setLink(rs.getString("link"));
				lecture.setThumbnail(rs.getString("thumbnail"));
				lecture.setLecturefile(rs.getString("lecturefile"));
				lecture.setHomework(rs.getString("homework"));
				lecture.setRegdate(rs.getString("regdate"));
				lecture.setHit(rs.getInt("hit"));
				return lecture;
			}
		}, lecturecategory_id);
		return list;
	}

	@Override
	public Lecture select(int lecture_id) {
		String sql = "select * from lecture where lecture_id=?";
		Lecture lecture = jdbcTemplate.queryForObject(sql, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int row) throws SQLException {
				Lecture lecture = new Lecture();
				lecture.setLecture_id(rs.getInt("lecture_id"));
				lecture.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lecture.setTitle(rs.getString("title"));
				lecture.setContent(rs.getString("content"));
				lecture.setLink(rs.getString("link"));
				lecture.setThumbnail(rs.getString("thumbnail"));
				lecture.setLecturefile(rs.getString("lecturefile"));
				lecture.setHomework(rs.getString("homework"));
				lecture.setRegdate(rs.getString("regdate"));
				lecture.setHit(rs.getInt("hit"));
				return lecture;
			}
		}, lecture_id);
		return lecture;
	}

	@Override
	public int insert(Lecture lecture) {
		String sql = "insert into lecture(title, content, link, thumbnail, lecturecategory_id)";
		sql += " values(?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, new Object[]{
				lecture.getTitle(),
				lecture.getContent(),
				lecture.getLink(),
				lecture.getThumbnail(),
				lecture.getLecturecategory_id()
		});
		return result;
	}

	@Override
	public int delete(int lecture_id) {
		String sql = "delete from lecture where lecture_id=?";
		int reulst = jdbcTemplate.update(sql, lecture_id);
		return reulst;
	}

	@Override
	public int update(Lecture lecture) {
		String sql = "update lecture set title=?, content=?, link=?, thumbnail=?, homework=?, lecturefile=?";
		sql += " where lecture_id=?";
		System.out.println("here");
		int result = jdbcTemplate.update(sql, new Object[]{
				lecture.getTitle(),
				lecture.getContent(),
				lecture.getLink(),
				lecture.getThumbnail(),
				lecture.getHomework(),
				lecture.getLecturefile(),
				lecture.getLecture_id()
		});
		return result;
	}
	
	@Override
	public int getLastInsertId() {
		String sql = "select last_insert_id()";
		int result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}
	
	@Override
	public int getCurLectureNum(Lecture lecture) {
		String sql = "select count(*) from lecture where lecturecategory_id=? and lecture_id <=? order by regdate asc";
		int result = jdbcTemplate.queryForObject(sql, Integer.class, lecture.getLecturecategory_id(), lecture.getLecture_id());
		return result;
	}

}
