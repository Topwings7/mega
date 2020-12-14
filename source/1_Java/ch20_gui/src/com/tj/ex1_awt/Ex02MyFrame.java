package com.tj.ex1_awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex02MyFrame extends Frame implements ActionListener{
	private Label lbl1;
	private Button btnExit;
	// ������ - ȭ�鱸��
	public Ex02MyFrame(String name) {
		super(name);
		setLayout(new FlowLayout());
		//setLayout(new GridLayout(1,2)); // 1�� 2��¥�� �׸��巹�̾ƿ�
		lbl1 = new Label("��ſ� ȭ����");
		btnExit = new Button("����");
		lbl1.setPreferredSize(new Dimension(250,200));
		btnExit.setPreferredSize(new Dimension(200, 200));
		setSize(new Dimension(500, 300));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		btnExit.addActionListener(this); // �̺�Ʈ ó���� �ſ�.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex02MyFrame() {
		this("");
	}
	// �̺�Ʈó�� - Ŭ���� ���ض� 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex02MyFrame("���� ����");
	}
	
}
