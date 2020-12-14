package com.tj.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class ConsoleStudentMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		String fn = "";
		ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement         stmt  = null;
		ResultSet         rs    = null;
		String sName, mName; int score;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.print("1:�Է�, 2:�а������, 3:��ü���, �׿�:����");
			fn = sc.next();
			switch(fn) {
			case "1" : // �Է��۾�(�̸�,�а���,������ �޾� insert)
				String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES" + 
						"    (TO_CHAR(SYSDATE, 'YYYY')" + 
						"    ||(SELECT mNO FROM MAJOR WHERE mNAME = ?)" + 
						"    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000'))," + 
						"    ?,(SELECT mNO FROM MAJOR WHERE mNAME=?), ?) ";
				System.out.print("�Է��� �л� �̸� ?");
				sName = sc.next();
				System.out.print("�а��� ? ");
				mName = sc.next();
				System.out.print("���� ? ");
				score = sc.nextInt();
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");//2
					pstmt = conn.prepareStatement(sql);//3
					pstmt.setString(1, mName);
					pstmt.setString(2, sName);
					pstmt.setString(3, mName);
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate(); // 4+5
					System.out.println(result>0 ? sName+"�Է� ����":"�Է½���"); // 6
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try { //7
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (Exception e) {}
				}
				break;
			case "2" : // �а��� ���(�а����� �Է¹޾� �ش��а� �л� ��� students �̿�)
				sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE" + 
						"    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND mNAME=?" + 
						"            ORDER BY SCORE DESC)";
				System.out.print("����� ���ϴ� �а��̸��� ? ");
				mName = sc.next();
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");//2�ܰ�
					pstmt = conn.prepareStatement(sql); // 3�ܰ�
					pstmt.setString(1, mName);
					rs = pstmt.executeQuery();
					students.clear(); //students�� �ִ� ���� ��� ���� size=0����
					while(rs.next()) {
						int rank      = rs.getInt("rank");
						String nameNo = rs.getString("name_no");
						mName         = rs.getString("mName");
						score         = rs.getInt("score");
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if(students.size()!=0) { // �����Ͱ� ����
						System.out.println("���\t�̸�(nameNO)\t�а�\t����");
						System.out.println("----------------------------------------------------");
						for(StudentDTO s : students) {
							System.out.println(s);
						}
					}else {
						System.out.println("�ش� �а� �л��� �����ϴ�");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try { //7
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (Exception e) {}
				}
				
				break;
			case "3" : // ��ü ��� (students �̿�)
				sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE" + 
						"    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0" + 
						"            ORDER BY SCORE DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott","tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					students.clear();
					while(rs.next()) {
						int rank      = rs.getInt("rank");
						String nameNo = rs.getString("name_no");
						mName         = rs.getString("mName");
						score         = rs.getInt("score");
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if(!students.isEmpty()) {
						System.out.println("���\t�̸�(nameNO)\t�а�\t����");
						System.out.println("----------------------------------------------------");
						for(StudentDTO s : students) {
							System.out.println(s);
						}
					}else {
						System.out.println("�л��� �����ϴ�.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try { //7
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (Exception e) {}
				}
				break;
			}
		}while(fn.equals("1") || fn.equals("2")||fn.equals("3"));
		System.out.println("�ȳ�");
	}
}








