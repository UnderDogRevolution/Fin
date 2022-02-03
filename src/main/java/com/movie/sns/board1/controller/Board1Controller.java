package com.movie.sns.board1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board1/*")
public class Board1Controller {

	@RequestMapping(value="myBoard", method=RequestMethod.GET)
	public String myboard() {
		
		return "board1/myBoard";
	}
	
	
	
	
	
}
