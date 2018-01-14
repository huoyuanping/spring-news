package com.et.dao;

import java.util.List;

import com.et.entity.News;
import com.et.tools.PageTools;

public interface NewsDao {
	/**
	 * ��ѯ���е�����
	 * @return ������Ʒ����
	 */
	public List<News> queryAll();
	
	
	/**
	 * ͨ����������ģ������
	 * @param name
	 * @return
	 */
	public PageTools queryNewsByContent(String content,Integer curPage );
	/**
	 * �������
	 */
	public void addNews(String title,String content,String createtime);
	/**
	 * ɾ������
	 * @param newid
	 */
	public void deleteNews(String newid);
	
}
