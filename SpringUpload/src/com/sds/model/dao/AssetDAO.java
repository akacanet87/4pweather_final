package com.sds.model.dao;

import java.util.List;

import com.sds.model.domain.Asset;

public interface AssetDAO {
	
	public List selectAll();
	public Asset select( int asset_id );
	public int insert( Asset asset );
	public int update( Asset asset );
	public int delete( int asset_id );

}
