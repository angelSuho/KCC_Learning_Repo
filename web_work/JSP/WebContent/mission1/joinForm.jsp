<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
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
        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            margin-bottom: 30px;
            color: #343a40;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-submit {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h1 class="text-center">회원가입</h1>
            <form action="joinProc.jsp" method="post">
                <div class="form-group">
                    <label for="userId">아이디:</label>
                    <input type="text" class="form-control" id="userId" name="userId" required>
                </div>
                <div class="form-group">
                    <label for="password">비밀번호:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="name">이름:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="age">나이:</label>
                    <input type="number" class="form-control" id="age" name="age" required>
                </div>
                <div class="form-group">
                    <label for="address">주소:</label>
                    <input type="text" class="form-control" id="address" name="address" required>
                </div>
                <div class="form-group">
                    <label for="phone">전화번호:</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>
                <button type="submit" class="btn btn-primary btn-submit">가입</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
