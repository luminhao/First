package com.bk.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class users  implements Serializable{
	@TableId(type = IdType.AUTO)
	private int uid;
	private String uname;
	private String pwd;
	private String nickname;//用户昵称，新添加
	private int isadmin;
	private int islogin;
	private String email;
	private String image;
	private Date date;
	private String logdate;
	private int isnormal;
}
