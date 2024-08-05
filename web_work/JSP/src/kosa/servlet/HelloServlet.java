package kosa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HelloServlet", "/hello"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 서비스 제공 내용(클라이언트 요구)
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // response되서 클라이언트에게 작업
		
		out.println("<html><head><title>hello</title></head>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
