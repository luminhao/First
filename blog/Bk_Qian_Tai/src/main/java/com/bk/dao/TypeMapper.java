package com.bk.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bk.entity.content;
import com.bk.entity.type;

public interface TypeMapper  extends BaseMapper<type>{
	List<type> Alltype();
}
