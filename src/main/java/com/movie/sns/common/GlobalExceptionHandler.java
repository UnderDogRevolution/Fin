package com.movie.sns.common;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;


// 전역 예외처리용 annotation (AOP를 이용한 방법)
//@ControllerAdvice
@Controller
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	// 404 에러 발생 시
	// 404 에러는 dispatcherServlet에서 처리하므로 web.xml 파일 수정한 뒤 메서드 설정해야함 
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public String error404(Model model, Exception e) {
//		
//		
//		model.addAttribute("errorCode", "404");
//		model.addAttribute("errorMessage", "[ Page Not Found ]");
//		
////		System.out.println("==========" + e.getClass().getSimpleName() + "==========\n");
//		
//		return path;
//	}
	

//	@ExceptionHandler({ Exception.class, SQLException.class })
//	public String handlingException(Model model, Exception e) {
//		
//		model.addAttribute("errorCode", "500");
//		model.addAttribute("errorMessage", "[ Server Error ]");
//		
////		System.out.println("==========" + e.getClass().getSimpleName() + "==========\n");
//		
//		return path;
//	}
	
	
	@RequestMapping("/error404")
	public String Error404(HttpServletRequest res, Model model, Exception e) {
		
		model.addAttribute("errorCode", "404");
		model.addAttribute("errorMessage", "[ Page Not Found ]");
		logger.warn(e.toString());
		System.out.println("====================================================== Error ======================================================");
		e.printStackTrace();
		
		return "common/errorPage";
	}
	
	@RequestMapping("/error500")
	public String Error500(HttpServletRequest res, Model model, Exception e) {
		
		model.addAttribute("errorCode", "500");
		model.addAttribute("errorMessage", "[ Server Error ]");
		
		logger.warn(e.toString());
		System.out.println("====================================================== Error ======================================================");
		e.printStackTrace();
		
		return "common/errorPage";
	}
	
	
	
	

}




