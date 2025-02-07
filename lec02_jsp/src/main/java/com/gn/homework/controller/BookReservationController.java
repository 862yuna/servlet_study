package com.gn.homework.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/borrow")
public class BookReservationController extends HttpServlet{


	private static final long serialVersionUID = 1L;

	public BookReservationController() {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("user_name");
		String userPhone = req.getParameter("user_phone");
		String userEmail = req.getParameter("user_email");
		String book = req.getParameter("book");
		int borrowDay = Integer.parseInt(req.getParameter("borrowDay"));
		
		int price = 0;
		
		switch(book) {
			case "1" : price = 1500;break;
			case "2" : price = 1800;break;
			case "3" : price = 2000;break;
		}
		
		if(borrowDay>1) {
			price = price + 500*(borrowDay-1);
		}
		
		RequestDispatcher view = req.getRequestDispatcher("views/bookConfirmation.jsp");
		req.setAttribute("name",userName);
		req.setAttribute("phone",userPhone);
		req.setAttribute("email",userEmail);
		req.setAttribute("book",book);
		req.setAttribute("borrowDay",borrowDay);
		req.setAttribute("price",price);
		view.forward(req, resp);
		
		System.out.printf("이름 : %s\n전화번호 : %s\n이메일 : %s\n도서명 :%s\n대출 기간 : %s\n대출 금액 :%s"
				, userName,userPhone,userEmail,book,borrowDay,price);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


	
}
