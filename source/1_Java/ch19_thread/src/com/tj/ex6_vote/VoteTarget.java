package com.tj.ex6_vote;
import java.util.Random;
public class VoteTarget implements Runnable{
	private int count; // ��ǥ��
	private Random random;
	private final int TARGETCOUNT = 100;
	private StringBuilder graph;
	public VoteTarget() {
		count = 0;
		random = new Random();
		graph = new StringBuilder();
	}
	@Override
	public void run() {
		while(true) {
			// count(��ǥ��)�� random.nextInt(10)��ŭ �ø���
			count += random.nextInt(10);
			if(count>=TARGETCOUNT) {
				count = TARGETCOUNT;
				// count ��ŭ �� ����� �ڡڡڡڡ�...�ڡڡ�
				graph.delete(0, graph.toString().length());  //graph �� �� �����
				for(int i = 0 ; i<count ; i++) {
					graph.append('��');
				}
				// �����̸�(�������̸�) count(��ǥ��), graph(��)�� ���
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% ��ǥ "+ graph);
				break;
			}
			// count ��ŭ �� �����
			graph.delete(0, graph.toString().length());  //graph �� �� �����
			for(int i = 0 ; i<count ; i++) {
				graph.append('��');
			}
			// �����̸�(�������̸�) count(��ǥ��), graph(��)�� ���
			System.out.println(Thread.currentThread().getName()+"\t"+count+"% ��ǥ "+ graph);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}

















