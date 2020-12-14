package com.tj.ex12_book;
import java.util.Scanner;
public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890-01", "java", "�ſ��"),
				new BookLib("890-02", "dbms", "�ڿ��"),
				new BookLib("890-03", "html", "����"),
				new BookLib("890-04", "css", "�̿��"),
				new BookLib("890-05", "jsp", "�����")	};
		Scanner sc = new Scanner(System.in);
		String bTitle;
		int idx; // �����̳� �ݳ��� ó���� å�� index
		String borrower, checkOutDate;
		int fn; // ��ɹ�ȣ
		for(BookLib book : books) {
			book.printState();
		}
		do {
			System.out.print("1.å����, 2.å�ݳ�, 0:����");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				//����ó�� 1.å�̸��Է� 2.å�˻� 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����ó�� 
				System.out.print("�����ϰ��� �ϴ� å�̸���?");            // (1)�ܰ�. å�̸��Է�
				bTitle = sc.next(); // white-space�ձ����� ��Ʈ�� ����.
				for(idx=0 ; idx<books.length ; idx++) {                  // (2)�ܰ�. å�˻�
					if(books[idx].getBookTitle().equals(bTitle)) {
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
				//�ݳ�ó�� 1.å�̸� 2.å�˻� 3.�ݳ�ó��
				System.out.print("�ݳ��� å�̸���?"); //(1)�ܰ�. å�̸�
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) { // (2)�ܰ�. å�˻�
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //ã�Ƽ� ����
					}
				}
				if(idx==books.length) {
					System.out.println("�̵����� �������� ����å�� �ƴմϴ�.");
				}else {
					books[idx].checkIn(); // (3)�ܰ�. �ݳ�ó��
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
		System.out.println("�ȳ��� ������");
		sc.close();
	}
}















