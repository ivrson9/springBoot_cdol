package com.cdol.template.mapper;

import com.cdol.template.user.dto.UserVO;

public interface UserMapper {
	public void userInsert(UserVO vo)throws Exception;
	public UserVO userView(UserVO vo)throws Exception;
}
