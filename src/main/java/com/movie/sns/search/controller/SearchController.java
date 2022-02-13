package com.movie.sns.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.search.model.service.SearchService;
import com.movie.sns.search.model.vo.Search;

@Controller
@SessionAttributes({ "loginMember" })
@RequestMapping("/search/*")
public class SearchController {
	
	
	@Autowired
	private SearchService service;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String search(String searchResult ,Model model){
		String search  = searchResult;
		System.out.println(search);
		model.addAttribute("search" , search);
		return "search/search";
	}
	
	// 멤버 찾기
	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public String searchMember(Search search , @ModelAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		search.setMemberNo(memberNo);
		List<Search> list = service.searchMember(search);
		return new Gson().toJson(list);
	}
	
	
	/** 팔로우
	 * @param memberNo
	 * @param friendNo
	 * @return result
	 */
	@ResponseBody
	@RequestMapping(value = "follow", method = RequestMethod.GET)
	public int follow(String memberNo , String friendNo) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("friendNo", friendNo);
		int result = service.follow(map);
		
		return result;
	}
	
	
	/** 팔로우 취소
	 * @param memberNo
	 * @param friendNo
	 * @return result
	 */
	@ResponseBody
	@RequestMapping(value = "cancell", method = RequestMethod.GET)
	public int cancell(String memberNo , String friendNo) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("friendNo", friendNo);
		int result = service.cancell(map);
		return result;
	}
	
}
