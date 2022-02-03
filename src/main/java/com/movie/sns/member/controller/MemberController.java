package com.movie.sns.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.common.RandomNumber;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.service.MemberService;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.member.model.vo.MemberAuth;


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
	
	
	// 닉네임 중복 검사 ajax
	@RequestMapping(value="nickNameDupCheck", method=RequestMethod.GET)
	@ResponseBody
	public int nickNameDupCheck(String memberNickName) {
		
		int result = service.nickNameDupCheck(memberNickName);
		
		return result;
	}
	
	
	// 이메일 인증번호 생성 후 DB에 삽입
	@RequestMapping(value="emailAuth", method=RequestMethod.POST)
	@ResponseBody
	public int emailAuth(@RequestParam(value="memberEmail") String memberEmail) {
		
		// 랜덤 문자열 생성
		String authCode = new RandomNumber().generateCertificationNo();
		
		// MemberAuth 객체에 정보를 담아서 DB에 삽입
		int result = service.insertAuthCode(memberEmail, authCode);
		
		return result;
	}
	
	
	// 이메일 인증번호를 제출받은 경우 + DB에 있는 번호와 비교 (가장 최신 인증번호만 조회하기)
	@RequestMapping(value="emailAuthCheck", method=RequestMethod.POST)
	@ResponseBody
	public int emailAuthCheck(	@RequestParam(value="memberEmail") String memberEmail,
								@RequestParam(value="authCode") String authCode) {
		
		int result = service.selectAuthCode(memberEmail, authCode);
		
		return result;
	}
	
	// (인증번호 정보 삭제는 스케쥴러 활용하기?)
	// 시간초 뜨게 만들기?
	// 이메일 꾸미기
	// 추가정보 입력하기
	// 로그인, 로그아웃 시 최근 페이지로 돌아가기
	
	
	
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
			Util.swalSetMessage(signUpMessage, text, icon, ra);
			path = "redirect:/member/login";
			
		}else {
			
			signUpMessage = "가입 실패";
			text = "회원가입을 진행하는 중 문제가 발생했습니다.<br> 관리자에게 문의해주세요.";
			icon = "error";
			Util.swalSetMessage(signUpMessage, text, icon, ra);
			path = "redirect:/member/signUp";
			
		}
		
		return path;
	}
	
	
	
	// 비밀번호 찾기 화면 호출
	@RequestMapping(value="findPw", method=RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}
	
	
	
	// 비밀번호 찾기 링크 만들기
	@RequestMapping(value = "findPw", method=RequestMethod.POST)
	public String findPw(String memberEmail, RedirectAttributes ra, HttpServletRequest req){
		
		// 가입 여부 체크하기
		int result = service.emailDupCheck(memberEmail);
		
		if(result == 1) {
			
			// 암호화해서 DB에 INSERT
			result = service.insertEncEmail(memberEmail, req);
			
			if(result > 0) {
				
				System.out.println("메일 전송 성공!");
				// 암호화 데이터 삽입 성공한 경우
				// 암호화된 값을 얻어와 @pathVariable로 사용해 이메일 발송
				// 주소로 요청이 오면 유효기간을 검사하고 변경페이지 or 메인페이지로 forward 
			}
			

			
			
			
			
			// 가입한 이메일인 경우(sweetAlert 사용예정)
			ra.addFlashAttribute("message", "이메일 발송 성공!");
			
		}else {
			
			// 가입하지 않은 이메일인 경우
			ra.addFlashAttribute("message1", memberEmail + "은");
			ra.addFlashAttribute("message2", "가입하지 않은 이메일입니다.");
			
		}
		
		ra.addFlashAttribute("result", result);
		
		return "redirect:/member/findPw";
		
	}
	
	
	
	
	
	
	// 비밀번호 재설정 화면 호출	
	// (*자리에 회원마다 특정 주소값 얻어와야할듯 { } 사용해서) 
	// => bcrypt를 사용했으므로 쿼리스트링을 이용해서 파라미터로 얻어오는 방법 사용
	// reset/* 로그인 필터?
	@RequestMapping(value="resetPw", method=RequestMethod.GET)
	public String resetPw(@RequestParam("djsejehr") String encEmail, Model model) {
		
		model.addAttribute("encEmail", encEmail);
		
		return "member/resetPw";
	}
	
	
	
	// 비밀번호 재설정하기 
	@RequestMapping(value="resetPw", method=RequestMethod.POST)
	public String resetPw(@RequestParam("djsejehr") String encEmail, String memberPw ) {
		
		
		// 새로 변경한 비밀번호
		String newPw = memberPw;
		
		// 수행 후 경로 지정
		String path = null;
		
		int result = service.resetPw(encEmail, newPw);
		
		if(result > 0) {
			
			System.out.println("수정 완료!");
			path = "redirect:/member/login";
			
		}else {
			
			System.out.println("수정 실패!");
			path = "redirect:/";
			
		}
		
		
		return path;
	}
	
	
	
	
	
	
}
