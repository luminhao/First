package com.bk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class article implements Serializable {
	@TableId(type = IdType.AUTO)
	private int aid;
	private String atitle;
	private String acontent;
	private int uid;
	private users user;
	private Date adate;
	private int tid;
	private String aimage;
	private int examine;
	private type type;
	private List<content> contents;
	
}
