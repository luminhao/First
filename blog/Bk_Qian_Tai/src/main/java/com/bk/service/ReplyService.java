package com.bk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.dao.ReplyMapper;
import com.bk.entity.reply;

@Service
public class ReplyService {
	@Autowired
	ReplyMapper mapper;
	public List<reply> replys(int rcid){
		return mapper.Allreply(rcid);
	}
	public int insert(reply reply) {
		reply.setRdate(new Date());
		return mapper.insert(reply);
	}
	public int count() {
		return mapper.selectCount(null);
	}
}
