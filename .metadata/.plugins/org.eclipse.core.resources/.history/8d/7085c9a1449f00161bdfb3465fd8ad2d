package com.sds.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sds.model.dao.ReBoardDAO;
import com.sds.model.domain.ReBoard;

@Service
public class ReBoardServiceImpl implements ReBoardService{

	@Autowired
	@Qualifier("reBoardDAOJdbc")
	private ReBoardDAO reboardDAO;
	
	@Override
	public List<ReBoard> selectAll() {
		
		return reboardDAO.selectAll();
		
	}

	@Override
	public ReBoard select(int reboard_id) {
		
		return reboardDAO.select(reboard_id);
		
	}

	@Override
	public int insert(ReBoard reboard) {
		
		return reboardDAO.insert(reboard);
	
	}

	@Override
	public int delete(int reboard_id) {
		
		return 0;
	}

	@Override
	public int update(ReBoard reboard) {
		
		return 0;
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED)			//	어노테이션을 이해하게 하려면 context에서 처리해야 한다.
	public int reply(ReBoard reboard) {
		
		//	트랜잭션이 일어나는 부분
		//	독립적으로 Commit이 일어나지 않고 하나로 묶여있다.
		//	Spring에 의존적인 JdbcTemplate을 이용하기 때문에 가능
		
		//	이미 존재하는 게시물의 rank 업데이트
		reboardDAO.updateRank(reboard);			//	들어갈 공간 확보
		
		//	새롭게 등록될 답변 글
		reboard.setRank(reboard.getRank()+1);
		reboard.setDepth(reboard.getDepth()+1);
		reboardDAO.replyInsert(reboard);
		
		return 0;
	}

}
