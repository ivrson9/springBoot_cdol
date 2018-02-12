package com.cdol.template.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdol.template.board.dto.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
    SqlSession sqlSession;
	
	@Override
	public List<BoardVO> getList(Map<String, Object> parameters) {
		return sqlSession.selectList("board.getList", parameters);
	}

	@Override
	public int getCount(Map<String, Object> parameters) {
		return sqlSession.selectOne("board.getCount", parameters);
	}
	
}
