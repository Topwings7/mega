package com.tj.ex7_person;

public class PersonMain {
	public static void main(String[] args) {
		System.out.println(Person.company_money);
		Person.staticTestMethod();
		Person p1 = new Person("ȫ�浿");
		Person p2 = new Person("�̱浿");
		Person[] p = {p1, p2};
		for(Person pp : p) {
			pp.saveCompany_money(1000); pp.saveMoney(1000);
			pp.currentMoney();
		}
		
	}
}
