package com.cdol.template.user.dao;

import com.cdol.template.user.dto.UserVO;

public interface UserDAO {
	public void insertUser(UserVO vo);
	public UserVO authentication(UserVO vo);
}
