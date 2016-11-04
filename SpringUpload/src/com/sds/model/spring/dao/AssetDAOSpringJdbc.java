package com.sds.model.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sds.model.dao.AssetDAO;
import com.sds.model.domain.Asset;

@Repository
public class AssetDAOSpringJdbc implements AssetDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		
		String sql = "insert into asset(asset_id, member_id, money, car) values(seq_asset.nextval, ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, new Object[]{ asset.getMember_id(), asset.getMoney(), asset.getCar() });
		
		/*if( result != 0 ){
			
			sql = "select seq_asset.currval as asset_id from dual";
			
			result = jdbcTemplate.queryForObject(sql, requiredType);
			
		}*/
		
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
