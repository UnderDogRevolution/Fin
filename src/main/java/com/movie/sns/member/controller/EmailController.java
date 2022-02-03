package com.movie.sns.member.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.sns.member.model.service.MemberService;



@Controller
@RequestMapping("/mail/*")
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;	// 메일 전송 객체
	
	
	// 인증번호 보내기 메서드
	public int sendMail(String memberEmail, String authCode) {
		
		String setfrom = "montagekh2@gmail.com";	// 보내는 사람 메일 주소
		
		String tomail = memberEmail;				// 받는 사람 메일 주소
		
		String title = "[Montage] 이메일 인증번호입니다.";
		
		String key = "";
		
		// 이미지 로고 넣어서 메일로 보내는 방법 찾기
		String content = "<div style='background-color: white; width: 500px; height: 500px; font-weight: bold;'>"
				+ "<p>안녕하세요 Montage 입니다.</p>"
				+ "<p>이메일 인증번호는 <span style='font-size: 25px; color: #F05454;'>"+ authCode +"</span> 입니다.</p>"
				+ "</div>";
		
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setfrom);
			messageHelper.setTo(tomail);
			messageHelper.setSubject(title);
			messageHelper.setText(content + key, true); 
			
			mailSender.send(message);
			
			return 1;
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return 0;
			
		}
		
	}
	
	
	
	
	// 비밀번호 변경 링크 보내기 메서드
	public void sendPwLink(String memberEmail, String encEmail, HttpServletRequest req) {
		
		// 요청 주소 값 (http://
		String url = req.getRequestURL().toString();
		url =  url.replace("findPw", "resetPw");
		
		String setfrom = "montagekh2@gmail.com";	// 보내는 사람 메일 주소
		
		String tomail = memberEmail;				// 받는 사람 메일 주소
		
		String title = "[Montage] 비밀번호 변경 링크입니다.";
		
		String content = "<a href=" + url + "?djsejehr=" + encEmail + ">비밀번호 변경 링크입니다.</a>";
		
		String key = "";
		
		
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setfrom);
			messageHelper.setTo(tomail);
			messageHelper.setSubject(title);
			messageHelper.setText(content + key, true); 
			
			mailSender.send(message);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
	
	
	
}






