package com.tj.ex1_string;

import java.util.Scanner;

public class Ex08_homework {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;	
		while(true) {
			System.out.print("��ȭ��ȣ(����XXXXXXXX) �Է� (x�� ����)");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) {
				break;
			}
			if(tel.length()<10 || tel.length() > 14 ||  tel.indexOf('-')==tel.lastIndexOf('-')) {
				System.out.println("�Է� ��ȭ��ȣ�� Ÿ���� �� �����ּ���");
				continue;
			}
			System.out.println("�Է��� ��ȭ��ȣ : "+tel);
			System.out.print("¦����° ���ڿ� : ");
			for(int i = 0 ; i < tel.length() ; i+=2) {
				System.out.print(tel.charAt(i)+" ");
			}
			System.out.println();
			System.out.print("���ڸ� �Ųٷ� : ");
			for(int i = tel.length()-1 ; i >= 0;i-- ) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			String preTel = tel.substring(0, tel.indexOf('-'));
			System.out.println("��ȭ��ȣ ���ڸ��� : " + preTel);
			String postTel = tel.substring(tel.lastIndexOf('-')+1);
			System.out.println("��ȭ��ȣ ���ڸ��� : "+ postTel);			
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
