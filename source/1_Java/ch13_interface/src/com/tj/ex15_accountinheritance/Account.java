package com.tj.ex15_accountinheritance;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account(){	}
	public Account(String accountNo,String ownerName){
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
		System.out.println(ownerName+"�� ���°��� ����");
	}
	public Account(String accountNo,String ownerName,int balance){
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"���°��� ���� ������ ������ �ֽð�");
	}
	public void deposit(int amount){
		balance += amount;
		System.out.println("�����մϴ� "+ownerName+"�� "+amount+"�� ���� �� �ܾ� : "+balance);
	}
	public int withdraw(int amount){
		if(balance >= amount) {
			balance -= amount;
			System.out.println(ownerName+"�� "+amount+"�� ���� �� �ܾ� : "+balance);
			return amount;
		}else {
			System.out.println("�ܾ��� �����Ͽ� ���� ����");
			return 0;
		}
	}
	public void printAccount(){
		System.out.println("���¹�ȣ:"+accountNo);
		System.out.println("�� �� ��:"+ownerName);
		System.out.println(" ��  �� :"+balance);
	}
	public String getAccountNo() {return accountNo;}
	public void setAccountNo(String accountNo) {this.accountNo = accountNo;}
	public String getOwnerName() {return ownerName;}
	public void setOwnerName(String ownerName) {this.ownerName = ownerName;}
	public int getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
}
