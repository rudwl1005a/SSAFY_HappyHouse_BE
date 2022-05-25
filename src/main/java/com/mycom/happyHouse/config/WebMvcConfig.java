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

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("authorization")
        .allowedMethods(
        	RequestMethod.GET.name(),RequestMethod.POST.name(), RequestMethod.HEAD.name(),
        	RequestMethod.PUT.name(),RequestMethod.DELETE.name(), RequestMethod.OPTIONS.name()
        );
        
    }
	
	private static final String[] EXCLUDE_PATHS = {
			"/favicon.ico",
            "/register/**",
            "/login/**",
            "/logout",
            "/",
            "/error",
            "/css/**",
            "/js/**",
            "/img/**",
            "/users/**"
    };
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns(EXCLUDE_PATHS);
	}
  
}
