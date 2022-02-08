package com.movie.sns.board1.model.Service;

import java.util.List;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;

public interface Board1Service {

	Member selectProfile(int memberNo);

	List<Post> selectList(int memberNo);

	List<Post> selectLike(int memberNo);

	int insertFollow(Member member);

	int deleteFollow(Member member);

	int followCheck(Member member);

	

	

	

	


}
