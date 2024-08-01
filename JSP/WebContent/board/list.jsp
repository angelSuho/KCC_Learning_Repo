<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kosa.model.Search"%>
<%@page import="kosa.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="kosa.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
/* 	Search search = new Search();
	search.setArea(request.getParameterValues("area"));
	search.setSearchKey("%" + request.getParameter("searchKey") + "%"); */
	
	Map map = new HashMap();
	map.put("area", request.getParameterValues("area"));
	map.put("searchKey", "%" + request.getParameter("searchKey") + "%");
	
	 	
	BoardDao2 dao = BoardDao2.getInstance();
	List<Board> list = dao.listBoard(search);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 목록</h3>
	<a href="/board/insert_form.jsp">글 쓰기</a>
	<table border="1" width="800">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				Board board = list.get(i);
		%>
		<tr>
			<td><%=board.getSeq() %></td>
			<td><a href='detail.jsp?seq=<%=board.getSeq() %>'><%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate() %></td>
			<td><%=board.getHitcount() %></td>
			<td>X</td>
		</tr>
		<%
			}
		%>
	</table>
	<br><br>
	
	<form action="list.jsp" method="get">
		<input type="checkbox" name="area", value="title">제목
		<input type="checkbox" name="area", value="writer">작성자
		<input type="text" name="searchKey" size="10">
		<input type="submit" value="검색">
	</form>
	
</body>
</html>