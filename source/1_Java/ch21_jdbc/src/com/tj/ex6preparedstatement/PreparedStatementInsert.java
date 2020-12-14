package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PreparedStatementInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �μ���ȣ ? ");
		String deptno = sc.next();
		System.out.print("�μ��̸��� ?");
		String dname = sc.next();
		System.out.print("��ġ�� ? ");
		String loc = sc.next();
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url,"scott","tiger"); //2
			//stmt = conn.createStatement(); - SQL������ ��ü(stmt) ����
			//int result = stmt.excuteUpdate(sql);  - SQL ���� + ����ޱ�
			pstmt = conn.prepareStatement(sql); // SQL������ ��ü(pstmt) ����
			pstmt.setString(1, deptno); // sql�� ù��° ? ó��
			pstmt.setString(2, dname);  // sql�� �ι�° ? ó��
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "����":"����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}









