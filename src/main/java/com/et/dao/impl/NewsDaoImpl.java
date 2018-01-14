package com.et.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.et.dao.NewsDao;
import com.et.entity.News;
import com.et.tools.PageTools;
@Repository 
public class NewsDaoImpl implements NewsDao {
	

	/**
	 * （在实现类，根据模板类JdbcTemplate连接到数据库）
	 * 自动装配
	 */
	@Autowired
	private JdbcTemplate jdbc;
	/**
	 * 查询所有的方法
	 */
	public List<News> queryAll() {
		String sql="select newid,title,content,createtime from mynews";

		List<News> list=jdbc.query(sql,new BeanPropertyRowMapper<News>(News.class));
		return list;
	}
	
	public PageTools queryNewsByContent(String content, Integer curPage) {
		
		
		Integer totalCount=getPageCount(content);
		PageTools pt=new PageTools(curPage, totalCount, 3);
		//StringBuffer sb=new StringBuffer();
		String sql="select * from mynews where content like '%"+content+"%' limit "+(pt.getStartIndex()-1)+" , "+pt.getPageCount();
		List<News> list=jdbc.query(sql,new BeanPropertyRowMapper<News>(News.class));
		pt.setData(list);
		return pt;
		
	}
	/**
	 * 获取总条数
	 * @param content
	 * @return
	 */
	public Integer getPageCount(String name){
		if(name==null){
			name="";
		}
		String sql="select count(*) as cr from mynews  where 1=1 and content like '%"+name+"%'";
		
		List<Map<String, Object>> result=jdbc.queryForList(sql);
		return Integer.parseInt(result.get(0).get("CR").toString());
	}
	/**
	 * 添加新闻
	 */
	public void addNews(String title, String content, String createtime) {
		String sql="insert into mynews(title,content,createtime) values('"+title+"','"+content+"','"+createtime+"')";
		jdbc.execute(sql);
		
	}
	public void deleteNews(String newid) {
		String sql="delete from mynews where newid="+newid;
		jdbc.execute(sql);
		
	}
	

}
