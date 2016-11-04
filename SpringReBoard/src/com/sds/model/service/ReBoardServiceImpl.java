package com.sds.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sds.model.dao.ReBoardDAO;
import com.sds.model.domain.ReBoard;

@Service
public class ReBoardServiceImpl implements ReBoardService{

	@Autowired
	@Qualifier("reBoardDAOJdbc")
	private ReBoardDAO reboardDAO;
	
	@Override
	public List<ReBoard> selectAll() {
		
		return reboardDAO.selectAll();
		
	}

	@Override
	public ReBoard select(int reboard_id) {
		
		return reboardDAO.select(reboard_id);
		
	}

	@Override
	public int insert(ReBoard reboard) {
		
		return reboardDAO.insert(reboard);
	
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
	//@Transactional(propagation=Propagation.REQUIRED)			//	������̼��� �����ϰ� �Ϸ��� context���� ó���ؾ� �Ѵ�.
	public int reply(ReBoard reboard) {
		
		//	Ʈ������� �Ͼ�� �κ�
		//	���������� Commit�� �Ͼ�� �ʰ� �ϳ��� �����ִ�.
		//	Spring�� �������� JdbcTemplate�� �̿��ϱ� ������ ����
		
		//	�̹� �����ϴ� �Խù��� rank ������Ʈ
		reboardDAO.updateRank(reboard);			//	�� ���� Ȯ��
		
		//	���Ӱ� ��ϵ� �亯 ��
		reboard.setRank(reboard.getRank()+1);
		reboard.setDepth(reboard.getDepth()+1);
		reboardDAO.replyInsert(reboard);
		
		return 0;
	}

}
