package com.tj.ex1_string;

public class Friend {
	private String name;
	private String tel;
	private String birth;
	public Friend(String name, String tel, String birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	public String infoString() {
		return "[�̸�]" + name + " [��ȭ]" + tel + " [����]" + birth;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
}
