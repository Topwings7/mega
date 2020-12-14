package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// �Է½�Ʈ������,��½�Ʈ������ - > ���������ͱ״��write�Ѵ� -> �Է½�Ʈ������½�Ʈ�����ݴ´�
public class FileCopyStep2 {
	public static void main(String[] args) {
		InputStream  is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/bts.jpg");
			os = new FileOutputStream("txtFile/bts_copy.jpg");
			int cnt = 0;
			byte[] bs = new byte[1024];
			while(true) {
				cnt++;
				int readByteCount = is.read(bs); // 1024byte �� �а�
				if(readByteCount==-1) break;
				// bs�迭�� 0index���� readByteCount ����Ʈ��ŭ ����
				os.write(bs, 0, readByteCount);
			}
			System.out.println("���� ī�� ��. while�� ��� ���Ҵ��� : "+cnt);
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã�� "+e.getMessage());
		} catch (IOException e) {
			System.out.println("�б� ���� "+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
