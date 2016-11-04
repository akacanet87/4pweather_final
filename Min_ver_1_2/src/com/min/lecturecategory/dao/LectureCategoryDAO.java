package com.min.lecturecategory.dao;

import java.util.List;

import com.min.domain.LectureCategory;

public interface LectureCategoryDAO {
	public List selectAll();
	public LectureCategory select(int lectureCategory_id);
	public int insert(LectureCategory lectureCategory);
	public int delete(int lectureCategory_id);
	public int update(LectureCategory lectureCategory);
	public int lastInsertId();
	public int increaseNumOfLecture(int lectureCategory_id);
	public int decreaseNumOfLecture(int lectureCategory_id);
}
