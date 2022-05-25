package com.mycom.happyHouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.happyHouse.common.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
//				.excludePathPatterns("/", "/logout", "/index", "/login/**", "/register/**")
//				.excludePathPatterns("/css/**", "/js/**", "/img/**");
//	}

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*")
        .allowedMethods(
        	RequestMethod.GET.name(),RequestMethod.POST.name(), RequestMethod.HEAD.name(),
        	RequestMethod.PUT.name(),RequestMethod.DELETE.name(), RequestMethod.OPTIONS.name()
        );
	}
}
