package com.bk.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class reply implements Serializable{
	@TableId(type = IdType.AUTO)
	private int rid;
	private String rcontent;
	private String unickname;
	private String uimage;
	private int ruid;
	private int rcid;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date rdate;
}
