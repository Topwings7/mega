package com.tj.ex2_swing;

public class Person {
	private String name;
	private String phone;
	private int age;
	public Person() { }
	public Person(String name, String phone, int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	@Override
	public String toString() {
		return "[�̸�]" + name + " [��ȭ]" + phone + " [����]" + age + "\r\n";
	}
}
