package com.tj.loop;
import java.util.Scanner;
// ¦���� �Է��Ҷ����� ����ڷκ��� �޴´�
public class Ex10do_while {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.print("¦���� �Է��ϼ��� : ");
			num = scanner.nextInt();
		}while(num%2!=0);
		System.out.println(num+" ¦���� �� �Է��ϼ̳׿�");
	}
}
