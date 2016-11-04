package com.sds.controller.reboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.common.board.PagingManager;
import com.sds.model.domain.ReBoard;
import com.sds.model.service.ReBoardService;

@Controller
@RequestMapping("/reboard/")
public class ReBoardController {
	
	@Autowired
	private ReBoardService reBoardService;
	
	Logger logger=LogManager.getLogger(this.getClass().getName());
	
	
	private PagingManager pm = new PagingManager();
	
	@RequestMapping("list.do")
	public ModelAndView selectAll( HttpServletRequest req){
		
		List<ReBoard> list = reBoardService.selectAll();
		
		req.setAttribute("list", list);
		pm.init(req);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pm", pm);
		mav.setViewName("reboard/list");
		
		return mav;
		
	}
	
	//	�� ����
	@RequestMapping("write.do")
	public String insert( ReBoard reboard ){
		
		reBoardService.insert(reboard);
		
		return "redirect:/reboard/list.do";
		
	}
	
	//	�󼼺���
	@RequestMapping("detail.do")
	public ModelAndView select( int reboard_id ){
		
		ReBoard reBoard = reBoardService.select(reboard_id);
		
		ModelAndView mav = new ModelAndView("reboard/detail");
		mav.addObject("reboard", reBoard);
		
		return mav;
		
	}
	
	//	�亯 ���
	@RequestMapping("reply.do")
	public String reply( HttpServletRequest req ){
		
		ReBoard reboard = new ReBoard();
		
		//	���Ӱ� ��ϵ� �亯 ��
		reboard.setWriter(req.getParameter("r_writer"));
		reboard.setTitle(req.getParameter("r_title"));
		reboard.setContent(req.getParameter("r_content"));
		
		//	���� �� ���� team, rank, depth
		reboard.setTeam(Integer.parseInt(req.getParameter("team")));
		reboard.setRank(Integer.parseInt(req.getParameter("rank")));
		reboard.setDepth(Integer.parseInt(req.getParameter("depth")));
		
		reBoardService.reply(reboard);
		
		return "redirect:/reboard/list.do";
		
	}

}
