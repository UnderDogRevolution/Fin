package com.movie.sns.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.member.model.service.MemberService;
import com.movie.sns.member.model.vo.Member;





@Controller
@RequestMapping("/member/*")
//@SessionAttributes
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	// 로그인 화면 전환
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	
	// 로그인 수행
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam(value="saveId", required=false) String saveId,
						Member member, Model model, RedirectAttributes ra,
						HttpServletRequest req, HttpServletResponse resp) {
		
		
		
		// 로그인 실패 시 파라미터값으로 넘어온 id를 ra에 담아서 되돌려보내기
		String path = null;
		
		
		return path;
	}
	
	
	
	
}
