package com.tj.ex1_string;

public class Ex11_speedcheck {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());// 1970.01.01.0�ú��� ������ �и�����
		String str = "A";
		long startTime = System.currentTimeMillis(); // ���۽����� 1970.1.1���� �̶������� �и�����
		for(int i=0 ; i<50000 ; i++) {
			str = str + "a";
		}
		long endTime = System.currentTimeMillis(); // ������ ����
		System.out.println("String 5���� ���� ��� �ð� : "+(endTime-startTime));
		
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis(); // ���۽���
		for(int i=0 ; i<50000 ; i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();// ������ ����
		System.out.println("StringBuffer 5���� ���� ����ð� : "+(endTime-startTime));
		
		StringBuilder strBui = new StringBuilder("A");
		startTime = System.currentTimeMillis(); // ���۽���
		for(int i=0 ; i<50000 ; i++) {
			strBui.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 5���� ���� ����ð� : "+(endTime-startTime));
	}
}













