package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
// �����Է�(inTest.txt) Hello, java\r\nHi
// 1.��Ʈ���� ���� 2.�д´� 3.���ϴݴ´�
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is=null;
		try {
			is = new FileInputStream("D:/mega_IT/inTest.txt"); // 1.��Ʈ���� ����
			while(true) {
				int i = is.read(); // 2. �д´�(1byte �д´�)
				if(i==-1) {
					break; // i�� -1�̸� ������ ��
				}
				System.out.println((char)i+"�� �ƽ�Ű�ڵ� �� : "+i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ��ã���� �� ���� "+e.getMessage());
		} catch (IOException e) {
			System.out.println("������ ���о����� ����"+e.getMessage());
		} finally {
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
