package com.tj.ex7_personinfo;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	public PersonInfo() { }
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {//�̸� = ȫ�浿	 ���� = 20	���� = m 
		System.out.println("�̸� = "+name+"\t���� = "+age+"\t����"+gender);
	}
}
