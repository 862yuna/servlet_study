package com.gn.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// @WebListener

public class AppListener implements ServletContextListener {

	public AppListener() {
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("===== 웹 애플리케이션 종료 =====");
		// 요청이 처리되었습니다.
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("===== 웹 애플리케이션 시작 =====");
		// 새로운 요청이 들어왔습니다!
	}
}
