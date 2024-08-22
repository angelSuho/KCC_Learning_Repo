<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Title Here</title>
</head>
<body>
    <h1>로그인 폼 페이지</h1>
    <hr>
    <form action="/login" method="post">
        <label for="username">사용자 이름</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="hidden" name="${_csrf.parameterName} value="${_csrf.token}"/>
        <button type="submit">로그인</button>
    </form>
    <a href="/joinForm">회원 가입</a>
</body>
</html>
