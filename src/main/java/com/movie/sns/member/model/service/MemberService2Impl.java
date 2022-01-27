package com.movie.sns.member.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.common.Util;
import com.movie.sns.member.model.dao.MemberDAO2;
import com.movie.sns.member.model.vo.Image;
import com.movie.sns.member.model.vo.Member;


@Service

	@Autowired
	private MemberDAO2 dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	// Bean으로 등록된 BCryptPasswordEncoder 객체를 의존성 주입(DI)
	
	// 로그인
	@Override
	public Member login(Member member) {

		return null;
	}
	
		// 비밀번호 수정
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

		// 회원 정보 수정
		@Override
		public int updateMember(Member member, List<MultipartFile> images, String webPath, String serverPath,
				String deleteImages) {
			
			int result = dao.updateMember(member);
			
			// 3) 기존에 있었지만 삭제된 이미지 DELETE 처리
						if(result > 0) {
							
							if( !deleteImages.equals("") ) { // 삭제할 이미지 있을 경우
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("memberNo", member.getMemberNo());
													// int -(Auto Boxing)-> Integer -> Object
								
								map.put("deleteImages", deleteImages);
														// String -> Object
								
								result = dao.deleteImages(map);
							}
						}
						
						
						// 4) images에 담겨있는 파일 정보 중
						//    업로드된 파일 정보를 imgList에 옮겨 담기
						if(result > 0) {
							
							List<Image> imgList = new ArrayList<Image>();
							
							for(int i=0 ; i<images.size(); i++) {
								// i == images 인덱스 == imgLevel
								
								// 업로드된 파일이 있는 경우
								if( !images.get(i).getOriginalFilename().equals("")  ) {
									
									Image img = new Image();
									
									img.setImgPath(webPath); // 웹 접근 경로
									img.setImgName( Util.fileRename( images.get(i).getOriginalFilename() ) ); // 변경된 파일명
									img.setImgOriginal( images.get(i).getOriginalFilename() ); // 원본 파일명
									img.setImgLevel(i); // 이미지 레벨
									img.setMemberNo(member.getMemberNo() ); // 사용자 번호
									
									imgList.add(img);
								}
							}
							
							
							// 5) imgList가 비어있지 않을 경우
							//    imgList에 있는 내용을 update 또는 insert
							
							// 향상된 for문으로 반복 접근할 List가 비어있다면 for문은 수행되지 않음.
							for(Image img : imgList) {
								
								// 서로 다른 행을 일괄적으로 update 하는 방법이 없기에 
								// 한 행씩 수정
								result = dao.updateImage(img);
								// 결과 1 -> 기존에 저장된 이미지가 수정됨.
								// 결과 0 -> 기존에 저장되지 않은 이미지가 추가됨 -> INSERT 진행
								
								if(result == 0) { // 기존에 저장되지 않은 이미지가 추가됨 -> INSERT 진행
									result = dao.insertImage(img);
									
								}
								
							} // for end
							
							
							// 6) 전달 받은 images 중 업로드된 파일이 있는 부분을 실제 파일 저장
							
							if(!imgList.isEmpty()) {
								
								try {
									for(int i=0; i<imgList.size(); i++) {
										
										images.get( imgList.get(i).getImgLevel() )
										.transferTo(new File(serverPath + "/" + imgList.get(i).getImgName() ));
										
									}
									
								}catch (Exception e) {
									e.printStackTrace();
								}
								
							}
							
							
						} // if end
						
						return result;
					}
		

		@Override
		public List<String> selectImgList() {
			return dao.selectImgList();
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
