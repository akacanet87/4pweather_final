package com.sds.model.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.model.dao.AssetDAO;
import com.sds.model.domain.Asset;

@Repository
public class AssetDAOSpringMybatis implements AssetDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

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
		
		int result = sqlSessionTemplate.insert("Asset.insert", asset);
		
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
