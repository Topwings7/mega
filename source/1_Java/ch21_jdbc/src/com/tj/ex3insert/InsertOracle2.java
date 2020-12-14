package com.tj.ex3insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class InsertOracle2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է��ϰ��� �ϴ� �μ���ȣ��? ");
		int deptno = scanner.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs = stmt.executeQuery(selectSQL); // 4+5
			if(!rs.next()) { // �ߺ��� �μ���ȣ�� �ƴϸ� �߰��۾�(�μ��̸�,��ġ�޾� insert)
				System.out.print("�Է��� �μ��̸��� ? ");
				String dname = scanner.next();
				System.out.print("�Է��� �μ���ġ�� ? ");
				String loc = scanner.next();
				String insertSQL =String.format("INSERT INTO DEPT VALUES (%d, '%s','%s')", 
																	deptno, dname, loc);
				insertSQL = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"','"+loc+"')";
				int result = stmt.executeUpdate(insertSQL);
				System.out.println(result>0 ? "�μ��Է¼���":"�μ��Է½���");
				
			}else { // �ߺ��� �μ���ȣ�� �Է��� ���
				System.out.println("�ߺ��� �μ���ȣ�� �����մϴ�. �ٸ��μ���ȣ ���");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {}
		}
		
		
	}
}
