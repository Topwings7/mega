package com.tj.ex4_object;

public class Ex03_equals {
	public static void main(String[] args) {
		Person p1 = new Person(9001111055955L);
		Person p2 = new Person(9001111055955L);
		if(p1.equals(p2)) {
			System.out.println("���� ���");
		}else {
			System.out.println("�ٸ� ���");
		}
	}
}
