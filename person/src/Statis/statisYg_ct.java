package Statis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import DB.DBtoExcel;
import DB.jdbcUtil;

public class statisYg_ct extends JFrame {
	public statisYg_ct() {
		Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		TableModel tablemodel = null;
		JTable table = new JTable(tablemodel);
		DefaultTableModel defaultTableModel = null;
		JFrame framestaff = new JFrame("����Ա��");
		framestaff.setBounds(200, 100, 500, 500);
		try {

			conn = jdbcUtil.getSQLConn();
			conn.setAutoCommit(true);
			st = conn.createStatement();
			String sql = "select * from ���˽�ʦ union select * from ��ʦ��Ϣ where ��ְ��Ϣ='����' ";
			// ��ȡ�����Ԫ��1
			rs = st.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count++;
			}
			Object[][] obj = new Object[count][10];
			rs = st.executeQuery(sql);
			int i = 0;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				obj[i][0] = rs.getObject(1);
				obj[i][1] = rs.getObject(2);
				obj[i][2] = rs.getObject(3);
				obj[i][3] = rs.getObject(4);
				obj[i][4] = rs.getObject(5);
				obj[i][5] = rs.getObject(6);
				obj[i][6] = rs.getObject(7);
				obj[i][7] = rs.getObject(8);
				obj[i][8] = rs.getObject(9);
				obj[i][9] = rs.getObject(10);
				i++;
			}
			final JFrame f = new JFrame("���˽�ʦ");
			String[] Names = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����", "��ְ��Ϣ", "���ű��" };
			defaultTableModel = new DefaultTableModel(obj, Names);
			table = new JTable(defaultTableModel);
			table.setPreferredScrollableViewportSize(new Dimension(400, 800));
			JScrollPane scrollPane = new JScrollPane(table);
			f.add(scrollPane, BorderLayout.CENTER);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
			rs = st.executeQuery(sql);
			Vector columnName = new Vector(); // ����
			columnName.add("���");
			columnName.add("����");
			columnName.add("�Ա�");
			columnName.add("ѧ��");
			columnName.add("ְ��");
			columnName.add("ְ��");
			columnName.add("��ҵԺУ");
			columnName.add("����");
			columnName.add("��ְ��Ϣ");
			columnName.add("���ű��");
			new DBtoExcel().WriteExcel(rs, "E://statisYg_zc.xls", "���˽�ʦ", columnName);
			JButton jb1 = new JButton("������ͳ��");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("������ͳ��")) {
						final JFrame framestaff = new JFrame("������ͳ��ת����ʦ");
						framestaff.setBounds(200, 100, 500, 500);
						JButton jb1 = new JButton("���Ա�");
						JButton jb2 = new JButton("��ѧ��");
						JButton jb3 = new JButton("��ְ��");
						JButton jb4 = new JButton("��ְ��");
						JButton jb5 = new JButton("�����ű��");
						jb1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JFrame framestaff = new JFrame("�Ա�ͳ��");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("Ҫͳ�Ƶ��Ա�");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("ͳ��");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "������ͳ������");
										} else {
											Connection conn = null;
											java.sql.Statement st = null;
											ResultSet rs = null;
											TableModel tablemodel = null;
											JTable table = new JTable(tablemodel);
											DefaultTableModel defaultTableModel = null;
											try {
												conn = jdbcUtil.getSQLConn();
												conn.setAutoCommit(true);
												System.out.println("�Ѿ����ӵ����ݿ�...");
												String sql = "SELECT * FROM ���˽�ʦ  WHERE �Ա� LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM ��ʦ��Ϣ  WHERE �Ա� LIKE" + "'%" + c1 + "%'"+" and ��ְ��Ϣ='����'" ;
												st = conn.createStatement();
												rs = st.executeQuery(sql);
												int count = 0;
												while (rs.next()) {
													count++;
												}
												Object[][] obj = new Object[count][10];
												int i = 0;
												rs = st.executeQuery(sql);
												while (rs.next()) {
													obj[i][0] = rs.getObject(1);
													obj[i][1] = rs.getObject(2);
													obj[i][2] = rs.getObject(3);
													obj[i][3] = rs.getObject(4);
													obj[i][4] = rs.getObject(5);
													obj[i][5] = rs.getObject(6);
													obj[i][6] = rs.getObject(7);
													obj[i][7] = rs.getObject(8);
													obj[i][8] = rs.getObject(9);
													obj[i][9] = rs.getObject(10);
													i++;
												}
												final JFrame f = new JFrame("���˽�ʦͳ�ƽ��");
												String[] Names = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����",
														"��ְ��Ϣ", "���ű��" };
												defaultTableModel = new DefaultTableModel(obj, Names);
												table = new JTable(defaultTableModel);
												table.setPreferredScrollableViewportSize(new Dimension(400, 800));
												JScrollPane scrollPane = new JScrollPane(table);
												f.add(scrollPane, BorderLayout.CENTER);
												table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
										
												f.setBounds(300, 200, 800, 200);
												f.setUndecorated(true);
												f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
												f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
												f.setVisible(true);
												rs = st.executeQuery(sql);
												Vector columnName = new Vector(); // ����
												columnName.add("���");
												columnName.add("����");
												columnName.add("�Ա�");
												columnName.add("ѧ��");
												columnName.add("ְ��");
												columnName.add("ְ��");
												columnName.add("��ҵԺУ");
												columnName.add("����");
												columnName.add("��ְ��Ϣ");
												columnName.add("���ű��");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_xb.xls", "��ʦ��Ϣ_�Ա�",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("�쳣" + e1);
											} finally {
												jdbcUtil.close(rs, st, conn);
											}
										}
									}
								});
								JPanel jp1 = new JPanel();
								JPanel jp = new JPanel();
								jp1.add(jl1);
								jp1.add(jt1);
								jp.add(jb1);
								framestaff.setUndecorated(true);
								framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
								JPanel imagePanel = new JPanel();
								imagePanel = (JPanel) framestaff.getContentPane();
								imagePanel.setOpaque(false);
								imagePanel.setLayout(new GridLayout(7, 3));
								imagePanel.add(jp1);
								jp1.setOpaque(false);
								jp.setOpaque(false);
								framestaff.getLayeredPane().setLayout(null);
								framestaff.add(jp, BorderLayout.SOUTH);
								framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								framestaff.setVisible(true);
							}
						});

						jb2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JFrame framestaff = new JFrame("ѧ��ͳ��");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("Ҫͳ�Ƶ�ѧ��");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("ͳ��");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "������ͳ������");
										} else {
											Connection conn = null;
											java.sql.Statement st = null;
											ResultSet rs = null;
											TableModel tablemodel = null;
											JTable table = new JTable(tablemodel);
											DefaultTableModel defaultTableModel = null;
											try {
												conn = jdbcUtil.getSQLConn();
												conn.setAutoCommit(true);
												System.out.println("�Ѿ����ӵ����ݿ�...");
												String sql = "SELECT * FROM ���˽�ʦ  WHERE ѧ�� LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM ��ʦ��Ϣ  WHERE ѧ�� LIKE" + "'%" + c1 + "%'"+" and ��ְ��Ϣ='����'";
												st = conn.createStatement();
												rs = st.executeQuery(sql);
												int count = 0;
												while (rs.next()) {
													count++;
												}
												Object[][] obj = new Object[count][10];
												int i = 0;
												rs = st.executeQuery(sql);
												while (rs.next()) {
													obj[i][0] = rs.getObject(1);
													obj[i][1] = rs.getObject(2);
													obj[i][2] = rs.getObject(3);
													obj[i][3] = rs.getObject(4);
													obj[i][4] = rs.getObject(5);
													obj[i][5] = rs.getObject(6);
													obj[i][6] = rs.getObject(7);
													obj[i][7] = rs.getObject(8);
													obj[i][8] = rs.getObject(9);
													obj[i][9] = rs.getObject(10);
													i++;
												}
												final JFrame f = new JFrame("���˽�ʦͳ�ƽ��");
												String[] Names = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����",
														"��ְ��Ϣ", "���ű��" };
												defaultTableModel = new DefaultTableModel(obj, Names);
												table = new JTable(defaultTableModel);
												table.setPreferredScrollableViewportSize(new Dimension(400, 800));
												JScrollPane scrollPane = new JScrollPane(table);
												f.add(scrollPane, BorderLayout.CENTER);
												table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
												
												f.setBounds(300, 200, 800, 200);
												f.setUndecorated(true);
												f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
												f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
												f.setVisible(true);
												rs = st.executeQuery(sql);
												Vector columnName = new Vector(); // ����
												columnName.add("���");
												columnName.add("����");
												columnName.add("�Ա�");
												columnName.add("ѧ��");
												columnName.add("ְ��");
												columnName.add("ְ��");
												columnName.add("��ҵԺУ");
												columnName.add("����");
												columnName.add("��ְ��Ϣ");
												columnName.add("���ű��");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_xl.xls", "��ʦ��Ϣ_ѧ��",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("�쳣" + e1);
											} finally {
												jdbcUtil.close(rs, st, conn);
											}
										}
									}
								});
								JPanel jp1 = new JPanel();
								JPanel jp = new JPanel();
								jp1.add(jl1);
								jp1.add(jt1);
								jp.add(jb1);
								framestaff.setUndecorated(true);
								framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
								JPanel imagePanel = new JPanel();
								imagePanel = (JPanel) framestaff.getContentPane();
								imagePanel.setOpaque(false);
								imagePanel.setLayout(new GridLayout(7, 3));
								imagePanel.add(jp1);
								jp1.setOpaque(false);
								jp.setOpaque(false);
								framestaff.getLayeredPane().setLayout(null);
								framestaff.add(jp, BorderLayout.SOUTH);
								framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								framestaff.setVisible(true);
							}
						});

						jb3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JFrame framestaff = new JFrame("ְ��ͳ��");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("Ҫͳ�Ƶ�ְ��");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("ͳ��");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "������ͳ������");
										} else {
											Connection conn = null;
											java.sql.Statement st = null;
											ResultSet rs = null;
											TableModel tablemodel = null;
											JTable table = new JTable(tablemodel);
											DefaultTableModel defaultTableModel = null;
											try {
												conn = jdbcUtil.getSQLConn();
												conn.setAutoCommit(true);
												System.out.println("�Ѿ����ӵ����ݿ�...");
												String sql = "SELECT * FROM ���˽�ʦ  WHERE ְ�� LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM ��ʦ��Ϣ  WHERE ְ�� LIKE" + "'%" + c1 + "%'"+" and ��ְ��Ϣ='����'";
												st = conn.createStatement();
												rs = st.executeQuery(sql);
												int count = 0;
												while (rs.next()) {
													count++;
												}
												Object[][] obj = new Object[count][10];
												int i = 0;
												rs = st.executeQuery(sql);
												while (rs.next()) {
													obj[i][0] = rs.getObject(1);
													obj[i][1] = rs.getObject(2);
													obj[i][2] = rs.getObject(3);
													obj[i][3] = rs.getObject(4);
													obj[i][4] = rs.getObject(5);
													obj[i][5] = rs.getObject(6);
													obj[i][6] = rs.getObject(7);
													obj[i][7] = rs.getObject(8);
													obj[i][8] = rs.getObject(9);
													obj[i][9] = rs.getObject(10);
													i++;
												}
												final JFrame f = new JFrame("���˽�ʦͳ�ƽ��");
												String[] Names = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����",
														"��ְ��Ϣ", "���ű��" };
												defaultTableModel = new DefaultTableModel(obj, Names);
												table = new JTable(defaultTableModel);
												table.setPreferredScrollableViewportSize(new Dimension(400, 800));
												JScrollPane scrollPane = new JScrollPane(table);
												f.add(scrollPane, BorderLayout.CENTER);
												table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
											
												f.setBounds(300, 200, 800, 200);
												f.setUndecorated(true);
												f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
												f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
												f.setVisible(true);
												rs = st.executeQuery(sql);
												Vector columnName = new Vector(); // ����
												columnName.add("���");
												columnName.add("����");
												columnName.add("�Ա�");
												columnName.add("ѧ��");
												columnName.add("ְ��");
												columnName.add("ְ��");
												columnName.add("��ҵԺУ");
												columnName.add("����");
												columnName.add("��ְ��Ϣ");
												columnName.add("���ű��");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_zw.xls", "��ʦ��Ϣ_ְ��",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("�쳣" + e1);
											} finally {
												jdbcUtil.close(rs, st, conn);
											}
										}
									}
								});
								JPanel jp1 = new JPanel();
								JPanel jp = new JPanel();
								jp1.add(jl1);
								jp1.add(jt1);
								jp.add(jb1);
								framestaff.setUndecorated(true);
								framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
								JPanel imagePanel = new JPanel();
								imagePanel = (JPanel) framestaff.getContentPane();
								imagePanel.setOpaque(false);
								imagePanel.setLayout(new GridLayout(7, 3));
								imagePanel.add(jp1);
								jp1.setOpaque(false);
								jp.setOpaque(false);
								framestaff.getLayeredPane().setLayout(null);
								framestaff.add(jp, BorderLayout.SOUTH);
								framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								framestaff.setVisible(true);
							}
						});

						jb4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JFrame framestaff = new JFrame("ְ��ͳ��");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("Ҫͳ�Ƶ�ְ��");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("ͳ��");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "������ͳ������");
										} else {
											Connection conn = null;
											java.sql.Statement st = null;
											ResultSet rs = null;
											TableModel tablemodel = null;
											JTable table = new JTable(tablemodel);
											DefaultTableModel defaultTableModel = null;
											try {
												conn = jdbcUtil.getSQLConn();
												conn.setAutoCommit(true);
												System.out.println("�Ѿ����ӵ����ݿ�...");
												String sql = "SELECT * FROM ���˽�ʦ  WHERE ְ�� LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM ��ʦ��Ϣ  WHERE ְ�� LIKE" + "'%" + c1 + "%'"+" and ��ְ��Ϣ='����'";
												st = conn.createStatement();
												rs = st.executeQuery(sql);
												int count = 0;
												while (rs.next()) {
													count++;
												}
												Object[][] obj = new Object[count][10];
												int i = 0;
												rs = st.executeQuery(sql);
												while (rs.next()) {
													obj[i][0] = rs.getObject(1);
													obj[i][1] = rs.getObject(2);
													obj[i][2] = rs.getObject(3);
													obj[i][3] = rs.getObject(4);
													obj[i][4] = rs.getObject(5);
													obj[i][5] = rs.getObject(6);
													obj[i][6] = rs.getObject(7);
													obj[i][7] = rs.getObject(8);
													obj[i][8] = rs.getObject(9);
													obj[i][9] = rs.getObject(10);
													i++;
												}
												final JFrame f = new JFrame("���˽�ʦͳ�ƽ��");
												String[] Names = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����",
														"��ְ��Ϣ", "���ű��" };
												defaultTableModel = new DefaultTableModel(obj, Names);
												table = new JTable(defaultTableModel);
												table.setPreferredScrollableViewportSize(new Dimension(400, 800));
												JScrollPane scrollPane = new JScrollPane(table);
												f.add(scrollPane, BorderLayout.CENTER);
												table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
											/*	TableColumn column = null;
												column = table.getColumnModel().getColumn(0);
												column.setPreferredWidth(60);
												column = table.getColumnModel().getColumn(1);
												column.setPreferredWidth(60);
												column = table.getColumnModel().getColumn(2);
												column.setPreferredWidth(60);
												column = table.getColumnModel().getColumn(3);
												column.setPreferredWidth(80);
												column = table.getColumnModel().getColumn(4);
												column.setPreferredWidth(80);
												column = table.getColumnModel().getColumn(5);
												column.setPreferredWidth(80);
												column = table.getColumnModel().getColumn(6);
												column.setPreferredWidth(60);
												column = table.getColumnModel().getColumn(7);
												column.setPreferredWidth(60);
												column = table.getColumnModel().getColumn(8);
												column.setPreferredWidth(60);
												column = table.getColumnModel().getColumn(9);
												column.setPreferredWidth(150);
												column.setPreferredWidth(150);*/
												f.setBounds(300, 200, 800, 200);
												f.setUndecorated(true);
												f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
												f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
												f.setVisible(true);
												rs = st.executeQuery(sql);
												Vector columnName = new Vector(); // ����
												columnName.add("���");
												columnName.add("����");
												columnName.add("�Ա�");
												columnName.add("ѧ��");
												columnName.add("ְ��");
												columnName.add("ְ��");
												columnName.add("��ҵԺУ");
												columnName.add("����");
												columnName.add("��ְ��Ϣ");
												columnName.add("���ű��");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_zc.xls", "��ʦ��Ϣ_ְ��",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("�쳣" + e1);
											} finally {
												jdbcUtil.close(rs, st, conn);
											}
										}
									}
								});
								JPanel jp1 = new JPanel();
								JPanel jp = new JPanel();
								jp1.add(jl1);
								jp1.add(jt1);
								jp.add(jb1);
								framestaff.setUndecorated(true);
								framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
								JPanel imagePanel = new JPanel();
								imagePanel = (JPanel) framestaff.getContentPane();
								imagePanel.setOpaque(false);
								imagePanel.setLayout(new GridLayout(7, 3));
								imagePanel.add(jp1);
								jp1.setOpaque(false);
								jp.setOpaque(false);
								framestaff.getLayeredPane().setLayout(null);
								framestaff.add(jp, BorderLayout.SOUTH);
								framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								framestaff.setVisible(true);
							}
						});

						jb5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JFrame framestaff = new JFrame("���ű��ͳ��");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("Ҫͳ�ƵĲ��ű��");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("ͳ��");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "������ͳ������");
										} else {
											Connection conn = null;
											java.sql.Statement st = null;
											ResultSet rs = null;
											TableModel tablemodel = null;
											JTable table = new JTable(tablemodel);
											DefaultTableModel defaultTableModel = null;
											try {
												conn = jdbcUtil.getSQLConn();
												conn.setAutoCommit(true);
												System.out.println("�Ѿ����ӵ����ݿ�...");
												String sql = "SELECT * FROM ���˽�ʦ  WHERE ���ű�� LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM ��ʦ��Ϣ  WHERE ���ű�� LIKE" + "'%" + c1 + "%'"+" and ��ְ��Ϣ='����'";
												st = conn.createStatement();
												rs = st.executeQuery(sql);
												int count = 0;
												while (rs.next()) {
													count++;
												}
												Object[][] obj = new Object[count][10];
												int i = 0;
												rs = st.executeQuery(sql);
												while (rs.next()) {
													obj[i][0] = rs.getObject(1);
													obj[i][1] = rs.getObject(2);
													obj[i][2] = rs.getObject(3);
													obj[i][3] = rs.getObject(4);
													obj[i][4] = rs.getObject(5);
													obj[i][5] = rs.getObject(6);
													obj[i][6] = rs.getObject(7);
													obj[i][7] = rs.getObject(8);
													obj[i][8] = rs.getObject(9);
													obj[i][9] = rs.getObject(10);
													i++;
												}
												final JFrame f = new JFrame("ת����ʦͳ�ƽ��");
												String[] Names = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����",
														"��ְ��Ϣ", "���ű��" };
												defaultTableModel = new DefaultTableModel(obj, Names);
												table = new JTable(defaultTableModel);
												table.setPreferredScrollableViewportSize(new Dimension(400, 800));
												JScrollPane scrollPane = new JScrollPane(table);
												f.add(scrollPane, BorderLayout.CENTER);
												table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
												
												f.setBounds(300, 200, 800, 200);
												f.setUndecorated(true);
												f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
												f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
												f.setVisible(true);
												rs = st.executeQuery(sql);
												Vector columnName = new Vector(); // ����
												columnName.add("���");
												columnName.add("����");
												columnName.add("�Ա�");
												columnName.add("ѧ��");
												columnName.add("ְ��");
												columnName.add("ְ��");
												columnName.add("��ҵԺУ");
												columnName.add("����");
												columnName.add("��ְ��Ϣ");
												columnName.add("���ű��");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_bmbh.xls", "��ʦ��Ϣ_���ű��",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("�쳣" + e1);
											} finally {
												jdbcUtil.close(rs, st, conn);
											}
										}
									}
								});
								JPanel jp1 = new JPanel();
								JPanel jp = new JPanel();
								jp1.add(jl1);
								jp1.add(jt1);
								jp.add(jb1);
								framestaff.setUndecorated(true);
								framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
								JPanel imagePanel = new JPanel();
								imagePanel = (JPanel) framestaff.getContentPane();
								imagePanel.setOpaque(false);
								imagePanel.setLayout(new GridLayout(7, 3));
								imagePanel.add(jp1);
								jp1.setOpaque(false);
								jp.setOpaque(false);
								framestaff.getLayeredPane().setLayout(null);
								framestaff.add(jp, BorderLayout.SOUTH);
								framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								framestaff.setVisible(true);
							}
						});

						JPanel jp = new JPanel();
						jp.add(jb1);
						jp.add(jb2);
						jp.add(jb3);
						jp.add(jb4);
						jp.add(jb5);
						framestaff.setUndecorated(true);
						framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
						JPanel imagePanel = new JPanel();
						imagePanel = (JPanel) framestaff.getContentPane();
						imagePanel.setOpaque(false);
						imagePanel.setLayout(new GridLayout(7, 3));
						jp.setOpaque(false);
						framestaff.getLayeredPane().setLayout(null);
						framestaff.add(jp, BorderLayout.SOUTH);
						framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						framestaff.setVisible(true);
					}
				}
			});
			JPanel jp = new JPanel();
			jp.add(jb1);
			jp.setOpaque(false);
			f.add(jp, BorderLayout.SOUTH);
			f.setBounds(300, 200, 800, 200);
			f.setUndecorated(true);
			f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setVisible(true);
		} catch (SQLException e1) {
			java.lang.System.out.println("�쳣" + e1);
		} finally {
			jdbcUtil.close(rs, st, conn);
		}
	}
}
