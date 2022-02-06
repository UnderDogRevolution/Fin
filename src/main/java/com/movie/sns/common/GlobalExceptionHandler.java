package com.movie.sns.common;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


// 전역 예외처리용 annotation (AOP를 이용한 방법)
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private String path = "common/errorPage";
	
	// 만일 이렇게 설정하면 NoHandlerFoundException 발생 시 밑에 핸들러까지 총 2번 처리되는건가??
	
	// 404 에러 발생 시
	// 404 에러는 dispatcherServlet에서 처리하므로 web.xml 파일 수정한 뒤 메서드 설정해야함 
	@ExceptionHandler(NoHandlerFoundException.class)
	public String error404(Model model, Exception e) {
		
		
		model.addAttribute("errorCode", "404");
		model.addAttribute("errorMessage", "[ Page Not Found ]");
		
		System.out.println("==========" + e.getClass().getSimpleName() + "==========\n");
		
		return path;
	}
	
	
	
	
	// Exception 클래스를 어떻게 설정해야 500에러를 처리할 수 있을까?
	// 기타 모든 예외가 발생하면 500에러 뜨도록하기
	@ExceptionHandler({ Exception.class, SQLException.class })
	public String handlingException(Model model, Exception e) {
		
		model.addAttribute("errorCode", "500");
		model.addAttribute("errorMessage", "[ Server Error ]");
		
		System.out.println("==========" + e.getClass().getSimpleName() + "==========\n");
		
		return path;
	}
	
	
	
	

}




