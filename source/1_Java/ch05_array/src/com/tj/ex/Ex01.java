package com.tj.ex;
public class Ex01 {
	public static void main(String[] args) {
		int[] iArr = { 10,20,30,40,50,60 }; // 1. �迭����� �ʱ�ȭ
		for(int idx=0 ; idx<iArr.length ; idx++) {
			System.out.println(iArr[idx]);
		}
		int[] iArr2 = new int[5]; // 2. �迭����� �迭�޸��Ҵ�
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.println(iArr2[idx]);
		}
		int[] iArr3;              //3.�迭����
		iArr3 = new int[3];
		iArr3[0] = 100;
		for(int idx=0; idx<iArr3.length ; idx++) {
			System.out.println(iArr3[idx]);
		}
	}
}
