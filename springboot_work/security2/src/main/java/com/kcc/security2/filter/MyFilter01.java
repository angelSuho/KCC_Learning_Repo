package com.kcc.security2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter01 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            System.out.println("필터 01");

            if (request.getMethod().equals("POST")) {
                String headerAuth = request.getHeader("Authorization");
                System.out.println(headerAuth);
                if (headerAuth.equals("kosa")) {
                    filterChain.doFilter(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.print("login fail");
                }
            }
            filterChain.doFilter(request, response);
    }
}
