package com.movie.sns.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.member.model.service.MemberService2;
import com.movie.sns.member.model.vo.Member;

import com.movie.sns.common.Util;

@Controller
@RequestMapping("/member/*")
//@SessionAttributes
public class MemberController2 {
	
	@Autowired
	private MemberService2 service;
	
	
	// 마이페이지 화면 전환
		@RequestMapping(value="myPage", method=RequestMethod.GET)
		public String myPage() {
			return "member/myPage";
		}
		
		// 회원 정보 수정
		@RequestMapping(value="update", method=RequestMethod.POST)
		public String updateMember(/*HttpSession session*/ 
									@ModelAttribute("loginMember") Member loginMember,
									@RequestParam Map<String, String> param, // 모든 파라미터를 Map형식으로 저장,
									@RequestParam("deleteImages") String deleteImages,
									@RequestParam("images") List<MultipartFile> images,
									Member member, // 비어있는 Member객체 생성
									RedirectAttributes ra, HttpSession session) {
			
			
			// 기존 세션데이터 얻어오는 방식
			//int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
			// @ModelAttribute 이용 방식
			// 1. 파라미터를 객체에 set하는 역할 -> 커맨드 객체 생성
			// 2. @SessionAttributes를 이용해 등록된 Session 데이터를 얻어오는 역할
			//    --> @ModelAttribute("Session키값")
			// 1) 웹 접근 경로(webPath), 서버 저장 경로(serverPath)
			String webPath = "/resources/images/member/"; // (DB에 저장되는 경로)
			String serverPath = session.getServletContext().getRealPath(webPath);
						
			// member에 회원번호, 수정된 파라미터를 모두 담기
			
			member.setMemberNo( loginMember.getMemberNo() );
			member.setMemberNickName( param.get("updateNickName") );
			member.setMemberEmail( param.get("updateEmail") );
			member.setMemberBirth( param.get("updateBirth") );
			
			
			// 회원 정보 수정 Service 호출 후 결과 반환 받기
			int result = service.updateMember(member, images, webPath, serverPath, deleteImages);
			
			
			// sweetalert 를 이용해서 수정 성공/실패 출력
			String title = null;
			String text = null;
			String icon = null;
			
			if(result > 0) { // 수정 성공
				
				// Session 로그인 회원 정보를 DB와 동기화
				// -> Session에 저장된 회원 정보 객체(Member)를 참조하는 loginMember 활용
				loginMember.setMemberNickName(param.get("updateNickName"));
				loginMember.setMemberEmail(param.get("updateEmail"));
				loginMember.setMemberBirth(param.get("updateBirth"));
				
				
				title = "회원 정보 수정 성공";
				icon = "success";
				
			}else { // 실패
				title = "회원 정보 수정 실패";
				text = "관리자에게 문의해주세요.";
				icon = "error";
			}
			
			ra.addFlashAttribute("title", title);
			ra.addFlashAttribute("text", text);
			ra.addFlashAttribute("icon", icon);
			
			// mypage로 리다이렉트
			return "redirect:myPage";
		}
		
		
		
