package com.tj.loop;
import java.util.Scanner;
//	����ڷκ��� ���ϴ� �ܼ��� �������� �������
public class Q3for {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��� ����?");
		int dansu = scanner.nextInt();
		for(int i=1 ; i<10 ; i++) {
			//System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
		scanner.close();
	}
}
