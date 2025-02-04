package com.min.controller.myquestion;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.domain.MyQuestion;
import com.min.myquestion.service.MyQuestionService;

@Controller
@RequestMapping("/myquestion/")
public class MyQuestionController {
	
	@Autowired
	private MyQuestionService myQuestionService;
	
	/*@RequestMapping("/lecture/selectlistlecture.do")
	@ResponseBody
	public ModelAndView selectListOfLecture( @RequestBody Map<String, Object> map, HttpServletResponse res ){
		System.out.println(map.get("member_id"));
		int member_id = Integer.parseInt(map.get("member_id").toString());
		int lecture_id = Integer.parseInt(map.get("lecture_id").toString());
		
		List<MyQuestion> list = myQuestionService.selectListOfLecture(member_id, lecture_id);
		
		ModelAndView mav = new ModelAndView("jsonConverter");
		
		mav.addObject("list", list);
		
		return mav;
		
	}*/
	
	@RequestMapping("registQuestion.do")
	@ResponseBody
	public MyQuestion selectListOfLecture( @RequestBody Map<String, Object> map){

		MyQuestion myQuestion = new MyQuestion();
		myQuestion.setContent((String)map.get("content"));
		myQuestion.setMember_id(Integer.parseInt(map.get("member_id").toString()));
		myQuestion.setLecture_id(Integer.parseInt(map.get("lecture_id").toString()));
		
		//myquestion insert
		myQuestionService.insert(myQuestion);
		
		int myquestion_id = myQuestionService.getLastVal();
		
		myQuestion.setMyquestion_id(myquestion_id);
		
		return myQuestion;
		
	}
	
/*	@RequestMapping("registquestion.do")
	@ResponseBody
	public void insertOne(@RequestBody Map<String, Object> map, HttpServletResponse res){
		
		MyQuestion myQuestion = new MyQuestion();
		
		myQuestion.setLecture_id(Integer.parseInt(map.get("lecture_id").toString()));
		myQuestion.setMember_id(Integer.parseInt(map.get("member_id").toString()));
		myQuestion.setContent(map.get("content").toString());

		
		myQuestionService.insert(myQuestion);
		
	}*/
	
	@RequestMapping("updatequestion.do")
	@ResponseBody
	public void updateOne(@RequestBody Map<String, Object> map, HttpServletResponse res){
		
		MyQuestion myQuestion = new MyQuestion();
		
		myQuestion.setLecture_id(Integer.parseInt(map.get("lecture_id").toString()));
		myQuestion.setMember_id(Integer.parseInt(map.get("member_id").toString()));
		myQuestion.setContent(map.get("content").toString());
		
		myQuestionService.update(myQuestion);
		
	}
	
	@RequestMapping("deletequestion.do")
	@ResponseBody
	public void deleteOne(@RequestBody Map<String, Object> map, HttpServletResponse res){

		int myquestion_id = Integer.parseInt(map.get("myquestion_id").toString());
	
		myQuestionService.delete(myquestion_id);
		
	}

}
