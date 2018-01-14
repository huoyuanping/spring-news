package com.et.dao;

import java.util.List;

import com.et.entity.News;
import com.et.tools.PageTools;

public interface NewsDao {
	/**
	 * 查询所有的新闻
	 * @return 返回商品对象
	 */
	public List<News> queryAll();
	
	
	/**
	 * 通过新闻内容模糊查找
	 * @param name
	 * @return
	 */
	public PageTools queryNewsByContent(String content,Integer curPage );
	/**
	 * 添加新闻
	 */
	public void addNews(String title,String content,String createtime);
	/**
	 * 删除新闻
	 * @param newid
	 */
	public void deleteNews(String newid);
	
}
