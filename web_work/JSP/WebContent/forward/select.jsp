<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="control.jsp" method="post">
		보고싶은 페이지: 
		<select name="page">
			<option value="a.jsp">A 페이지</option>
			<option value="b.jsp">B 페이지</option>
			<option value="c.jsp">C 페이지</option>
		</select>
		<input type="submit" value="이동">
	</form>
</body>
</html>