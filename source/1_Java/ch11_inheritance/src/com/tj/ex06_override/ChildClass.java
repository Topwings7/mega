package com.tj.ex06_override;

public class ChildClass extends ParentClass{ // method1(), method2()
	public ChildClass() { // �����ε�(�Լ��� �ߺ�����)
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	@Override
	public void method1() { // override (�Լ��� ������)
		System.out.println("ChildClass�� method1()");
	}
	public void method3() {
		System.out.println("ChildClass�� emthod3()");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}







