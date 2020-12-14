package com.tj.ex2_swing;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Ex01 extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel    jPanel;
	private JLabel    jlbl;
	private JButton   jbtn;
	public Ex01(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x��ư Ŭ���� ����
		//contenPane = getContentPane(); // �����̳ʸ� �޾ƿ�
		jPanel  = (JPanel) getContentPane(); // �����̳ʸ� �޾ƿ� jpanel������ ����ȯ�Ͽ� ����
		jPanel.setLayout(new FlowLayout());
		jlbl = new JLabel("��ſ� ������");
		jbtn = new JButton("����");
		jlbl.setPreferredSize(new Dimension(250, 200));
		jbtn.setPreferredSize(new Dimension(200, 200));
		jPanel.add(jlbl);
		jPanel.add(jbtn);
		pack(); // ȭ���� �ּ����� �������
		setLocation(100, 50);
		setVisible(true);
		jbtn.addActionListener(this); // �̺�Ʈ �߰��� �׸�
	}
	public Ex01() {
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex01("���� ���� ù ����");
	}
	
}
