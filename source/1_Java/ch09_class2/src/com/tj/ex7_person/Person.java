package com.tj.ex7_person;

public class Person {
	private String name;
	private int money;
	public static int company_money;
	public Person(String name) { // Person p = new Person("ȫ�浿");
		this.name = name; 
	}
	public void currentMoney() {
		System.out.print(name+"�� �����ڻ� : "+money+"\t");
		System.out.println(name+"�� ȸ����� : "+company_money);
	}
	public void saveMoney(int money) {
		this.money += money;
	}
	public void saveCompany_money(int money) {
		company_money += money;
	}
	public static void staticTestMethod() {
		System.out.println("static �޼ҵ� test");
	}
}












