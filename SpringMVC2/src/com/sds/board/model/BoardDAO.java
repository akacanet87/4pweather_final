package com.sds.board.model;

import java.util.List;

import com.sds.domain.Board;

//	인터페이스를 만들어야 하는 이유
//	mybatis를 이용하다가 하이버네이트, jdbc 등으로 변경할 때 유지보수성이 높다.
public interface BoardDAO {

	public List selectAll();
	public Board select(int board_id);
	public int insert(Board board);
	public int update(Board board);
	public int delete(int board_id);
	
}

