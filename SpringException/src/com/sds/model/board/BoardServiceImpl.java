package com.sds.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sds.domain.Board;
import com.sds.exception.spring.WriteException;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List selectAll() {
		
		return null;
		
	}

	@Override
	public Board select(int board_id) {
		
		return null;
		
	}

	@Override
	public void insert(Board board) throws WriteException{
		
		boardDAO.insert(board);
		
	}

	@Override
	public void update(Board board) {
		
		
		
	}

	@Override
	public void delete(int board_id) {
		
		
		
	}

}
