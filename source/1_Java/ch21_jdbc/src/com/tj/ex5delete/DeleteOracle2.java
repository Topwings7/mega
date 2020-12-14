package com.tj.ex5delete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteOracle2 {
	public static void main(String[] args) {
		// 1. ������ �μ���ȣ�� �Է¹޽��ϴ�
		// 2-1. �����ϴ� �μ���ȣ�� ��� : ��¥ �������� �����(Y/N) 
		             // 2-1-1 Y�� �Է����� ��� : �ش�μ���ȣ ����
					 // 2-1-2 N�� �Է����� ��� : ���α׷� ��
		// 2-2. �������� �ʴ� �μ���ȣ�� ��� : �������� �ʴ� �μ���ȣ�Դϴ� ���
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ��� �ϴ� �μ���ȣ�� ? ");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String deleteSQL = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if(rs.next()) {
				System.out.print(deptno+"�� ���� �����Ͻðڽ��ϱ�? ");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("y")) {
					int result = stmt.executeUpdate(deleteSQL);
					System.out.println(result>0? deptno+"�μ� ���� ����" : deptno+"�μ���������");
				}else if(answer.equalsIgnoreCase("n")) {
					System.out.println(deptno+"�� �������� �ʰڽ��ϴ�");
				}else {
					System.out.println("Y�� N�� �� ������ �� �϶�� ����");
				}
			}else {
				System.out.println("�������� �ʴ� �μ���ȣ�Դϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  != null) rs.close();
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()); 
			}// close try-catch
		}//try-catch-finally
	}//main
}//class
