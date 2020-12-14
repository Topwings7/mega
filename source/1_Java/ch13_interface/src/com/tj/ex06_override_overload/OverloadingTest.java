package com.tj.ex06_override_overload;

public class OverloadingTest {
	private int i1;
	private int i2;
	public OverloadingTest() {}  //������ �Լ� �����ε�
	public OverloadingTest(int i) {
		i1 = i2 = i;
	}
	public OverloadingTest(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	public void calculate() {   // �Ϲ��Լ��� �����ε�
		System.out.println("i1+i2="+(i1+i2));
	}
	public void calculate(char op) { // ��ü�̸�.calculate()  ��ü�̸�.calculate('*')
		switch (op) {
		case '+':
			calculate();break;
		case '-':
			System.out.println("i1-i2 = "+(i1-i2));break;
		case '*':
			System.out.println("i1*i2 = "+(i1*i2));break;
		case '/':
			System.out.println("i1/i2 = "+(i1/i2));break;
		case '%':
			System.out.println("i1%i2 = "+(i1%i2));break;
		default:
			System.out.println("��ȿ���� �ʴ� �������Դϴ�");	break;
		}
	}
}















