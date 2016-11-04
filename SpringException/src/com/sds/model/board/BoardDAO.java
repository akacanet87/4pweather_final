package com.sds.model.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.domain.Board;

@Repository
public interface BoardDAO {
	
	public List selectAll();
	public Board selectOne( int board_id );
	public void insert( Board board );
	public void update( Board board );
	public void delete( int board_id );

}
