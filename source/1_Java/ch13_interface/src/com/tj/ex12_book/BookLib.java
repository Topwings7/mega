package com.tj.ex12_book;

public class BookLib extends BookInfo implements ILendable {
	private String borrower;     // ������
	private String checkOutDate; // ������
	private byte state; // ������(1)or���Ⱑ��(0)
	public BookLib() { }
	// BookLib b = new BookLib("450-01��","java","�ſ��");
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) { //b.checkOut("ȫ�浿","12-06");
		if(state==STATE_BORROWED) { // �����߻��¶� �޼��� �Ѹ��� return
			System.out.println(getBookTitle()+" ������ �������Դϴ�");
			return;
		}
		// ���Ⱑ�ɻ����̹Ƿ� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // ������ ����
		System.out.println(getBookTitle()+" ����ó���Ǿ����ϴ�.");
		System.out.println("������ : "+borrower);
		System.out.println("������ : "+checkOutDate);
	}
	@Override
	public void checkIn() {// b.checkIn()
		if(state==STATE_NORMAL) {
			System.out.println("�� å�� ���Ⱑ�ɻ����̶� �����µ� �̻��ϴ�. ���ܴ�");
			return;
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+" ������ �ݳ��Ǿ����ϴ�.");
	}
	// b.printState() => 840-0�� "java" �ſ���� ������ (12-06)
	//                   840-0�� "java" �ſ���� ���Ⱑ��
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo()+" \""+getBookTitle()+"\" "+getWriter()+"�� ���Ⱑ��");
		}else if(state==STATE_BORROWED) {
			System.out.println(getBookNo()+" \""+getBookTitle()+"\" "+getWriter()+"�� ������("+checkOutDate+")");
		}else {
			System.out.println(getBookNo()+" \""+getBookTitle()+"\" �̻��ϴ�. ���ܻ�Ȳ");
		}
	}
	public byte getState() {
		return state;
	}
}
