<%@page import="kosa.dao.BoardDao2"%>
<%@page import="kosa.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- 특정한 자바빈 파일을 사용한다고 명시할 때 사용: Board 객체 받아오기 -->
<!-- Board board = new Board() -->
<jsp:useBean id="board" class="kosa.model.Board" />
<!-- 데이터의 값을 설정할 때 사용 -->
<!-- name은 useBean의 id와 같아야 함 -->
<!-- Board와 form의 name, 변수 이름들이 동일해야 *로 모두 불러올 수 있음 -->
<!-- board.setTitle(request.getParameter("title")) -->
<jsp:setProperty property="*" name="board"/>
<%
	BoardDao2 dao = BoardDao2.getInstance();
	int re = dao.updateBoard(board);
	
	if(re > 0) {
		response.sendRedirect("/board/list.jsp");
	} else {
		out.println("실패");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>