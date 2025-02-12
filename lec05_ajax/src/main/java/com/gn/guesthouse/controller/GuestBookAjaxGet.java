package com.gn.guesthouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/guestbookajaxget")
public class GuestBookAjaxGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBookAjaxGet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");						
		String guestMessage = request.getParameter("guestMessage");
//		response.setContentType("text/html; charset=utf-8");
//		response.getWriter().append("<li>"+guestName+" : "+guestMessage+"</li>");
		JSONObject o1 = new JSONObject();
		o1.put("guestName",guestName);
	 	o1.put("guestMessage",guestMessage);	
	 	response.setContentType("application/json; charset=UTF-8");
	 	response.getWriter().print(o1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
