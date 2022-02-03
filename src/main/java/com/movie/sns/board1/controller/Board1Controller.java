package com.movie.sns.board1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.sns.board1.model.Service.Board1Service;
import com.movie.sns.member.model.vo.Member;




@Controller
@RequestMapping("/board1/*")
public class Board1Controller {
	
	
	@RequestMapping(value="myBoard/{memberNo}", method=RequestMethod.GET)
	public String myboard(@PathVariable("memberNo") int memberNo
			) {
		
		
		
		
		
		return "board1/myBoard";
	}
	
	
	
	
	
}
