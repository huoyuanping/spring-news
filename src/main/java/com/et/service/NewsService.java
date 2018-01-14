package com.et.service;

import java.util.List;

import com.et.entity.News;
import com.et.tools.PageTools;

public interface NewsService {
	
	
	/**
	 * �������
	 */
	public void addNews(String title,String content,String createtime);
	/**
	 * ������������ģ������
	 * @param content ��������
	 * @return 
	 */
	public PageTools queryNewsByContent(String content,Integer curPage );
	/**
	 * ɾ������
	 * @param newid
	 */
	public void deleteNews(String newid);	
}
