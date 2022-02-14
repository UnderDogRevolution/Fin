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
	public int sendMail(String memberEmail, String authCode, HttpServletRequest req) {
		
		String homePage = "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/"; 
		
		String setfrom = "montagekh2@gmail.com";	// 보내는 사람 메일 주소
		
		String tomail = memberEmail;				// 받는 사람 메일 주소
		
		String title = "[Montage] 이메일 인증번호입니다.";
		
		String key = "";
		
		// 이미지 로고 넣어서 메일로 보내는 방법 찾기
		String content = "<table style='font-family: NanumBarunGothic; padding: 20px; border-radius: 20px; color:#EEEEEE; user-select: none; background-color: #323232;' cellspacing='0' cellpadding='0' width='500'>" 
    					+ "<tbody>" 
    					+ "<tr><td style='text-align: left; padding: 20px;  line-height: 18px; font-size: 40px; font-weight: bold; height: 50px;'><a href='" + homePage + "' style='color: #EB3636; text-decoration:none;'>Montage</a></td></tr>"
					    + "<tr><th style='font-size: 18px;'>"
					    + "<p>안녕하세요. <strong style='font-size: 25px;'>Montage</strong> 입니다.</p>"
					    + "<p style='margin-bottom: 30px;'>회원 가입 인증번호 입니다.</p></th></tr>"
					    + "<tr><th style='padding: 10px; border-radius: 10px 10px 0 0; letter-spacing: 4px; font-size: 20px; font-weight: bold; background-color: #F05454;'>인증번호</th></tr>"
					    + "<tr><th style='border-radius: 0 0 10px 10px; user-select: all; letter-spacing: 0.5rem;; padding: 10px; font-size: 30px; font-weight: bold; color: #F05454; background-color: #E6E6E6;'>"
					    +  authCode + "</th></tr>"
					    + "<tr><th>"
					    + "<a href='" + homePage + "'><img style='cursor: pointer; object-fit: cover; max-width: 460px; opacity: 0.7; border-radius: 10px; margin: 30px 0;'  src='http://drive.google.com/uc?export=view&id=1cH3qDK8Iq_7GSdHpCELj9R2-h2xpRPNj'></a></th></tr>"
					    + "</tbody>"
					    + "</table>";
		
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
		
		String homePage = "http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/";
		// 요청 주소 값 (http://
		String url = req.getRequestURL().toString();
		url =  url.replace("findPw", "resetPw");
		
		String setfrom = "montagekh2@gmail.com";	// 보내는 사람 메일 주소
		
		String tomail = memberEmail;				// 받는 사람 메일 주소
		
		String title = "[Montage] 비밀번호 변경 링크입니다.";
		
		String content = 	"<table style='font-family: NanumBarunGothic; padding: 20px; border-radius: 20px; color:#EEEEEE; user-select: none; background-color: #323232;' cellspacing='0' cellpadding='0' width='500'>" 
					      + "<tbody>" 
					      + "<tr><td style='text-align: left; padding: 20px;  line-height: 18px; font-size: 40px; font-weight: bold; height: 50px;'><a href='" + homePage + "' style='color: #EB3636; text-decoration:none;'>Montage</a></td></tr>"
					      + "<tr><th style='font-size: 18px;'>"
					      + "<p>안녕하세요. <strong style='font-size: 25px;'>Montage</strong> 입니다.</p>"
					      + "<p style='margin-bottom: 30px;'>회원님의 비밀번호 변경 링크입니다.</p></th></tr>"
					      + "<tr><th style='padding: 10px; border-radius: 10px 10px 10px 10px; letter-spacing: 4px; font-size: 20px; font-weight: bold; background-color: #F05454;'>"
					      + "<p><a href='" + url + "?djsejehr=" + encEmail + "' style='text-decoration: none; color: #EEEEEE; font-size: 25px; font-weight: bold;'>비밀번호 변경하기</a></p></th></tr>"
					      + "<tr><th>"
					      + "<a href='" + homePage + "'><img style='cursor: pointer; object-fit: cover; max-width: 460px; opacity: 0.7; border-radius: 10px; margin: 30px 0;'  src='http://drive.google.com/uc?export=view&id=1cH3qDK8Iq_7GSdHpCELj9R2-h2xpRPNj'></a></th></tr>"
						  + "</tbody>"
						  + "</table>";
		
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






