package com.movie.sns.post.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.common.Util;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.dao.PostDAO;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Pagination;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.PostImage;
import com.movie.sns.post.model.vo.Report;
import com.movie.sns.post.model.vo.Tag;
import com.movie.sns.post.model.vo.Youtube;

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
	public Map<String, Object> insertPost(Map<String, Object> postVO, List<MultipartFile> fileList, String webPath, String serverPath) {
		
		Post post = new Post();
		post.setMemberNo((int)postVO.get("memberNo"));
		post.setPostContent((String)postVO.get("postContent"));
		post.setCheckUsePoster((int)postVO.get("checkUsePoster"));
		

		Map<String, Object> movieMap = new HashMap<String, Object>();
		Movie movie = new Movie();
		
		
		post.setPostContent(Util.XSS(post.getPostContent()));
		post.setPostContent(Util.changeNewLine(post.getPostContent()));
		
		Youtube youtube = new Youtube();
		
		int result = dao.insertPost(post);
		
		if(result >0) {
			List<PostImage> imgList = new ArrayList<PostImage>();
			for(int i=0; i <fileList.size(); i++) {
				if(!fileList.get(i).getOriginalFilename().equals("")) {
					PostImage img = new PostImage();
					img.setPostImagePath(webPath);
					img.setPostImageOriginal(fileList.get(i).getOriginalFilename());
					img.setPostImageName(Util.fileRename(fileList.get(i).getOriginalFilename()));
					img.setPostImageLevel(i);
					img.setPostNo(post.getPostNo());
					
					imgList.add(img);
				}
			}
			
			if(!imgList.isEmpty()) {
				result = dao.insertImgLIst(imgList);
				
				if(result == imgList.size()) {
					
					for(int i=0; i < imgList.size(); i++) {
						try {
							fileList.get(imgList.get(i).getPostImageLevel()).transferTo(new File(serverPath+"/"+imgList.get(i).getPostImageName()));
						}catch (Exception e) {
							e.printStackTrace();
							
							throw new RuntimeException("파일 변환 중 문제 발생");
						}
					}
				}else {
					throw new RuntimeException("파일 변환 중 문제 발생");
				}
			}
		
		}
		// 태그 등록
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postNo", post.getPostNo());
		
		if(postVO.get("tagArr") != null) {
			List<String> tagArr = (List<String>)postVO.get("tagArr");
			
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
		}
		movie.setPostNo(post.getPostNo());
		// 영화 등록
		if(postVO.get("movie") != null) {
			movieMap = (Map<String, Object>)postVO.get("movie");
			Movie temp = new Movie();
			movie = (Movie)Util.convertMapToObject(movieMap, temp);
			movie.setMemberNo((int)postVO.get("memberNo"));
			movie.setPostNo(post.getPostNo());
			
			if(result>0) {
				int check= dao.dupCheckMovie(movie);
				
				if(check == 0){
					result = dao.insertMovie(movie); // 영화 등록
				}
				if(result>0 && movie.getRating() != null) {
						result = dao.insertRating(movie); // 영화 별점 등록
				}
				
			}
		}
		
		// 유튜브 등록
		if(postVO.get("youtube") != null) {
			Map<String, Object> youtubeMap = new HashMap<String, Object>();
			youtubeMap = (Map<String, Object>)postVO.get("youtube");
			youtube.setYoutubePath((String)youtubeMap.get("path"));
			youtube.setVideoId((String)youtubeMap.get("id"));
			youtube.setThumbnail((String)youtubeMap.get("thumbnail"));
			youtube.setPostNo(post.getPostNo());
			result = dao.insertYoutube(youtube);
		}
		
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("result", result);
		tempMap.put("post", post);
		return tempMap;
	}
	
	
	@Override
	public Pagination getPagination(int cp) {
		int listCount = dao.getListCount();
		return new Pagination(listCount, cp);
	}
	@Override
	public List<Post> selectPostList(Map<String, Object> map, Pagination pagination) {
		
		
		
		return dao.selectPostList(map, pagination);
	}
	
	@Transactional
	@Override
	public int insertLike(int postNo, int memberNo) {
		Map<String, Integer> likeMap = new HashMap<String, Integer>();
		likeMap.put("postNo", postNo);
		likeMap.put("memberNo", memberNo);
		int result = dao.checkDupLike(likeMap);
		if(result == 0) {
			result = dao.insertLike(likeMap);
			result = dao.plusLike(postNo);
		}
		return result;
	}
	@Transactional
	@Override
	public int deleteLike(int postNo, int memberNo) {
		Map<String, Integer> likeMap = new HashMap<String, Integer>();
		likeMap.put("postNo", postNo);
		likeMap.put("memberNo", memberNo);
		int result = dao.checkDupLike(likeMap);
		if(result == 1) {
			result = dao.deleteLike(likeMap);
			result = dao.minusLike(postNo);
		}
		return result;
	}

	@Override
	public int deletePost(int postNo) {
		return dao.deletePost(postNo);
	}

	@Override
	public Post selectPostOne(Post post) {
		return dao.selectPostOne(post);
	}

	@Override
	public int insertReport(Report report) {
		report.setReportContent(Util.XSS(report.getReportContent()));
		report.setReportContent(Util.changeNewLine(report.getReportContent()));
		return dao.insertReport(report);
	}
	
	@Transactional
	@Override
	public int searchMemberNo(String memberName) {
		int result = dao.checkMemberNo(memberName);
		if(result >0) {
			result = dao.searchMemberNo(memberName);
		}
		
		
		return result;
	}

	@Override
	public List<Post> searchPostList(Map<String, Object> map, Pagination pagination) {
		return dao.searchPostList(map, pagination);
	}

	@Override
	public List<Post> popularPostList(Map<String, Object> map, Pagination pagination) {
		return dao.popularPostList(map, pagination);
	}

	@Override
	public List<Post> searchMoviePostList(Map<String, Object> map, Pagination pagination) {
		return dao.searchMoviePostList(map, pagination);
	}

	@Override
	public List<Movie> rankMovie() {
		return dao.rankMovie();
	}

	
	
	
	
}
