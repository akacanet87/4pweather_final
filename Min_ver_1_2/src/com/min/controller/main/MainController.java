package com.min.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.lecturecategory.service.LectureCategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	LectureCategoryService lectureCategoryService;
	
	@RequestMapping("index.do")
	public ModelAndView selectAll(){
		List listLecCat = (List)lectureCategoryService.selectAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("listLecCat", listLecCat);
		mav.setViewName("index");
		return mav;
	}
}