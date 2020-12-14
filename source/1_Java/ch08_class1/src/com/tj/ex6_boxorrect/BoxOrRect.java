package com.tj.ex6_boxorrect;
// �ڽ� - ����, ����, ����     ���簢�� - ����, ����, 0
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume; // ���ǳ� ����
	public BoxOrRect() {}
	public BoxOrRect(int width, int height, int depth) { // �ڽ���ü ������ ȣ���� ������
		this.width = width; this.height = height; this.depth = depth;
	}
	public BoxOrRect(int width, int height) {
		this.width=width; this.height = height; // ���簢�� ��ü ������ ȣ���� ������
	}
	public void calVolume() {
		if(depth==0) { // ���簢���� ��� volume = width * height
			volume = width * height;
		}else { // �ڽ��� ��� volume = width*height*depth
			volume = width*height*depth;
		}//if
	}//calVolume
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}//class














