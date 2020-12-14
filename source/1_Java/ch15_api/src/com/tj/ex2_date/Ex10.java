package com.tj.ex2_date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
public class Ex10 {
	public static void main(String[] args) {
		Date date = new Date(new GregorianCalendar(1990, 11, 11).getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-d");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss:SS");
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd E���� a hh:mm:ss:SS");
		SimpleDateFormat sdf6 = new SimpleDateFormat("������ ������ D��° ���Դϴ�");
		SimpleDateFormat sdf7 = new SimpleDateFormat("������ �̴��� W���� ���Դϴ�");
		SimpleDateFormat sdf8 = new SimpleDateFormat("������ ������ w���� ���Դϴ�");
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		System.out.println(sdf5.format(date));
		System.out.println(sdf6.format(date));
		System.out.println(sdf7.format(date));
		System.out.println(sdf8.format(date));
	}
}










