package com.tj.loop;
import java.util.Scanner;
public class Homework4 {
	public static void main(String[] args) {
		int computer, you;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("����(0),����(1),��(2) �� �ϳ�����(���Ḧ ���Ͻø� -1) : ");
			you = sc.nextInt();
			if(you==-1) break;
			computer = (int)(Math.random()*3);
			if(you >2 || you < -1) {
			  System.out.println("����(0), ����(1), ��(2) �� ����� ������");
			}else if((you+2)%3==computer) {
			  System.out.println("����� "+(you==0? "����":you==1? "����":"��"));
			  System.out.println("��ǻ�ʹ� "+(computer==0? "����":computer==1? "����":"��"));
			  System.out.println("����� �̰���");
			}else if(you == computer) {
			  System.out.println("����� "+(you==0? "����":you==1? "����":"��"));
			  System.out.println("��ǻ�ʹ� "+(computer==0? "����":computer==1? "����":"��"));
			  System.out.println("�����");
			}else {
			  System.out.println("����� "+(you==0? "����":you==1? "����":"��"));
			  System.out.println("��ǻ�ʹ� "+(computer==0? "����":computer==1? "����":"��"));
			  System.out.println("����� �����");
			}//if
		}//while
		sc.close();
		System.out.println("bye");
		}//main
}