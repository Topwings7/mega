package com.tj.ex;
import java.util.Scanner;
public class Ex04 {
	public static void main(String[] args) {
		String[] name = {"����","ö��","�浿","����","����"};
		int[] height = new int[5];
		Scanner scanner = new Scanner(System.in);
		for(int idx=0 ; idx<name.length ; idx++) {
			System.out.print(name[idx]+"�� Ű�� ?");
			height[idx] = scanner.nextInt();
		}
		int min = 9999;//�ּ�Ű
		int max = 0; // �ִ�Ű
		int tot = 0; // Ű ����
		int minIndex=-1, maxIndex=-1;
		for(int idx=0; idx<name.length ; idx++) {
			tot += height[idx]; // Ű ����
			if(height[idx]<min) {
				min = height[idx]; // �ּҰ��� min�� �ƴϸ� min���� ����
				minIndex = idx;
			}//if - �ּҰ�ó��
			if(height[idx]>max) {
				max = height[idx];
				maxIndex = idx;
			}
		}
		System.out.println("�����Ű : "+max+"("+name[maxIndex]+")"); // �����Ű : 190 (ö��)
		System.out.println("�ִܽ�Ű : "+min+"("+name[minIndex]+")"); // �ִܽ�Ű : 150 (����)
		System.out.printf("���Ű : %.2f\n", (double)tot/name.length);
	}
}







