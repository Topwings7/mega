package com.tj.ex08_toy;

public class AirPlaneToy implements IMissile, ILight{
	public AirPlaneToy() {
		System.out.println("������Դϴ�");
		canLight();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canLight() {
		System.out.println("�Һ��ݻ��� �� �ִ�");
	}
	@Override
	public void canMissile() {
		System.out.println("�̻��� �� �� �ִ�");
	}
}
