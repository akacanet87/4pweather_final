package com.min.myquestion.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.min.domain.MyQuestion;

@Repository
public class MyQuestionDAOSpringJdbc implements MyQuestionDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MyQuestion> selectListOfLecture(int member_id, int lecture_id) {
		
		String sql = "select * from myquestion where member_id=? and lecture_id=? order by desc";
		
		List<MyQuestion> list = jdbcTemplate.query(sql, new RowMapper<MyQuestion>(){

			@Override
			public MyQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MyQuestion myQuestion = new MyQuestion();
				
				myQuestion.setMyquestion_id(rs.getInt("myquestion_id"));
				myQuestion.setLecture_id(rs.getInt("lecture_id"));
				myQuestion.setMember_id(rs.getInt("member_id"));
				myQuestion.setContent(rs.getString("content"));
				myQuestion.setRegdate(rs.getString("regdate"));
				
				return myQuestion;
				
			}
			
		}, member_id, lecture_id);
		
		return list;
		
	}

	@Override
	public List<MyQuestion> selectAll(int member_id ) {
		
		String sql = "select * from myquestion where member_id=?";
		
		List<MyQuestion> list = jdbcTemplate.query(sql, new RowMapper<MyQuestion>(){

			@Override
			public MyQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MyQuestion myQuestion = new MyQuestion();
				
				myQuestion.setMyquestion_id(rs.getInt("myquestion_id"));
				myQuestion.setLecture_id(rs.getInt("lecture_id"));
				myQuestion.setMember_id(rs.getInt("member_id"));
				myQuestion.setContent(rs.getString("content"));
				myQuestion.setRegdate(rs.getString("regdate"));
				
				return myQuestion;
				
			}
			
		}, member_id );
		
		return list;
		
	}

	@Override
	public MyQuestion selectOne(int member_id, int myquestion_id ) {
		
		String sql = "select * from myquestion where member_id=? and myquestion_id=?";
		
		MyQuestion myQuestion = jdbcTemplate.queryForObject(sql, new RowMapper<MyQuestion>(){

			@Override
			public MyQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MyQuestion myQuestion = new MyQuestion();
				
				myQuestion.setMyquestion_id(rs.getInt("myquestion_id"));
				myQuestion.setLecture_id(rs.getInt("lecture_id"));
				myQuestion.setMember_id(rs.getInt("member_id"));
				myQuestion.setContent(rs.getString("content"));
				myQuestion.setRegdate(rs.getString("regdate"));
				
				return myQuestion;
				
			}
			
		}, member_id, myquestion_id);
		
		return myQuestion;
		
	}

	@Override
	public int insert(MyQuestion myQuestion) {
		
		String sql = "insert into myquestion(lecture_id, member_id, content)";
		sql = sql + " values( ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				myQuestion.getLecture_id(),
				myQuestion.getMember_id(),
				myQuestion.getContent(),
				
		});
		
		return result;
		
	}

	@Override
	public int update(MyQuestion myQuestion) {
		
		String sql = "update myquestion set content=? where myquestion_id=?";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				myQuestion.getContent(), myQuestion.getMyquestion_id()
				
		});
		
		return result;
		
	}

	@Override
	public int delete(int myquestion_id) {
		
		String sql = "delete from myquestion where myquestion_id=?";
		
		int result = jdbcTemplate.update(sql, myquestion_id);
		
		return result;
		
	}

	@Override
	public int getLastVal() {
		
		String sql = "select last_insert_id()";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return result;
		
	}

}
