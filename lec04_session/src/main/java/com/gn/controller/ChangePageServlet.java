package com.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePageServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  화면 전환
		//	RequestDispatcher view
							//	= request.getRequestDispatcher("/views/countPage.jsp"); // 직접 url을 맞춰야함
							//	= getServletContext().getRequestDispatcher("/views/countPage.jsp"); // 절대 경로로 접근	
		//	view.forward(request, response);
		response.sendRedirect("/views/countPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
