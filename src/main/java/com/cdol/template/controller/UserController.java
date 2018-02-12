package com.cdol.template.controller;

import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdol.template.user.dto.UserVO;
import com.cdol.template.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		String returnURL = request.getHeader("REFERER");
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnURL", returnURL);
		mav.setViewName("login");
		
		return mav;
	}
	
	@RequestMapping(value = "signup")
	public String signup(Locale locale, Model model) {
		return "register";
	}
	
	
//	@ResponseBody UserVO
	@RequestMapping(value = "authentication", method = RequestMethod.POST)
	public void authentication(@ModelAttribute UserVO vo, HttpSession session, 
								HttpServletRequest request, HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		UserVO resultVo = userService.authentication(vo, session, request);
		
		try {
			if(vo.getReturnURL() == null) {
				resultVo.setReturnURL("/");
			} else {
				resultVo.setReturnURL(vo.getReturnURL());
			}
			
			response.getWriter().print(mapper.writeValueAsString(resultVo));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute UserVO vo) throws Exception {
		userService.insertUser(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
