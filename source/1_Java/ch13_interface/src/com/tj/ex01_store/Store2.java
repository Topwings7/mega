package com.tj.ex01_store;
//��ġ�-5,000  �δ��-5,000(��)  �����-5,000(��) ���뱹-5,000  �����-����(��)
public class Store2 implements HeadQuarterStore{
	private String str = "���а� 2ȣ��";
	@Override
	public void kimchi() {System.out.println("��ġ� 5,000��");}
	@Override
	public void bude() {System.out.println("�δ�� 5,000��");}
	@Override
	public void bibib() {System.out.println("����� 5,000��");}
	@Override
	public void sunde() {System.out.println("���뱹 5,000��");}
	@Override
	public void gongibab() {System.out.println("����� ����");}
	public String getStr() {
		return str;
	}
}
