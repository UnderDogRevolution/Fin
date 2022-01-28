package com.movie.sns.post.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.Tag;

@Repository
public class PostDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Tag> selectTag(String tagName) {
		return sqlSession.selectList("postMapper.selectTag", tagName);
	}

	public List<Member> selectUser(String tagName) {
		return sqlSession.selectList("postMapper.selectUser", tagName);
	}

	public int insertPost(Post post, List<String> tagArr) {
		int result = sqlSession.insert("postMapper.insertPost", post);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postNo", post.getPostNo());
		for(String tagName : tagArr) {
			map.put("tagName", tagName);
			result = sqlSession.selectOne("postMapper.dupCheckTag", map);
			if(result == 1) { //중복되는 태그가 있는 경우
				result = sqlSession.insert("postMapper.insertPostTag", map);
			}else if(result == 0) { //중복되는 태그가 없는 경우
				result = sqlSession.insert("postMapper.insertTag", map);
				result = sqlSession.insert("postMapper.insertPostTag", map);
			}
		}
		return result;
	}

}
