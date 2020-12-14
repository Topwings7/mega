package com.tj.ex7homework;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class MainTest02_4 {
	public static void main(String[] args) {
		// 1. N(n)�� �Է��� ������ ȸ�������� ArrayList�� �޴´�(���� �����̸� ���ϸ޼������)
		Scanner scanner = new Scanner(System.in);
		String keepgoing, name, phone, birth, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			System.out.print("ȸ�������� �ϽǷ���(Y/N) ? ");
			keepgoing = scanner.next();
			if(keepgoing.equalsIgnoreCase("n")) break;
			System.out.print("ȸ���̸� ? ");
			name = scanner.next();
			System.out.print("��ȭ��ȣ ? ");
			phone = scanner.next();
			System.out.print("����(mm-dd) ? ");
			birth = scanner.next();
			System.out.print("�ּ� ? ");
			scanner.nextLine();
			address = scanner.nextLine();
			if(birth.equals(todayStr)) {
				System.out.println(name+"�� �����̽ñ���. ���������մϴ�");
			}
			customers.add(new Customer(name, phone, birth, address));
		}while(true);
		// 2. ArrayList ������ ��� �����ߴ��� ���� ��°� �ܼ� ����Ѵ�
		PrintWriter printwriter = null;
		try {
			printwriter = new PrintWriter("src/com/tj/ex7homework/customer.txt");
			for(Customer c:customers) {
				System.out.print(c);
				printwriter.print(c.toString());
			}
			System.out.println("        ....���� "+customers.size()+"�� ����");
			printwriter.println("        ....���� "+customers.size()+"�� ����");
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				printwriter.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}
		}
	}
}
