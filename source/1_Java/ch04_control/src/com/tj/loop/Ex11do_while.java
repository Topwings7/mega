package com.tj.loop;
import java.util.Scanner;
//1~45������ ������ �� ���߱�
public class Ex11do_while {
	public static void main(String[] args) {
		int lotto; //��ǻ�Ͱ� ������ ������ ��
		int su;    //����ڿ��� ���� �Է¹��� ��
		Scanner scanner = new Scanner(System.in);
		// 0.0 <= Math.random() <1
		// 0.0 <= Math.random()*45 < 45
		// (int)(Math.random()*45) : 0~44������ ������ ����
		// (int)(Math.random()*45)+1 : 1~45������ ������ ����
		lotto = (int)(Math.random()*45)+1;
//		System.out.println("�ӼӸ� : "+lotto);
		do {
			System.out.print("1~45������ ���� ���纸���� : ");
			su = scanner.nextInt();
			if(su>lotto) {
				System.out.println(su+"���� ���� ���� �����ϼ���");
			}else if(su<lotto) {
				System.out.println(su+"���� ū ���� �����ϼ���");
			}
		}while(su!=lotto);
		System.out.println("���߼̽��ϴ�. bye");
	}
}














