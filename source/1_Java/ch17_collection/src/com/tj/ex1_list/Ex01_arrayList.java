package com.tj.ex1_list;
import java.util.ArrayList;
public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3]; // ��Ʈ�� �迭
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		array[1] = "1111";
		for(int idx=0 ; idx<array.length ; idx++) {
			System.out.println(idx+"��° "+array[idx]);
		}
		
		ArrayList<String> arrayList = new ArrayList<String>(); // ��Ʈ�� arrayList
		arrayList.add("str0"); // 0�� �ε���
		arrayList.add("str1"); // 1�� �ε���
		arrayList.add("str2"); // 2�� �ε���
		arrayList.add(1, "str111111111"); 
		arrayList.set(1, "11111111");
		for(int idx=0 ; idx<arrayList.size() ; idx++) {
			System.out.println(idx+"��° "+arrayList.get(idx));
		}
		arrayList.remove(1); // 1�� �ε��� arrayList�� ����
		System.out.println(arrayList.toString());
		arrayList.clear(); // arrayList�� ��� �����͸� ���� (size()�� 0����)
		if(arrayList.isEmpty()) {
			System.out.println("arrayList.clear()��");
		}
		arrayList = null;
		arrayList.add("str");
	}
}





