<%@page import="kosa.model.Member"%>
<%@page import="kosa.dao.MemberDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userId");
	String password = request.getParameter("password");

	MemberDao dao = MemberDao.getInstance();
	Member member = dao.loginMember(userId);

	boolean loginSuccess = (member != null && member.getPassword().equals(password));

	request.setAttribute("loginSuccess", loginSuccess);
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 결과</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .alert-custom {
            border-radius: 0.25rem;
            padding: 20px;
        }
        .alert-success {
            background-color: #d4edda;
            color: #155724;
            border-color: #c3e6cb;
        }
        .alert-danger {
            background-color: #f8d7da;
            color: #721c24;
            border-color: #f5c6cb;
        }
    </style>
</head>
<body>
    <div class="container">
        <c:if test="${loginSuccess}">
            <div class="alert alert-success alert-custom" role="alert">
                <h4 class="alert-heading">환영합니다, ${member.name}님!</h4>
                <p>로그인에 성공하였습니다.</p>
                <hr>
                <p class="mb-0">
                    <a href="productList.jsp?userId=${member.userId}" class="btn btn-primary">상품 보기</a>
                </p>
            </div>
        </c:if>
        <c:if test="${!loginSuccess}">
            <div class="alert alert-danger alert-custom" role="alert">
                <h4 class="alert-heading">로그인 실패</h4>
                <p>아이디 또는 비밀번호가 일치하지 않습니다.</p>
                <hr>
                <p class="mb-0">
                    <a href="loginForm.jsp" class="btn btn-secondary">재로그인</a>
                    <a href="joinForm.jsp" class="btn btn-info">회원가입</a>
                </p>
            </div>
        </c:if>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