		// 비밀번호 수정 화면 전환
		@RequestMapping(value="updatePw", method=RequestMethod.GET)
		public String updatePw() {
			return "member/resetPw";
		}
		
		
		// 비밀번호 수정
		@RequestMapping(value="updatePw", method=RequestMethod.POST)
		public String updatePw(@ModelAttribute("loginMember") Member loginMember,
							   String currentPw, String newPw1, RedirectAttributes ra) {
			
			// 비밀번호 수정 흐름
			// (Controller)
			// 1. 회원번호 + 현재 비밀번호 + 새 비밀번호  서비스 호출
			
			// (Service)
			// 2. 회원 번호를 이용해서 DB에 저장된 비밀번호를 조회
			
			// 3. DB 저장된 비밀번호와  입력된 현재 비밀번호 비교(  matches() 사용 )
			
			// 4. 일치하면 새 비밀번호를 암호화
			//    -> 비밀번호 변경 DAO 호출
			
			// 5. 일치하지 않으면 Controller로 0 반환
			
			// (Controller)
			// 6. 성공 여부에 따라 출력 메세지 지정 -> 리다이렉트
			
			
			
			// 1. 회원번호 + 현재 비밀번호 + 새 비밀번호  서비스 호출
			// 회원번호 + 파라미터 저장용 Map 생성
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("memberNo", loginMember.getMemberNo() + "");
			map.put("currentPw", currentPw);
			map.put("newPw", newPw1);
			
			int result = service.updatePw(map);
			
			
			// 6. 성공 여부에 따라 출력 메세지 지정 -> 리다이렉트
			if(result  > 0) {
				Util.swalSetMessage("비밀번호 변경 성공","비밀번호가 변경되었습니다.", "success", ra);
			}else {
				Util.swalSetMessage("비밀번호 변경 실패","현재 비밀번호가 일치하지 않습니다.", "error", ra);
			}
			
			return "redirect:myPage";
		}
		
		
	    // 회원 탈퇴 화면 전환
	    @RequestMapping(value="secession", method=RequestMethod.GET )
	    public String secession(Member member) {
	       return "member/secession";
	    }


	    // 회원 탈퇴
	    @RequestMapping(value="secession", method=RequestMethod.POST )
	    public String secession(@ModelAttribute("loginMember") Member loginMember,  
	    					String currentPw, SessionStatus status, RedirectAttributes ra) {
	       
	    	
	       // 회원 가입 Service 호출 후 결과 반환 받기
	       int result = service.secession(loginMember.getMemberNo(),  currentPw);
	       
	       String path = null;
	       
	       if(result > 0) { // 성공
	          Util.swalSetMessage("회원 탈퇴 성공", "탈퇴 되었습니다.", "success", ra);
	          status.setComplete(); // 세션만료
	          
	          path = "/";
	          
	       }else { // 실패
	          Util.swalSetMessage("회원 탈퇴 실패", "비밀번호가 일치하지 않습니다.", "error", ra);
	          path = "secession";
	       }
	       
	       
	       return "redirect:" + path;
	    }

		
	    // 바라는 점 화면 전환
	    @RequestMapping(value="ask", method=RequestMethod.GET )
	    public String ask(Member member) {
	       return "member/ask";
	    }


	    // 바라는 점
	    @RequestMapping(value="ask", method=RequestMethod.POST )
	    public String ask(@ModelAttribute("loginMember") Member loginMember, Member member,
	    					String currentPw, SessionStatus status, RedirectAttributes ra) {
	       
	    	member.setMemberNo( loginMember.getMemberNo() );
	    	
	       int result = service.ask(member);
	       
	       String path = null;
	       
	       if(result > 0) { // 성공
	          Util.swalSetMessage("바라는 점 제출 성공", "제출되었습니다.", "success", ra);
	          status.setComplete(); // 세션만료
	          
	          path = "/";
	          
	       }else { // 실패
	          Util.swalSetMessage("바라는 점 제출 실패", "제출에 실패하였습니다.", "error", ra);
	          path = "ask";
	       }
	       return "redirect:" + path;
	    }

		
		/* 스프링 예외 처리 방법
		 * 
		 * 1. 메소드별 try-catch / throws 예외 처리 (1순위)
		 * 
		 * 2. 컨트롤러 별로 예외 처리(@ExceptionHandler) (2순위)
		 * 		-> DispatcherServlet(servlet-context.xml)에
		 * 			<annotaion-driven/> 이 수행되어야 사용 가능
		 * 
		 * 
		 * 3. 전역(모든 클래스)에서 발생하는 예외를 하나의 클래스에서 처리
		 * 	  (@ControllerAdvice) (3순위)
		 * */
		
		//@ExceptionHandler(처리할 예외.class)
		@ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception e, Model model) {
			
			 String path = null;
			// Model : 데이터 전달용 객체(Map형식, request범위)
			model.addAttribute("errorMessage", "회원 관련 서비스 이용 중 문제가 발생했습니다.");
			model.addAttribute("e", e);
			
			return  "redirect:" + path;
		}
		
	
}
