package com.tj.ex11_store;
//��ġ�-5,000(��)  �δ��-5,000(��)  �����-6,000(��) ���뱹-���Ⱦ�(��) �����-1,000��(��)
public class Store1 extends HeadQuarterStore{
	private String str = "���ð�1ȣ��";
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 ���Ⱦ�");
	}
	@Override
	public String getStr() {
		return str;
	}
}
