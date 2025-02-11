package com.gn.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

    public SessionListener() {
    
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("===== 세션 객체 생성 =====");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("===== 세션 사용 불가능 =====");
    }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("===== 세션 속성 추가 =====");
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("===== 세션 속성 제거 =====");
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("===== 세션 속성 대체 =====");
    }
	
    
}
