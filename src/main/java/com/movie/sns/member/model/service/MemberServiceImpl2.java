package com.movie.sns.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.sns.member.model.dao.MemberDAO2;
import com.movie.sns.member.model.vo.Member;

@Service
public class MemberServiceImpl2 implements MemberService2{

	@Autowired
	private MemberDAO2 dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	// Bean으로 등록된 BCryptPasswordEncoder 객체를 의존성 주입(DI)
	
	// 로그인
	@Override
	public Member login(Member member) {

//		return dao.login(member);
		
		return null;
	}
	
	// 회원 정보 수정
		// @Transactional // 트랜잭션 처리는 여러 DML 수행 시 사용한다.
		@Override
		public int updateMember(Member member) {
			return dao.updateMember(member);
		}

		// 회원 정보 수정
		@Override
		public int updatePw(Map<String, String> map) {

			// 2. 회원 번호를 이용해서 DB에 저장된 비밀번호를 조회
			String savePw = dao.selectSavePw(map.get("memberNo"));

			// 3. DB 저장된 비밀번호와 입력된 현재 비밀번호 비교( matches() 사용 )
			int result = 0;
			if (encoder.matches(map.get("currentPw"), savePw)) { // 일치할 때
				// 4. 일치하면 새 비밀번호를 암호화 -> 비밀번호 변경 DAO 호출

				String encPw = encoder.encode(map.get("newPw")); // 새 비밀번호 암호화
				map.put("newPw", encPw); // map에 key가"newPw"인 요소의 value를 encPw로 변경

				result = dao.updatePw(map); // 비밀번호 변경 DAO 호출
			}

			// 5. 일치하지 않으면 Controller로 0 반환

			return result;
		}

		
		// 회원 탈퇴
		@Override
		public int secession(int memberNo, String currentPw) {
			
			String savePw = dao.selectSavePw(memberNo+"");

			int result = 0;

			if (encoder.matches(currentPw, savePw)) { 

				result = dao.secession(memberNo); 
			}

			return result;
		}
	
	

}
