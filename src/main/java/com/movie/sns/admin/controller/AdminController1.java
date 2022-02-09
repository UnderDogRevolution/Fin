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
			@RequestParam(value="cp", required=false, defaultValue="1")int cp,  Model model , AdminPost post ) {
		//Admin loginMember = service.adminLogin(member);	
		//Member member = null;
		//member.setMemberNo(loginMember.getMemberNo()); loginMember.getMemberNo()
		
		Pagination pagination =service.getPagination(cp,post);
		
		List<AdminPost> List =service.adminPost(pagination,post);
		List<PostStatus> cd = service.selectStatus();
		model.addAttribute("pagination", pagination);
		model.addAttribute("post", List);
		model.addAttribute("cd", cd);
		
		return "admin/adminPost";
	}
	
	@ResponseBody
	@RequestMapping(value = "changeStatus", method = RequestMethod.GET)
	public int changeStatus(AdminPost post){
		int result = service.changeStatus(post);
			
		
		return result;
	} 
	
	
	@ResponseBody
	@RequestMapping(value = "searchPost", method = RequestMethod.GET)
	public String searchPost(AdminPost post ,@RequestParam(value="cp", required=false, defaultValue="1")int cp){
			Pagination pagination =service.getPagination(cp,post);
			System.out.println(post.getInputResult());
			System.out.println(post.getSearchPost());
			List<AdminPost> List =service.adminPost(pagination,post);
			
			System.out.println("페이지네이션 결과" +pagination);
			System.out.println("검색 결과" +List);
			Map<String, Object> map =  new HashMap<String, Object>();
			map.put("List" , List);
			map.put("pagination" , pagination);
			
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
	
	
}
