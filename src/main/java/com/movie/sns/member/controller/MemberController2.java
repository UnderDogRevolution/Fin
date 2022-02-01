package com.movie.sns.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController2.class);

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
									@RequestParam("profile") List<MultipartFile> images,
									Member member, // 비어있는 Member객체 생성
									RedirectAttributes ra, HttpSession session) {
			
		
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
			return "member/updatePw";
		}
		
		
		// 비밀번호 수정
		@RequestMapping(value="updatePw", method=RequestMethod.POST)
		public String updatePw(@ModelAttribute("loginMember") Member loginMember,
							   String currentPw, String newPw1, RedirectAttributes ra) {
			
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

		//안되면 회원탈퇴 맵 처럼
		
		@ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception e, Model model) {
			
			 String path = null;
			 
			model.addAttribute("errorMessage", "회원 관련 서비스 이용 중 문제가 발생했습니다.");
			model.addAttribute("e", e);
			
			return  "redirect:" + path;
		}
		
	
}
