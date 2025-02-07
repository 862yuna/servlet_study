<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("name");
	String userPhone = (String)request.getAttribute("phone");
	String userEmail = (String)request.getAttribute("email");
	int book = Integer.parseInt((String)request.getAttribute("book"));
	int borrowDay = (int)request.getAttribute("borrowDay");
	int price = (int)request.getAttribute("price");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출 내역</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명:<%=userName %></li>
		<li>전화번호:<%=userPhone %></li>
		<li>이메일:<%=userEmail %></li>
	</ul>
	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목:
			<%
				switch(book){
					case 1 : out.println("자바 프로그래밍 입문");break;
					case 2 : out.println("웹 개발의 기초");break;
					case 3 : out.println("데이터베이스 시스템");break;
				}
			%>
		</li>
		<li>대출 기간:<%=borrowDay %>일</li>
	</ul>
	<h3>대출 금액:<%=price %>원</h3>
	<h4>도서를 즐겁게 읽으세요!</h4>
</body>
</html>