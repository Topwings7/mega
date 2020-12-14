package com.tj.ex2_date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
public class Sawon1 {
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	private String no; // d102-01
	private String name;
	private String part;//COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES
	private Date enterDate;
	// Sawon1 kim = new Sawon1("d102-01","ȫ�浿","PLANNING");
	public Sawon1(String no, String name, String part) {
		this.no = no; this.name = name; this.part = part;
		enterDate = new Date();
	}
	// Sawon1 yi = new Sawon1("d102-02", "ȫ","DESIGN",1990,12,11);
	public Sawon1(String no, String name, String part, int year, int month, int day) {
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










