package com.tj.ex1_string;
import java.util.Scanner;
public class Ex03 {
	public static void main(String[] args) {
		// x�� ������ ����. ������ ����� ���ѹݺ�
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("���ϴ� ��ɹ�ȣ�� 1:����, 2:�ݳ�, x:����");
			fn = scanner.next();
			if(fn.equals("1")) {
				System.out.println("�������");
			}else if(fn.equals("2")) {
				System.out.println("�ݳ�����");
			}
		}while(!fn.equalsIgnoreCase("x"));
	}
}
