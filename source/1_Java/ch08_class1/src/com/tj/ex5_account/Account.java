package com.tj.ex5_account;
// ���¹�ȣ, ������, �ܾ� / deposit(int), withdraw(int), getBalance()
public class Account {
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������
	private int balance;      // �ܾ�
	public Account() {System.out.println("���°��� ����");}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName+"�� ���°��� ����");
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"���°��� ���� ������ �־���");
	}
	public void deposit(int money) {
		balance += money;
		System.out.println("�����մϴ�. "+ownerName+"�� "+money+"�� ���� �� �ܾ� : "+balance);
	}
	public int withdraw(int money) {
		if(balance >= money) {
			balance -= money;
			System.out.println(ownerName+"�� "+money+"�� ���� �� �ܾ� : "+balance);
			return money;
		}else {
			System.out.println("�ܾ��� �����Ͽ� ���� ����");
			return 0;
		}
	}
	public int getBalance() {
		return balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
}











