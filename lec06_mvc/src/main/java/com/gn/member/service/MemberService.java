package com.gn.member.service;

import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;
public class MemberService {

	// createMember 메소드
	// Member 를 매개변수로 받아서 
	// Connection 객체를 생성
	// MemberDao 에게 Connection 과 Member 전달
	// int 반환


	public int createMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().createMember(conn,m);
		close(conn);
		return result;
	}
	
}
