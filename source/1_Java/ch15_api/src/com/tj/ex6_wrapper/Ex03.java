package com.tj.ex6_wrapper;
// java Ŭ������ 100 20 10 ; ����Ķ���ͷ� ���� ���ڿ��� ���ڸ� ��
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("���� �� ���� : "+ args.length);
		//"10" "20" "1" "2" "3" "5"
		int total = 0;
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.println(args[idx]);
			total += Integer.parseInt(args[idx]);
		}
		System.out.println("total = "+total);
	}
}
