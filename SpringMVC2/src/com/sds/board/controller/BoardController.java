/*
 * 각 요청마다 1:1 대응하는 컨트롤러 클래스를 둘 경우 
 * xml 설정이 너무 비대해진다..따라서 요청을 처리하는 컨트
 * 롤러의 개수를 줄여보자...(유지보수성도 높이면서....)
 * */
package com.sds.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.board.model.BoardDAO;
import com.sds.common.board.PagingManager;
import com.sds.domain.Board;

@Controller
@RequestMapping("/board/")
public class BoardController{
	//BoardDAO와 현재 컨트롤러는 결합도가 낮아야, 유지보수성
	//이 좋아진다...따라서 BoardDAO 최상위 인터페이스로 정의
	
	@Autowired
	@Qualifier("boardDAOMybatis")
	private BoardDAO boardDAO;
	
	@Autowired
	private PagingManager pm;
	
	//setter 주입!
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	public void setPm(PagingManager pm) {
		this.pm = pm;
	}
	
	//클라이언트의 요청 uri를 처리할 메서드 위에, 기재.
	@RequestMapping("write.do")
	public String insert(Board board){
		boardDAO.insert(board);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("list.do")
	public ModelAndView selectAll(HttpServletRequest request){
		List list=boardDAO.selectAll();
		request.setAttribute("list", list);
		pm.init(request);
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", list);						//결과 저장!
		mav.addObject("pm", pm);
		return mav;
	}
	
	@RequestMapping("detail.do")
	public ModelAndView select(int board_id){
		
		System.out.println("넘겨받은 아이디 : "+board_id);
		Board board = boardDAO.select(board_id);
		
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);				//	저장
		
		return mav;
		
	}
	
	@RequestMapping("delete.do")
	public String delete( int board_id ){
		
		boardDAO.delete(board_id);
		
		return "redirect:/board/list.do";
		
	}
	
	@RequestMapping("edit.do")
	public String update( Board board ){
		
		boardDAO.update(board);
		
		return "redirect:/board/list.do";
		
	}
	
}












