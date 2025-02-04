package com.min.controller.lecture;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.domain.Lecture;
import com.min.domain.MyQuestion;
import com.min.lecture.service.LectureSerivce;
import com.min.myquestion.service.MyQuestionService;

@Controller
@RequestMapping("/lecture/")
public class LectureController {
	
	@Autowired
	private LectureSerivce lectureSerivce;
	
	@Autowired
	private MyQuestionService myQuestionService;
	
	@RequestMapping("list.do")
	public ModelAndView selectAll( HttpServletRequest req ){
		
		int lecturecategory_id = Integer.parseInt((String)req.getParameter("lecturecategory_id"));
		
		List<Lecture> list = lectureSerivce.selectAll(lecturecategory_id);
		HashMap<String, String> map = lectureSerivce.getCategoryValues(lecturecategory_id);
		
		req.setAttribute("lecturelist", list);
		/*req.setAttribute("lecturecategoryvalues", map);
		req.setAttribute("lecturecategory_id", lecturecategory_id);
		req.setAttribute("title", title);*/
		
		ModelAndView mav = new ModelAndView("lecture/list");
		mav.addObject("lecturelist", list);
		mav.addObject("categoryvalues", map);
		
		return mav;
		
	}
	
	@RequestMapping("player.do")
	public ModelAndView selectOne( HttpServletRequest req ){
		
		int lecture_id = Integer.parseInt((String)req.getParameter("lecture_id"));
		int member_id = 2;//Integer.parseInt((String)req.getAttribute("member_id"));
		
		Lecture lecture = lectureSerivce.selectOne(lecture_id);
		//HashMap<String, String> categoryMap = lectureSerivce.getCategoryValues(lecturecategory_id);
		HashMap<String, String> lectureMap = lectureSerivce.getLectureValues(lecture_id);
		
		List<MyQuestion> questionList = myQuestionService.selectAll(member_id);
		
		ModelAndView mav = new ModelAndView("lecture/player");
		mav.addObject("lecture", lecture);
		mav.addObject("lecturevalues", lectureMap);
		mav.addObject("questionList", questionList);
		//mav.addObject("categoryvalues", categoryMap);
		
		return mav;
		
	}
	
}
