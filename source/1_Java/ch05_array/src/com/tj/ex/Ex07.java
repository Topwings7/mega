package com.tj.ex;
// �Ϲ�for vs. Ȯ��for
public class Ex07 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		// �Ϲ� for��
		for(int idx = 0 ; idx < arr.length ; idx++) {
			System.out.println(arr[idx]);
		}
		// Ȯ�� for ��
		for(int a : arr) {
			System.out.println(a);
		}
	}
}
