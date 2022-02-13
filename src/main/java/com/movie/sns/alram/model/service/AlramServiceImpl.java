package com.movie.sns.alram.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.alram.model.dao.AlramDAO;
import com.movie.sns.alram.model.vo.Alram;

@Service
public class AlramServiceImpl implements AlramService{

	@Autowired
	public AlramDAO dao;
	
	
	@Override
	public int insertAlram(Alram alram) {
		
		return dao.insertAlram(alram);
	}


	@Override
	public List<Alram> selectAlram(int memberNo) {
		
		return dao.selectAlram(memberNo);
	}

	
	
	
}
