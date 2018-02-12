package com.cdol.template.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdol.template.board.dto.BoardVO;
import com.cdol.template.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/lists/{boardName}", method = RequestMethod.GET)
	public ModelAndView home(@PathVariable String boardName, 
							@RequestParam(value="cnt", defaultValue = "1") int list_num,
							@RequestParam(value="search_type", defaultValue = "") String search_type,
							@RequestParam(value="search_cont", defaultValue = "") String search_cont) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("boardName", boardName);
		parameters.put("search_type", search_type);
		parameters.put("search_cont", search_cont);
		parameters.put("list_num", list_num);
		
		List<BoardVO> boardList = null;
		int countAll = 0;
		
		try {
			boardList = boardService.getList(parameters);
			countAll = boardService.getCount(parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int page_cnt = 0;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String today = dateFormat.format(new Date());
		
		if(countAll % 10 == 0){
			page_cnt = (int)(countAll / 10);
		} else {
			page_cnt = (int)(countAll / 10) + 1; 
		}
		mv.addObject("boardName", boardName);
		mv.addObject("list_num", list_num);
		mv.addObject("today", today);
		mv.addObject("page_cnt", page_cnt);
		mv.addObject("boardList", boardList);
		mv.addObject("search_type", search_type);
		mv.addObject("search_cont", search_cont);
		mv.setViewName("board_lists");
		
		return mv;
	}
	
}
