package com.tj.ex;
import com.tj.method.Arithmetic;
// Arithmetic���� sum, evenOdd, abs
public class Ex03 {
	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(10, 100);
		System.out.println(ar.evenOdd(tot));
		int value = Arithmetic.abs(-5);
		System.out.println("-5�� ���밪�� "+value);
//		Scanner sc = new Scanner(System.in);
//		int s = sc.nextInt();
	}
}
