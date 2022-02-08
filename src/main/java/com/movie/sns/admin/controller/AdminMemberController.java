package com.movie.sns.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.admin.model.service.AdminMemberService;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminMemberSearch;
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
	public String memberBoard(	Admin member,
								@RequestParam(value="cp", required=false, defaultValue="1") int cp,
								Model model /*, AdminMemberSearch search */) 
	{
		// search 추가 예정
		
		Pagination pagination = null;
		List<Member> memberList = null;
		
		// 검색 조건이 따로 없는 경우
		pagination = service.getPagination(cp);
		
		memberList = service.selectMemberList(pagination);
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("memberList", memberList);
		
		System.out.println("==================================");
		System.out.println(memberList);
		System.out.println("==================================");
		
		return "admin/adminMember";
	}
	
	

	
	
}
