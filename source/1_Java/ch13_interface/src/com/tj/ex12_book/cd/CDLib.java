package com.tj.ex12_book.cd;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;     // ������
	private String checkOutDate; // ������
	private byte state; // ������(1)or���Ⱑ��(0)
	public CDLib() { }
	// CDLib b = new CDLib("001-01","javacd","450-01��");
	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) { //b.checkOut("ȫ�浿","12-06");
		if(state==STATE_BORROWED) { // �����߻��¶� �޼��� �Ѹ��� return
			System.out.println(getCdNo()+" CD�� �������Դϴ�");
			return;
		}
		// ���Ⱑ�ɻ����̹Ƿ� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // ������ ����
		System.out.println(getCdTitle()+" ����ó���Ǿ����ϴ�.");
		System.out.println("������ : "+borrower);
		System.out.println("������ : "+checkOutDate);
	}
	@Override
	public void checkIn() {// b.checkIn()
		if(state==STATE_NORMAL) {
			System.out.println("�� CD�� ���Ⱑ�ɻ����̶� �����µ� �̻��ϴ�. ���ܴ�");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdTitle()+" CD�� �ݳ��Ǿ����ϴ�.");
	}
	// b.printState() => 001-01 "java" 450-01���� ���� CD ������ (12-06)
	//                   001-01 "java" 450-01���� ���� CD ���Ⱑ��
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getCdNo()+" \""+getCdTitle()+"\" "+getBookNo()+"�� ���� CD ���Ⱑ��");
		}else if(state==STATE_BORROWED) {
			System.out.println(getCdNo()+" \""+getCdTitle()+"\" "+getBookNo()+"�� ���� CD ������("+checkOutDate+")");
		}else {
			System.out.println(getCdNo()+" \""+getCdTitle()+"\" �̻��ϴ�. ���ܻ�Ȳ");
		}
	}
	public byte getState() {
		return state;
	}
}
