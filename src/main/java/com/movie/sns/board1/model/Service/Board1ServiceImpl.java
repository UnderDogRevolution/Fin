package com.movie.sns.board1.model.Service;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.board1.model.dao.Board1DAO;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;

@Service
public class Board1ServiceImpl implements Board1Service {
	
	@Autowired
	private Board1DAO dao;

	@Override
	public Member selectProfile(int memberNo) {
		
		return dao.selectProfile(memberNo);
	}

	@Override
	public List<Post> selectList(int memberNo) {
		
		return dao.selectList(memberNo);
	}

	@Override
	public List<Post> selectLike(int memberNo) {
		
		return dao.selectLike(memberNo);
	}

	@Override
	public int insertFollow(Map<String, Object> map) {
		
		return dao.insertFollow(map);
		
		
	}

	@Override
	public int deleteFollow(Map<String, Object> map) {
		
		return dao.deleteFollow(map);
	}

	@Override
	public int followCheck(Member member) {
		
		return dao.followCheck(member);
	}

	
	
	
	
	
	

	}

	
	
	

	
	
	
	

