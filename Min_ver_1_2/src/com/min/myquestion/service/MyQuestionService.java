package com.min.myquestion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.domain.MyQuestion;

@Service
public interface MyQuestionService {
	
	public List<MyQuestion> selectListOfLecture( int member_id, int lecture_id );
	public List<MyQuestion> selectAll( int member_id  );
	public MyQuestion selectOne( int member_id, int myquestion_id );
	public int insert( MyQuestion myQuestion );
	public int update( MyQuestion myQuestion );
	public int delete( int myquestion_id );
	public int getLastVal();

}
