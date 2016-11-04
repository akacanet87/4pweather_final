package com.sds.common.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.sds.domain.Board;

public class ControllerLog {
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	public Object printMsg(ProceedingJoinPoint joinPoint) {
	
		Object obj = null;
		
		//	프록시가 요청을 낚아 챈 상태이므로 핵심 비즈니스 로직을 호출해 줘야 한다.
		Object target =  joinPoint.getTarget();
		String className = target.getClass().getName();
		String methodName = joinPoint.getSignature().getName();

		//	어떤 메서드의 매개 변수인지는 알 수 없다.
		Object[] args = joinPoint.getArgs();
		
		try {
			
			logger.debug(className+"의"+methodName+"이 호출 전 ");
			obj = joinPoint.proceed();
		
		} catch (Throwable e) {
			
			e.printStackTrace();
		
		}
		
		logger.debug(className+"의"+methodName+"이 호출 후 ");
		
		return obj;
		
	}

}
