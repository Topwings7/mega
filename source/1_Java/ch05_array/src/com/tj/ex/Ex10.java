package com.tj.ex;
// ������ ����3. 76,45,34,89,100,50,90,92�� ����, ���, �ִ밪, �ּҰ�
public class Ex10 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int tot=0; //����
		double avg; // ���
		int max=-9999, min=9999;
		for(int a : arr) {
			tot += a; // ����
			if(max < a) { // �ִ밪 ó��
				max = a;
			}//if-max
			if(min > a) { // �ּҰ� ó��
				min = a;
			}//if-min
		}//for
		avg = tot / arr.length;
		System.out.println("���� : "+tot+", ��� : "+avg);
		System.out.println("�ּҰ� : "+min+", �ִ밪 : "+max);
	}
}
