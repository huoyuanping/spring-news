package com.et.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.et.entity.News;
import com.et.service.NewsService;


public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddNewsServlet() {
        super();
       
    }

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//获取容器在取service
		NewsService gs=(NewsService)ac.getBean("newsServiceImpl");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Date date=new Date();
		String createtime=sdf.format(date);
		gs.addNews(title, content, createtime);
	
		request.getRequestDispatcher("NewsServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
