package com.tj.ex5_pouch;
public class Child {
	//static MomPouch momPouch = new MomPouch();
	private String name;
	public Child(String name) { // main�Լ����� Child first = new Child("ù°�浿��");
		this.name = name;
	}
	public void takeMoney(int money) {
		if(MomPouch.money>=money) {
			MomPouch.money = MomPouch.money - money;
			System.out.println(name+"�� "+money+"�� �޾ư��� ���������� "+MomPouch.money+"�� ����");
		}else {
			System.out.println(name+"�� �� �� ����. ���� ������ ���� ���ڶ�");
		}
	}
}
