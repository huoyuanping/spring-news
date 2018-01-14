package com.et.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.et.service.NewsService;


public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteNewsServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//获取容器在取service
		NewsService gs=(NewsService)ac.getBean("newsServiceImpl");
		String newid=request.getParameter("newid");
		gs.deleteNews(newid);
		request.getRequestDispatcher("NewsServlet").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
