/*
		
		공통 관심 사항인 로거 기능을 클래스로 정의해 놓고 AOP를 이용하여
		필요한 시점에 실행시키기
		
*/
package com.sds.common.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyLogger {
	
	Logger logger;
	
	public MyLogger() {
	
		logger = LogManager.getLogger(this.getClass().getName());
	
	}
	
	public Object printMsg(ProceedingJoinPoint joinPoint){
		
		Object obj = null;
		
		//	타겟의 본래 로직 수행전에 하고 싶은 코드 작성
		
		Object target = joinPoint.getTarget();
		String className = target.getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//	타겟의 본래 로직 수행
		try {
			
			logger.debug(className+"."+methodName+"수행 전");
			obj=joinPoint.proceed();
	
		} catch (Throwable e) {
			
			e.printStackTrace();
		
		} finally {
			
			logger.debug(className+"."+methodName+"수행 후");
			
		}
		

		//	타겟의 본래 로직 수행후에 하고 싶은 코드 작성
		return obj;
		
	}

}
