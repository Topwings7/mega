package com.tj.ex12_book.cd;
import java.util.Scanner;
public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("a01", "java", "�ſ��"), 
							new BookLib("a02", "dbms", "�ƹ���"),
							new BookLib("a03", "html", "ȫ�浿"), 
							new BookLib("a04", "css", "��浿"),
							new BookLib("a05", "jsp", "�ڱ浿") };
		CDLib[] cds = { new CDLib("c01", "java_cd", "a01"), 
						new CDLib("c02", "ITtrend", null), 
						new CDLib("c03", "jsp", "a02") };
		Scanner sc = new Scanner(System.in);
		String title;
		int idx; // �����̳� �ݳ��� ó���� å�� index
		String borrower, checkOutDate;
		int fn; // ��ɹ�ȣ
		for(BookLib book : books) {
			book.printState();
		}
		for(CDLib cd : cds) {
			cd.printState();
		}
		do {
			System.out.print("1:å���� | 2:CD���� | 3:å�ݳ� | 4:CD�ݳ� | 0:���� ?");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				//å����ó�� 1.å�̸��Է� 2.å�˻� 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����ó�� 
				System.out.print("�����ϰ��� �ϴ� å�̸���?");            // (1)�ܰ�. å�̸��Է�
				title = sc.next(); // white-space�ձ����� ��Ʈ�� ����.
				for(idx=0 ; idx<books.length ; idx++) {                  // (2)�ܰ�. å�˻�
					if(books[idx].getBookTitle().equals(title)) {
						break;//ã�Ҵ�. �̰� �����ϸ� �ǰڴ�
					}
				}
				// idx<books.length���� ã�Ҵ�. idx==books.length���� ��ã�Ҵ�
				if(idx==books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				}else {
					if(books[idx].getState() == ILendable.STATE_BORROWED) {// (3) �ܰ�. å����Ȯ��
						System.out.println("���� �������� �����Դϴ�.");
					}else {
						System.out.print("�����ڴ�?");// (4)�ܰ�. �������Է�
						borrower = sc.next();
						System.out.print("�������� ?");// (5)�ܰ�. �������Է� 
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);// (6)����ó��
					}
				}
				break;
			case 2: 
				//cd����ó�� 1.cd�̸��Է� 2.cd�˻� 3.cd����Ȯ�� 4.�������Է� 5.�������Է� 6.����ó�� 
				System.out.print("�����ϰ��� �ϴ� cd�̸���?");            // (1)�ܰ�. cd�̸��Է�
				title = sc.next(); // white-space�ձ����� ��Ʈ�� ����.
				for(idx=0 ; idx<cds.length ; idx++) {                  // (2)�ܰ�. cd�˻�
					if(cds[idx].getCdTitle().equals(title)) {
						break;//ã�Ҵ�. �̰� �����ϸ� �ǰڴ�
					}
				}
				// idx<cds.length���� ã�Ҵ�. idx==cds.length���� ��ã�Ҵ�
				if(idx==cds.length) {
					System.out.println("���� �������� ���� cd�Դϴ�.");
				}else {
					if(cds[idx].getState() == ILendable.STATE_BORROWED) {// (3) �ܰ�. å����Ȯ��
						System.out.println("���� �������� cd�Դϴ�.");
					}else {
						System.out.print("�����ڴ�?");// (4)�ܰ�. �������Է�
						borrower = sc.next();
						System.out.print("�������� ?");// (5)�ܰ�. �������Է� 
						checkOutDate = sc.next();
						cds[idx].checkOut(borrower, checkOutDate);// (6)����ó��
					}
				}
				break;
			case 3:
				//å�ݳ�ó�� 1.å�̸� 2.å�˻� 3.�ݳ�ó��
				System.out.print("�ݳ��� å�̸���?"); //(1)�ܰ�. å�̸�
				title = sc.next();
				for(idx=0 ; idx<books.length ; idx++) { // (2)�ܰ�. å�˻�
					if(books[idx].getBookTitle().equals(title)) {
						break; //ã�Ƽ� ����
					}
				}
				if(idx==books.length) {
					System.out.println("�̵����� �������� ����å�� �ƴմϴ�.");
				}else {
					books[idx].checkIn(); // (3)�ܰ�. �ݳ�ó��
				}
				break;
			case 4:
				//cd�ݳ�ó�� 1.cd�̸� 2.cd�˻� 3.�ݳ�ó��
				System.out.print("�ݳ��� cd�̸���?"); //(1)�ܰ�. cd�̸�
				title = sc.next();
				for(idx=0 ; idx<cds.length ; idx++) { // (2)�ܰ�. cd�˻�
					if(cds[idx].getCdTitle().equals(title)) {
						break; //ã�Ƽ� ����
					}
				}
				if(idx==cds.length) {
					System.out.println("�̵����� �������� ����å�� �ƴմϴ�.");
				}else {
					cds[idx].checkIn(); // (3)�ܰ�. �ݳ�ó��
				}
				break;
			case 0:
				break;
			default:
				System.out.println("��ȿ���� �ʴ� ��ɹ�ȣ�Դϴ�.");
			}
		}while(fn!=0);
		for(BookLib book : books) {
			book.printState();
		}
		for(CDLib cd : cds) {
			cd.printState();
		}
		System.out.println("�ȳ��� ������");
		sc.close();
	}
}















