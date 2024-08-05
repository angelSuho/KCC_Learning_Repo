<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String sess = (String) session.getAttribute("name");
	
	if (sess == null) {
		response.sendRedirect("loginForm.jsp");
	}
	
	session.invalidate();
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>