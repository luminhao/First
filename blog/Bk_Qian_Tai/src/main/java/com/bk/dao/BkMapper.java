package com.bk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bk.entity.article;
import com.bk.entity.type;

public interface BkMapper extends BaseMapper<article>{
	//查询所有博客
	List<article> AllArticle();
	//查询单个博客
	article byArticleId(int id);
	//搜索博客
	List<article> byArticleTitle(@Param("title") String title,@Param("tid")String tid,@Param("uid") String uid);
	/**
	 * 查询所有分类
	 * @return
	 */
	List<type> selectFenlei();
	/**
	 * 删除博客，连同评论
	 * @return
	 */
	int del_article(String aid);
}
