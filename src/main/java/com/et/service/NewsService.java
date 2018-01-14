package com.et.service;

import java.util.List;

import com.et.entity.News;
import com.et.tools.PageTools;

public interface NewsService {
	
	
	/**
	 * 添加新闻
	 */
	public void addNews(String title,String content,String createtime);
	/**
	 * 根据新闻内容模糊查找
	 * @param content 新闻内容
	 * @return 
	 */
	public PageTools queryNewsByContent(String content,Integer curPage );
	/**
	 * 删除新闻
	 * @param newid
	 */
	public void deleteNews(String newid);	
}
