package com.tj.ex08_super;
public class PersonMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("�ƺ���");
		papa.setCharacter("�׶���");
		papa.intro();
		Person mom = new Person("������","������");
		mom.intro();
		Baby child1 = new Baby();
		child1.setName("�Ʊ��1");
		child1.setCharacter("�Ϳ���");
		child1.intro();
		System.out.println("**********");
		Baby child2 = new Baby("�Ʊ��2","�ʹ��ʹ��Ϳ���");
		child2.intro();
	}
}
