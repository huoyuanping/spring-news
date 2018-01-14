package com.et.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.dao.NewsDao;
import com.et.entity.News;
import com.et.service.NewsService;
import com.et.tools.PageTools;
/**
 * ҵ���߼�
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao dao;
	/**
	 * ��ѯ���е�����
	 */
	public PageTools queryNewsByContent(String content, Integer curPage) {
		if(content==null){
			content="";
		}
		return dao.queryNewsByContent(content, curPage);
	}
	
	/**
	 * �������
	 */
	public void addNews(String title, String content, String createtime) {
		 dao.addNews(title, content, createtime);
		
	}

	public void deleteNews(String newid) {
		dao.deleteNews(newid);
		
	}




}
