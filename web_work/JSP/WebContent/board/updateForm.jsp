<%@page import="kosa.model.Board"%>
<%@page import="kosa.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	BoardDao2 dao = BoardDao2.getInstance();
	Board board = dao.detailBoard(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 수정하기</h3>
	<hr>
	<form action="updateAction.jsp" method="post">
		<input type="hidden" name="seq" value="<%=board.getSeq() %>">
		제목: <input type="text" name="title" value="<%=board.getTitle() %>"> <br>
		내용: <br>
		<textarea rows="6" cols="70" name="contents"><%=board.getContents() %></textarea>
		<br>
		<input type="submit" value="수정 완료">
	</form>
</body>
</html>