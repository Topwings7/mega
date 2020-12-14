package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatementUpdateSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// �μ���ȣ�� �Է¹޾� �ִ� �μ���ȣ�̸� �����۾�(�μ��̸�, �μ���ġ�� �޾� ����)
		//                    ���� �μ���ȣ�̸� ���ٰ� ���
		String seleteSQL ="SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updateSQL = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �μ���ȣ�� ? ");
		int deptno = sc.nextInt();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			Class.forName(driver);//1�ܰ�
			conn = DriverManager.getConnection(url,"scott","tiger");//2�ܰ�
			pstmt = conn.prepareStatement(seleteSQL); //3�ܰ�
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();  // 4�ܰ� + 5�ܰ�
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt==1) {//�ִ� �μ���ȣ�� ��� �����۾�(�μ��̸�, �μ���ġ�� �޾� ����)
				System.out.print("������ �μ��̸��� ? ");
				String dname = sc.next();
				System.out.print("������ �μ���ġ�� ? ");
				String loc = sc.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(updateSQL); // 3�ܰ�
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate(); // 4�ܰ� + 5�ܰ�
				System.out.println(result>0? "��������":"��������");
			}else {
				System.out.println("�������� �ʴ� �μ���ȣ�Դϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {  // 7�ܰ�
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
	}
}
