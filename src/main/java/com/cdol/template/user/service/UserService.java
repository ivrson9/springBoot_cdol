package com.cdol.template.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cdol.template.user.dto.UserVO;

public interface UserService {
	public void insertUser(UserVO vo) throws Exception;
	public UserVO authentication(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception;
}
