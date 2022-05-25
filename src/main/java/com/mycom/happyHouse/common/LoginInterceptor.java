package com.mycom.happyHouse.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycom.happyHouse.exception.UnauthorizedException;
import com.mycom.happyHouse.service.user.JwtService;

@Component
public class LoginInterceptor implements HandlerInterceptor { // HandlerInterceptorAdapter 는 deprecated
	private static final String HEADER_AUTH = "authorization";

	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println(">>>>>> " + request.getRequestURI());

		// cors put, delete 대응
		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}

		final String token = request.getHeader(HEADER_AUTH);
		System.out.println(token);
		
		if (token != null && !token.equals("") && jwtService.isUsable(token)) {
			return true;
		} else {
			Gson gson = new Gson();

			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("result", "login");
			
			String jsonStr = gson.toJson(jsonObject);
			response.getWriter().write(jsonStr);
			
			throw new UnauthorizedException();
		}

	}
}
