package com.sds.model.service;

import java.util.List;

import com.sds.model.domain.ReBoard;

public interface ReBoardService {
	
	public List selectAll();
	public ReBoard select( int reboard_id );
	public int insert( ReBoard reboard );
	public int delete( int reboard_id );
	public int update( ReBoard reboard );
	
	//	답변 등록
	public int reply( ReBoard reboard );

}
