package com.tj.studentmng;
import java.util.Scanner;
public class StudentMngMain {
	public static void main(String[] args) {
		Student[] students = {new Student(201901,"ȫ�浿",20,"���"),
							  new Student(201902,"��浿",20,"�濵"),
							  new Student(201903,"�ű浿",21,"�İ�"),
							  new Student(201904,"���浿",21,"���"),
							  new Student(201905,"�ڱ浿",20,"����")
		};
		Scanner scanner = new Scanner(System.in);
		int no;  // �˻��� �й�
		int idx; // �˻��� �й��� ����Ű�� index
		int fn;  // ��ɹ�ȣ 1:�й�����, 2:�̸�����, 3:���̼���, 4:��������
		String data; // �ٲ� �����Ͱ� �Էµ� ����
		for(Student s : students) {
			s.setAge(s.getAge()+9);
		}
		for(Student s : students) {
			System.out.println(s.infoString());
			//s.print();
		}
		while(true) {
			System.out.print("�ٲ� �л��� �й���(�� ���Ḧ ���ϸ� 0)?");
			no = scanner.nextInt();
			if(no==0) break;
			// �ٲٰ� ���� �л��� �й� �ް�
			// student[0] ~ student[4] no�� ���� �й��� �ִ��� �˻�
			for(idx=0 ; idx<students.length ; idx++) {
				if(students[idx].getNo()==no) {
					break; // ã�Ҵ�. idx��° �ִ� students[idx]�� ������ ����
				}
			}
			if(idx == students.length) {
				//��ã�� ���
				System.out.println("��ȿ���� ���� �й��� �Է��ϼ̽��ϴ�.");
				continue;
			}
			// ��ɹ�ȣ �ް� 1. 1~4 fn�� �Է��� ��� 2.��ȿ���� �ʴ� fn�� ���
			System.out.print("1:�й�����, 2:�̸�����, 3:���̼���, 4:��������. ���ϴ� ��ɹ�ȣ��?");
			fn = scanner.nextInt();
			if(fn>4 || fn<1) {
				System.out.println("��ȿ���� �ʴ� ��ɹ�ȣ�Դϴ�.");
				continue;
			}
			// �ٲ� ������ �ް�
			System.out.print("�ٲ� �����ʹ� ?");
			data = scanner.next(); // String �Է�(white space�������� String)
			// ������ ������ ��� - ���� - ������ ������ ���
			System.out.println("���� �� : "+students[idx].infoString());
			students[idx].modify(fn, data); // ����
			System.out.println("���� �� : "+students[idx].infoString());
		}
		System.out.println("�ȳ��� ������. ���� �����ʹ� ������ ���ƿ�");
		for(Student s : students) {
			System.out.println(s.infoString());
		}
	}
}















