package com.tj.ex1_string;
// String�� �޸𸮸� ���Һ�(�����Ͱ� ���� ��) - �� ������ ���� : StringBuffer, StringBuilder
public class Ex09_string {
	public static void main(String[] args) {
		String str1 = "Java"; // 100����
		String str2 = str1;   // 100����
		str1 = "Python";      // 200����
		if(str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּҳ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҳ�");
		}
		str1 = "Python1";   // 300����
	}
}
