package com.tj.ex2_dataInputStreamDataOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
public class Ex03_productMain {
	public static void main(String[] args) {
		// 1�ܰ�. x�� �Է��Ҷ����� ����Է�(���Ǹ�, ����, ������)�޾� ���Ͽ� ����
		Scanner scanner = new Scanner(System.in);
		String answer;
		OutputStream     fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("��� �� �ֳ���(�ߴ��� ���ϸ� x, ����� ���ϸ� �ƹ��ų�)?");
				answer = scanner.next();
				if(answer.equalsIgnoreCase("x")) break;
				System.out.print("�Է��� ����� ���Ǹ��� ? ");
				dos.writeUTF(scanner.next());
				System.out.print("�Է��� ��� ������ ������ ?");
				dos.writeInt(scanner.nextInt());
				System.out.print("�Է��� ��� ������ ������? ");
				dos.writeInt(scanner.nextInt());
			}while(true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}//main
}//class
