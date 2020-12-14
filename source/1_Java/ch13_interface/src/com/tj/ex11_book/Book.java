package com.tj.ex11_book;
public class Book implements ILendable{
	private String bookNo;       // å��ȣ
	private String bookTitle;    // å����
	private String writer;       // ����
	private String borrower;     // ������
	private String checkOutDate; // ������
	private byte state; // ������(1)or���Ⱑ��(0)
	public Book() { }
	// Book b = new Book("450-01��","java","�ſ��");
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) { //b.checkOut("ȫ�浿","12-06");
		if(state==STATE_BORROWED) { // �����߻��¶� �޼��� �Ѹ��� return
			System.out.println(bookTitle+" ������ �������Դϴ�");
			return;
		}
		// ���Ⱑ�ɻ����̹Ƿ� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // ������ ����
		System.out.println(bookTitle+" ����ó���Ǿ����ϴ�.");
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
		System.out.println(bookTitle+" ������ �ݳ��Ǿ����ϴ�.");
	}
	// b.printState() => 840-0�� "java" �ſ���� ������ (12-06)
	//                   840-0�� "java" �ſ���� ���Ⱑ��
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo+" \""+bookTitle+"\" "+writer+"�� ���Ⱑ��");
		}else if(state==STATE_BORROWED) {
			System.out.println(bookNo+" \""+bookTitle+"\" "+writer+"�� ������("+checkOutDate+")");
		}else {
			System.out.println(bookNo+" \""+bookTitle+"\" �̻��ϴ�. ���ܻ�Ȳ");
		}
	}
	public String getBookNo() {
		return bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public byte getState() {
		return state;
	}
}