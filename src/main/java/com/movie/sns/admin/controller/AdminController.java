package com.movie.sns.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminLoginPage(HttpSession session, Model model , RedirectAttributes ra) {
		
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
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			
			if(loginMember.getMemberGradeCode() == 101) {
				
				return "admin/adminMain";
				
			}else {
				
				return "admin/adminLogin";
				
			}
			
		}else {
			
			return "admin/adminLogin";
			
		}
		
		
		
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Member member, Model model, RedirectAttributes ra, HttpServletRequest req,
			HttpServletResponse resp) {

		Member loginMember = service.adminLogin(member);
		System.out.println("loginMember" + loginMember);
		String path = null;
		
		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember);
			path = "redirect:/admin/";

		} else {

			ra.addFlashAttribute("failMessage", "????????? ?????? ??????????????? ??????????????????");
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
		
		System.out.println("????????????");
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
