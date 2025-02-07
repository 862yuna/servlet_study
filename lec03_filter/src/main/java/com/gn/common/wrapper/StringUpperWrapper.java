package com.gn.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class StringUpperWrapper extends HttpServletRequestWrapper{

	public StringUpperWrapper(HttpServletRequest request) {
		super(request);
	}


	@Override
	public String getParameter(String name) {
//		name = name.toUpperCase();
		
		return super.getParameter(name).toUpperCase();
	}
	
	

}
