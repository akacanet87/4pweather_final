package com.min.lecturecategory.service;

import java.util.List;

import com.min.domain.LectureCategory;

public interface LectureCategoryService {
	public List selectAll();
	public LectureCategory select(int lectureCategory_id);
	public int insert(LectureCategory lectureCategory);
	public int delete(int lectureCategory_id);
	public int update(LectureCategory lectureCategory);
	public int lastInsertId();
}
