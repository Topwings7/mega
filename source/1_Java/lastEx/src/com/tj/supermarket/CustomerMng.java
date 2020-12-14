package com.tj.supermarket;
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
public class CustomerMng extends JFrame implements ActionListener{
	//Swing
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField jtxtId, jtxtTel, jtxtName, jtxtPoint, jtxtAmount;
	private Vector<String> levels;
	private JComboBox<String> jcomLevel;
	private JButton jbtnTelSearch, jbtnNameSearch, jbtnPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAllOutput, 
				jbtnInsert, jbtnTelUpdate, jbtnDelete, jbtnExit;
	private JTextArea jtxtPool;
	private JScrollPane scrollPane;
	//JDBC ���� ����
	private String driver;
	private String url;
	private Connection        conn;
	private PreparedStatement pstmt;
	private ResultSet         rs;
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();
		jtxtId = new JTextField(20);
		jtxtTel = new JTextField(20);
		jtxtName = new JTextField(20);
		jtxtPoint = new JTextField(20);
		jtxtAmount = new JTextField(20);
		levels = new Vector<String>();
		levels.add("");
		// �̺κ� ��� db���� LEVELNAME�� ������ vector�� add : 1�ܰ� ~ 7�ܰ�
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			Class.forName(driver); // 1�ܰ�
			conn = DriverManager.getConnection(url,"scott","tiger");//2�ܰ�
			pstmt = conn.prepareStatement(sql); // 3�ܰ�
			rs = pstmt.executeQuery(); // 4+5�ܰ�
			while(rs.next()) { //6�ܰ�
				levels.add(rs.getString("levelname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7�ܰ�
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}// levels ���Ϳ� LEVENAME�� add
		jcomLevel = new JComboBox<String>(levels);
		jbtnTelSearch = new JButton("��4�ڸ�(FULL) �˻�");
		jbtnNameSearch = new JButton("�� �̸� �˻�");
		jbtnPoint = new JButton("����Ʈ�θ� ����");
		jpup.add(new JLabel(" �� �� �� ",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtId);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("�� �� �� ȭ",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("�� �� �� ��",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("��  ��  Ʈ",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("�� �� �� ��",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));//�� �� �߰��ϴ� �κ�
		jpup.add(new JLabel("�� �� �� ��",(int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		jbtnBuy = new JButton("��ǰ ����");
		jbtnLevelOutput = new JButton("��޺����");
		jbtnAllOutput = new JButton("��ü���");
		jbtnInsert = new JButton("ȸ������");
		jbtnTelUpdate = new JButton("��ȣ����");
		jbtnDelete = new JButton("ȸ��Ż��");
		jbtnExit = new JButton("������");
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAllOutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelUpdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		jtxtPool = new JTextArea(6, 60);
		scrollPane = new JScrollPane(jtxtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setSize(new Dimension(750, 370));setLocation(200, 200);
		setVisible(true);
		jtxtPool.setText("\t�� �� �� ���˻� �� �����ϼ��� �� �� ��");
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAllOutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelUpdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
		jtxtPoint.setFocusable(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		if(e.getSource()==jbtnTelSearch) { // ����ȣ �˻�
			String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"        (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO !=5) LEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L " + 
				"    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||?";
			String ctel = jtxtTel.getText().trim();
			if(ctel.length() >= 4) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						int cid = rs.getInt("cid");
						ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
						jtxtId.setText(String.valueOf(cid));
						jtxtTel.setText(ctel);
						jtxtName.setText(cname);
						jtxtPoint.setText(String.valueOf(cpoint));
						jcomLevel.setSelectedItem(levelname);
					}
					jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ ������ �ݾ�\n");
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					if(customers.size()==0) {
						jtxtPool.append("�ش� ��ȭ��ȣ�� �����ϴ�");
						jtxtId.setText("");
						jtxtTel.setText("");
						jtxtName.setText("");
						jtxtPoint.setText("");
						jcomLevel.setSelectedIndex(0);
					}else {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try{
						if(rs!=null) rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("��� ��4�ڸ� �̻� �Է��Ͻð� �˻��ϼ���");
			}//�� ��4�ڸ��� �Է��ߴ��� if 
		}else if(e.getSource()==jbtnNameSearch) { // �̸��˻�
			String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO!=5) LEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO AND cNAME=?";
			String cname = jtxtName.getText().trim();
			if(cname.length()!=0) {
				try {
					conn=DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cname);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						int cid = rs.getInt("cid");
						String ctel = rs.getString("ctel");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
						jtxtId.setText(String.valueOf(cid));
						jtxtTel.setText(ctel);
						jtxtName.setText(cname);
						jtxtPoint.setText(String.valueOf(cpoint));
						jcomLevel.setSelectedItem(levelname);
					}
					jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ ������ �ݾ�\n");
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					if(!customers.isEmpty()) {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
					}else {
						jtxtPool.append("�ش� �̸��� ���� �����");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(rs!=null) rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("�̸��� �Է��Ͻ� �� �̸��˻��ϼ���");
			}//if �̸��Է� ����
		}else if(e.getSource()==jbtnPoint) { // ����Ʈ�� ����
			String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT-? WHERE cID=?";
			String cid = jtxtId.getText().trim();
			int cpoint = Integer.parseInt(jtxtPoint.getText());
			int camount = Integer.parseInt(jtxtAmount.getText());
			if(cpoint>=camount && cid.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, camount);
					pstmt.setString(2, cid);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("����Ʈ�θ� ���� ����");
						// ������ ����Ʈ�� DB���� �������� �ʰ� �׳� ����ؼ� ����
						jtxtPoint.setText(String.valueOf(cpoint-camount)); 
						jtxtAmount.setText("");
					}else {
						jtxtPool.setText("�ش� ID�� �����ϴ�");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(rs   !=null) rs.close(); 
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else { // ����Ʈ�� �� ���űݾ׺��� ���� ���
				jtxtPool.setText("id�� �˾ƾ� �ϰ�, ����Ʈ�� �����ϸ� ����Ʈ ������ �Ұ��ؿ�");
			}
		}else if(e.getSource()==jbtnBuy) { // ��ǰ����
			String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT+?*0.05, " + 
				"              cAMOUNT = cAMOUNT + ?, " + 
				"              LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L" + 
				"                         WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?)" + 
				"            WHERE cID=?";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				int camount = Integer.parseInt(jtxtAmount.getText().trim());
				int cid = Integer.parseInt(jtxtId.getText());
				pstmt.setInt(1, camount);
				pstmt.setInt(2, camount);
				pstmt.setInt(3, camount);
				pstmt.setInt(4, cid);
				pstmt.setInt(5, cid);
				int result = pstmt.executeUpdate();
				if(result>0) {
					jtxtPool.setText("��ǰ���� ����\n");
					int cpoint = Integer.parseInt(jtxtPoint.getText());
					int updatePoint = (int)(cpoint+camount*0.05);
					jtxtPoint.setText(String.valueOf(updatePoint));
					jtxtAmount.setText("");
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}finally {
				try{
					if(pstmt !=null) pstmt.close();
					if(conn  !=null) conn.close();
				}catch (Exception ignored) { }
			}//try-catch-finally

		}else if(e.getSource()==jbtnLevelOutput) {// ��޺����
			String sql = "SELECT CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
					"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO!=5) LEVELUP " + 
					"    FROM CUSTOMER C, CUS_LEVEL L" + 
					"    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=?";
			if(jcomLevel.getSelectedIndex()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, jcomLevel.getSelectedItem().toString());
					rs = pstmt.executeQuery();
					while(rs.next()) {
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
					}
					jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ �ݾ�\n");
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					if(!customers.isEmpty()) {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
						jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
						jtxtPool.append("�� "+customers.size()+"��");
					}else {
						jtxtPool.append("�ش� ���� �����ϴ�");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try{
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("����� ���� �� ��޺� ����� Ŭ���ϼ���");
			}
		}else if(e.getSource()==jbtnAllOutput) { // ��ü���
			String sql = "SELECT CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
					"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO!=5) LEVELUP" + 
					"    FROM CUSTOMER C, CUS_LEVEL L" + 
					"    WHERE C.LEVELNO=L.LEVELNO" + 
					"    ORDER BY CAMOUNT DESC";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String ctel = rs.getString("ctel");
					String cname = rs.getString("cname");
					int cpoint = rs.getInt("cpoint");
					int camount = rs.getInt("camount");
					String levelname= rs.getString("levelname");
					int levelup = rs.getInt("levelup");
					customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
				}
				jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ �ݾ�\n");
				jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
				if(!customers.isEmpty()) {
					for(CustomerDto c : customers)
						jtxtPool.append(c.toString());
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					jtxtPool.append("�� "+customers.size()+"��");
				}else {
					jtxtPool.append("���� �����ϴ�");
				}
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try{
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				}catch (Exception ignored) { }
			}//try-catch-finally
		}else if(e.getSource()==jbtnInsert) { // ȸ������
			String sql = "INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES " + 
							"    (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
			String ctel = jtxtTel.getText().trim();
			String cname = jtxtName.getText().trim();
			if(ctel.length()!=0 && cname.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					pstmt.setString(2, cname);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ȸ�����Լ����� �帳�ϴ�");
						jtxtPoint.setText("1000");
						jcomLevel.setSelectedIndex(1);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("��ȭ��ȣ�� �̸��� �Է��� ȸ�������� �����ؿ�");
			}// if ȸ�����Խ� ��ȭ��ȣ�� �̸��� �Է��ؾ� ����
		}else if(e.getSource()==jbtnTelUpdate) { // ����ȣ ����
			String sql = "UPDATE CUSTOMER SET cTEL=? WHERE cID=?";
			String cid = jtxtId.getText().trim();
			String ctel = jtxtTel.getText().trim();
			if(cid.length()!=0 && ctel.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					pstmt.setString(2, cid);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("��ȣ ������ �Ϸ�Ǿ����ϴ�");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("��ȭ��ȣ�� �̸��� �Է��� ��ȣ������ �����ؿ�");
			}// if ��ȣ������ ��ȭ��ȣ�� �̸��� �Է��ؾ� ����

		}else if(e.getSource()==jbtnDelete) { // ȸ��Ż��
			String sql = "DELETE FROM CUSTOMER WHERE cID=?";
			String cid = jtxtId.getText().trim();
			if(cid.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cid);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText(jtxtTel.getText().trim()+"�� ȸ�� Ż�� �Ϸ�Ǿ����ϴ�");
						jtxtId.setText("");
						jtxtTel.setText(""); jtxtName.setText(""); 
						jtxtPoint.setText(""); jcomLevel.setSelectedIndex(0);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("���̵� �־�� ȸ��Ż�� �����ؿ�");
			} // if ȸ��Ż��� ��ȭ��ȣ�� �ԷµǾ� �־�� ����

		}else if(e.getSource()==jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMng("������");
	}
}
