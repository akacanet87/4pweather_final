package com.min.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.min.domain.Lecture;
import com.min.domain.LectureCategory;
import com.min.lecture.dao.LectureDAO;
import com.min.lecturecategory.dao.LectureCategoryDAO;

@Service
public class LectureServiceImpl implements LectureService{
	@Autowired
	@Qualifier("lectureCategoryDAOSpringJdbc")
	private LectureCategoryDAO lectureCategoryDAO;
	
	@Autowired
	@Qualifier("lectureDAOSpringJdbc")
	private LectureDAO lectureDAO;
	
	@Override
	public List selectAll() {
		return lectureDAO.selectAll();
	}
	
	@Override
	public List selectAll(int lecturecategory_id) {
		return lectureDAO.selectAll(lecturecategory_id);
	}

	@Override
	public Lecture select(int lecture_id) {
		return lectureDAO.select(lecture_id);
	}

	@Override
	public int insert(Lecture lecture) {
		return lectureDAO.insert(lecture);
	}

	@Override
	public int delete(int lecture_id) {
		return lectureDAO.delete(lecture_id);
	}

	@Override
	public int update(Lecture lecture) {
		return lectureDAO.update(lecture);
	}
	
	@Override
	public List getLectureCategoryAll() {
		return lectureCategoryDAO.selectAll();
	}
	
	@Override
	public LectureCategory getLectureCategory(int lecturecategory_id) {
		return lectureCategoryDAO.select(lecturecategory_id);
	}
	
	@Override
	public int getLastInsertId() {
		return lectureDAO.getLastInsertId();
	}
	
	@Override
	public int getCurLectureNum(Lecture lecture) {
		return lectureDAO.getCurLectureNum(lecture);
	}
	
	@Override
	public int increaseNumOfLecture(int lecturecategory_id) {
		return lectureCategoryDAO.increaseNumOfLecture(lecturecategory_id);
	}
	
	@Override
	public int decreaseNumOfLecture(int lecturecategory_id) {
		return lectureCategoryDAO.decreaseNumOfLecture(lecturecategory_id);
	}
}
