package com.tj.ex2_thread;
// "�ݰ����ϴ� 10��"�ϴ� target����
public class TargetEx02 extends Thread{
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("�ݰ����ϴ�.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
}
