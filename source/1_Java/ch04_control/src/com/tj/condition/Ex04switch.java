package com.tj.condition;
import java.util.Scanner;
//�����Է¹޾� ���� ���(if, switch��)
public class Ex04switch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ ?");
		int score = scanner.nextInt();
		if(90<=score && score<=100) { // 90<=score<=100
			System.out.println("A����");
		}else if(80<=score && score<90) {
			System.out.println("B����");
		}else if(70<=score && score<80) {
			System.out.println("C����");
		}else if(60<=score && score<70) {
			System.out.println("D����");
		}else if(0<=score && score<60) {
			System.out.println("F����");
		}else {
			System.out.println("��ȿ���� �ʴ� �����Դϴ�");
		}
		scanner.close();
	}
}