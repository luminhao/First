package com.bk.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class type  implements Serializable{
	@TableId(type = IdType.AUTO)
	private int tid;
	private String tname;
	private List<article> articles;
}
