package com.tj.loop;
import java.util.Scanner;
//1~45������ ������ �� ���߱�
public class Ex11do_while2 {
	public static void main(String[] args) {
		int lotto; //��ǻ�Ͱ� ������ ������ ��
		int su;    //����ڿ��� ���� �Է¹��� ��
		int min = 1, max=45;
		Scanner scanner = new Scanner(System.in);
		lotto = (int)(Math.random()*45)+1;
//		System.out.println("�ӼӸ� : "+lotto);
		do {
			System.out.printf("%d ~ %d������ ���� ���纸���� : ", min, max);
			su = scanner.nextInt();
			if(su<min || su>max) {
				System.out.println("����");
			}else if(su==lotto) {
				break;
			}else if(su>lotto) {
				max = su - 1;
			}else if(su<lotto) {
				min = su + 1;
			}
		}while(true);
		System.out.println("���߼̽��ϴ�. bye");
	}
}














