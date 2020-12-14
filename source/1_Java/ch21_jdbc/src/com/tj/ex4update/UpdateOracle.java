package com.tj.ex4update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �μ���ȣ�� ? ");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT count(*) FROM DEPT WHERE DEPTNO="+deptno;
		selectSQL = String.format("SELECT COUNT(*) FROM DEPT WHERE DEPTNO=%d", deptno);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt==1) { // �μ���ȣ�� �����ϴ� ��� : �����۾�
				System.out.print("�����ϰ��� �ϴ� �μ��̸��� ? ");
				String dname = sc.next();
				System.out.print("�����ϰ��� �ϴ� �μ���ġ�� ? ");
				String loc = sc.next();
				String updateSQL = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc
									+"' WHERE DEPTNO="+deptno;
				updateSQL = String.format(
						"UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d",
																dname, loc, deptno);
				int result = stmt.executeUpdate(updateSQL);
				System.out.println(result>0? deptno+"�μ���ȣ ���� ����":"��������");
			}else { // �ش�μ���ȣ�� �������� �ʴ� ���
				System.out.println("�������� �ʴ� �μ���ȣ�� ���� �Ұ�");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {}
		}
		
	}
}






