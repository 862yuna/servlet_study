<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회수 확인</title>
</head>
<body>
	<%
		// 조회수를 담을 변수
		int visitCount = 0;
		// 쿠키 가져오기 -> 쿠키 존재 여부
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			// 해당 페이지 접근 이력이 O
			for(Cookie c : cookies){
				if("visit_count".equals(c.getName())){
					visitCount = Integer.parseInt(c.getValue());
				}
			}
		}
		// 조회수 증가
		visitCount++;
		
		// 쿠키 생성 및 갱신
		Cookie visitCookie = new Cookie("visitCount",String.valueOf(visitCount));
		visitCookie.setMaxAge(60*60*24);
		response.addCookie(visitCookie);
		
		
		//String cnt = String.valueOf(visitCount++);
		//Cookie c = new Cookie("visit_count","visitCount");
		//c.setMaxAge(60*60*24);
		//response.addCookie(c);
	%>
	<p>
	당신은 이 페이지를 
	<strong><%=visitCount%></strong>번 방문했습니다.
	</p>
	
</body>
</html>