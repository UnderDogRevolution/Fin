package com.movie.sns.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.member.model.service.MemberService;
import com.movie.sns.member.model.vo.Member;


// 로그인필터

@Controller
@RequestMapping("/member/*")
@SessionAttributes({"loginMember"})
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
			
			path = "redirect:/";
			
			
		}else {
			
			ra.addFlashAttribute("memberEmail", member.getMemberEmail());
			
			path = "redirect:/member/login";
			
		}
		
	
		
		
		// 로그인 실패 시 파라미터값으로 넘어온 email를 ra에 담아서 되돌려보내기
		
		
		
		return path;
	}
	
	
	// 로그아웃
	@RequestMapping("logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		// 최근 페이지로 보내는 법
		return "redirect:/";
	}
	
	
	
	// 회원가입 화면 호출
	@RequestMapping(value="signUp", method=RequestMethod.GET)
	public String signUp(@ModelAttribute("loginMember") Member loginMember) {
		return "member/signUp";
	}
	
	
	// 회원가입 수행
	@RequestMapping(value="signUp", method=RequestMethod.POST)
	public String signUp( Model model) {
		
		return "redirect:/";
	}
	
	// 기타 중복검사 기능 들어올 자리
	
	
	
	// 비밀번호 찾기 화면 호출
	@RequestMapping(value="findPw", method=RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}
	
	
	
	// 비밀번호 재설정 화면 호출	(*자리에 회원마다 특정 주소값 얻어와야할듯 { } 사용해서)
	@RequestMapping(value="resetPw/*", method=RequestMethod.GET)
	public String resetPw() {
		return "member/resetPw";
	}
	
	
}
