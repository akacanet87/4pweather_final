package com.sds.exception;

public class Test {
	
	public Test() {
	
		try {
			
			test();
		
		} catch (CorrectArrayUseException e) {
			
			e.printStackTrace();
			
			System.out.println("�迭�� ũ�⸦ �����ϰų� ���� ����� �Է����ּ���.");
		
		}
	
	}
	
	public void test() throws CorrectArrayUseException{
		
		int[] arr = new int[1];
		
		try {
			
			System.out.println(arr[1]);
			
		} catch ( Exception e ) {
			
			/*System.out.println("�迭�� ����� ���");
			e.getMessage();
			e.printStackTrace();*/
			
			throw new CorrectArrayUseException("�迭�� ũ�Ⱑ �ùٸ��� �ʽ��ϴ�.");
			
		}
		
	}

	public static void main(String[] args) {
		
		new Test();
		
	}
	
}
