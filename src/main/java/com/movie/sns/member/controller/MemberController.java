package com.movie.sns.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
						HttpServletRequest req, HttpServletResponse resp
						) {
		
		
		Member loginMember = service.login(member);
		
		String path = null;	// 주소 저장용
		
		if(loginMember != null) {
			
			
			model.addAttribute("loginMember",loginMember);
			
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) {
				cookie.setMaxAge(60*60*24*30);
			}else {
				cookie.setMaxAge(0);
			}
			
			cookie.setPath(req.getContextPath());
			
			resp.addCookie(cookie);
			
			path = "redirect:/main";
			
			
		}else {
			
			// 로그인 실패 시 파라미터값으로 넘어온 email를 ra에 담아서 되돌려보내기
			ra.addFlashAttribute("failMessage", "이메일 주소 또는 비밀번호를 확인해주세요");
			path = "redirect:/member/login";
			
		}
		
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
	public String signUp() {
		return "member/signUp";
	}
	
	
	// 이메일 중복 검사 ajax
	@RequestMapping(value="emailDupCheck", method=RequestMethod.GET)
	@ResponseBody
	public int emailDupCheck(String memberEmail) {
		
		int result = service.emailDupCheck(memberEmail);
		
		return result;
	}
	
	
	// 이메일 인증번호 검사 ajax 삽입 예정
	
	
	
	
	// 닉네임 중복 검사 ajax
	@RequestMapping(value="nickNameDupCheck", method=RequestMethod.GET)
	@ResponseBody
	public int nickNameDupCheck(String memberNickName) {
		
		int result = service.nickNameDupCheck(memberNickName);
		
		return result;
	}
	
	
	
	// 회원가입 수행
	@RequestMapping(value="signUp", method=RequestMethod.POST)
	public String signUp( Member member, RedirectAttributes ra) {
		
		
		int result = service.signUp(member);
		
		String path = null;
		String signUpMessage;
		String text;
		String icon;
		
		if(result > 0) {
			
			signUpMessage = "회원 가입 성공!";
			text = member.getMemberNickName() + "님의 가입을 환영합니다.<br> 로그인을 진행해주세요.";
			icon = "success";
			path = "redirect:/member/login";
			
		}else {
			
			signUpMessage = "가입 실패";
			text = "회원가입을 진행하는 중 문제가 발생했습니다.<br> 관리자에게 문의해주세요.";
			icon = "error";
			path = "redirect:/member/signUp";
			
		}
		
		ra.addFlashAttribute(signUpMessage);
		ra.addFlashAttribute(icon);
		ra.addFlashAttribute(text);
		
		return path;
	}
	
	
	
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
