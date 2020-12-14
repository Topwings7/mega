package com.tj.ex3insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class InsertOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��ϰ��� �ϴ� �μ���ȣ�� ? ");
		int deptno = sc.nextInt();
		System.out.print("�Է��ϰ��� �ϴ� �μ��̸��� ? ");
		String dname = sc.next(); // �μ��̸����� space ���Ұ�
		System.out.print("�Է��ϰ��� �ϴ� �μ���ġ�� ? ");
		sc.nextLine(); // ���۸� ����� �뵵
		String loc = sc.nextLine();
		String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", 
													deptno, dname, loc);
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url,"scott","tiger");//2
			stmt = conn.createStatement();//3
			int result = stmt.executeUpdate(sql);//4+5
			System.out.println(result>0? "�Է¼���":"�Է½���");//6
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
	}
}







