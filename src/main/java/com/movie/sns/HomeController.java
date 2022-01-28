package com.movie.sns;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.member.model.vo.Member;


/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"loginMember"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	// 메인페이지로 화면 이동
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainPageForward(HttpSession session) {
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			
			return "main/main";
			
		}else {
			
			return "startPage";
			
		}
		
	}
	
	
}





