package com.cdol.template.mapper;

import java.util.List;
import java.util.Map;

import com.cdol.template.board.dto.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(Map<String, Object> parameters)throws Exception;
	public int boardCountView(Map<String, Object> parameters)throws Exception;
}
