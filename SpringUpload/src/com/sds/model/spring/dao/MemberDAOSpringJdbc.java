/*
		
		���ݱ����� �������� MVC ���Ͽ� ������ Spring MVC ���� ��Դ�.
		������ �������� ��������������� �� �������� �ʿ�� �ϴ� ������� �������ش�.
		�������� �����ͺ��̽� ���� ����� ���� �н��ϱ�
		
		jdbc						: �������� �����ϴ� JDBC
		ibatis / mybatis		: �������� �����ϴ� mybatis
		hibernate
		JPA
		JTA
		
		����)
		�������� �����ϴ� DB���� ����� ����� ���û���������
		��� �� ������(.xml), ������̼�(@) ����� Ʈ����� ������ ���� �� �ִ�.
		
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
		
		jdbcTemplate�� �̿��ϸ� ������ jdbc �ڵ��� ȿ���� �����ϳ�
		�����ڰ� Connection, PreparedStatement ���� ó���� �ʿ䰡 ����.
		
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
		
		//	���� ���������� �߻��� primary key ���
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
