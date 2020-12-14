package com.tj.ex4_bufferedReaderBufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
public class Ex01_bufferedReader {
	public static void main(String[] args) {
		Reader         reader = null;
		BufferedReader br     = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1.�⺻��Ʈ������
			br     = new BufferedReader(reader);           //   ������Ʈ���� �⺻��Ʈ���� ����
			while(true) {
				String linedata = br.readLine();// 2.���پ� �д´�
				if(linedata==null) break; // ������ ���� ���
				System.out.println(linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {                            // 3. �ݴ´�
				if(br    !=null) br.close();
				if(reader!=null) reader.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
