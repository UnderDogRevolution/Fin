package com.movie.sns.alram.model.service;

import java.util.List;

import com.movie.sns.alram.model.vo.Alram;

public interface AlramService {

	int insertAlram(Alram alram);

	List<Alram> selectAlram(int memberNo);

}
