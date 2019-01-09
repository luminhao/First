package com.bk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bk.dao.ContentMapper;
import com.bk.dao.TypeMapper;
import com.bk.entity.content;
import com.bk.entity.type;


@Service
public class FenleiService {
	@Autowired
	TypeMapper typeMapper;
	public List<type> Alltype(){
		return typeMapper.Alltype();
	}
}
