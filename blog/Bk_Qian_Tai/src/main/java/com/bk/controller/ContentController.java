package com.bk.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bk.entity.content;
import com.bk.service.ContentService;

@Controller
public class ContentController {
	@Autowired
	ContentService contentService;	
	/**
	 * 添加用户评论
	 */
	@RequestMapping("add_content")
	public String content_add( content content,HttpSession session,String auid,String aatitle) {
		content.setCdate(new Date());				
		contentService.insert(content);
		
		
		return "forward:add-dynamics-del?pageinfo=redirect:bk_view?id="+content.getAid()+"&auid="+auid+"&atitle="+aatitle;
	}
}
