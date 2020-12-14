package com.tj.ex13_homework;

public class Gangsa extends Person {
	private String department;
	public Gangsa() { }
	public Gangsa(String id, String name, String department){
		super(id,name);
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(�μ�)"+department;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(�μ�)"+department);
	}
}
