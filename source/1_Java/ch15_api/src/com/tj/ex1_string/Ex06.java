package com.tj.ex1_string;
import java.util.Scanner;
// substring() lastIndexOf()
public class Ex06 {
	public static void main(String[] args) {
		String[] tels = {"010-1111-9999", "010-1111-8888", "02-325-9999", "02-3333-9999"};
		Scanner sc = new Scanner(System.in);
		String searchTel;
		int idx;
		boolean searchOk = false; // �˻��� ����� ������ true�� �� ����
		System.out.print("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ���?");
		searchTel = sc.next(); // 9999
		for(idx=0 ; idx<tels.length ; idx++) {
			// ��ȭ��ȣ ���ڸ� ������
			String temp = tels[idx].substring( tels[idx].lastIndexOf('-')+1 );
			if(temp.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� "+tels[idx]);// ��ȭ��ȣ ã�Ҵ�.
				searchOk = true;
			}
		}
		if(!searchOk) { //searchTel�� �迭��ȭ�� ���� ���(�� ã�� ������ �� ���)
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
	}
}











