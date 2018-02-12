package com.cdol.template.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdol.template.mapper.UserMapper;
import com.cdol.template.user.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public void insertUser(UserVO vo) throws Exception {
		// Bcrypt Encode
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		userMapper.userInsert(vo);
	}

	@Override
	public UserVO authentication(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {
		UserVO result = userMapper.userView(vo);
		if( result != null) {
			if(passwordEncoder.matches(vo.getPassword(), result.getPassword())) {
				String ip = req.getHeader("X-FORWARDED-FOR");
		        if (ip == null) {
		            ip = req.getRemoteAddr();
		        }
		        result.setIp_address(ip);
		        result.setIs_login(true);
	            
		        session.setAttribute("user", result);
	            
				return result;
			}
		}
		return null;
	}
	
}
