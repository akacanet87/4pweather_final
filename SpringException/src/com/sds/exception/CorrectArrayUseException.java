/*
		
		sun 사와 Spring이 많은 예외 객체들을 지원해 주긴 하지만
		업무별 세부적 예외는 개발자가 직접 정의 하여 사용해야 한다.
		
		
		
*/
package com.sds.exception;

public class CorrectArrayUseException extends ArrayIndexOutOfBoundsException{

	public CorrectArrayUseException( String msg ) {
	
		super(msg);
	
	}
	
}
