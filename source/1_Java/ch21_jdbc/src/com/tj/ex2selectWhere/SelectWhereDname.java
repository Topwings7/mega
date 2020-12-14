package com.tj.ex2selectWhere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ��̸��� ?");
		String dname = sc.nextLine();
		String sql = "SELECT * FROM DEPT WHERE DNAME='"+dname+"'";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME='%s'", dname);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url,"scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs = stmt.executeQuery(sql); // 4+5
			if(rs.next()) { // 6
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("�Է��Ͻ� �μ� ��ȣ : "+deptno);
				System.out.println("�Է��Ͻ� �μ� �̸� : "+dname);
				System.out.println("�Է��Ͻ� �μ� ��ġ : "+loc);
			}else {
				System.out.println("��ȿ���� �ʴ� �μ��̸��Դϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"����̹� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL ����");
		}finally {
			try { //7.��������
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {  }
		}
	}
}






