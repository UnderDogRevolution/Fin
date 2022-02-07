package com.movie.sns.admin.model.service;

import com.movie.sns.admin.model.vo.Admin;

public interface AdminService {
	
	// 관리자 로그인
	Admin adminLogin(Admin member);

}
