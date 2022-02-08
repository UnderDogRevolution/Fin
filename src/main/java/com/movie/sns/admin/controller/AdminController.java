package com.movie.sns.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.admin.model.service.AdminService;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;



@Controller
@RequestMapping("/admin/*")
@SessionAttributes({"adminLoginMember"}) 
public class AdminController {

	@Autowired
	private AdminService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminLoginPage() {

		return "admin/adminLogin";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Admin member, Model model, RedirectAttributes ra, HttpServletRequest req,
			HttpServletResponse resp) {

		Admin loginMember = service.adminLogin(member);
		System.out.println("loginMember" + loginMember);
		String path = null;

		if (loginMember != null) {

			model.addAttribute("adminLoginMember", loginMember);

			path = "admin/adminMain";

		} else {

			ra.addFlashAttribute("failMessage", "이메일 또는 비밀번호를 확인해주세요");
			path = "redirect:/admin/";

		}

		return path;
	}

	@RequestMapping("logout")
	public String logout(SessionStatus status) {

		status.setComplete();

		return "redirect:/admin/";
	}

	// 회원정보조회
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public String memberBoard(@RequestParam(value="cp", required=false, defaultValue="1")
	int cp,  Model model,Admin member) {

		Pagination pagination = null;
		List<Member> memberList = null;
		
		pagination =service.getPagination(cp);
		memberList=service.memberBoard(pagination);
		
		
		model.addAttribute("memberList", memberList);
		
		return "admin/adminMember";
	}
	
	
	// 바라는 점
		@RequestMapping(value = "ask", method = RequestMethod.GET)
		public String memberAsk(Admin member) {
			
			
			return "admin/ask";
		}
		

	// 바라는 점 목록 조회
	@RequestMapping("askList")
	public String selectAskList(Admin member, @RequestParam(value="cp", required=false, defaultValue="1") 
	int cp,  Model model) {

		Pagination pagination = null;
		List<Member> askList = null;
		
		pagination = service.getPagination(cp);
		askList = service.selectAskList(pagination);
				
		model.addAttribute("pagination", pagination);
		model.addAttribute("askList", askList);
		
		
		return "admin/askList";
	}

}
