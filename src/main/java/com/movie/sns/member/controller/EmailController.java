package com.movie.sns.member.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/mail/*")
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;	// 메일 전송 객체
	
	
	
	
	// 메일 보내기
	@RequestMapping("sendMail")
	@ResponseBody
	public int sendMail(@RequestParam(value="memberEmail") String memberEmail) {
		
		String setfrom = "montagekh2@gmail.com";	// 보내는 사람 메일 주소
		
		String tomail = memberEmail;				// 받는 사람 메일 주소
		
		String title = "[Montage] 이메일 인증번호입니다.";
		
		String content = "<div style='background-color: red; width: 500px; height: 500px;'>이메일 인증번호는 123456입니다.</div>";
		
		String key = "";
		
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
			
			return -1;
			
		}
		
		
		
		
	}
	
	
	
	
	
	
}






