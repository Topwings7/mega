package com.tj.ex3_shape;
public class Circle extends Shape{
	private int r; // ������
	public Circle(int r) {this.r = r;}
	@Override
	public double computeArea() {
		return 3.14*r*r;
	}
	@Override
	public void draw() {
		System.out.print("�� ");
		super.draw();
	}
}
