package com.sds.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{


	@Override
	public void contextInitialized(ServletContextEvent e) {
		
		//	babo��� �̸��� xml�� �����ͺ���
		String path = e.getServletContext().getInitParameter("babo");
		
		System.out.println("���񽺿� xml ������ "+path);

	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		
		
		
	}
	
}
