package com.tj.ex10_customer;

public class Staff extends Person {
	private String hiredate;   // �Ի���(2020-05-01) �����ֺ��ʹ� Date��
	private String department; //  �μ�
	// Staff s = new Staff("ȫ�浿","9999-9999","2020-05-01","�����");
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println("�Ի� ��������");
	}
	// sysout(s.infoString()) -> [�̸�]ȫ�浿 [��ȭ]9999-9999 [�μ�]�����
	@Override
	public String infoString() { 
		return super.infoString()+" [�μ�]"+department;
	}
}
