package com.tj.ex4_man;

public class ManMain {
	public static void main(String[] args) {
		Man kang = new Man(179, 61);
		// kang : ��ü���� = ���۷������� = ��ü
		Man kim = new Man();
		kim.setHeight(185);
		kim.setWeight(75);
		Man lee = new Man(185, 75);
		if (lee.equals(kim)) {
			System.out.println("1.kim ��ü������ lee ��ü������ ����");
		} else {
			System.out.println("1.kim ��ü�� lee ��ü�� �ٸ� ��ü��");
		}
		lee = kim;
		if (lee.equals(kim)) {
			System.out.println("2.kim ��ü������ lee ��ü������ ����");
		} else {
			System.out.println("2.kim ��ü�� lee ��ü�� �ٸ� ��ü��");
		}
		double biman = kang.calculateBMI();
		if (biman > 24) {
			System.out.println("kang�� ���̴� ���̾�Ʈ �ϼ���");
		}else {
			System.out.println("kang�� �ǰ��Ͻó׿�");
		}
		biman = kim.calculateBMI();
		if(biman>24) {
			System.out.println("kim�� ���̴� ���̾�Ʈ �ϼ���");
		}else {
			System.out.println(kim.getClass().getName()+" kim�� �ǰ��Ͻó׿�");
			// kim.getClass().getName() : kim ��ü������ Ŭ���� �̸�
		}
	}// main
}// class



















