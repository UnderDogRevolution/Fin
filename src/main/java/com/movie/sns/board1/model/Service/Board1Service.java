package com.movie.sns.board1.model.Service;

import java.util.List;
import java.util.Map;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;

public interface Board1Service {

	Member selectProfile(int memberNo);

	List<Post> selectList(int memberNo);

	List<Post> selectLike(int memberNo);

	
	int insertFollow(Map<String, Object> map);

	int deleteFollow(Map<String, Object> map);

	int followCheck(Member member);

	int followCount(int memberNo);

	int followerCount(int memberNo);

	int postCount(int memberNo);


	

	

	

	


}
