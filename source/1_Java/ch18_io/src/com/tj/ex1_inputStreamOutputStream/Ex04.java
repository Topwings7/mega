package com.tj.ex1_inputStreamOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class Ex04 {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // 1.��Ʈ������ true:append
			String str = "�ȳ��ϼ���\r\n�ݰ����ϴ�";
			byte[] bs = str.getBytes(); 
			os.write(bs);
		}catch(FileNotFoundException e) {
			System.out.println("���ϸ�ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
