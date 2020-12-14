package com.tj.ex2_map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import com.tj.ex1_list.Customer;
public class Ex02_CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		do {
			System.out.print("ȸ�������� �����Ͻðڽ��ϱ�(Y/N)?");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) { 
				System.out.print("������ ȸ���� �̸��� ?");
				name = scanner.next();
				System.out.print("������ ȸ���� ����ȣ�� ?");
				phone = scanner.next();
				scanner.nextLine(); // ���ۿ� �����ִ� '\n'�� ����� �뵵
				System.out.print("������ ȸ���� �ּҴ� ?");
				address = scanner.nextLine();
				customers.put(phone, new Customer(name, phone, address));
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);
		//System.out.println(customers);
		Iterator<String> iterator = customers.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customers.get(key));
		}
	}
}








