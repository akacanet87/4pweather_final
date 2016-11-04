package com.min.lecturecategory.dao;

import java.util.List;

import com.min.domain.LectureCategory;

public interface LectureCategoryDAO {
	
	public List<LectureCategory> selectAll();
	public LectureCategory selectOne( int lecturecategory_id );
	/*public int insert( LectureCategory lectureCategory );
	public int update( LectureCategory lectureCategory );
	public int delete( int lecturecategory_id );*/

}
