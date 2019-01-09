package com.bk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.dao.DynamicMapper;
import com.bk.entity.dynamic;
@Service
public class DynamicService {
	@Autowired 
	DynamicMapper mapper;
	public boolean insert(dynamic dynamic) {
		return mapper.insert(dynamic)>0?true:false;
	}
	public List<dynamic> byuidselect(int uid){
		return mapper.byuidselect(uid);
	}
}
