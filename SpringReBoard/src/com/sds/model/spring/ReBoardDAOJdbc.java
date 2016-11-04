package com.sds.model.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sds.model.dao.ReBoardDAO;
import com.sds.model.domain.ReBoard;

@Repository
public class ReBoardDAOJdbc implements ReBoardDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ReBoard> selectAll() {
		
		String sql = "select * from reboard order by team desc, rank asc";
		
		List<ReBoard> list = jdbcTemplate.query(sql, new RowMapper<ReBoard>() {

			@Override
			public ReBoard mapRow(ResultSet rs, int arg1) throws SQLException {
				
				ReBoard reboard = new ReBoard();
				
				reboard.setReboard_id(rs.getInt("reboard_id"));
				reboard.setWriter(rs.getString("writer"));
				reboard.setTitle(rs.getString("title"));
				reboard.setContent(rs.getString("content"));
				reboard.setRegdate(rs.getString("regdate"));
				reboard.setHit(rs.getInt("hit"));
				reboard.setTeam(rs.getInt("team"));
				reboard.setRank(rs.getInt("rank"));
				reboard.setDepth(rs.getInt("depth"));
				
				return reboard;
			}
			
		});
		
		return list;
	}

	@Override
	public ReBoard select(int reboard_id) {
		
		String sql = "select * from reboard where reboard_id=?";
		
		ReBoard reboard =jdbcTemplate.queryForObject(sql, new RowMapper<ReBoard>(){

			@Override
			public ReBoard mapRow(ResultSet rs, int row) throws SQLException {
				
				ReBoard reboard = new ReBoard();
				
				reboard.setReboard_id(rs.getInt("reboard_id"));
				reboard.setWriter(rs.getString("writer"));
				reboard.setTitle(rs.getString("title"));
				reboard.setContent(rs.getString("content"));
				reboard.setRegdate(rs.getString("regdate"));
				reboard.setHit(rs.getInt("hit"));
				reboard.setTeam(rs.getInt("team"));
				reboard.setRank(rs.getInt("rank"));
				reboard.setDepth(rs.getInt("depth"));
				
				return reboard;

			}
			
		}, reboard_id);
		
		return reboard;
	}

	@Override
	public int insert(ReBoard reboard) {
		
		String sql = "insert int reboard(reboard_id, writer, title, content, team)";
		sql = sql + " values(seq_reboard.nextval, ?, ?, ?, seq_reboard.nextval)";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				reboard.getWriter(), reboard.getTitle(), reboard.getContent()
				
		});
		
		return result;
	}

	@Override
	public int delete(int reboard_id) {
		
		return 0;
	}

	@Override
	public int update(ReBoard reboard) {
		
		return 0;
	}

	@Override
	public int updateRank(ReBoard reboard) {
		
		String sql="update reboard set rank=rank+1 where team=? and rank>?";
		
		int result = jdbcTemplate.update(sql, reboard.getTeam(), reboard.getRank());
		
		return result;
	}
	
	@Override
	public int replyInsert( ReBoard reboard ) {
		
		String sql = "insert into reboard(reboard_id, writer, title, content, team, rank, depth)";
		sql = sql + " values(seq_reboard.nextval, ?, ?, ?, ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, new Object[]{
				
				reboard.getWriter(), reboard.getTitle(), reboard.getContent(), reboard.getTeam(), reboard.getRank(), reboard.getDepth()
				
		});
		
		return result;
	}

}
