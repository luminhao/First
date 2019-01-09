package com.bk.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dynamic implements Serializable{
	@TableId(type = IdType.AUTO)
	private Integer did;
	private int duid;              //本人
	private Integer dcuid;          //他人
	private String dinfo;
	private Date ddate;
	private users dcuser;//操作用户
	public dynamic(Integer did, int duid, Integer dcuid, String dinfo,Date ddate) {
		super();
		this.did = did;
		this.duid = duid;
		this.dcuid = dcuid;
		this.dinfo = dinfo;
		this.ddate=ddate;
	}
	public dynamic() {
		super();
	}
	
}
