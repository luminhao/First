package com.bk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bk.dao.BkMapper;
import com.bk.dao.DynamicMapper;
import com.bk.entity.article;
import com.bk.entity.dynamic;
import com.bk.entity.type;

@Controller
public class BkService {
	@Autowired
	BkMapper bkMapper;

	public List<article> AllArticle(){
		return bkMapper.AllArticle();
	}
	public article byArticleId(int id) {
		return bkMapper.byArticleId( id);
	}
	public List<article> byArticleTitle(String title){
		return bkMapper.byArticleTitle(title,null,null);
	}
	public List<article> byArticlefenlei(String tid){
		return bkMapper.byArticleTitle(null,tid,null);
	}
	public List<article> byArticleuid(String uid){
		return bkMapper.byArticleTitle(null,null,uid);
	}
	public List<type> selectFenlei(){
		return bkMapper.selectFenlei();
	}
	public boolean insert(article article) {
		return bkMapper.insert(article)>0?true:false;
	}
	public boolean delBk(String aid) {
		return bkMapper.del_article(aid)>0?true:false;
	}
}
