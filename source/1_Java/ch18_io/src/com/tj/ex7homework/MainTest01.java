package com.tj.ex7homework;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class MainTest01 {
	public static void main(String[] args) {
		// 1. N(n)�� �Է��� ������ ȸ�������� ArrayList�� �޴´�(���� �����̸� ���ϸ޼������)
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String keepgoing, name, phone, birth, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			try {
				System.out.print("ȸ�������� �ϽǷ���(Y/N) ? ");
				keepgoing = keyboard.readLine();
				if(keepgoing.equalsIgnoreCase("n")) break;
				System.out.print("ȸ���̸� ? ");
				name = keyboard.readLine();
				System.out.print("��ȭ��ȣ ? ");
				phone = keyboard.readLine();
				System.out.print("����(mm-dd) ? ");
				birth = keyboard.readLine();
				System.out.print("�ּ� ? ");
				address = keyboard.readLine();
				if(birth.equals(todayStr)) {
					System.out.println(name+"�� �����̽ñ���. ���������մϴ�");
				}
				customers.add(new Customer(name, phone, birth, address));
			}catch ( IOException e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		// 2. ArrayList ������ ��� �����ߴ��� ���� ��°� �ܼ� ����Ѵ�
		OutputStream os = null;
		try {
			os = new FileOutputStream("src/com/tj/ex7homework/customer.txt");
			for(Customer c:customers) {
				byte[] bs = c.toString().getBytes();
				System.out.print(c);
				os.write(bs);
			}
			System.out.println("        ....���� "+customers.size()+"�� ����");
			String msg = "        ....���� "+customers.size()+"�� ����";
			os.write(msg.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}
		}//try
	}//main
}//class
