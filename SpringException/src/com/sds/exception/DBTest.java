/*
		
		예외 처리의 목적 : 비정상 종료의 방지
		예외 처리 방법 : 
		
		1. try~catch
			현재 메서드에서 예외처리를 마무리한다.
			
		2. throws
			예외를 전가시키는 것으로 예외를 현재 메서드에서 부적절하게 처리할 경우
			예외의 내용을 외부로 전달할 때 사용
			
		예외를 개발자가 발생시키는 방법 : throw
		
*/
package com.sds.exception;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest{
	
	/*
		
		스프링이 지원하는 db를 사용하면 트랜잭션 처리시 aop를 이용할 수도
		있을 뿐만 아니라 예외처리가 쉬워진다.
		
	*/
	
	//	오라클 연동
	/*String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="spring";
	String password="spring";*/
	
	//	마리아db연동
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhot:3306:mvc";
	String user="root";
	String password="";

	public DBTest() {
	
		connect();
	
	}
	
	public void connect() {
		
		try {
			
			Class.forName(driver);		//	드라이버 로드
			DriverManager.getConnection(url, user, password);
		
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 경로가 올바르지 않습니다.");
		
		} catch (SQLException e) {
			
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			
			/*if(e.getErrorCode()==17002){
			
				System.out.println("url 정보가 틀렸습니다.");
			
			}else if(e.getErrorCode()==1017){
				
				System.out.println("id가 틀렸습니다.");
				
			}*/
				
		}
		
	}
	
	public static void main(String[] args) {
		
		DBTest dbTest =  new DBTest();
		
	}
	
}
