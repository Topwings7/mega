package singletonclass1;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE;
	// ��ü�� ������ �ȵǾ� ������ �����ϰ�
	// ��ü������ ���� ������ �� ��ü�� �ּҸ� return
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	private SingletonClass() {}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
