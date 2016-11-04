package com.sds.model.dao;

import java.util.List;

import com.sds.model.domain.ReBoard;

public interface ReBoardDAO {
	
	public List<ReBoard> selectAll();
	public ReBoard select( int reboard_id );
	public int insert( ReBoard reboard );
	public int delete( int reboard_id );
	public int update( ReBoard reboard );
	
	
	//	답변 등록
	public int updateRank( ReBoard reboard );
	public int replyInsert( ReBoard reboard );

}
