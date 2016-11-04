package com.sds.model.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class PoolManager {
	
	private static PoolManager instance;
	private InitialContext context;			//	JNDI �˻� ��ü
	private DataSource ds;						//	DATA �ҽ� ( DB Ŀ�ؼ� ���� ��ü )
	
	private PoolManager() {
	
		try {
			
			context = new InitialContext();
			
			//	xml �˻�
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public static PoolManager getInstance(){
		
		if( instance == null ){
			
			instance = new PoolManager();
			
		}
		
		return instance;
		
	}
	
	//	�뿩
	public Connection getConnection(){
		
		Connection con = null;
		
		try {
		
			con = ds.getConnection();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	//	�ݳ� - DML (insert, update, delete )
	public void freeConnection( Connection con, PreparedStatement pstmt ){
		
		if( pstmt != null ){
			
			try {
				
				pstmt.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		if( con != null ){
			
			try {
				
				con.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
	}
	
	public void freeConnection( Connection con, PreparedStatement pstmt, ResultSet rs ){
		
		if( pstmt != null ){
			
			try {
				
				pstmt.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		if( con != null ){
			
			try {
				
				con.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		if( rs != null ){
			
			try {
				
				rs.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
	}

}
