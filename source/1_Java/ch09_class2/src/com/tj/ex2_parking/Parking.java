package com.tj.ex2_parking;

import com.tj.cons.PiClass;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	//private static final int HOURLYPARKINGRATE = 2000; // final ���� = ���
	// Parking car1 = new Parking("11��1111",12);
	public Parking(String no, int inTime) {
		this.no = no; this.inTime = inTime;
		System.out.println(no+"�� �������");
		System.out.println("�����ð� : "+inTime+"��");
	}
	// car1.out(14);
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime) * PiClass.HOURLYPARKINGRATE;
		System.out.println(no+"�� �ȳ��� ������");
		System.out.println("�����ð� : "+ inTime +"��");
		System.out.println("�����ð� : "+ outTime +"��");
		System.out.println("������� : "+fee+"��");
	}
}










