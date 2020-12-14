package com.tj.ex15_accountinheritance;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine; // ī���ѵ�
	public CreditLineAccount() {	}
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine=creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine=creditLine;
	}
	public int pay (String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if(creditLine< amount) {
				System.out.println(getOwnerName()+"��, �ѵ��ʰ�. ���Ұ��մϴ�");
				return 0;
			} else {
				creditLine -= amount;
				System.out.println(getOwnerName()+"��, "+ amount +"�� ���(�ܿ� �ѵ�:"+creditLine+"��)");
				return amount;
			}
		} else {
			System.out.println("ī���ȣ�� ��ġ�����ʽ��ϴ�");
			return 0;
		}
	}
	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("ī�� �ѵ��� :" +creditLine);
	}
	public long getCreditLine() {return creditLine;}
}
