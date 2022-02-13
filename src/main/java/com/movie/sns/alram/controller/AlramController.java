package com.movie.sns.alram.controller;



import java.util.List;

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
import com.movie.sns.alram.model.service.AlramService;
import com.movie.sns.alram.model.vo.Alram;
import com.movie.sns.member.model.vo.Member;




@Controller

@SessionAttributes({ "loginMember" })

public class AlramController {

	
	@Autowired
	private AlramService service;
	
	
	@ResponseBody
	@RequestMapping(value = "/selectAlram", method=RequestMethod.GET)
	public String selectAlram(Model model, HttpSession session, @ModelAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		
		List<Alram> list = null;
		
		list = service.selectAlram(memberNo);
		
		
		System.out.println(list);
		
		return new Gson().toJson(list);

		
		
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/selectAlram", method=RequestMethod.GET)
//	public int deleteAlram(Model model, HttpSession session, @ModelAttribute("loginMember") Member loginMember) {
//		
//		int memberNo = loginMember.getMemberNo();
//		
//		int deleteAlramNo;
//		
//		int result = service.deleteAlram(deleteAlramNo);
//		
//		
//		
//		System.out.println(result);
//		
//		return result;
//		
//		
//		
//	}
	
}
