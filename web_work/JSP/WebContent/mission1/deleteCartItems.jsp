<%@page import="kosa.dao.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String userId = request.getParameter("userId");
	String[] itemIds = request.getParameterValues("itemIds");
	if(itemIds != null && itemIds.length > 0) {
		List<Integer> idList = new ArrayList<>();
		for(String id : itemIds) {
			idList.add(Integer.parseInt(id));
		}
		
		CartDao dao = CartDao.getInstance();
		for(Integer id : idList) {
			dao.deleteCartItem(id);
		}
	}
	
	response.sendRedirect("cart.jsp?userId=" + userId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>