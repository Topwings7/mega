package com.tj.ex2selectWhere;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SelectWhereDeptno2 {
	// 1.����ڿ��� �μ���ȣ�� ����� 
	// 2-1. �ش�μ���ȣ�� ������ �ش�μ��̸�, �ش�μ���ġ �����, �ش�μ� ����� ���.
	// 2-2. �ش�μ���ȣ�� ������ �ش�μ���ȣ�� ���ٰ� ���
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ���ϴ� �μ���ȣ�� ? ");
		int deptno = sc.nextInt();
		String query1 = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String query2 = "SELECT * FROM EMP WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs   = stmt.executeQuery(query1); // 4+5
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc   = rs.getString("loc");
				System.out.println("���ϴ� �μ���ȣ : "+deptno);
				System.out.println("���ϴ� �μ��̸� : "+dname);
				System.out.println("���ϴ� �μ���ġ : "+loc);
				rs.close();
				rs = stmt.executeQuery(query2);
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						System.out.println(empno+"\t"+ename+"\t"+hiredate);
					}while(rs.next());
				}else {
					System.out.println(deptno+"�� �μ� ����� �����ϴ�");
				}
			}else {
				System.out.println("��ȿ���� �ʴ� �μ���ȣ�Դϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7.��������
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {  }
		}
	}
}








