package com.min.lecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.min.domain.Lecture;

@Repository
public class LectureDAOSpringJdbc implements LectureDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Lecture> selectAll(int lecturecategory_id) {

		String sql = "select * from lecture where lecturecategory_id=?";

		List<Lecture> list = jdbcTemplate.query(sql, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setLecture_id(rs.getInt("lecture_id"));
				lecture.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lecture.setTitle(rs.getString("title"));
				lecture.setContent(rs.getString("content"));
				lecture.setLink(rs.getString("link"));
				lecture.setRegdate(rs.getString("regdate"));
				lecture.setHit(rs.getInt("hit"));

				return lecture;

			}

		}, lecturecategory_id);

		return list;

	}

	@Override
	public Lecture selectOne(int lecture_id) {

		String sql = "select * from lecture where lecture_id=?";

		Lecture lecture = jdbcTemplate.queryForObject(sql, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();

				lecture.setLecture_id(rs.getInt("lecture_id"));
				lecture.setLecturecategory_id(rs.getInt("lecturecategory_id"));
				lecture.setTitle(rs.getString("title"));
				lecture.setContent(rs.getString("content"));
				lecture.setLink(rs.getString("link"));
				lecture.setRegdate(rs.getString("regdate"));
				lecture.setHit(rs.getInt("hit"));

				return lecture;
				
			}

		}, lecture_id);

		return lecture;

	}

	/*@Override
	public int insert(Lecture lecture) {
		
		String sql = "insert into lecture(lecturecategory_id, title, content, link, track, homework, lecturefile)";
		sql = sql + " values(?, ?, ?, ?, ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				lecture.getLecturecategory_id(),
				lecture.getTitle(),
				lecture.getContent(),
				lecture.getLink(),
				lecture.getTrack(),
				lecture.getHomework(),
				lecture.getLecturefile()
				
		});

		return result;

	}

	@Override
	public int update(Lecture lecture) {
		
		String sql = "update lecture set lecturecategory_id=?, title=?, content=?, link=?, track=?, homework=?, lecturefile=?";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				lecture.getLecturecategory_id(),
				lecture.getTitle(),
				lecture.getContent(),
				lecture.getLink(),
				lecture.getTrack(),
				lecture.getHomework(),
				lecture.getLecturefile()
				
		});
		
		return result;

	}

	@Override
	public int delete(int lecture_id) {
		
		String sql = "delete from lecture where lecture_id=?";
		
		int result = jdbcTemplate.update(sql, lecture_id);

		return 0;

	}*/

}
