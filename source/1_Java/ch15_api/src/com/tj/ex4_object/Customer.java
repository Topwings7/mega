package com.tj.ex4_object;

public class Customer {
	private String phone;//010-9999-9999
	private String name;
	private int point;
	private int sum;
	private String birth; // 01-01
	private boolean vip;  // false:�Ϲݰ�  true:vip��
	// Customer c = new Customer("010-9999-9999","ȫ","01-01");
	public Customer(String phone, String name, String birth) {
		this.phone = phone;
		this.name = name;
		this.birth = birth;
		point = 1000;
		sum = 0;
		vip = false;
		System.out.println(name+"ȸ���� ���� ����帳�ϴ�. ����Ʈ �� 1000 ���� �����");
	}
	// sysout(c) -> ȫ�浿(010-9999-9999) ���� ����Ʈ : 1000�� �����ݾ� : 0
	@Override
	public String toString() {
		return name+"("+phone+") ���� ����Ʈ : "+point+"�� �����ݾ� : "+sum;
	}
}
