package com.tj.ex3_math;
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		// 9.12 -> 9 10.0 9.0
		System.out.println("9.12�� �ݿø� : "+Math.round(9.12)); // 9 (long)
		System.out.println("9.12�� �ø� : "+Math.ceil(9.12));    // 10.0 (double)
		System.out.println("9.12�� ���� : "+Math.floor(9.12));   // 9.0 (double)
		System.out.println("�Ҽ��� ���ڸ����� �ݿø�, �ø�, ����");
		// 9.56 -> 9.6 9.6 9.5
		System.out.println("9.56�� �Ҽ��� ���ڸ����� �ݿø� : "+Math.round(9.56*10)/10.0); // 9.6
		System.out.println("9.56�� �Ҽ��� ���ڸ����� �ø� : "+Math.ceil(9.56*10)/10);  //9.6
		System.out.println("9.56�� �Ҽ��� ���ڸ����� ���� : "+Math.floor(9.56*10)/10); // 9.5
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		// 19 -> 20 20 10
		System.out.println("19�� ���� �ڸ����� �ݿø� : "+Math.round(19/10.0)*10); // 20
		System.out.println("19�� ���� �ڸ����� �ø� : "+Math.ceil(19/10.0)*10);    // 20
		System.out.println("19�� ���� �ڸ����� ���� : "+Math.floor(19/10.0)*10 );  // 10
	}
}












