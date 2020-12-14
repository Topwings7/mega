package com.tj.ex15_accountinheritance;

public class CheckingAccount extends Account {
	private String cardNo;  // ī���ȣ
	public CheckingAccount(){ }
	public CheckingAccount(String accountNo,String ownerName, String cardNo){ 
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo,String ownerName,int balance,String cardNo){ 
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public int pay(String cardNo, int amount){
		if(this.cardNo.equals(cardNo)){
			if(getBalance()<amount){
				System.out.println("�ڡڡ��ܾ��� �����մϴ١ڡڡ�");
				return 0;
			}else{
				setBalance(getBalance()-amount);
				System.out.println(amount+"���Ǽ� ���� �ܾ� : "+getBalance());
				return amount;
			}
		}else{
			System.out.println("ī���ȣ�� ��ġ�����ʽ��ϴ�");
			return 0;
		}
	}
	public String getCardNo() {return cardNo;}
	public void setCardNo(String cardNo) {this.cardNo = cardNo;}
}
