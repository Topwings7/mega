package com.tj.ex1_tryCatch;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		do {
			try {
				System.out.print("ù��° ���� i�� ?");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("ù��° ���� �� ���ڸ� �־��ּ���");
				scanner.nextLine(); // ���۸� ����� ����
			}
		}while(true);
		System.out.print("�ι�° ���� j�� ");
		
		j = scanner.nextInt();
		System.out.println("i="+i+"\t j="+j);
		System.out.println("i * j = "+ (i*j));
		try {
			System.out.println("i / j = "+ (i/j));
		}catch(ArithmeticException e) {
			//e.printStackTrace(); // e.getMessage()���� �ڼ��ϰ� 
			System.out.println(e.getMessage()); // /by zero
			System.out.println("0���� ������ �ʰ� ��ȸ�մϴ�.");
		}
		System.out.println("i + j = "+ (i+j));
		System.out.println("i - j = "+ (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
