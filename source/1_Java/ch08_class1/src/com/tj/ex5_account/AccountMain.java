package com.tj.ex5_account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("111-111","ȫ�浿",20000);
		Account hong1 = new Account("111-112", "��浿");
		Account hong2 = new Account();
		hong2.setAccountNo("111-113");
		hong2.setOwnerName("�ű浿");
		hong.deposit(10000);
		hong1.deposit(10000);
		hong2.deposit(10000);
		int result = hong.withdraw(40000);
		if(result==0) {
			System.out.println("�������");
		}
		result = hong2.withdraw(5000);
		if(result==0) {
			System.out.println("�������");
		}
	}
}
