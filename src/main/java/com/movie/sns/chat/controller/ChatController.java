package com.movie.sns.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/chat/*")
public class ChatController {
	
	
	@RequestMapping(value="myChat", method=RequestMethod.GET)
	public String mainPageForward() {
		
		return "chat/chat";
	}
	
	
		
	
}
