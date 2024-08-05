<%@page import="kosa.model.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="kosa.model.Member"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>