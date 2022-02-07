package com.movie.sns.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminDAO;
import com.movie.sns.admin.model.vo.Admin;






/**
 * @author home
 *
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO dao;

	/** 관리자 로그인
	 *
	 */
	@Override
	public Admin adminLogin(Admin member) {

		
		return dao.adminLogin(member);
	}

	public AdminServiceImpl(AdminDAO dao) {
		super();
		this.dao = dao;
	}
	
	
}
