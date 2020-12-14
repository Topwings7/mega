package com.tj.ex2_date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
public class Sawon2 {
	private String no; // d102-01
	private String name;
	private PartType part;//COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES
	private Date enterDate;
	// Sawon1 kim = new Sawon1("d102-01","ȫ�浿",PartType.COMPUTER);
	public Sawon2(String no, String name, PartType part) {
		this.no = no; this.name = name; this.part = part;
		enterDate = new Date();
	}
	// Sawon1 yi = new Sawon1("d102-02", "ȫ","DESIGN",1990,12,11);
	public Sawon2(String no, String name, PartType part, int year, int month, int day) {
		this.no = no; this.name = name; this.part = part;
		//enterDate = new Date(year-1900, month-1, day);
		enterDate = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	public String infoString() {
		// [���]d102-02 [�̸�]ȫ [�μ�]DESIGN [�Ի���]1990��2��2��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��M��d��");
		String enterDateStr = sdf.format(enterDate);
		return "[���]"+no+" [�̸�]"+name+" [�μ�]"+part+" [�Ի���]"+enterDateStr;
	}
}










