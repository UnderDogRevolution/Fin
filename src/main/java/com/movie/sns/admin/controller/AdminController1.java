package com.movie.sns.admin.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.admin.model.service.AdminService1;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.Pagination;


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
			
	
		Pagination pagination =service.getPagination(cp);
		
		List<AdminPost> post =service.adminPost(pagination);
		model.addAttribute("pagination", pagination);
		model.addAttribute("post", post);
		
		return "admin/adminPost";
	}
	

}