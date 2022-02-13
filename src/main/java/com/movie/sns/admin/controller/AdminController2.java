package com.movie.sns.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.movie.sns.admin.model.service.AdminService2;
import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.admin.model.vo.AdminMemberSearch;
import com.movie.sns.admin.model.vo.Pagination;

@Controller
@RequestMapping("/admin/*")
@SessionAttributes({ "loginMember" })
public class AdminController2 {

	@Autowired
	private AdminService2 service;

	// 바라는 점 목록 조회
	@RequestMapping("ask")
		public String selectAskList(@RequestParam(value="cp", required=false, defaultValue="1") 
		int cp,  Model model) {

			Pagination pagination = null;
			List<AdminAsk> askList = null;
			
					
			pagination = service.getPagination(cp);
			askList = service.selectAskList(pagination);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("askList", askList);
						
			
			return "admin/adminAskList";
		}

	
	// 바라는 점 검색 조회
	@RequestMapping("askList")
	@ResponseBody
		public String selectAskList(@RequestParam(value="cp", required=false, defaultValue="1") 
		int cp,  Model model, AdminMemberSearch search) {

			Pagination pagination = null;
			List<AdminAsk> askList = null;
			
			
			// 검색 값이 있는 경우
			if(search.getSv() != null && !search.getSv().trim().equals("")) {
							
					pagination = service.getPagination(cp, search);
					askList = service.selectAskList(pagination, search);
							
			}else {//검색값 없을 때
				
			pagination = service.getPagination(cp);
			askList = service.selectAskList(pagination);
			
			}
			
			Map<String, Object> askMap = new HashMap<String, Object>();
			askMap.put("pagination", pagination);
			askMap.put("askList", askList);
						
			
			return new Gson().toJson(askMap);
		}
	
	// 바라는 점 상세 조회 modal
	@RequestMapping(value = "selectAskDetail", method = RequestMethod.GET)
	@ResponseBody
	public AdminAsk selectAskDetail(int askNo, AdminAsk ask, Model model) {

		ask = service.selectAskDetail(askNo);
		model.addAttribute("ask", ask);

		return ask;
	}

	// 바라는 점 삭제
	@ResponseBody
	@RequestMapping(value = "askDelete", method = RequestMethod.GET)
	public int askDelete(int askNo, AdminAsk ask, Model model) {

		int result = service.askDelete(askNo);

		if (result > 0) {
			return result;
		} else {
			return 0;
		}

	}
}
