package com.tj.ex1_tryCatch;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1;
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
		try {
			j = scanner.nextInt();                   //InputMismatchException
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i * j = "+ (i*j));
			System.out.println("i / j = "+ (i/j));   // ArithmeticException
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("0���� ������ ���� �ȵǿ�");
		}
		System.out.println("i + j = "+ (i+j));
		System.out.println("i - j = "+ (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
