package com.tj.ex12_book.cd;

public interface ILendable {
	public byte STATE_BORROWED = 1; // �������� �ǹ�
	public byte STATE_NORMAL   = 0; // ���Ⱑ�� ���ĸ� �ǹ�
	public void checkOut(String borrower, String checkOutDate); // ����
	public void checkIn();  // �ݳ�  
	public void printState(); // ���������� ����
}
