/*
		
		지금까지는 스프링을 MVC 패턴에 적용한 Spring MVC 만을 써왔다.
		하지만 스프링은 엔터프라이즈급의 각 계층에서 필요로 하는 기술들을 지원해준다.
		스프링의 데이터베이스 연동 기술에 대해 학습하기
		
		jdbc						: 스프링이 지원하는 JDBC
		ibatis / mybatis		: 스프링이 지원하는 mybatis
		hibernate
		JPA
		JTA
		
		주의)
		스프링이 지원하는 DB연동 기술의 사용은 선택사항이지만
		사용 시 선언적(.xml), 어노테이션(@) 방식의 트랜잭션 지원을 받을 수 있다.
		
*/
package com.sds.model.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sds.model.dao.MemberDAO;
import com.sds.model.domain.Member;

@Repository
public class MemberDAOSpringJdbc implements MemberDAO{
	
	/*
		
		jdbcTemplate을 이용하면 기존의 jdbc 코딩과 효과는 동일하나
		개발자가 Connection, PreparedStatement 등을 처리할 필요가 없다.
		
	*/
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		
		String sql = "insert into member(member_id, id, password, profile) values(seq_member.nextval, ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, member.getId(), member.getPassword(), member.getProfile());
		
		//	현재 시퀀스에서 발생한 primary key 얻기
		sql = "select seq_member.currval as member_id from dual";
		
		if( result != 0 ){
			
			result = jdbcTemplate.queryForObject(sql, Integer.class);
		
		}
		
		return result;
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
