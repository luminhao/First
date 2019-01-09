package com.bk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bk.entity.reply;
import com.bk.service.ReplyService;
@Controller
public class ReplyController {
	@Autowired
	ReplyService service;
	@RequestMapping("allreply")
	@ResponseBody
	public String allreply(int rcid) {
		return JSON.toJSONString(service.replys(rcid));
	}
	@RequestMapping("insertreply")
	@ResponseBody
	public String insert(reply r) {
		return service.insert(r)+"";
	}
/*	@RequestMapping("bk_view2")
	public String bk_view(int id,Model model) {
		model.addAttribute("replycount", service.count());
		return "affinity";
	}*/
}
