package com.bk.dao;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bk.entity.users;

public interface UserMapper extends BaseMapper<users> {
	users login(Map<String, String> user);
	int update(users user);
	int lastlogin(String logdate,String uid);
}
