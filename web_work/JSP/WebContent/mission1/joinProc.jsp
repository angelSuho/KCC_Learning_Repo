<%@page import="kosa.dao.MemberDao"%>
<%@page import="kosa.model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="kosa.model.Member"></jsp:useBean>
<jsp:setProperty property="*" name="member" />
<%
	MemberDao dao = MemberDao.getInstance();
	int re = dao.insertMember(member);

	request.setAttribute("re", re);
	request.setAttribute("member", member);
%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 결과</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            max-width: 600px;
        }
        .result-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .result-container h1 {
            margin-bottom: 20px;
            color: #343a40;
        }
        .btn-back {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="result-container text-center">
            <c:choose>
                <c:when test="${re == 1 }">
                    <h1 class="text-success">회원가입 완료</h1>
                    <p class="lead">${member.name}님, 환영합니다!</p>
                    <a href="loginForm.jsp" class="btn btn-primary btn-back">로그인 페이지로 가기</a>
                </c:when>
                <c:otherwise>
                    <h1 class="text-danger">회원가입 실패</h1>
                    <p class="lead">다시 시도해 주세요.</p>
                    <a href="joinForm.jsp" class="btn btn-danger btn-back">회원가입 다시 하기</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>