package com.tj.ex7_personinfo;
public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("ȫ�浿", 20, 'm'),
							   new PersonInfo("ȫ���",19,'f')
		};
		for(PersonInfo p : person) {
			p.print();
		}
		for(int idx=0 ; idx<person.length ; idx++) {
			person[idx].print();
		}
		PersonInfo[] iperson = new PersonInfo[2];
		iperson[0] = new PersonInfo("ȫ�浿", 20, 'm');
		iperson[1] = new PersonInfo("ȫ���",19,'f');
		for(PersonInfo p : iperson) {
			p.print();
		}
	}
}
