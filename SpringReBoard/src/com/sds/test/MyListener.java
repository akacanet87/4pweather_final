package com.sds.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{


	@Override
	public void contextInitialized(ServletContextEvent e) {
		
		//	babo라는 이름의 xml을 가져와보기
		String path = e.getServletContext().getInitParameter("babo");
		
		System.out.println("서비스용 xml 파일은 "+path);

	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		
		
		
	}
	
}
