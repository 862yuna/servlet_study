package com.gn.board.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;


public class BoardService {
	
	public Board selectBoardOne(int boardNo) {
		Connection conn = getConnection();
		Board board = new BoardDao().selectBoardOne(conn,boardNo);
		close(conn);
		return board;
	}
	
	public int selectBoardCount(Board option) {
		Connection conn = getConnection();
		int result = new BoardDao().selectBoardCount(conn,option);
		close(conn);
		return result;
	}
	
	public List<Board> selectBoardList(Board option){
		Connection conn = getConnection();
		List<Board> resultList = new ArrayList<Board>();
		resultList = new BoardDao().selectBoardList(conn,option);
		return resultList;
	}
	
	public int createBoard(Board b,Attach a) {
		 Connection conn = getConnection();
		 int result = 0;
		 try {
			 conn.setAutoCommit(false);
			 int boardNo = new BoardDao().insertBoard(b,conn);
			 a.setBoardNo(boardNo);
			 int attachNo = new BoardDao().insertAttach(a,conn);
			 if(boardNo != 0 && attachNo != 0) {
				 result = 1;
				 commit(conn);
			 }else {
				 rollback(conn);
			 }
		 }catch(Exception e) {
			 rollback(conn);
			 e.printStackTrace();
		 }
		 
		 
		 close(conn);
		 return result;
	}
	
}
