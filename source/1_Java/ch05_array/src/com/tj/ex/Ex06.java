package com.tj.ex;
// int[] arr =  { 10, 20, 30, 40, 50}  �迭 ���� ������ ���� ����ϴ� ���α׷�
public class Ex06 {
	public static void main(String[] args) {
		int a = 10;
		int[] arr = {10,20,30,40,50,60,70,80,90,100,110};
		int tot = 0; //��������
		for(int idx=0 ; idx<arr.length ; idx++) {
			tot += arr[idx];
		}
		System.out.println(tot);
	}
}
