package com.tj.ex1_awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Ex04Frame extends Frame implements ActionListener{
	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List   list;
	public Ex04Frame() {
		// ������Ʈ ��ü ����
		panel = new Panel(new FlowLayout());
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		setLocation(300, 200);
		btnOk.addActionListener(this); // �̺�Ʈ�߰�
		btnExit.addActionListener(this);
	}
	public Ex04Frame(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==btnOk) {
			// txtField.getText()�� list�� add
			list.add(txtField.getText());
			// txtField�� text�� ""
			txtField.setText("");
		}
	}
	public static void main(String[] args) {
		new Ex04Frame("���� ������Ʈ ����");
	}
	
}
