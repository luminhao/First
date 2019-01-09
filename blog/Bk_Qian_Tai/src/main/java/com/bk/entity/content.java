package com.bk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class content  implements Serializable{
	@TableId(type = IdType.AUTO)
	private Integer cid;
	private int uid;
	private String content;
	private Date cdate;
	private int cexamine;
	private int aid;
	private users user;
	private List<reply> replys;
	@TableField(exist=false)//排除此字段	
	private int replycount;
}
