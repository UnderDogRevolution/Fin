package com.movie.sns.member.controller;

import javax.servlet.http.Cookie;
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
		
		
		Member loginMember = service.login(member);
		
		String path = null;	// 주소 저장용
		
		if(loginMember != null) {
			
			
			model.addAttribute(loginMember);
			
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) {
				cookie.setMaxAge(60*60*24*30);
			}else {
				cookie.setMaxAge(0);
			}
			
			cookie.setPath(req.getContextPath());
			
			resp.addCookie(cookie);
			
			
		}else {
			
			ra.addFlashAttribute("memberId", member.getMemberEmail());
			
		}
		
	
		
		
		// 로그인 실패 시 파라미터값으로 넘어온 id를 ra에 담아서 되돌려보내기
		
		
		
		return path;
	}
	
	
	
	
	// 회원가입 화면 호출
	@RequestMapping(value="signUp", method=RequestMethod.GET)
	public String signUp() {
		return "member/signUp";
	}
	
	
	// 회원가입 수행
	@RequestMapping(value="signUp", method=RequestMethod.POST)
	public String signUp( Model model) {
		
		return null;
	}
	
	
	
	// 비밀번호 찾기 화면 호출
	@RequestMapping(value="findPw", method=RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}
	
	
	
}
