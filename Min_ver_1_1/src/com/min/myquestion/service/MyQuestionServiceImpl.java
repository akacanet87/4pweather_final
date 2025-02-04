package com.min.myquestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.min.domain.MyQuestion;
import com.min.myquestion.dao.MyQuestionDAO;

@Service
public class MyQuestionServiceImpl implements MyQuestionService{
	
	@Autowired
	@Qualifier("myQuestionDAOSpringJdbc")
	private MyQuestionDAO myQuestionDAO;

	@Override
	public List<MyQuestion> selectListOfLecture(int member_id, int lecture_id) {
		
		return myQuestionDAO.selectListOfLecture(member_id, lecture_id);
		
	}

	@Override
	public List<MyQuestion> selectAll(int member_id) {
		
		return myQuestionDAO.selectAll(member_id);
		
	}

	@Override
	public MyQuestion selectOne(int member_id, int myquestion_id) {
		
		return myQuestionDAO.selectOne(member_id, myquestion_id);
		
	}

	@Override
	public int insert(MyQuestion myQuestion) {
		
		return myQuestionDAO.insert(myQuestion);
		
	}

	@Override
	public int update(MyQuestion myQuestion) {
		
		return myQuestionDAO.update(myQuestion);
		
	}

	@Override
	public int delete(int myquestion_id) {
		
		return myQuestionDAO.delete(myquestion_id);
		
	}

	@Override
	public int getLastVal() {
		
		return myQuestionDAO.getLastVal();
		
	}

}
