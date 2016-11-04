package com.sds.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.model.connection.SessionManager;
import com.sds.model.domain.Asset;

@Repository
public class AssetDAOMybatis implements AssetDAO{
	
	@Autowired
	private SessionManager manager;

	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public Asset select(int asset_id) {
		
		return null;
	}

	@Override
	public int insert(Asset asset) {
		
		SqlSession session = manager.getSession();
		
		int result = session.insert("Asset.insert", asset);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(Asset asset) {
		
		return 0;
	}

	@Override
	public int delete(int asset_id) {
		
		return 0;
	}
	
	

}
