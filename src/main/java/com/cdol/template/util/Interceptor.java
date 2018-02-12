package com.cdol.template.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 * 1. preHandle - controller 이벤트 호출전
 * 2. postHandle - controller 호출 후 view 페이지 출력전
 * 3. afterCompletion - controller + view 페이지 모두 출력 후
 * 4. afterConcurrentHandlingStarted - 동시에 핸들링 해주는 메서드 
 */
public class Interceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		try {
			//logininfo 세션값이 널일경우	
			if(request.getSession().getAttribute("user") == null ){
				//로그인페이지로 redirect
				response.sendRedirect("/user/login");
				return false;
			}
		} catch (Exception e) { e.printStackTrace(); } //널이 아니면 정상적으로 컨트롤러 호출
		
		return true;
	}
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
 
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}


