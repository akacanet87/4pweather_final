package com.sds.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.domain.Board;
import com.sds.exception.spring.WriteException;
import com.sds.model.board.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list.do")
	public List selectAll(){
		
		System.out.println("selectAll 호출");
		
		return null;
		
	}
	
	@RequestMapping("write.do")
	public String insert( Board board){
		
		boardService.insert(board);
		
		return "redirect:/board/list.do";
		
	}
	
	//	에러가 발생하면 작동하는 메서드 정의
	@ExceptionHandler(WriteException.class)
	public ModelAndView handleException( WriteException e ){
		
		ModelAndView mav = new ModelAndView("board/error");
		
		mav.addObject("e", e);
		
		return mav;
		
	}

}
