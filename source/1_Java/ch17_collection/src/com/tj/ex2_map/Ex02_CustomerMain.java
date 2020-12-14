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
			System.out.print("회원가입을 진행하시겠습니까(Y/N)?");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) { 
				System.out.print("가입할 회원의 이름은 ?");
				name = scanner.next();
				System.out.print("가입할 회원의 폰번호는 ?");
				phone = scanner.next();
				scanner.nextLine(); // 버퍼에 남아있는 '\n'을 지우는 용도
				System.out.print("가입할 회원의 주소는 ?");
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








