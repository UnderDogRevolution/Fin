package com.movie.sns.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.member.model.vo.Member;

@Controller
@SessionAttributes({ "loginMember" })
@RequestMapping("/search/*")
public class SearchController {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String search(String searchResult ,Model model){
		String search  = searchResult;
		System.out.println(search);
		model.addAttribute("search" , search);
		return "search/search";
	}
	
	// 멤버 찾기
	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.POST)
	public String searchMember() {
		
		return null;
	}
	
}
