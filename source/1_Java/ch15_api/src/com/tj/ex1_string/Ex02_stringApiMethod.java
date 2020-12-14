package com.tj.ex1_string;
public class Ex02_stringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "   ja  va    ";
		System.out.println("1." + str1.concat(str2)); // abcXabcabcXabc
		System.out.println("2." + str1.substring(3)); // Xabc
		System.out.println("3." + str1.substring(3, 5)); // 3���ε������� 5�� �ձ��� Xa
		System.out.println("4." + str1.length()); // str1���ڱ��� 7
		System.out.println("5." + str1.toUpperCase()); // �빮�ڷ� ABCXABC
		System.out.println("6." + str1.toLowerCase()); // �ҹ��ڷ� abcxabc
		System.out.println("7." + str1.charAt(3)); // 3���ε����� ���� X
		System.out.println("8." + str1.indexOf('b')); // ù��° b�� ������ �ε��� 1
		System.out.println("9." + str1.lastIndexOf('b')); // ������ b�� ������ �ε��� 5
		String str4 = "abcXabcXabcXabc";
		System.out.println("10." + str4.indexOf('b', 3));// 3���ε������� �˻��Ͽ� ùb�� ������ �ε��� 5
		System.out.println("11." + str4.indexOf("cX"));  // ù��° cX�� ������ �ε��� 2
		System.out.println("12." + str4.indexOf('z'));   // z�� ������ -1
		System.out.println("13." + str1.equals(str2)); // str1�� str2�� ���� ��������(��ҹ��ڱ���) false
		System.out.println("14." + str1.equalsIgnoreCase(str2));// ��ҹ��ڱ������� ���� ���ĺ����� true
		System.out.println("15." + str3.trim()); // �յ� space ���� java
		System.out.println("16." + str4.replace('a', '9')); // str4�� 'a'�� �� 9�� 9bcX9bcX9bcX9bc
		System.out.println("17." + str4.replace("abcX", "�ٲ�")); // �ٲ�ٲ�ٲ�abc
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
		System.out.println("str3 : "+str3);
		System.out.println("str4 : "+str4);
	}
}













