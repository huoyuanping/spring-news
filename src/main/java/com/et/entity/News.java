package com.et.entity;

import java.sql.Date;

public class News {
	private String newid;//新闻编号
	private String title;//新闻标题
	private String content;//新闻内容
	private Date  createtime;//创建时间
	public News(){
		
	}
	public News(String newid, String title, String content, Date createtime) {
		super();
		this.newid = newid;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
	}
	public String getNewid() {
		return newid;
	}
	public void setNewid(String newid) {
		this.newid = newid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
	
}
