package com.sds.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sds.model.dao.AssetDAO;
import com.sds.model.dao.MemberDAO;
import com.sds.model.domain.Asset;
import com.sds.model.domain.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	@Qualifier("memberDAOSpringMybatis")
	private MemberDAO memberDAO;
	
	@Autowired
	@Qualifier("assetDAOSpringMybatis")
	private AssetDAO assetDAO;
	
	//	∞°¿‘
	@Override
	public int regist(Member member) {
		
		int result = 0;
		
		int member_id = memberDAO.insert(member);
		Asset asset = member.getAsset();
		asset.setMember_id(member_id);
		assetDAO.insert(asset);
			
		return result;

	}

	@Override
	public int delete(int memeber_id) {
		
		return 0;
	}

	@Override
	public int update(Member member) {
		
		return 0;
	}

	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public Member select(int member_id) {
		
		return null;
	}

}
