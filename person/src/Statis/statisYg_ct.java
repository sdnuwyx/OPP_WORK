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
		JFrame framestaff = new JFrame("辞退员工");
		framestaff.setBounds(200, 100, 500, 500);
		try {

			conn = jdbcUtil.getSQLConn();
			conn.setAutoCommit(true);
			st = conn.createStatement();
			String sql = "select * from 辞退教师 union select * from 教师信息 where 在职信息='辞退' ";
			// 获取结果集元数1
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
			final JFrame f = new JFrame("辞退教师");
			String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩", "在职信息", "部门编号" };
			defaultTableModel = new DefaultTableModel(obj, Names);
			table = new JTable(defaultTableModel);
			table.setPreferredScrollableViewportSize(new Dimension(400, 800));
			JScrollPane scrollPane = new JScrollPane(table);
			f.add(scrollPane, BorderLayout.CENTER);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
			rs = st.executeQuery(sql);
			Vector columnName = new Vector(); // 列名
			columnName.add("编号");
			columnName.add("姓名");
			columnName.add("性别");
			columnName.add("学历");
			columnName.add("职务");
			columnName.add("职称");
			columnName.add("毕业院校");
			columnName.add("奖惩");
			columnName.add("在职信息");
			columnName.add("部门编号");
			new DBtoExcel().WriteExcel(rs, "E://statisYg_zc.xls", "辞退教师", columnName);
			JButton jb1 = new JButton("按条件统计");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("按条件统计")) {
						final JFrame framestaff = new JFrame("按条件统计转出教师");
						framestaff.setBounds(200, 100, 500, 500);
						JButton jb1 = new JButton("按性别");
						JButton jb2 = new JButton("按学历");
						JButton jb3 = new JButton("按职务");
						JButton jb4 = new JButton("按职称");
						JButton jb5 = new JButton("按部门编号");
						jb1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final JFrame framestaff = new JFrame("性别统计");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("要统计的性别");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("统计");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "请输入统计条件");
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
												System.out.println("已经连接到数据库...");
												String sql = "SELECT * FROM 辞退教师  WHERE 性别 LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM 教师信息  WHERE 性别 LIKE" + "'%" + c1 + "%'"+" and 在职信息='辞退'" ;
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
												final JFrame f = new JFrame("辞退教师统计结果");
												String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩",
														"在职信息", "部门编号" };
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
												Vector columnName = new Vector(); // 列名
												columnName.add("编号");
												columnName.add("姓名");
												columnName.add("性别");
												columnName.add("学历");
												columnName.add("职务");
												columnName.add("职称");
												columnName.add("毕业院校");
												columnName.add("奖惩");
												columnName.add("在职信息");
												columnName.add("部门编号");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_xb.xls", "教师信息_性别",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("异常" + e1);
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
								final JFrame framestaff = new JFrame("学历统计");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("要统计的学历");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("统计");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "请输入统计条件");
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
												System.out.println("已经连接到数据库...");
												String sql = "SELECT * FROM 辞退教师  WHERE 学历 LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM 教师信息  WHERE 学历 LIKE" + "'%" + c1 + "%'"+" and 在职信息='辞退'";
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
												final JFrame f = new JFrame("辞退教师统计结果");
												String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩",
														"在职信息", "部门编号" };
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
												Vector columnName = new Vector(); // 列名
												columnName.add("编号");
												columnName.add("姓名");
												columnName.add("性别");
												columnName.add("学历");
												columnName.add("职务");
												columnName.add("职称");
												columnName.add("毕业院校");
												columnName.add("奖惩");
												columnName.add("在职信息");
												columnName.add("部门编号");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_xl.xls", "教师信息_学历",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("异常" + e1);
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
								final JFrame framestaff = new JFrame("职务统计");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("要统计的职务");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("统计");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "请输入统计条件");
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
												System.out.println("已经连接到数据库...");
												String sql = "SELECT * FROM 辞退教师  WHERE 职务 LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM 教师信息  WHERE 职务 LIKE" + "'%" + c1 + "%'"+" and 在职信息='辞退'";
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
												final JFrame f = new JFrame("辞退教师统计结果");
												String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩",
														"在职信息", "部门编号" };
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
												Vector columnName = new Vector(); // 列名
												columnName.add("编号");
												columnName.add("姓名");
												columnName.add("性别");
												columnName.add("学历");
												columnName.add("职务");
												columnName.add("职称");
												columnName.add("毕业院校");
												columnName.add("奖惩");
												columnName.add("在职信息");
												columnName.add("部门编号");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_zw.xls", "教师信息_职务",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("异常" + e1);
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
								final JFrame framestaff = new JFrame("职称统计");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("要统计的职称");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("统计");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "请输入统计条件");
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
												System.out.println("已经连接到数据库...");
												String sql = "SELECT * FROM 辞退教师  WHERE 职称 LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM 教师信息  WHERE 职称 LIKE" + "'%" + c1 + "%'"+" and 在职信息='辞退'";
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
												final JFrame f = new JFrame("辞退教师统计结果");
												String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩",
														"在职信息", "部门编号" };
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
												Vector columnName = new Vector(); // 列名
												columnName.add("编号");
												columnName.add("姓名");
												columnName.add("性别");
												columnName.add("学历");
												columnName.add("职务");
												columnName.add("职称");
												columnName.add("毕业院校");
												columnName.add("奖惩");
												columnName.add("在职信息");
												columnName.add("部门编号");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_zc.xls", "教师信息_职称",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("异常" + e1);
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
								final JFrame framestaff = new JFrame("部门编号统计");
								framestaff.setBounds(200, 100, 500, 500);
								JLabel jl1 = new JLabel("要统计的部门编号");
								final JTextField jt1 = new JTextField(8);
								JButton jb1 = new JButton("统计");
								jb1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String c1 = jt1.getText().toString();
										if (c1.equals("")) {
											javax.swing.JOptionPane.showMessageDialog(null, "请输入统计条件");
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
												System.out.println("已经连接到数据库...");
												String sql = "SELECT * FROM 辞退教师  WHERE 部门编号 LIKE" + "'%" + c1 + "%'"+" union SELECT * FROM 教师信息  WHERE 部门编号 LIKE" + "'%" + c1 + "%'"+" and 在职信息='辞退'";
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
												final JFrame f = new JFrame("转出教师统计结果");
												String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩",
														"在职信息", "部门编号" };
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
												Vector columnName = new Vector(); // 列名
												columnName.add("编号");
												columnName.add("姓名");
												columnName.add("性别");
												columnName.add("学历");
												columnName.add("职务");
												columnName.add("职称");
												columnName.add("毕业院校");
												columnName.add("奖惩");
												columnName.add("在职信息");
												columnName.add("部门编号");
												new DBtoExcel().WriteExcel(rs, "E://statisYg_ct_bmbh.xls", "教师信息_部门编号",
														columnName);
											} catch (SQLException e1) {
												java.lang.System.out.println("异常" + e1);
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
			java.lang.System.out.println("异常" + e1);
		} finally {
			jdbcUtil.close(rs, st, conn);
		}
	}
}
