package com.tj.ex2_date;
import java.util.Calendar;
import com.tj.ex1_string.Friend;
public class Ex06 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-16"),
				new Friend("ȫ�浿", "010-9999-9999", "01-11"),
				new Friend("ȫ�浿", "010-9999-9999", "12-16")};
		Calendar today = Calendar.getInstance(); 
		int month = today.get(Calendar.MONTH)+1;     // 1
		int day   = today.get(Calendar.DAY_OF_MONTH);// 1
		String monthStr = (month<10)? "0"+month : ""+month;
		String dayStr   = (day  <10)? "0"+day   : ""+day;   
		String todayStr = monthStr + "-" + dayStr;
		System.out.println("������ "+todayStr);
		boolean searchOk = false;
		for(Friend friend : friends) {
			String temp = friend.getBirth(); // �ش� index�� ��ü�� ���ϰ�
			if(temp.equals(todayStr)) {
				System.out.println(friend.infoString());
				searchOk = true;
			}
		}
		if(!searchOk) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
		
	}
}









