package kosa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalsServlet
 */
@WebServlet("/CalsServlet")
public class CalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String name = request.getParameter("name");
		
		int result = num1 + num2;
		
		request.setAttribute("result", result);
		request.setAttribute("name", name);
		
		// 페이지 이동
		// 1. Dispatcher: 기존 요청의 연장선(1개의 request)
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
		
		// 2. Redirect: 기존 요청과 다른 새로운 요청으로 이동
//		response.sendRedirect("result.jsp");
	}

}
