package com.tj.ex5_lib;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
// main �Լ��� format
public class Main {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890-01", "this is java", "�ſ��"),
				new BookLib("890-02", "dbms", "�ڿ��")	};
		try {
			books[0].checkOut("kim");
			books[0].setCheckOutDate(new Date(new GregorianCalendar(2019, 10, 13).getTimeInMillis()));
			books[0].checkIn();
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		Scanner sc = new Scanner(System.in); int fn; int idx; String bTitle,borrower;
		do {
			System.out.print("0:��ü ���⿩�� ���� ���� 1.����, 2.�ݳ�, �׿�:����");
			try {
				fn = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("0,1,2 �� �� ���ڸ� �Է��Ͻø� ����ǿ�");
				break;
			}
			switch(fn) {
			case 0:
				System.out.println("for������ ��ü å���� ����"); break;
			case 1:
				System.out.println("å�̸��� ������ �޾� ���� ó��"); break;
			case 2:
				System.out.println("å�̸� �޾� �ݳ� ó��"); break;
			}
		}while(fn==0 || fn==1 || fn==2);
	}//main
}
