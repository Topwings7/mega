package com.tj.studentmng;
// (�������)�й�,�̸�,����,�а� (�޼ҵ�)modify(fn, �ٲܵ�����) infoString() print()
public class Student {
	private int no;		// �й��� 201901 ��Ÿ�Ϸ�
	private String name;
	private int age;
	private String major; // ��ǻ�Ͱ���
	public Student() { } // ����Ʈ ������
	public Student(int no, String name, int age, String major) {
		this.no = no;						// Student s = new Student(201901,"ȫ�浿",20,"�濵");
		this.name = name;
		this.age = age;
		this.major = major;
	}
	public void modify(int fn, String data) { // s.modify(3, "23")
		switch(fn) {
		case 1: no = Integer.parseInt(data); break;
		case 2: name = data; break;
		case 3: age = Integer.parseInt(data);break;
		case 4: major = data;break;
		default:
			System.out.println("��ȿ�� fn��ȣ�� �ƴմϴ�.");
		}//switch
	}//modify
	// System.out.println(s.infoString()) [�й�]201901 [�̸�]ȫ�浿 [����]23 [����]���
	public String infoString() {
		return "[�й�]"+no+" [�̸�]"+name+" [����]"+age+" [����]"+major;
	}
	public void print() {
		System.out.println("[�й�]"+no+" [�̸�]"+name+" [����]"+age+" [����]"+major);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}//class














