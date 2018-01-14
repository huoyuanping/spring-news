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
		//��ȡ������ȡservice
		NewsService gs=(NewsService)ac.getBean("newsServiceImpl");
		String content=request.getParameter("content");
		//��ȡ��ǰҳ
		String curPage=request.getParameter("curPage");
		
		Integer cur=1;
		if(curPage!=null){
			cur=Integer.parseInt(curPage);
		}
		//��ȡ��ѯ������
		PageTools list=gs.queryNewsByContent(content, cur);
		
		//����ѯ�����������������
		request.setAttribute("content", content);
		request.setAttribute("newsList", list);
		//����ת����jsp
		request.getRequestDispatcher("/news.jsp").forward(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
