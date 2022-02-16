package com.movie.sns.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.member.model.service.MemberService;
import com.movie.sns.member.model.service.MemberService2;
import com.movie.sns.member.model.vo.Image;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.admin.model.vo.AdminAsk;

import com.movie.sns.common.Util;

@Controller
@RequestMapping("/member/*")
@SessionAttributes({ "loginMember" })
public class MemberController2 {

	@Autowired
	private MemberService2 service;

	// 마이페이지 화면 전환
	@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public String myPage() {
		return "member/myPage";
	}

	// 회원 정보 수정
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMember(
			@ModelAttribute("loginMember") Member loginMember,
			@RequestParam("nickInput") String nickInput,
			@RequestParam("birthInput") @DateTimeFormat(pattern = "yyyy-MM-dd")String birthInput,
			Member member, RedirectAttributes ra,
			List<MultipartFile> images,
			@RequestParam(value="deleteCheck", required = false, defaultValue = "0" )int deleteCheck, HttpSession session) {
		
		
		member.setMemberBirth(birthInput);
		member.setMemberNo(loginMember.getMemberNo());
		member.setMemberNickName(nickInput);

		String webPath = "/resources/images/member/"; // (DB에 저장되는 경로)
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		int result = service.updateMember(member, images, webPath, serverPath, deleteCheck);
		String path = null;
		
		if (result > 0) { // 수정 성공
				
			Image memberImage = service.selectProfileImage(loginMember.getMemberNo());
				
			loginMember.setProfileImage(memberImage);
			loginMember.setMemberNickName(nickInput);
			loginMember.setMemberBirth(birthInput);
			
			Util.swalSetMessage("회원정보 수정 성공", "회원정보가 변경되었습니다.", "success", ra);
		} else { // 실패
			Util.swalSetMessage("회원정보 수정 실패", "회원정보 변경에 실패하였습니다.", "error", ra);
		}

		return "redirect:/member/myPage";
	}
	
	
	
	
	// 비밀번호 수정 화면 전환
	@RequestMapping(value = "updatePw", method = RequestMethod.GET)
	public String updatePw() {
		return "member/updatePw";
	}

	
	
	// 비밀번호 수정
	@RequestMapping(value = "updatePw", method = RequestMethod.POST)
	public String updatePw(@ModelAttribute("loginMember") Member loginMember, String currentPw, String newPw1,
			RedirectAttributes ra) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("memberNo", loginMember.getMemberNo() + "");
		map.put("currentPw", currentPw);
		map.put("newPw", newPw1);

		int result = service.updatePw(map);

		if (result > 0) {
			Util.swalSetMessage("비밀번호 변경 성공", "비밀번호가 변경되었습니다.", "success", ra);
		} else {
			Util.swalSetMessage("비밀번호 변경 실패", "현재 비밀번호가 일치하지 않습니다.", "error", ra);
		}

		return "redirect:/member/updatePw";
	}

	// 회원 탈퇴 화면 전환
	@RequestMapping(value = "secession", method = RequestMethod.GET)
	public String secession(Member member) {
		return "member/secession";
	}

	// 회원 탈퇴
	@RequestMapping(value = "secession", method = RequestMethod.POST)
	public String secession(@ModelAttribute("loginMember") Member loginMember, String currentPw, SessionStatus status,
			RedirectAttributes ra) {

		// 회원 가입 Service 호출 후 결과 반환 받기
		int result = service.secession(loginMember.getMemberNo(), currentPw);

		if (result > 0) { // 성공
			Util.swalSetMessage("회원 탈퇴 성공", "탈퇴 되었습니다.", "success", ra);
			status.setComplete(); // 세션만료

		} else { // 실패
			Util.swalSetMessage("회원 탈퇴 실패", "비밀번호가 일치하지 않습니다.", "error", ra);
		}

		return "redirect:/member/login";
	}

	
	
	
	
	// 문의 글 화면 전환
	@RequestMapping(value = "ask", method = RequestMethod.GET)
	public String askInsert(Model model) {
		return "member/askInsert";
	}
	
	//문의 글 삽입
	@RequestMapping(value="ask", method=RequestMethod.POST)
	public String boardInsert(Model model, AdminAsk ask,
		  @ModelAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
		
		ask.setMemberNo(loginMember.getMemberNo());
		int askNo = service.insertAsk(ask);
		
		if(askNo > 0) { // 삽입 성공
			Util.swalSetMessage("바라는 글 제출 성공", null, "success", ra);

		}else { // 실패
			Util.swalSetMessage("바라는 글 제출 실패", null, "error", ra);
		}
		
		return "redirect:/member/ask";
	}
}
