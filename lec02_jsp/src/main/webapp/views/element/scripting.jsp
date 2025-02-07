<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅 요소 연습</title>
</head>
<body>
	<%-- Scriptlet : 일반적인 자바 코드 --%>
	<% 
		int sum = 0;
		for(int i = 0; i <= 10 ; i++){
			sum += i;
		}
		// System.out.println(sum);
		out.println("총합 : "+sum);
	%>
	<br>
	<%-- Expression : (화면에)출력 --%>
	<%= "총합(2) :"+sum %>
	<%-- Declaration : 선언 --%>
	<%! int visitCount = 0; %>
	<%! 
		public int sumNum(int a, int b){
			return a + b;
	}
	%>
	<% visitCount++; %>
	<br>
	<%= "조회수 : "+visitCount %>
	<br>
	<%= "더하기 : "+sumNum(3,4) %>
</body>
</html>