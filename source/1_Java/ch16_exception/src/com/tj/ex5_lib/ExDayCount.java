package com.tj.ex5_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ExDayCount {
	public static void main(String[] args) {
		//Date checkOutDate = new Date(119, 10, 13); // 2019,11,13�Ϸ� ����
		Date checkOutDate = new Date(new GregorianCalendar(2019,11,12).getTimeInMillis());
		Date now = new Date();
		long checkOutMillis = checkOutDate.getTime(); // 1970.1.1~2019.11.13���� �и�����
		long nowMillis      = now.getTime();          // 1970.1.1~2019.12.13���� �и�����
		long diff = nowMillis - checkOutMillis;// ���� ������ �и�����
		long day = diff/(24*60*60*1000);
		if(day>14) {
			// ��ü�� ���
			System.out.println((day-14)*100+"�� ��ü�Ḧ ���ž� �ݳ�ó�� �����մϴ�.");
			Scanner sc = new Scanner(System.in);
			System.out.print("��ü�Ḧ �����̳���Y/N (N:�ݳ��ߴ�?)");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.exit(0); // checkIn method������ return���� ��ü
			}//if
		}//if
		System.out.println("�ݳ�ó�� ����");
	}
}













