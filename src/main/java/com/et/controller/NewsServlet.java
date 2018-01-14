package com.et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.et.service.NewsService;
import com.et.tools.PageTools;

public class NewsServlet extends HttpServlet {

	

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//获取容器在取service
		NewsService gs=(NewsService)ac.getBean("newsServiceImpl");
		String content=request.getParameter("content");
		//获取当前页
		String curPage=request.getParameter("curPage");
		
		Integer cur=1;
		if(curPage!=null){
			cur=Integer.parseInt(curPage);
		}
		//获取查询的数据
		PageTools list=gs.queryNewsByContent(content, cur);
		
		//将查询到的数据设进作用域
		request.setAttribute("content", content);
		request.setAttribute("newsList", list);
		//请求转发到jsp
		request.getRequestDispatcher("/news.jsp").forward(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
