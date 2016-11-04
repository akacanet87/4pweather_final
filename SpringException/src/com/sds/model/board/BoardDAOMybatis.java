package com.sds.model.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.domain.Board;
import com.sds.exception.spring.WriteException;

@Repository
public class BoardDAOMybatis implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public Board selectOne(int board_id) {
		
		return null;
	}

	@Override
	public void insert(Board board) throws WriteException{
		
		try {
			
			sqlSessionTemplate.insert("Board.insert", board);
			
		} catch (Exception e) {
			
			throw new WriteException("등록 실패");
			
		}
		
	}

	@Override
	public void update(Board board) {
	}

	@Override
	public void delete(int board_id) {
	}

}
