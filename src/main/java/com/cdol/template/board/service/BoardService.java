package com.cdol.template.board.service;

import java.util.List;
import java.util.Map;

import com.cdol.template.board.dto.BoardVO;

public interface BoardService {
	public List<BoardVO> getList(Map<String, Object> parameters) throws Exception;
	public int getCount(Map<String, Object> parameters)throws Exception;
}
