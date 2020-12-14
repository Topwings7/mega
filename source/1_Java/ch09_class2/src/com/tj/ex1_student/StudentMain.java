package com.tj.ex1_student;
public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("���켺", 90, 90, 90);
		Student s2 = new Student("���ϴ�", 81, 90, 90);
		Student s3 = new Student("Ȳ����", 91, 90, 90);
		Student s4 = new Student("������", 80, 90, 90);
		Student s5 = new Student("������", 70, 90, 90);
		Student[] student = {s1, s2, s3, s4, s5};
		String[] title = {"�̸�","����","����","����","����","���"};
		int[] tot = new int[5];
		double[] avg = new double[5]; // ��� �濣 0.0 �ʱ�ȭ
		line(); // �������
		System.out.println("\t\t\t����ǥ");
		line('-',50); // --------------- 
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		line('-',50); // --------------- 
		for(Student s : student) {
			//s.print();
			System.out.println(s.infoString()); // �Ѱ�ü�� ���
			tot[0] += s.getKor(); // tot[0] = tot[0] + s.getKor()
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();
		}
		for(int idx=0 ; idx<avg.length ; idx++) { // ��յ� ���
			avg[idx] = tot[idx] / student.length;
		}
		line('-',50);
		System.out.print("\t����");
		for(int t : tot) {
			//System.out.print("\t "+t);
			System.out.printf("\t%4d", t);
		}
		System.out.print("\n\t���");
		for(double a : avg) {
			System.out.print("\t"+a);
		}
		System.out.println();
		line(); // �������
		
	}
	private static void line() {
		for(int i=0 ; i<65 ; i++) {
			System.out.print('��');
		}
		System.out.println();
	}
	private static void line(char ch, int cnt) {
		System.out.print("\t");
		for(int i=0 ; i<cnt ; i++) { // ���ٿ� cnt�� ch�� ���
			System.out.print(ch);
		}
		System.out.println(); // ����
	}
}
