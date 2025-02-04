package com.min.controller.lecturecategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.domain.LectureCategory;
import com.min.lecturecategory.service.LectureCategoryService;

@Controller
@RequestMapping("/lecture/")
public class LectureCategoryController {
	
	@Autowired
	private LectureCategoryService lectureCategoryService;
	
	@RequestMapping("index.do")
	public ModelAndView selectAll(){
		
		List<LectureCategory> list = lectureCategoryService.selectAll();
		
		ModelAndView mav = new ModelAndView("lecture/index");
		mav.addObject("lecturecategorylist", list);
		
		return mav;
		
	}
	
	

}
