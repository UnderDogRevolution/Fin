package com.movie.sns.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.movie.sns.admin.model.service.AdminService1;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.AdminReply;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.admin.model.vo.PostStatus;
import com.movie.sns.admin.model.vo.ReplyStatus;
import com.movie.sns.member.model.vo.Member;

@Controller
@RequestMapping("/admin/*")
@SessionAttributes({ "loginMember" })
public class AdminController1 {

	@Autowired
	private AdminService1 service;

	// 게시글 게시판
	@RequestMapping(value = "post", method = RequestMethod.GET)
	public String postBoard(@RequestParam(value = "cp", required = false, defaultValue = "1") int cp, Model model,
			AdminPost post) {
		// Admin loginMember = service.adminLogin(member);
		// Member member = null;
		// member.setMemberNo(loginMember.getMemberNo()); loginMember.getMemberNo()

		Pagination pagination = service.getPagination(cp, post);
		// 게시글 전체 조회
		List<AdminPost> List = service.adminPost(pagination, post);
		List<PostStatus> cd = service.selectStatus();
		model.addAttribute("pagination", pagination);
		
		model.addAttribute("post", List);
		model.addAttribute("cd", cd);

		return "admin/adminPost";
	}

	@ResponseBody
	@RequestMapping(value = "changeStatus", method = RequestMethod.GET)
	public int changeStatus(AdminPost post) {
		int result = service.changeStatus(post);

		return result;
	}
	

	@ResponseBody
	@RequestMapping(value = "searchPost", method = RequestMethod.GET)
	public String searchPost(AdminPost post, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		Pagination pagination = service.getPagination(cp, post);
		List<AdminPost> List = service.adminPost(pagination, post);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("List", List);
		map.put("pagination", pagination);

		/*
		 * if(search.equals("memberNo")) { pagination =service.getPagination(cp);
		 * 
		 * System.out.println("메롱");
		 * 
		 * 
		 * }else if(search.equals("memberNm")) {
		 * 
		 * System.out.println("아뇽");
		 * 
		 * 
		 * }else if(search.equals("postNo")) {
		 * 
		 * 
		 * 
		 * 
		 * }else if(search.equals("status")) {
		 * 
		 * }
		 */

		return new Gson().toJson(map);
	}

	// 게시글 상세조회
	@ResponseBody
	@RequestMapping(value = "postView", method = RequestMethod.GET)
	public String postView(String postNo) {
		AdminPost result = service.postView(postNo);
		System.out.println("결과" +result);
		return new Gson().toJson(result);
	}
	//댓글상세
	@ResponseBody
	@RequestMapping(value = "replyView", method = RequestMethod.GET)
	public String replyView(String replyNo) {
		AdminReply result = service.replyView(replyNo);
		System.out.println("결과" +result);
		return new Gson().toJson(result);
	}

	
		// 댓글 조회
		@RequestMapping(value = "reply", method = RequestMethod.GET)
		public String reply(@RequestParam(value = "cp", required = false, defaultValue = "1") int cp, Model model
							,AdminReply reply
				
				) {
			
			Pagination pagination = service.getReplyPagination(cp, reply);
			List<AdminReply> List = service.adminReply(pagination, reply);
			List<ReplyStatus> cd = service.selectReplyStatus();
			System.out.println(cd);
			model.addAttribute("pagination", pagination);
			model.addAttribute("reply", List);
			model.addAttribute("cd", cd);
			
			
			return "admin/adminReply";
		}
	
		
		
		@ResponseBody
		@RequestMapping(value = "searchReply", method = RequestMethod.GET)
		public String searchReply(AdminReply reply, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
			Pagination pagination = service.getReplyPagination(cp, reply);
			List<AdminReply> List = service.adminReply(pagination, reply);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("List", List);
			map.put("pagination", pagination);


			return new Gson().toJson(map);
		}
		
		@ResponseBody
		@RequestMapping(value = "changeStatusReply", method = RequestMethod.GET)
		public int changeStatus(AdminReply reply) {
			int result = service.changeStatus(reply);
			
			return result;
		}
		
		
}
