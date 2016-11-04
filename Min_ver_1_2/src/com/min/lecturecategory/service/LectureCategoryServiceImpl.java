package com.min.lecturecategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.min.domain.LectureCategory;
import com.min.lecturecategory.dao.LectureCategoryDAO;

@Service
public class LectureCategoryServiceImpl implements LectureCategoryService{
	@Autowired
	@Qualifier("lectureCategoryDAOSpringJdbc")
	private LectureCategoryDAO lectureCategoryDAO;
	
	@Override
	public List selectAll() {
		return lectureCategoryDAO.selectAll();
	}

	@Override
	public LectureCategory select(int lectureCategory_id) {
		return lectureCategoryDAO.select(lectureCategory_id);
	}

	@Override
	public int insert(LectureCategory lectureCategory) {
		return lectureCategoryDAO.insert(lectureCategory);
	}

	@Override
	public int delete(int lectureCategory_id) {
		return lectureCategoryDAO.delete(lectureCategory_id);
	}

	@Override
	public int update(LectureCategory lectureCategory) {
		return lectureCategoryDAO.update(lectureCategory);
	}
	
	@Override
	public int lastInsertId() {
		return lectureCategoryDAO.lastInsertId();
	}
}
