package com.min.lecture.service;

import java.util.HashMap;
import java.util.List;

import com.min.domain.Lecture;

public interface LectureSerivce {
	
	public List<Lecture> selectAll( int lecturecategory_id );
	public Lecture selectOne( int lecture_id );
	public HashMap<String, String> getCategoryValues( int lecturecategory_id );
	public HashMap<String, String> getLectureValues( int lecture_id );

}
