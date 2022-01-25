package com.movie.sns.common;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component	// 통해 @Autowired 가능하도록 Bean 등록
public class RandomNumber {

	
	// 인증번호 길이
	private int certificationNoLength = 6;
	
	// 임시비밀번호 길이
	private int temporaryPwLength = 20;
	
	// 인증 번호 및 임시 비밀번호에 사용될 테이블
	private final char[] characterTable = {	'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
										        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
										        'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	// 인증번호 생성하기 ( 문자 + 숫자 )
	public String generateCertificationNo() {
		
		
		Random random = new Random(System.currentTimeMillis());
		
		int tableLength = characterTable.length;
		
		StringBuffer buf = new StringBuffer();
		
		
		for(int i = 0; i < certificationNoLength; i++) {
			
			buf.append(characterTable[random.nextInt(tableLength)]);
			
		}
		
		return buf.toString();
		
	}
	
	
	// 임시 비밀번호 생성하기 (문자 + 숫자) 20글자
	public String generateTemporaryPw() {
		
		
		Random random = new Random(System.currentTimeMillis());
		
		int tableLength = characterTable.length;
		
		StringBuffer buf = new StringBuffer();
		
		for(int i = 0; i < temporaryPwLength; i++) {
			
			buf.append(characterTable[random.nextInt(tableLength)]);
			
		}
		
		return buf.toString();
		
	}
	
	
}
