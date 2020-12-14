package com.tj.ex2_swing;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Ex03 extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private ImageIcon i1, i2;
	private JButton   btnInput;
	private JButton   btnOutput;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private HashMap<String, Person> person;
	public Ex03(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());//��ü �����̳ʸ� flowLayout����
		jpup = new JPanel(new GridLayout(3, 2));
		//jpup.setLayout(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		txtName = new JTextField(15);
		txtPhone = new JTextField(15);
		txtAge = new JTextField(15);
		i1 = new ImageIcon("icon/bell.gif");
		btnInput = new JButton("�Է�", i1); // �̹��� �߰��� button
		i2 = new ImageIcon("icon/write.gif");
		btnOutput = new JButton("���",i1);
		textArea = new JTextArea(5, 30);
		scrollPane = new JScrollPane(textArea);
		person = new HashMap<String, Person>();
		jpup.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("�� ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtAge);
		jpdown.add(btnInput);
		jpdown.add(btnOutput);
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollPane);
		setVisible(true);
		//setSize(new Dimension(200, 400));
		//setLocation(100, 100);
		setBounds(100, 100, 400, 320);
		btnInput.addActionListener(this); // �̺�Ʈ ó���� ������Ʈ�� �߰�
		btnOutput.addActionListener(this);
	}
	public static void main(String[] args) {
		new Ex03("GUI ����");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			// txtName, txtPhone, txtAge�� person�� �߰�
			String name, phone; int age=0;
			name = txtName.getText().trim();
			phone = txtPhone.getText().trim();
			try {
				age = Integer.parseInt(txtAge.getText().trim());
			}catch (NumberFormatException excep) {
				textArea.setText("������ Ÿ���� ��ȿ���� �ʾ� �Է� ����");
				return;
			}
			if(name.equals("") || phone.equals("")) {
				textArea.setText("�̸��� ��ȭ��ȣ�� �Է����� �ʾ� �Է� ����");
				return;
			}
			if(age>150 || age<0) {
				textArea.setText("��ȿ���� �ʴ� ���̴� �Է� ����");
				return;
			}
			// person(hashmap)�� ���� phone�� �ִ��� �˻�
			int idx = 0; // phone�̶� ���� ��ȣ�� �ִ��� ������ Ȯ�ο�
			Iterator<String> iterator = person.keySet().iterator();
			// 010-9999-9999, ȫ�浿��ü
			// 010-8888-8888, ��浿��ü
			while(iterator.hasNext()) {
				String tempPhone = iterator.next();
				if(tempPhone.equals(phone)) {
					break;
				}
				idx++;
			}
			if(idx < person.size()) { // tempPhone�� phone�� ���Ƽ� break�Ǽ� ���� ���
				textArea.setText("�ߺ��� ��ȭ��ȣ�� �־ �Է� ����");
				return;
			}
			Person p = new Person(name, phone, age);
			person.put(phone, p); // person(hashmap)�� �߰�
			textArea.setText(p.toString() + "�Է� ����");
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
		}else if(e.getSource()==btnOutput) {
			// person �� ���� ��°� �ܼ�â, textArea�� ���
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex2_swing/person.txt");
				Iterator<String> iterator = person.keySet().iterator();
				textArea.setText("");
				while(iterator.hasNext()) {
					String tempPhone = iterator.next();
					Person p = person.get(tempPhone);
					System.out.println(p);         // �ܼ����
					textArea.append(p.toString()); // textArea�� ���
					writer.write(p.toString());    // ���� ���
				}
				System.out.println(person.size()+"�� �Էµ�"); // �ֿܼ��� ��� �Է����� ���
				textArea.append(person.size()+"�� �Էµ�");    // textArea���� ��� �ԷµǾ����� ���
				writer.write(person.size()+"�� �Էµ�");       // ���Ͽ��� ��� �ԷµǾ����� ���
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(writer!=null) writer.close();
				}catch (Exception e1) { }
			}
			
		}		
	}
}













