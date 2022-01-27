package com.movie.sns.post.model.service;

import java.util.List;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Tag;

public interface PostService {

	List<Tag> selectTag(String tagName);

	List<Member> selectUser(String tagName);

}
