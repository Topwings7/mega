package strategy3.modularization;

import strategy3.inter.GetSalary;
import strategy3.inter.JobLec;

public class Staff extends Person{
	private String part;
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobLec());     // ��ǰ ����
		setGet(new GetSalary());  // ��ǰ ����
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(��)"+part);
	}
}
