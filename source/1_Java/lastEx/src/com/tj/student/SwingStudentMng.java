package com.tj.student;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class SwingStudentMng extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel    jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames; // �޺��ڽ��� �� ��������Ʈ�� ���� vector
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate;
	private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private String driver;
	private String url;
	private Connection        conn;
	private PreparedStatement pstmt;
	private ResultSet         rs;
	ArrayList<StudentDTO> students;
	ArrayList<StudentDTO2> students2;
	public SwingStudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		students = new ArrayList<StudentDTO>();     //db
		students2 = new ArrayList<StudentDTO2>();   //db
		driver= "oracle.jdbc.driver.OracleDriver";  //db
		url ="jdbc:oracle:thin:@127.0.0.1:1521:xe"; //db
		contenPane = getContentPane(); // ȭ�鱸��
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = new Vector<String>();
		mNames.add("");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement("SELECT MNAME FROM MAJOR");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mNames.add(rs.getString("mname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}// try-catch-finally
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		btnInput       = new JButton("�л��Է�");
		btnUpdate      = new JButton("�л�����");
		btnStudentOut  = new JButton("�л����");
		btnExpelOut  = new JButton("���������");
		btnExpel     = new JButton("����ó��");
		btnExit      = new JButton("����");
		txtPool      = new JTextArea(10, 50);
		scrollPane   = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200,150);
		setVisible(true);
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSNoSearch) { //�й��˻�
			String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M "+ 
					"    WHERE S.MNO=M.MNO AND SNO=?";
			String sNo = txtSNo.getText().trim();
			if(!sNo.equals("")) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sNo);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						txtSName.setText(rs.getString("sName"));
						comMname.setSelectedItem(rs.getString("mname"));
						txtScore.setText(rs.getString("score"));
						txtPool.setText(sNo+"�˻� �Ϸ�");
					}else {
						txtSName.setText("");
						comMname.setSelectedItem("");
						txtScore.setText("");
						txtPool.setText("���� �й��Դϴ�");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e1) { }
				}
			}else {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�й��� �Է� �� �й� �˻��� �ϼ���");
			}
		}else if(e.getSource()==btnSNameSearch) { // �̸��˻�
			String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M " + 
					"    WHERE S.MNO=M.MNO AND SNAME=?";
			String sName = txtSName.getText().trim();
			if(sName.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sName);
					rs = pstmt.executeQuery();
					students2.clear();
					while(rs.next()) {
						String sNo   = rs.getString("sNo");
						String mName = rs.getString("mName");
						int score    = rs.getInt("score");
						txtSNo.setText(sNo);
						txtSName.setText(sName);
						comMname.setSelectedItem(mName);
						txtScore.setText(String.valueOf(score));
						students2.add(new StudentDTO2(sNo, sName, mName, score));
						txtPool.setText("");
					}
					if(students2.size()==0) {
						txtPool.setText("�ش� �̸��� �л��� �����ϴ�");
						txtSNo.setText("");
						comMname.setSelectedItem("");
						txtScore.setText("");
					}else if(students2.size()>1) {
						txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
						txtPool.append("\t����������������������������������������������������\n");
						for(StudentDTO2 s : students2) {
							txtPool.append("\t"+s.toString()+"\n");
						}
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e1) { }
				}
			}else {
				txtSNo.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�̸��� �Է��ϰ� �˻��ؾ���");
			}
		}else if(e.getSource()==btnMNameSearch) { // �����˻�
			String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME, SCORE " + 
					"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M  " + 
					"            WHERE S.mNO=m.mNO AND mNAME=?" + 
					"            ORDER BY SCORE DESC)";
			String mName = comMname.getSelectedItem().toString();
			if(!mName.equals("")) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					rs = pstmt.executeQuery();
					students.clear();
					while(rs.next()) {
						int rank      = rs.getInt("rank");
						String nameNo = rs.getString("name_no");
						mName = rs.getString("mNAME");
						int score         = rs.getInt("score");
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if(students.size()!=0) {
						txtPool.setText("\t�й�\t�̸�\t\t�а���\t����\n");
						txtPool.append("\t����������������������������������������������������������������\n");
						for(StudentDTO s : students) {
							txtPool.append("\t"+s.toString()+"\n");
						}
					}else {
						txtPool.setText("�ش� �л��� �����ϴ�");
					}					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(rs   != null) rs.close();
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("������ �����ϰ� �˻��ؾ���");
			}
		}else if(e.getSource()==btnInput) {//�л��Է�
			String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES " + 
					"    (TO_CHAR(SYSDATE, 'YYYY') " + 
					"    ||(SELECT mNO FROM MAJOR WHERE mNAME= ? ) " + 
					"    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')), " + 
					"    ?, (SELECT mNO FROM MAJOR WHERE mNAME=?), ?)";
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			if(sName.length()!=0 && mName.length()!=0) {
				int score = 0;
				try {
					score = Integer.parseInt(txtScore.getText());
					if(score<0 || score>100) {
						System.out.println("��ȿ�� ������ �ƴϸ� 0�� ó��");
						score = 0;
					}
				}catch (Exception e1) {
					System.out.println("������ �Է��� �� �ϰų� �����̸� 0�� ó��");
				}
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					pstmt.setString(2, sName);
					pstmt.setString(3, mName);
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate();
					txtPool.setText(result>0? "�л��Է¼���":"�л��Է½���");
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�л��Է½� �й�, �̸�, ������ �Է��ؾ���");
			}
		}else if(e.getSource()==btnUpdate) {//�л� ����
			String sql = "UPDATE STUDENT SET  sNAME=?, " + 
					"   		mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?)," + 
					"       	SCORE = ?" + 
					"       WHERE SNO=?";
			String sNo = txtSNo.getText().trim();
			String sName = txtSName.getText().trim();
			if(sNo.length()!=0 && sName.length()!=0 && comMname.getSelectedIndex() !=0) {
				int score = 0;
				try {
					score = Integer.parseInt(txtScore.getText());
					if(score<0 || score>100) {
						System.out.println("��ȿ�� ������ �ƴϸ� 0�� ó��");
						score = 0;
					}
				}catch (Exception e1) {
					System.out.println("������ �Է��� �� �ϰų� �����̸� 0�� ó��");
				}
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sName);
					pstmt.setString(2, comMname.getSelectedItem().toString());
					pstmt.setInt(3, score);
					pstmt.setString(4, sNo);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "�л���������":"�л���������");
					txtPool.setText(result>0? "�л���������":"�л���������");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�л������� �й�, �̸�, ������ �Է��ؾ���");
			}
		}else if(e.getSource()==btnStudentOut) {//�л����(����������)
			String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME, SCORE " + 
					"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M " + 
					"            WHERE S.mNO=m.mNO AND sEXPEL=0 " + 
					"            ORDER BY SCORE DESC)";
			try {
				conn = DriverManager.getConnection(url, "scott","tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				students.clear();
				while(rs.next()) {
					int    rank    = rs.getInt("rank");
					String nameNo = rs.getString("name_no");
					String mName   = rs.getString("mname");
					int    score   = rs.getInt("score");
					students.add(new StudentDTO(rank, nameNo, mName, score));
				}
				if(!students.isEmpty()) {
					txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
					txtPool.append("\t��������������������������������������������������������������\n");
					for(StudentDTO s : students) {
						txtPool.append("\t"+s.toString()+"\n");
					}
				}else {
					txtPool.setText("\t �ش� �л��� �����ϴ�");
				}					
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e1) {System.out.println(e1.getMessage());}
			}
		}else if(e.getSource()==btnExpelOut) {//������ ���
			String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME, SCORE " + 
					"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M " + 
					"            WHERE S.mNO=m.mNO AND sEXPEL=1 " + 
					"            ORDER BY SCORE DESC)";
			try {
				conn = DriverManager.getConnection(url, "scott","tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				students.clear();
				while(rs.next()) {
					int    rank    = rs.getInt("rank");
					String nameNo = rs.getString("name_no");
					String mName   = rs.getString("mname");
					int    score   = rs.getInt("score");
					students.add(new StudentDTO(rank, nameNo, mName, score));
				}
				if(!students.isEmpty()) {
					txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
					txtPool.append("\t������������������������������������������������������������\n");
					for(StudentDTO s : students) {
						txtPool.append("\t"+s.toString()+"\n");
					}
				}else {
					txtPool.append("\t �ش� �л��� �����ϴ�");
				}					
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e1) {System.out.println(e1.getMessage());}
			}
		}else if(e.getSource()==btnExpel) { // ����ó��
			String sql = "UPDATE STUDENT SET sEXPEL = 1 WHERE SNO = ?";
			String sNo = txtSNo.getText().trim();
			if(sNo.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sNo);
					int result = pstmt.executeUpdate();
					if(result>0) {
						System.out.println("����ó�� ����");
						txtPool.setText("����ó�� ����");
					}else {
						System.out.println("�ش� �й��� ���� ����ó�� �Ұ�");
						txtPool.setText("�ش� �й��� ���� ����ó�� �Ұ�");
					}
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�й��� �Է��ϰ� ����ó���ؾ���");
			}
		}else if(e.getSource()==btnExit) {// ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingStudentMng("�л����");
	}
}
