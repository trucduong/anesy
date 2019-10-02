//package com.green.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.green.config.AuthContext;
//
//@WebFilter(urlPatterns = { 
//		"/cart", 
//		"/cart/add", 
//		"/admin",
//		"/profile/info",
//		"/profile/password",
//		"/profile/history",
//		"/profile/certificate",
//		"/profile/mycourse",
//		
//})
//public class LoginFilter implements Filter{
//	@Autowired
//	private AuthContext authContext;
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		HttpServletRequest htttpRequest = (HttpServletRequest) request;
//		if(authContext == null) {
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
//			httpResponse.sendRedirect(htttpRequest.getContextPath()+"/login");
//			return;
//		}
//		chain.doFilter(request, response);
//	}
//
//
//}
