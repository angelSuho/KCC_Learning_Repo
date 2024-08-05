<%@page import="kosa.model.CartItem"%>
<%@page import="kosa.model.Cart"%>
<%@page import="kosa.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userId");

	int productId = Integer.parseInt(request.getParameter("productId"));
	String productName = request.getParameter("productName");
	int productPrice = Integer.parseInt(request.getParameter("productPrice"));
	int quantity = Integer.parseInt(request.getParameter("quantity"));

	CartDao dao = CartDao.getInstance();
	Cart cart = dao.selectCartByUserId(userId);

	if (cart == null) {
		cart = new Cart(0, userId);
		int re = dao.insertCart(cart);
		if (re <= 0) {
			throw new RuntimeException("카트 생성 실패");
		}
		cart = dao.selectCartByUserId(userId);
	}

	// 중복으로 담은 상품이 있는지 확인
	CartItem existingItem = dao.selectCartItemByCartIdAndProductId(cart.getCartId(), productId);
	System.out.println("existingItem: " + existingItem);
	if(existingItem != null) {
		int newQuantity = existingItem.getQuantity() + quantity;
		dao.updateCartItemQuantity(existingItem.getCartItemId(), newQuantity);
	} else {
		CartItem cartItem = new CartItem(0, cart.getCartId(), productId, productName, productPrice, quantity);
		dao.insertCartItem(cartItem);
	}

	response.sendRedirect("productList.jsp?userId=" + userId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>

</body>
</html>