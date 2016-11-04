package com.min.lecture.dao;

import java.util.List;

import com.min.domain.Lecture;

public interface LectureDAO {
	public List selectAll();
	public List selectAll(int lecturecategory_id);
	public Lecture select(int lecture_id);
	public int insert(Lecture lecture);
	public int delete(int lecture_id);
	public int update(Lecture lecture);
	public int getLastInsertId();
	public int getCurLectureNum(Lecture lecture);
}