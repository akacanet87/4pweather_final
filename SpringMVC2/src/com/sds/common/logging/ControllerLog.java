package com.sds.common.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.sds.domain.Board;

public class ControllerLog {
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	public Object printMsg(ProceedingJoinPoint joinPoint) {
	
		Object obj = null;
		
		//	���Ͻð� ��û�� ���� æ �����̹Ƿ� �ٽ� ����Ͻ� ������ ȣ���� ��� �Ѵ�.
		Object target =  joinPoint.getTarget();
		String className = target.getClass().getName();
		String methodName = joinPoint.getSignature().getName();

		//	� �޼����� �Ű� ���������� �� �� ����.
		Object[] args = joinPoint.getArgs();
		
		try {
			
			logger.debug(className+"��"+methodName+"�� ȣ�� �� ");
			obj = joinPoint.proceed();
		
		} catch (Throwable e) {
			
			e.printStackTrace();
		
		}
		
		logger.debug(className+"��"+methodName+"�� ȣ�� �� ");
		
		return obj;
		
	}

}
