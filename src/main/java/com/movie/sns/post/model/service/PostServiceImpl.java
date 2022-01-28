package com.movie.sns.post.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.dao.PostDAO;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.Tag;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO dao;	

	@Override
	public List<Tag> selectTag(String tagName) {
		return dao.selectTag(tagName);
	}

	@Override
	public List<Member> selectUser(String tagName) {
		return dao.selectUser(tagName);
	}
	@Transactional // RuntimException 예외 발생 시 Rollback
	@Override
	public int insertPost(Post post, List<String> tagArr, Movie movie) {
		int result = dao.insertPost(post);
		
		// 태그 등록
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postNo", post.getPostNo());
		
		for(String tagName : tagArr) {
			map.put("tagName", tagName);
			result = dao.dupCheckTag(map);
			if(result == 1) { //중복되는 태그가 있는 경우
				result = dao.insertPostTag(map);
			}else if(result == 0) { //중복되는 태그가 없는 경우
				result = dao.inserTag(map);
				result = dao.insertPostTag(map);
			}
		}
		movie.setPostNo(post.getPostNo());
		// 영화 등록
		if(result>0) {
			int check= dao.dupCheckMovie(movie);
			
			if(check == 0){
				result = dao.insertMovie(movie); // 영화 등록
			}
			if(result>0) {
				result = dao.insertRating(movie); // 영화 별점 등록
			}
			
		}
		
		return result;
	}

	
	
	
}
