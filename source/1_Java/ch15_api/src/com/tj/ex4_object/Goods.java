package com.tj.ex4_object;
public class Goods {
	private String goodsCode;  // ��ǰ�ڵ�
	private String goodsName;  // ��ǰ�̸�
	private int    goodsPrice; // ��ǰ ����
	private int    stockNum;   // ������
	public Goods() {}
	// Goods g = new Goods("a01","�����",1500,10); sysout(g)
	public Goods(String goodsCode, String goodsName, int goodsPrice, int stockNum) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stockNum = stockNum;
	}
	// �����(a01) : 1500��.  ���10��
	@Override
	public String toString() {
		return goodsName+"("+goodsCode+") : "+goodsPrice+"��. ��� "+stockNum+"��";
	}
}
