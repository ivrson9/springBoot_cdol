package com.cdol.template.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdol.template.board.dto.BoardVO;
import com.cdol.template.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;
			
	@Override
	public List<BoardVO> getList(Map<String, Object> parameters) throws Exception {
		return boardMapper.boardList(parameters);
	}

	@Override
	public int getCount(Map<String, Object> parameters) throws Exception {
		return boardMapper.boardCountView(parameters);
	}

}
