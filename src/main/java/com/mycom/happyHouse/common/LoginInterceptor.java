package com.mycom.happyHouse.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.happyHouse.dto.user.UserDto;

@Component
public class LoginInterceptor implements HandlerInterceptor { // HandlerInterceptorAdapter 는 deprecated
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
}
