package com.tj.ex1_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҴ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҴ�");
		}
		if(str1==str3) {
			System.out.println("str1�� str3�� ���� �ּҴ�");
		}else {
			System.out.println("str1�� str3�� �ٸ� �ּҴ�");
		}
		if(str4==str3) {
			System.out.println("str4�� str3�� ���� �ּҴ�");
		}else {
			System.out.println("str4�� str3�� �ٸ� �ּҴ�");
		}
		System.out.println("str1�� str2�� ���� ��Ʈ���̳�?"+str1.equals(str2));
		System.out.println("str1�� str2�� ���� ��Ʈ���̳�?"+str2.equals(str1));
		System.out.println("str1�� str3�� ���� ��Ʈ���̳�?" + str1.equals(str3));
		System.out.println("str1�� hashcode : " + str1.hashCode());
		System.out.println("str2�� hashcode : " + str2.hashCode());
		System.out.println("str3�� hashcode : " + str3.hashCode());
		System.out.println("str4�� hashcode : " + str4.hashCode());
	}
}













