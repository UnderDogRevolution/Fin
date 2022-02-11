package com.movie.sns.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.movie.sns.admin.model.service.AdminMemberService;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminMemberSearch;
import com.movie.sns.admin.model.vo.MemberStatus;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

@Controller
@RequestMapping("/admin/member/*")
@SessionAttributes({"loginMember"})
public class AdminMemberController {
	
	
	@Autowired
	private AdminMemberService service;
	

	// 회원정보조회
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String memberBoard(	@RequestParam(value="cp", required=false, defaultValue="1") int cp,
								Model model /*, AdminMemberSearch search */) 
	{
		// search 추가 예정
		
		Pagination pagination = null;
		List<Member> memberList = null;
		
		// 검색 조건이 따로 없는 경우
		pagination = service.getPagination(cp);
		
		memberList = service.selectMemberList(pagination);
		
		// 회원 상태 얻어오기
		List<MemberStatus> statusList = service.selectStatus();
		
		System.out.println(statusList);
		
		model.addAttribute("statusList", statusList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("memberList", memberList);
		
//		System.out.println("==================================");
//		System.out.println("회원 정보 : " + memberList);
//		System.out.println("==================================");
		
		return "admin/adminMember";
	}
	
	// 회원정보조회(ajax를 이용한 조회 페이지)
		@RequestMapping(value = "selectMemberList2", method = RequestMethod.GET)
		@ResponseBody
		public String memberInfoList( @RequestParam(value="cp", required=false, defaultValue="1") int cp,
									 Model model, AdminMemberSearch search /*, 
									 @RequestParam(value="sk", required=false) String sk, 
									 @RequestParam(value="sv", required=false) String sv */ ) 
		{
			// search 추가 예정
			
			Pagination pagination = null;
			List<Member> memberList = null;
			
//			search.setSk(sk);
//			search.setSv(sv);
//			
//			System.out.println(sk + " + " + sv);
			System.out.println(search + "검색 결과");
			
			// 검색 값이 있는 경우
			if(search.getSv() != null && !search.getSv().trim().equals("")) {
				
				pagination = service.getPagination(cp, search);
				memberList = service.selectMemberList(pagination, search);
				
			}else {
				
				// 검색 조건이 따로 없는 경우
				pagination = service.getPagination(cp);
				memberList = service.selectMemberList(pagination);
				
			}
			
			// 회원 상태 얻어오기
			List<MemberStatus> statusList = service.selectStatus();
			
			System.out.println(statusList);
			
			model.addAttribute("statusList", statusList);
			model.addAttribute("pagination", pagination);
			model.addAttribute("memberList", memberList);
			
//			System.out.println("==================================");
//			System.out.println("회원 정보 : " + memberList);
//			System.out.println("==================================");
			
			return new Gson().toJson(memberList);
		}
	
	
	// 회원 상세정보 조회
	// 회원의 상세 정보를 담아서 Member로 전달
	@RequestMapping(value="selectMemberDetail", method=RequestMethod.GET)
	@ResponseBody
	public Member selectMemberDetail(int memberNo, Member member) {
		
		member = service.selectMemberDetail(memberNo);
		
		if(member != null) {
			
			return member;
			
		}else {
			return null;
		}
		
	}
	
	
	
	// 회원 상태 변경
	@RequestMapping(value="changeStatus", method=RequestMethod.GET)
	@ResponseBody
	public int changeStatus(Member member) {
		
		System.out.println("변경할 회원 번호:"+member.getMemberNo());
		System.out.println("변경할 회원 상태:"+member.getMemberStatusCode());
		
		int result = service.changeStatus(member);
		
		if(result > 0) {
			return result;
		}else {
			return 0;
		}
		
	}
	
	
	// 회원 상태 일괄 변경
	@RequestMapping(value="multiChangeStatus", method=RequestMethod.GET)
	@ResponseBody
	public int multiChangeStatus(	@RequestParam(value="checkedMemberNo", required=false) int[] checkedMemberNo , 
									@RequestParam(value="statusValue", required=false) int statusValue) {
		
		
//		System.out.println(Arrays.toString(checkedMemberNo));
		int result = service.multiChangeStatus(checkedMemberNo, statusValue);
		
		if(result > 0) {
			return result;
		}else {
			return 0;
		}
		
	}
	
	
	

	
	
}
