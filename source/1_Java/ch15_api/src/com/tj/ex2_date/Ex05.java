package com.tj.ex2_date;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Ex05 {
	public static void main(String[] args) {
		// ����
		Calendar calNow = Calendar.getInstance();
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dateNow = new Date();
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", calNow);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", gcNow);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateNow);
		// Ư���� ���� (1990.12.11)
		GregorianCalendar gcThat   = new GregorianCalendar(1990, 11, 11);
		Date              dateThat1 = new Date(90, 11, 11);
		Date              dateThat2 = new Date(gcThat.getTimeInMillis());
		Date dateThat3 = new Date(new GregorianCalendar(1990,11,11).getTimeInMillis()); ///
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", gcThat);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateThat1);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateThat2);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateThat3);
	}
}
