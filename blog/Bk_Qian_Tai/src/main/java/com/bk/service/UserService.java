package com.bk.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.dao.UserMapper;
import com.bk.entity.users;
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	/**
	 * 登录用户
	 * @param user
	 * @return
	 */
	public users login(Map<String, String> user) {
		return userMapper.login(user);
	}
	/**
	 * 注册用户
	 */
	public boolean sign(users user) {
		user.setImage("images/user_48px_26148_easyicon.net.png");
		return userMapper.insert(user)==1?true:false;
	}
	/**
	 * 查询单个用户
	 */
	public users selectUser(String uid) {
		return userMapper.selectById(uid);
	}
	/**
	 * 修改用户
	 */
	public boolean update(users user) {
		return userMapper.update(user)>0?true:false;
	}
	/**
	 * 最后一次登录
	 */
	public boolean lastlogin(String logdate,String uid) {
		return userMapper.lastlogin(logdate, uid)>0?true:false;
	}
}
