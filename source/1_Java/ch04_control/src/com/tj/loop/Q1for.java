package com.tj.loop;
//	1~10������ ���� ���غ���
public class Q1for {
	public static void main(String[] args) {
		int result = 1;
		for(int i=1 ; i<=10 ; i++) {
			result *= i; // result = result*i
		}
		System.out.println("1~10������ ���� "+result);
	}
}
