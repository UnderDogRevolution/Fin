package com.movie.sns.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.movie.sns.admin.model.service.AdminService;
import com.movie.sns.admin.model.service.AdminService1;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;



@Controller
@RequestMapping("/admin/*")
@SessionAttributes({"loginMember"}) 
public class AdminController {

	@Autowired
	private AdminService service;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String adminLoginPage() {
		
		
		return "admin/adminLogin";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Member member, Model model, RedirectAttributes ra, HttpServletRequest req,
			HttpServletResponse resp) {

		Member loginMember = service.adminLogin(member);
		System.out.println("loginMember" + loginMember);
		String path = null;
		
		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember);
			path = "redirect:/admin/main";

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

	
	
	@RequestMapping(value ="main", method = RequestMethod.GET)
	public String adminMain(Model model , RedirectAttributes ra) {
		int postCount = service.postCount();
		int replyCount = service.replyCount();
		int reportCount = service.reportCount();
		int askCount = service.askCount();
		int memberCount = service.memberCount();
		model.addAttribute("replyCount" ,replyCount);
		model.addAttribute("postCount", postCount);
		model.addAttribute("reportCount", reportCount);
		model.addAttribute("askCount", askCount);
		model.addAttribute("memberCount", memberCount);
		
		
		return "admin/adminMain";
	} 
		
	@ResponseBody
	@RequestMapping(value = "mainRefresh", method = RequestMethod.GET)
	public Map<String, Object> mainRefresh() {
		
		System.out.println("값넘어옴");
		int postCount = service.postCount();
		int replyCount = service.replyCount();
		int reportCount = service.reportCount();
		int askCount = service.askCount();
		int memberCount = service.memberCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postCount", postCount);
		map.put("replyCount", replyCount);
		map.put("reportCount", reportCount);
		map.put("askCount", askCount);
		map.put("memberCount", memberCount);
		
		
		return map;
	}
	
	
		

}
