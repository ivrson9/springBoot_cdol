package com.cdol.template.board.dao;

import java.util.List;
import java.util.Map;

import com.cdol.template.board.dto.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getList(Map<String, Object> parameters);
	public int getCount(Map<String, Object> parameters);
}
