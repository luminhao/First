package com.bk.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bk.entity.article;
import com.bk.service.BkService;
import com.bk.tool.Tool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BkController {
	@Autowired
	BkService bkService;
	/**
	 * 显示主页面并查询所有数据
	 * @return
	 */
	@RequestMapping("index.action")
	public String index(Model model,Integer pageNum) {
		PageHelper.startPage(pageNum==null?1:pageNum,6);				
		model.addAttribute("articles", bkService.AllArticle());
		model.addAttribute("pageNum", pageNum==null?1:pageNum);		
		return "index1";
	}
	/**
	 * 按id查看单个博客
	 * @param id
	 * @return
	 */
	@RequestMapping("bk_view")
	public String bk_view(int id,Model model) {
		model.addAttribute("article", bkService.byArticleId(id));
		return "affinity";
	}
	/**
	 * 显示搜索页面
	 */
	@RequestMapping("search-view")
	public String search_view() {
		return "search";
	}
	/**
	 * 模糊查询博客
	 */
	@RequestMapping("search")
	public String search(String title,Model model,Integer pageNum) {
		PageHelper.startPage(pageNum==null?1:pageNum,6);		
		model.addAttribute("articles", bkService.byArticleTitle(title));	
		model.addAttribute("pageNum", pageNum==null?1:pageNum);
		model.addAttribute("search", title);
		return "index1";
	}
	/**
	 * 按用户id查询博客
	 */
	@RequestMapping("search-userid")
	public String search_userid(String uid,Model model) {
		//PageHelper.startPage(pageNum==null?1:pageNum,5);		
		model.addAttribute("articles", bkService.byArticleuid(uid));	
		//model.addAttribute("pageNum", pageNum==null?1:pageNum);		
		return "table-book";
	}
	/**
	 * 分类查询按分类id分类
	 * @param tname
	 * @param model
	 * @return
	 */
	@RequestMapping("search_fenlei")
	public String search_fenlei(String tname,Model model,Integer pageNum) {	
		PageHelper.startPage(pageNum==null?1:pageNum,6);		

		model.addAttribute("articles", bkService.byArticlefenlei(tname));	
		model.addAttribute("pageNum", pageNum==null?1:pageNum);

		return "index1";
	}
	/**
	 * 显示分类查询页面
	 */
	@RequestMapping("fenlei-view")
	public String fenlei_view(Model model) {		
		model.addAttribute("types", bkService.selectFenlei());	
		return "classify";
	}	

	/**
	 * 添加博客
	 */
	@RequestMapping("bk-add")
	public String bk_add(MultipartFile file ,article Article ,HttpServletRequest request,Model model)  throws IOException{
    		if (!file.isEmpty()) {
                String saveFileName = UUID.randomUUID().toString().replace("-", "").toLowerCase()+".jpg";                
                File saveFile = new File("C:/bk-image/"+saveFileName);
                if (!saveFile.getParentFile().exists()) {
                    saveFile.getParentFile().mkdirs();
                }
                if(Tool.upload(saveFile, file)) {
                	Article.setAimage("bk-image/"+saveFileName);
                	Article.setAdate(new Date());
                	if(bkService.insert(Article)) {
                    	System.out.println("上传成功");
                    	model.addAttribute("info", "ok");
                		return "forward:add-dynamics?pageinfo=text-edit";
                	}

                }else {
                	System.out.println("上传失败,有问题，需要检查");
                }                	
            }	
		return "text-edit";
	}	
	/**
	 * 删除博客
	 * 异步请求
	 */
	@RequestMapping("del-article")
	@ResponseBody
	public String del_article(String aid) {		
		return bkService.delBk(aid)?"ok":"no";
	}
}
