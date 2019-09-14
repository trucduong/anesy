package com.green.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BaseTag extends SimpleTagSupport {

	public HttpSession getSession() {
		PageContext pageContext = (PageContext) getJspContext();  
		return pageContext.getSession();
	}
	
	public HttpServletRequest getRequest() {
		PageContext pageContext = (PageContext) getJspContext();  
		return (HttpServletRequest) pageContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		PageContext pageContext = (PageContext) getJspContext();  
		return (HttpServletResponse) pageContext.getResponse();
	}
}
