<%@page import="kosa.model.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="kosa.model.Cart"%>
<%@page import="kosa.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String userId = request.getParameter("userId");
	CartDao dao = CartDao.getInstance();
	Cart cart = dao.selectCartByUserId(userId);

	List<CartItem> list = dao.selectCartItems(cart.getCartId());

	double totalAmount = 0.0;
	for (CartItem item : list) {
		totalAmount += item.getQuantity() * item.getProductPrice();
	}

	request.setAttribute("list", list);
	request.setAttribute("totalAmount", totalAmount);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>장바구니 보기</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.container {
	margin-top: 50px;
}

.table th, .table td {
	text-align: center;
}

.btn-secondary {
	margin-top: 20px;
}

.btn-delete {
	margin-top: 20px;
}

.empty-cart {
	text-align: center;
	margin-top: 50px;
}

.empty-cart p {
	font-size: 1.5rem;
	color: #dc3545;
}

.empty-cart .btn-primary {
	margin-top: 20px;
	padding: 10px 20px;
	font-size: 1.2rem;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="my-4">장바구니</h1>
		<c:choose>
			<c:when test="${not empty list }">
				<form action="deleteCartItems.jsp">
					<input type="hidden" name="userId" value="${param.userId }">
					<table class="table table-bordered table-striped">
						<thead class="thead-dark">
							<tr>
								<th></th>
								<th>상품명</th>
								<th>가격</th>
								<th>수량</th>
								<th>총액</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${list}">
								<tr>
									<td><input type="checkbox" name="itemIds"
										value="${item.cartItemId}"></td>
									<td>${item.productName}</td>
									<td><fmt:formatNumber value="${item.productPrice}"
											type="currency" /></td>
									<td>${item.quantity}</td>
									<td><fmt:formatNumber
											value="${item.quantity * item.productPrice }" type="currency" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<button type="submit" class="btn btn-danger btn-delete">선택
						항목 삭제</button>
				</form>
				<br>
				<h3 class="my-4">
					총액:
					<fmt:formatNumber value="${totalAmount }" type="currency" />
				</h3>
				<a href="javascript:history.back()" class="btn btn-secondary">상품
					목록으로 돌아가기</a>
			</c:when>
			<c:otherwise>
				<div class="empty-cart">
					<p>장바구니가 비었습니다.</p>
					<a href="productList.jsp?userId=${param.userId}"
						class="btn btn-primary">상품 목록으로 돌아가기</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
