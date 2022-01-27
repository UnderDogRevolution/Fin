package com.movie.sns.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.member.model.vo.Member;

@Controller
public class MainController {


	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String mainPageForward(Model model , @ModelAttribute("loginMember")Member loginMember) {
		
		return "main/main";
	}
	
}
