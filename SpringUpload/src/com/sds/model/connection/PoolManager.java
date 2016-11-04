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
	private InitialContext context;			//	JNDI °Ë»ö °´Ã¼
	private DataSource ds;						//	DATA ¼Ò½º ( DB Ä¿³Ø¼Ç Á¤º¸ °´Ã¼ )
	
	private PoolManager() {
	
		try {
			
			context = new InitialContext();
			
			//	xml °Ë»ö
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
	
	//	´ë¿©
	public Connection getConnection(){
		
		Connection con = null;
		
		try {
		
			con = ds.getConnection();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	//	¹Ý³³ - DML (insert, update, delete )
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
