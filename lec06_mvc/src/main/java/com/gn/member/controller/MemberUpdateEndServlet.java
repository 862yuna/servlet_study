package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;

@WebServlet(name="memberUpdateEndServlet",urlPatterns="/memberUpdateEnd")
public class MemberUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		String name = request.getParameter("member_name");
		int no = Integer.parseInt(request.getParameter("member_no"));
		
		Member m = new Member();
		m.setMemberId(id);
		m.setMemberPw(pw);
		m.setMemberName(name);
		m.setMemberNo(no);
		
		int result = new MemberService().updateMember(m);
		
		JSONObject o1 = new JSONObject();
		o1.put("res_code", "500");
		o1.put("res_msg", "회원정보 수정중 오류가 발생하였습니다.");
			
		if(result > 0 ) {
			// Session 재설정
			// 1. member_no 정보를 기준으로 단일 회원 정보(Member)조회
			// 2. 새롭게 조회된 Member 정보를 Session에 재설정
			Member mm = new MemberService().selectMember(m);
				HttpSession session = request.getSession();
					session.setAttribute("member", mm);
					session.setMaxInactiveInterval(60*30);
			
			o1.put("res_code", "200");
			o1.put("res_msg", "정상적으로 회원정보 수정되었습니다.");
		}		 
			
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(o1);
		
		
		
//		RequestDispatcher view = request.getRequestDispatcher("/views/member/update.jsp");
//		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
