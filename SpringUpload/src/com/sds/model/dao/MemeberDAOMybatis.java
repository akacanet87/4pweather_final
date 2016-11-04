package com.sds.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.model.connection.SessionManager;
import com.sds.model.domain.Member;

//	���������� ����� ������Ʈ �����̾�� scan ����� �ȴ�.
//	dao�� ���� �о߿��� repository ��� �θ���.
@Repository
public class MemeberDAOMybatis implements MemberDAO{

	@Autowired
	private SessionManager manager;
	
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
		
		SqlSession session = manager.getSession();
		
		int result = session.insert("Member.insert", member);
		
		//	session.insert("Asset.insert", );
		
		session.commit();
		session.close();
		
		System.out.println("manager is "+manager);
		
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
