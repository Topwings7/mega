package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	private String add;
	private int sum;   // ���Ŵ����ݾ�
	private int point; // ����Ʈ(������ ������ 5%����)
	private String date; // �����
	private boolean vip; // true�� vip��, false�� �Ϲݰ�
	// Customer c = new Customer("ȫ","9999-9999","����","0811");
	public Customer(String name, String tel, String add, String date) {
		// �ݵ�� super���� ������ ȣ���� ù��° ���ο�
		super(name, tel);
		this.add = add;
		this.date = date;
		sum = 0; // ���ο� ���� ���Ŵ����ݾ� 0������
		point = 1000; // ȸ�������� ù���� 1000�� ����Ʈ �ڵ� �ο�
		vip = false;  // ���ο� ���� �Ϲݰ����� �ڵ� �з�		
		System.out.println(name+"�� ���簨�� ������� ����Ʈ 1000���� ������");
	}
	public void buy(int price) { // c.buy(10000);
		sum += price;
		int tempPoint = (int)(price*Constant.RATE);
		point += tempPoint;
		System.out.println(getName()+"�� ���� �ݹ�����Ʈ:"+tempPoint+", ������Ʈ:"+point);
		if(sum>1000000 && vip==false) {
			vip = true; // �����ݾ��� 100���� �ʰ��� vip������ 
		}//if
	}//buy
	@Override
	public String infoString() {//[�̸�]ȫ�浿 [��ȭ]9999-9999 [�ּ�]�������� [����Ʈ]500
		return super.infoString()+" [�ּ�]"+add +"[ ����Ʈ]"+point;
	}
}

















