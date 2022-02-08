package com.movie.sns.admin.controller;



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

import com.movie.sns.admin.model.service.AdminService1;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.admin.model.vo.PostStatus;
import com.movie.sns.member.model.vo.Member;


@Controller
@RequestMapping("/admin/*")
@SessionAttributes({"loginMember"}) 
public class AdminController1 {

	@Autowired
	private AdminService1 service;


	
	//게시글 게시판
	@RequestMapping(value = "post", method = RequestMethod.GET)
	public String postBoard(
			@RequestParam(value="cp", required=false, defaultValue="1")int cp,  Model model ) {
		//Admin loginMember = service.adminLogin(member);	
		//Member member = null;
		//member.setMemberNo(loginMember.getMemberNo()); loginMember.getMemberNo()
		
		Pagination pagination =service.getPagination(cp);
		
		List<AdminPost> post =service.adminPost(pagination);
		List<PostStatus> cd = service.selectStatus();
		model.addAttribute("pagination", pagination);
		model.addAttribute("post", post);
		model.addAttribute("cd", cd);
		
		return "admin/adminPost";
	}
	
	@ResponseBody
	@RequestMapping(value = "changeStatus", method = RequestMethod.GET)
	public int changeStatus(AdminPost post){
		System.out.println(post);
		int result = service.changeStatus(post);
			
		
		return result;
	} 
	
	
	@ResponseBody
	@RequestMapping(value = "searchPost", method = RequestMethod.GET)
	public String searchPost(AdminPost post ,@RequestParam(value="cp", required=false, defaultValue="1")int cp){
			String search = post.getSearchPost(); // 검색 구분자
		
			if(search.equals("postNo")) {
				
				System.out.println("메롱");
				
				
			}else if(search.equals("memberNo")) {
				
				System.out.println("아뇽");

				
			}else if(search.equals("status")) {
				
			}else if(search.equals("createDt")) {
				
			}
			
		return null;
	} 
	
	
}
