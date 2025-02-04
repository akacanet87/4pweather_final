package com.min.controller.member;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.min.common.PagingManager;
import com.min.domain.Member;
import com.min.domain.MemberCategory;
import com.min.member.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	PagingManager pm = new PagingManager();
	
	/*@RequestMapping("sendHomework.do")
	public ModelAndView registHomeworkFile( Member member, HttpServletRequest request ){
		
		MultipartFile homework= member.getHomework();
		String fileName = homework.getOriginalFilename();
		
		System.out.println("업로드한 파일 명은 : "+fileName);
		
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/data/homework/")+fileName;
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(realPath);
		
		try {
			
			homework.transferTo(new File(realPath));
		
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
		return mav;
	
	}*/
	
	@RequestMapping("changeName.do")
	public ModelAndView changeName(){
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
		
	}
}
