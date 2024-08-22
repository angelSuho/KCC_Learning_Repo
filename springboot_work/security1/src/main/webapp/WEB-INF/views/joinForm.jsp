<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Title Here</title>
</head>
<body>
    <h1>회원 가입 폼</h1>
    <hr>
    <form action="/join" method="post">
        <label for="username">사용자 이름</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" required>
        <input type="hidden" name="${_csrf.parameterName} value="${_csrf.token}"/>
        <br>
        <button type="submit">회원 가입</button>
    </form>
</body>
</html>
