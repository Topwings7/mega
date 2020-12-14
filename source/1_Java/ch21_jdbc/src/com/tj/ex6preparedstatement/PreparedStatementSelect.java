package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatementSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP " + 
				"    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=?)";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ��̸��� ? ");
		String dname = sc.next();
		try {
			Class.forName(driver);  //1�ܰ�
			conn = DriverManager.getConnection(url,"scott","tiger");//2�ܰ�
			pstmt = conn.prepareStatement(sql);//3�ܰ�
			pstmt.setString(1, dname); // ����ǥ ó��
			rs = pstmt.executeQuery(); // 4�ܰ�+5�ܰ�
			while(rs.next()) {         // 6�ܰ�
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				System.out.println(empno+"\t"+ename+"\t"+deptno);
			}
			System.out.println("Done");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {  // 7�ܰ�
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}









