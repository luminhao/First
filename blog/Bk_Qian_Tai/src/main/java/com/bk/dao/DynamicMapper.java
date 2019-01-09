package com.bk.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bk.entity.dynamic;

public interface DynamicMapper extends BaseMapper<dynamic>{
	List<dynamic> byuidselect(int uid);
}
