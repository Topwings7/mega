package strategy3.modularization;

import strategy3.inter.GetSalary;
import strategy3.inter.JobLec;

public class Gangsa extends Person {
	private String subject;
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());     // ��ǰ ����
		setGet(new GetSalary());  // ��ǰ ����
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(����)"+subject);
	}
}
