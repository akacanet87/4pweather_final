package com.min.lecture.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.min.domain.Lecture;
import com.min.domain.LectureCategory;
import com.min.lecture.dao.LectureDAO;
import com.min.lecturecategory.dao.LectureCategoryDAO;

@Service
public class LectureSerivceImpl implements LectureSerivce{

	@Autowired
	@Qualifier("lectureDAOSpringJdbc")
	private LectureDAO lectureDAO;
	
	@Autowired
	@Qualifier("lectureCategoryDAOSpringJdbc")
	private LectureCategoryDAO lectureCategoryDAO;
	
	@Override
	public List<Lecture> selectAll( int lecturecategory_id ) {
		
		List<Lecture> list = lectureDAO.selectAll(lecturecategory_id);
		
		return list;
		
	}

	@Override
	public Lecture selectOne( int lecture_id ) {
		
		Lecture lecture = lectureDAO.selectOne(lecture_id);
		
		return lecture;
		
	}

	@Override
	public HashMap<String, String> getCategoryValues(int lecturecategory_id) {
		
		LectureCategory lectureCategory = lectureCategoryDAO.selectOne(lecturecategory_id);
		
		int lecturecategoryid=lectureCategory.getLecturecategory_id();
		String title=lectureCategory.getTitle();
		String instructor=lectureCategory.getInstructor();
		String content=lectureCategory.getContent();
		String summary=lectureCategory.getSummary();
		String img=lectureCategory.getImg();
		String summaryimg=lectureCategory.getSummaryimg();
		int rank=lectureCategory.getRank();
		String lang=lectureCategory.getLang();
		String ide=lectureCategory.getIde();
		int price=lectureCategory.getPrice();
		int issummary=lectureCategory.getIssummary();
		int numoflecture=lectureCategory.getNumoflecture();
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("lecturecategory_id", Integer.toString(lecturecategoryid));
		map.put("title", title);
		map.put("instructor", instructor);
		map.put("content", content);
		map.put("summary", summary);
		map.put("img", img);
		map.put("summaryimg", summaryimg);
		map.put("rank", Integer.toString(rank));
		map.put("lang", lang);
		map.put("ide", ide);
		map.put("price", Integer.toString(price));
		map.put("issummary", Integer.toString(issummary));
		map.put("numoflecture", Integer.toString(numoflecture));
		
		return map;
		
	}
	
	@Override
	public HashMap<String, String> getLectureValues(int lecture_id) {
		
		Lecture lecture = lectureDAO.selectOne(lecture_id);
		
		int lectureid=lecture.getLecture_id();
		int lecturecategoryid=lecture.getLecturecategory_id();
		String title=lecture.getTitle();
		String content=lecture.getContent();
		String link=lecture.getLink();
		String regdate=lecture.getRegdate();
		int hit=lecture.getHit();
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("lecture_id", Integer.toString(lectureid));
		map.put("lecturecategory_id", Integer.toString(lecturecategoryid));
		map.put("title", title);
		map.put("content", content);
		map.put("link", link);
		map.put("regdate", regdate);
		map.put("hit", Integer.toString(hit));
		
		return map;
		
	}

}
