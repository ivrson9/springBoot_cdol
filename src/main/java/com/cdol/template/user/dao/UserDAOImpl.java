package com.cdol.template.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdol.template.user.dto.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    SqlSession sqlSession; // mybatis 실행 객체
	
	@Override
	public void insertUser(UserVO vo){
		sqlSession.insert("insertUser", vo);
	}

	@Override
	public UserVO authentication(UserVO vo) {
		return sqlSession.selectOne("authentication", vo);
	}

}
