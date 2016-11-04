package com.sds.exception;

public class Test {
	
	public Test() {
	
		try {
			
			test();
		
		} catch (CorrectArrayUseException e) {
			
			e.printStackTrace();
			
			System.out.println("배열의 크기를 수정하거나 값을 제대로 입력해주세요.");
		
		}
	
	}
	
	public void test() throws CorrectArrayUseException{
		
		int[] arr = new int[1];
		
		try {
			
			System.out.println(arr[1]);
			
		} catch ( Exception e ) {
			
			/*System.out.println("배열을 제대로 써라");
			e.getMessage();
			e.printStackTrace();*/
			
			throw new CorrectArrayUseException("배열의 크기가 올바르지 않습니다.");
			
		}
		
	}

	public static void main(String[] args) {
		
		new Test();
		
	}
	
}
