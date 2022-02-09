package com.movie.sns.admin.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.sns.admin.model.service.AdminService2;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

import com.movie.sns.common.Util;


@Controller
@RequestMapping("/admin/*")
@SessionAttributes({"loginMember"}) 
public class AdminController2 {

	@Autowired
	private AdminService2 service;

		// 바라는 점 목록 조회
		@RequestMapping("ask")
		public String selectAskList(@RequestParam(value="cp", required=false, defaultValue="1") 
		int cp,  Model model) {

			Pagination pagination = null;
			List<AdminAsk> askList = null;
			
			pagination = service.getPagination(cp);
			askList = service.selectAskList(pagination);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("askList", askList);
			
			
			return "admin/adminAskList";
		}
	
	
		// 바라는 점 상세 조회
		@RequestMapping("view/{askNo}")
		public String selectBoard(@PathVariable("askNo") int askNo,
				@RequestParam(value="cp", required=false, defaultValue="1") int cp,
				Model model, RedirectAttributes ra, HttpSession session,
				@ModelAttribute("loginMember") Member loginMember) {
				
			int memberNo = 0;
			
			// session에 loginMember가 있을 경우
			if(session.getAttribute("loginMember") != null) {
				memberNo = ( (Member)session.getAttribute("loginMember") ).getMemberNo();
			}
			
			
			// 게시글 상세 조회 Service 호출
			AdminAsk ask = service.selectAsk(askNo, memberNo);
			
			
			
			return "admin/adminAskView";
		}
		

		
}
