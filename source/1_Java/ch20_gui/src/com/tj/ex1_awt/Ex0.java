package com.tj.ex1_awt;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("��ư");
		frame.add(btn);
		Button btn2 = new Button("�׳� ��ư");
		frame.add(btn2);
		frame.setSize(new Dimension(300, 200));
		//frame.pack(); // �ּ����� ������ 
		frame.setLocation(100, 50);
		frame.setVisible(true);// frame�� ȭ�鿡 ���̰� ��
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		frame.setVisible(false); // ȭ�鿡 �� ���̰�
		frame.dispose();         // �ڿ�����
		System.exit(0);          // ���� ����
	}
}
