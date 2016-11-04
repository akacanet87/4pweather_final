package com.min.lecture.service;

import java.util.List;

import com.min.domain.Lecture;
import com.min.domain.LectureCategory;

public interface LectureService {
	public List selectAll();
	public List selectAll(int lecturecategory_id);
	public Lecture select(int lecture_id);
	public int insert(Lecture lecture);
	public int delete(int lecture_id);
	public int update(Lecture lecture);
	public List getLectureCategoryAll();
	public LectureCategory getLectureCategory(int lecturecategory_id);
	public int getCurLectureNum(Lecture lecture);
	public int getLastInsertId();
	public int increaseNumOfLecture(int lecturecategory_id);
	public int decreaseNumOfLecture(int lecturecategory_id);
}
