package com.tj.ex1_square;
public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		s1.setSide(5);//s1.side = 5;
		Square s2 = new Square(7);
		s2.setSide(9);
		System.out.println(s1.getSide()+"������ Square ���� :"+s1.area());
		System.out.println(s2.getSide()+"������ Square ���� : "+s2.area());
	}
}
