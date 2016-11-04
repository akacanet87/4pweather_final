package com.sds.controller.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sds.model.dao.MemberDAO;
import com.sds.model.domain.Asset;
import com.sds.model.domain.Member;
import com.sds.model.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//	ȸ�� ��� ��û ó��
	//	3,4 �ܰ�
	@RequestMapping("regist.do")
	public ModelAndView regist( Member member, Asset asset, HttpServletRequest request ){
		
		//	Ŭ���̾�Ʈ�� ���ε��� ������ ó���ϱ�
		MultipartFile myFile = member.getMyFile();
		String fileName = myFile.getOriginalFilename();			//	���ε��� ���ϸ�
		
		System.out.println("���ε��� ���� ���� : "+fileName);
		
		//	3�ܰ� : ������ �ϵ忡 ���� + DB�� insert
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/data/")+fileName;
		
		System.out.println(realPath);
		
		try {
			
			myFile.transferTo(new File(realPath));
			
			member.setProfile(fileName);
			
			member.setAsset(asset);
			
			memberService.regist(member);
		
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();

		}
		
		//	4�ܰ� : ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/result");
		
		return mav;
		
	}

}
