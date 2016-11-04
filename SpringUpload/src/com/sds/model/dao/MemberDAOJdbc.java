package com.sds.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.model.connection.PoolManager;
import com.sds.model.domain.Member;

@Repository
public class MemberDAOJdbc implements MemberDAO{
	
	@Autowired
	private PoolManager pool;

	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public Member select(int member_id) {
		
		return null;
	}

	@Override
	public int insert(Member member) {
		
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		int result = 0;
		
		con = pool.getConnection();
		
		String sql = "insert into member(member_id, id, password, profile)";
		sql = sql+ " values(seq_member.nextval, ?, ?, ?)";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getProfile());
			
			result = pstmt.executeUpdate();
			
			if( result != 0 ){
			
				sql="select seq_member.currval as member_id from dual";
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				//	Asset¿¡ insert
				sql = "insert into asset(asset)";
				
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(Member member) {
		
		return 0;
	}

	@Override
	public int delete(int member_id) {
		
		return 0;
	}

}
