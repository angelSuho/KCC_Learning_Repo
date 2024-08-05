<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userId = request.getParameter("userId");
    request.setAttribute("userId", userId);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .card {
            margin-bottom: 20px;
        }
        .card-title {
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="my-4">상품 목록</h1>
        <div class="row">
            <!-- 상품 1 -->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">새우깡</h5>
                        <p class="card-text">가격: 1000원</p>
                        <form action="addCart.jsp" method="post">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="productId" value="1">
                            <input type="hidden" name="productName" value="새우깡">
                            <input type="hidden" name="productPrice" value="1000">
                            <div class="form-group">
                                <label for="quantity1">수량:</label>
                                <input type="number" id="quantity1" name="quantity" class="form-control" value="1" min="1">
                            </div>
                            <button type="submit" class="btn btn-primary">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 상품 2 -->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">홈런볼</h5>
                        <p class="card-text">가격: 2000원</p>
                        <form action="addCart.jsp" method="post">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="productId" value="2">
                            <input type="hidden" name="productName" value="홈런볼">
                            <input type="hidden" name="productPrice" value="2000">
                            <div class="form-group">
                                <label for="quantity2">수량:</label>
                                <input type="number" id="quantity2" name="quantity" class="form-control" value="1" min="1">
                            </div>
                            <button type="submit" class="btn btn-primary">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 상품 3 -->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">꿀꽈배기</h5>
                        <p class="card-text">가격: 1500원</p>
                        <form action="addCart.jsp" method="post">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="productId" value="3">
                            <input type="hidden" name="productName" value="꿀꽈배기">
                            <input type="hidden" name="productPrice" value="1500">
                            <div class="form-group">
                                <label for="quantity3">수량:</label>
                                <input type="number" id="quantity3" name="quantity" class="form-control" value="1" min="1">
                            </div>
                            <button type="submit" class="btn btn-primary">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 상품 4 -->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">바나나킥</h5>
                        <p class="card-text">가격: 2500원</p>
                        <form action="addCart.jsp" method="post">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="productId" value="4">
                            <input type="hidden" name="productName" value="바나나킥">
                            <input type="hidden" name="productPrice" value="2500">
                            <div class="form-group">
                                <label for="quantity4">수량:</label>
                                <input type="number" id="quantity4" name="quantity" class="form-control" value="1" min="1">
                            </div>
                            <button type="submit" class="btn btn-primary">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 상품 5 -->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">칸쵸</h5>
                        <p class="card-text">가격: 800원</p>
                        <form action="addCart.jsp" method="post">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="productId" value="5">
                            <input type="hidden" name="productName" value="칸쵸">
                            <input type="hidden" name="productPrice" value="800">
                            <div class="form-group">
                                <label for="quantity5">수량:</label>
                                <input type="number" id="quantity5" name="quantity" class="form-control" value="1" min="1">
                            </div>
                            <button type="submit" class="btn btn-primary">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 상품 6 -->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">양파링</h5>
                        <p class="card-text">가격: 1200원</p>
                        <form action="addCart.jsp" method="post">
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="productId" value="6">
                            <input type="hidden" name="productName" value="양파링">
                            <input type="hidden" name="productPrice" value="1200">
                            <div class="form-group">
                                <label for="quantity6">수량:</label>
                                <input type="number" id="quantity6" name="quantity" class="form-control" value="1" min="1">
                            </div>
                            <button type="submit" class="btn btn-primary">장바구니에 추가</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <a href="cart.jsp?userId=${userId}" class="btn btn-secondary mt-4">장바구니 확인</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
