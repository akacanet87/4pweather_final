package com.min.admin.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.common.PagingManager;
import com.min.member.service.MemberService;

@Controller
@RequestMapping("/admin/")
public class AdminMemberController {
	@Autowired
	private MemberService memberService;
	
	PagingManager pm = new PagingManager();
	
	@RequestMapping("listuser.do")
	public ModelAndView selectAll(HttpServletRequest request){
		int membercategory_id = Integer.parseInt(request.getParameter("select"));
		List listMem = null;
		if(membercategory_id == 0){
			listMem = memberService.selectAll();
		}else{
			listMem = memberService.selectAll(membercategory_id);
		}
		
		List listMemCat = memberService.getMemberCategoryAll();
		request.setAttribute("list", listMem);
		pm.init(request);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("listMem", listMem);
		mav.addObject("listMemCat", listMemCat);
		mav.addObject("pm", pm);
		mav.addObject("select", membercategory_id);
		mav.setViewName("admin/user_list");
		return mav;
	}
}
