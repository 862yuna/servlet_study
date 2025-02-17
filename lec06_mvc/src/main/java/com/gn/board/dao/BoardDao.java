package com.gn.board.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;



public class BoardDao {
	
	public List<Board> selectBoardList(Connection conn){
		// 게시글 번호(board_no)
		// 게시글 정보(board_title)
		// 게시글 내용(board_contenet)
		//  게시글 작성자(board_writer)
		// 게시글 작성자의 닉네임()
		// 게시글 작성자의 (reg_date)
		// 게시글 수정일(mod_date)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> resultList = new ArrayList<Board>();
		try {
			String sql = "SELECT b.board_no ,b.board_title ,b.board_content ,b.board_writer ,m.member_name ,b.reg_date ,b.mod_date "
					+ "FROM `board` b "
					+ "JOIN `member` m "
					+ "ON b.board_writer = m.member_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardWriter(rs.getInt("board_writer"));
				b.setMemberName(rs.getString("member_name"));
				b.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				b.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				resultList.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return resultList;
		
	}
	
	public int insertBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardNo = 0;
		try {
			String sql = "INSERT INTO `board`(board_title ,board_content ,board_writer) "
					+ "VALUES(?,?,?)";
			// (1) 매개변수 추가
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,b.getBoardTitle());
			pstmt.setString(2,b.getBoardContent());
			pstmt.setInt(3,b.getBoardWriter());
			
			boardNo = pstmt.executeUpdate();
			// (2) 생성된 키 반환
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				boardNo = rs.getInt(1);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardNo;
	}
	
	public int insertAttach(Attach a, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int attachNo = 0;
		try {
			// 1. board_no
			// 2. ori_name
			// 3. new_name
			// 4. attach_path
			String sql = "INSERT INTO `attach`(board_no ,ori_name ,new_name ,attach_path) "
					+ "VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, a.getBoardNo());
			pstmt.setString(2, a.getOriName());
			pstmt.setString(3,a.getNewName());
			pstmt.setString(4, a.getAttachPath());
			
			attachNo = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				attachNo = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		return attachNo;
		
		// attach_no
		
	}
}
