package com.tj.ex2_thread;
// ThreadEx threadA = new ThreadEx();
// threaA.setName("A")
// => ThreadEx threadA = new ThreadEx("A");
public class ThreadEx extends Thread{
	public ThreadEx() {}
	public ThreadEx(String name) {
		super(name); // ������ �̸��� ���
	}//������
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("ThreadEx");
		for(int i = 0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName()+"�������� i = "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}// for
	}
}//class
