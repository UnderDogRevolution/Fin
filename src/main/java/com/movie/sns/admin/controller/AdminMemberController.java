package com.movie.sns.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.sns.admin.model.service.AdminMemberService;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.member.model.vo.Member;

@Controller
@RequestMapping("/admin/*")
public class AdminMemberController {
	
	
	@Autowired
	private AdminMemberService service;
	

	// 회원정보조회
	@RequestMapping(value = "member2", method = RequestMethod.GET)
	public String memberBoard(Admin member) {
		
		
		return "admin/adminMember";
	}
	
	
	// 멤버 리스트를 조회해서 member를 json으로 반환
	@RequestMapping(value="selectMemberList", method=RequestMethod.GET)
	@ResponseBody
	public List<Member> selectMemberList() {
		
		
		
		return null;
		
		
	}

	
	
}
