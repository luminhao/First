package com.bk.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bk.entity.article;
import com.bk.entity.content;
import com.bk.entity.dynamic;
import com.bk.entity.users;
import com.bk.service.DynamicService;

@Controller
public class DynamicController {
	@Autowired
	DynamicService dynamicService;
	/**
	 * 查询用户动态
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("profile")
	public String selectdynamic(Model model,HttpSession session) {
		model.addAttribute("dynamics", dynamicService.byuidselect(((users)session.getAttribute("user")).getUid()));
		return "profile";
	}
	/**
	 * 添加用户发表动态
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("add-dynamics")
	public String add_dynamics(Model model,HttpSession session,article article,String pageinfo) {
			dynamicService.insert(new dynamic(null, article.getUid(), null, "发表了"+article.getAtitle()+"的文章",new Date()));		
		return pageinfo;
	}
	/**
	 * 添加用户发表评论的动态
	 * @param pageinfo 需要跳转的页面
	 * @return
	 */
	@RequestMapping("add-dynamics-del")
	public String add_dynamics(String pageinfo,content content,int auid,String atitle) {
		dynamicService.insert(new dynamic(null, auid,content.getUid(), "评论了您["+atitle+"]的文章",new Date()));		
	return pageinfo;
}
}
