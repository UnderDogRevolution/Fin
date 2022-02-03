package com.movie.sns.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RedisController {

//	@Autowired
//	private RedisTemplate<String, String> redis;
//	
//	
//	// 이메일과 인증번호를 얻어와 redis에 저장하기
//	public void setAuthKey( String userEmail, String authKey ) {
//		
//		redis.opsForHash().put("emailAuth", userEmail, authKey);
//		
//		System.out.println(redis.toString());
//	}
//	
//	
//	// Redis에서 정보 얻어오기
//	public void getAuthKey(String userEmail, String authKey) {
//		
//		String result = null;
//		
//		result = (String)redis.opsForHash().get("emailAuth", userEmail);
//		
//		System.out.println(result);
//	}
	
	
}
