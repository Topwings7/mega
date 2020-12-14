package com.tj.ex7homework;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class MainTest02_2 {
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
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/tj/ex7homework/customer.txt");
			for(Customer c:customers) {
				System.out.print(c);
				writer.write(c.toString());
			}
			String msg = "        ....���� "+customers.size()+"�� ����";
			System.out.println(msg);
			writer.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(writer!=null) writer.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}//try-close
		}//try-catch-finally
	}//main
}//class
