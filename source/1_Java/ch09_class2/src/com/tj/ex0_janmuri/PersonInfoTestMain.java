package com.tj.ex0_janmuri;
class PersonInfo {
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
public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("ȫ�浿", 20, 'm'),
							   new PersonInfo("ȫ���",19,'f')
		};
		for(PersonInfo p : person) {
			p.print();
		}
	}
}
