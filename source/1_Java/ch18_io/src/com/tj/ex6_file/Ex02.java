package com.tj.ex6_file;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Ex02 {
	public static void main(String[] args)  {
		File file = new File(".");
		try {
			System.out.println("������ :"+file.getAbsolutePath());
			System.out.println("ǥ�ذ�� :"+file.getCanonicalPath());
			Date thatTime = new Date(file.lastModified()); // ������ ���� ������ �ð�
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E) hh:mm:ss");
			System.out.println("���� ������ : "+sdf.format(thatTime));
			System.out.printf("%1$ty-%1$tm-%1$td(%1$ta) %1$tl : %1$tM : %1$tS", thatTime);
			System.out.println("���� ũ�� : "+file.length());
			System.out.println("�б� �Ӽ� : "+file.canRead());
			System.out.println("���� �Ӽ� : "+file.canWrite());
			System.out.println("���� �Ӽ� : "+file.isHidden());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}