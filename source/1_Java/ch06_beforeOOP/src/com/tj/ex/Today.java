package com.tj.ex;

import java.util.Scanner;

/* ������ ���� : ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
(��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. 
����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)
   Today.java������ ÷���Ͽ� yisy0703@naver.com�� ���Ϸ� �����մϴ�(6:20)
 */
public class Today {
	public static void main(String[] args) {
		// ����ڷ� ���� 2~9������ ���ϴ� �������� �޴´�.
		Scanner sc = new Scanner(System.in);
		int dansu;
		do {
			System.out.print("����� ���ϴ� ������ ���� ?(2~9�ܱ����� ��)");
			dansu = sc.nextInt();
		}while(dansu < 2 || dansu>9);
		guguPrint(dansu);// ����ڷκ��� ���� ���� �������� ���
	}
	private static void guguPrint(int dansu) {// ����ڷκ��� ���� ���� �������� ���
		for(int i=1 ; i<10 ; i++) {
			System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
		}
	}
}
