package com.tj.ex1_list;
import java.util.ArrayList;
import java.util.Scanner;
public class Ex02_CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
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
				customers.add(new Customer(name, phone, address));
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);
		System.out.println(customers);
//		for(Customer customer :  customers) {
//			System.out.println(customer);
//		}
		for(int idx=0 ; idx<customers.size() ; idx++) {
			System.out.println(customers.get(idx));
		}
	}
}








