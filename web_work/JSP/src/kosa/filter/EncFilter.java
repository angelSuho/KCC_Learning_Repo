package kosa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 2개 이상의 경로를 필터하고 싶을 때 중괄호 안에 쉼표로 여러 개 작성 가능
@WebFilter({"/board/*", "/session/*"})
public class EncFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("utf-8");
		}
		System.out.println("필터 적용");
		chain.doFilter(request, response);
	}

}
