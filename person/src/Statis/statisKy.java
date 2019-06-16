package Statis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class statisKy implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("科研方向")) {
			Connection conn = null;
			java.sql.Statement st = null;
			ResultSet rs = null;
			TableModel tablemodel = null;
			JTable table = new JTable(tablemodel);
			DefaultTableModel defaultTableModel = null;
			try {
				conn = jdbcUtil.getSQLConn();
				conn.setAutoCommit(true);
				st = conn.createStatement();
				// 获取结果集元数1
				rs = st.executeQuery("select 教师编号  from 科研信息");
				int count = 0;
				while (rs.next()) {
					count++;
				}
				Object[][] obj = new Object[count][5];
				rs = st.executeQuery("select * from 科研信息");
				int i = 0;
				while (rs.next()) {
					obj[i][0] = rs.getObject(1);
					obj[i][1] = rs.getObject(2);
					obj[i][2] = rs.getObject(3);
					obj[i][3] = rs.getObject(4);
					// obj[i][4] = rs.getObject(5);
					i++;
				}
				final JFrame f = new JFrame("科研信息");
				String[] Names = { "教师编号", "专利论文编号", "研究方向", "研究情况" };
				defaultTableModel = new DefaultTableModel(obj, Names);

				table = new JTable(defaultTableModel);

				table.setPreferredScrollableViewportSize(new Dimension(400, 800));
				JScrollPane scrollPane = new JScrollPane(table);
				f.add(scrollPane, BorderLayout.CENTER);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			/*/TableColumn column = null;
				column = table.getColumnModel().getColumn(0);
				column.setPreferredWidth(60);
				column = table.getColumnModel().getColumn(1);
				column.setPreferredWidth(60);
				column = table.getColumnModel().getColumn(2);
				column.setPreferredWidth(60);
				column = table.getColumnModel().getColumn(3);
				column.setPreferredWidth(80);*/
				/*
				 * column = table.getColumnModel().getColumn(4);
				 * column.setPreferredWidth(80);
				 */
				JButton jb1 = new JButton("按条件统计");
				jb1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("按条件统计")) {
							final JFrame framestaff = new JFrame("按条件统计科研信息");
							framestaff.setBounds(200, 100, 500, 500);
							JButton jb1 = new JButton("按教师编号");
							JButton jb2 = new JButton("按专利论文编号");
							JButton jb3 = new JButton("按研究方向");
							JButton jb4 = new JButton("按研究情况");
							// JButton jb5 = new JButton("学分");
							jb1.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent e) {
									final JFrame framestaff = new JFrame("教师编号统计");
									framestaff.setBounds(200, 100, 500, 500);
									JLabel jl1 = new JLabel("要统计的教师编号");
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
													String sql = "SELECT * FROM 科研信息  WHERE 教师编号 LIKE" + "'%" + c1
															+ "%'";
													st = conn.createStatement();

													rs = st.executeQuery(sql);
													int count = 0;
													while (rs.next()) {
														count++;
													}
													Object[][] obj = new Object[count][5];

													int i = 0;
													rs = st.executeQuery(sql);
													while (rs.next()) {

														obj[i][0] = rs.getObject(1);
														obj[i][1] = rs.getObject(2);
														obj[i][2] = rs.getObject(3);
														obj[i][3] = rs.getObject(4);
														// obj[i][4] =
														// rs.getObject(5);

														i++;
													}

													final JFrame f = new JFrame("科研信息统计结果");
													String[] Names = { "教师编号", "专利论文编号", "研究方向", "研究情况" };

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
													columnName.add("教师编号");
													columnName.add("专利论文编号");
													columnName.add("研究方向");
													columnName.add("研究情况");
													new DBtoExcel().WriteExcel(rs, "E://statisKy_jsbh.xls", "科研信息",
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
									final JFrame framestaff = new JFrame("专利论文编号统计");
									framestaff.setBounds(200, 100, 500, 500);
									JLabel jl1 = new JLabel("要统计的专利论文编号");
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
													String sql = "SELECT * FROM 科研信息  WHERE 专利论文编号  LIKE" + "'%" + c1
															+ "%'";
													st = conn.createStatement();
													rs = st.executeQuery(sql);
													int count = 0;
													while (rs.next()) {
														count++;
													}
													Object[][] obj = new Object[count][5];
													rs = st.executeQuery(sql);
													int i = 0;
													while (rs.next()) {

														obj[i][0] = rs.getObject(1);
														obj[i][1] = rs.getObject(2);
														obj[i][2] = rs.getObject(3);
														obj[i][3] = rs.getObject(4);
														// obj[i][4] =
														// rs.getObject(5);

														i++;
													}
													final JFrame f = new JFrame("科研信息统计结果");
													String[] Names = { "教师编号", "专利论文编号", "研究方向", "研究情况" };
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
													column.setPreferredWidth(80);*/
													/*
													 * column =
													 * table.getColumnModel().
													 * getColumn(4);
													 * column.setPreferredWidth(
													 * 80);
													 */
												//	column.setPreferredWidth(150);
													f.setBounds(300, 200, 800, 200);
													f.setUndecorated(true);
													f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
													f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
													f.setVisible(true);
													rs = st.executeQuery(sql);
													Vector columnName = new Vector(); // 列名
													columnName.add("教师编号");
													columnName.add("专利论文编号");
													columnName.add("研究方向");
													columnName.add("研究情况");
													new DBtoExcel().WriteExcel(rs, "E://statisKy_zllw.xls", "科研信息",
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
									final JFrame framestaff = new JFrame("研究方向统计");
									framestaff.setBounds(200, 100, 500, 500);
									JLabel jl1 = new JLabel("要统计的研究方向");
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
													String sql = "SELECT * FROM 科研信息  WHERE 研究方向  LIKE" + "'%" + c1
															+ "%'";
													st = conn.createStatement();
													rs = st.executeQuery(sql);
													int count = 0;
													while (rs.next()) {
														count++;
													}
													Object[][] obj = new Object[count][5];
													rs = st.executeQuery(sql);
													int i = 0;
													while (rs.next()) {

														obj[i][0] = rs.getObject(1);
														obj[i][1] = rs.getObject(2);
														obj[i][2] = rs.getObject(3);
														obj[i][3] = rs.getObject(4);
														// obj[i][4] =
														// rs.getObject(5);

														i++;
													}
													final JFrame f = new JFrame("科研信息统计结果");
													String[] Names = { "教师编号", "专利论文编号", "研究方向", "研究情况" };
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
													column.setPreferredWidth(80);*/
													/*
													 * column =
													 * table.getColumnModel().
													 * getColumn(4);
													 * column.setPreferredWidth(
													 * 80);
													 */
											//		column.setPreferredWidth(150);
													f.setBounds(300, 200, 800, 200);
													f.setUndecorated(true);
													f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
													f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
													f.setVisible(true);
													rs = st.executeQuery(sql);
													Vector columnName = new Vector(); // 列名
													columnName.add("教师编号");
													columnName.add("专利论文编号");
													columnName.add("研究方向");
													columnName.add("研究情况");
													new DBtoExcel().WriteExcel(rs, "E://statisKy_yjfx.xls", "科研信息",
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
									final JFrame framestaff = new JFrame("研究情况统计");
									framestaff.setBounds(200, 100, 500, 500);
									JLabel jl1 = new JLabel("要统计的研究情况");
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
													String sql = "SELECT * FROM 科研信息  WHERE 研究情况  LIKE" + "'%" + c1
															+ "%'";
													st = conn.createStatement();
													rs = st.executeQuery(sql);
													int count = 0;
													while (rs.next()) {
														count++;
													}
													Object[][] obj = new Object[count][5];
													rs = st.executeQuery(sql);
													int i = 0;
													while (rs.next()) {

														obj[i][0] = rs.getObject(1);
														obj[i][1] = rs.getObject(2);
														obj[i][2] = rs.getObject(3);
														obj[i][3] = rs.getObject(4);
														// obj[i][4] =
														// rs.getObject(5);

														i++;
													}
													final JFrame f = new JFrame("科研信息统计结果");
													String[] Names = { "教师编号", "专利论文编号", "研究方向", "研究情况" };
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
													column.setPreferredWidth(80);*/
													/*
													 * column =
													 * table.getColumnModel().
													 * getColumn(4);
													 * column.setPreferredWidth(
													 * 80);
													 */
												//	column.setPreferredWidth(150);
													f.setBounds(300, 200, 800, 200);
													f.setUndecorated(true);
													f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
													f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
													f.setVisible(true);
													rs = st.executeQuery(sql);
													Vector columnName = new Vector(); // 列名
													columnName.add("教师编号");
													columnName.add("专利论文编号");
													columnName.add("研究方向");
													columnName.add("研究情况");
													new DBtoExcel().WriteExcel(rs, "E://statisKy_yjqk.xls", "科研信息",
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

							/*
							 * jb5.addActionListener(new ActionListener() {
							 * 
							 * public void actionPerformed(ActionEvent e) {
							 * final JFrame framestaff = new JFrame("学分统计");
							 * framestaff.setBounds(200, 100, 500, 500); JLabel
							 * jl1 = new JLabel("要统计的学分"); final JTextField jt1
							 * = new JTextField(8); JButton jb1 = new
							 * JButton("统计"); jb1.addActionListener(new
							 * ActionListener() {
							 * 
							 * public void actionPerformed(ActionEvent e) {
							 * String c1 = jt1.getText().toString(); if
							 * (c1.equals("")) {
							 * javax.swing.JOptionPane.showMessageDialog(null,
							 * "请输入统计条件"); } else{ Connection conn = null;
							 * java.sql.Statement st = null; ResultSet rs =
							 * null; TableModel tablemodel = null; JTable table
							 * = new JTable(tablemodel); DefaultTableModel
							 * defaultTableModel = null; try { conn =
							 * jdbcUtil.getSQLConn(); conn.setAutoCommit(true);
							 * System.out.println("已经连接到数据库..."); String sql =
							 * "SELECT * FROM 课程信息  WHERE 学分  LIKE" + "'%" + c1
							 * + "%'"; st = conn.createStatement(); rs =
							 * st.executeQuery(sql); int count = 0; while
							 * (rs.next()) { count++; } Object[][] obj = new
							 * Object[count][5]; rs = st.executeQuery(sql); int
							 * i = 0; while (rs.next()) {
							 * 
							 * obj[i][0] = rs.getObject(1); obj[i][1] =
							 * rs.getObject(2); obj[i][2] = rs.getObject(3);
							 * obj[i][3] = rs.getObject(4); obj[i][4] =
							 * rs.getObject(5);
							 * 
							 * i++; } final JFrame f = new JFrame("课程信息统计结果");
							 * String[] Names = { "课程编号", "课程名称", "课程性质",
							 * "课程时数", "学分" }; defaultTableModel = new
							 * DefaultTableModel(obj, Names); table = new
							 * JTable(defaultTableModel);
							 * table.setPreferredScrollableViewportSize(new
							 * Dimension(400, 800)); JScrollPane scrollPane =
							 * new JScrollPane(table); f.add(scrollPane,
							 * BorderLayout.CENTER);
							 * table.setAutoResizeMode(JTable.
							 * AUTO_RESIZE_SUBSEQUENT_COLUMNS); TableColumn
							 * column = null; column =
							 * table.getColumnModel().getColumn(0);
							 * column.setPreferredWidth(60); column =
							 * table.getColumnModel().getColumn(1);
							 * column.setPreferredWidth(60); column =
							 * table.getColumnModel().getColumn(2);
							 * column.setPreferredWidth(60); column =
							 * table.getColumnModel().getColumn(3);
							 * column.setPreferredWidth(80); column =
							 * table.getColumnModel().getColumn(4);
							 * column.setPreferredWidth(80);
							 * column.setPreferredWidth(150); f.setBounds(300,
							 * 200, 800, 200); f.setUndecorated(true);
							 * f.getRootPane().setWindowDecorationStyle(
							 * JRootPane.FRAME);
							 * f.setDefaultCloseOperation(JFrame.
							 * DISPOSE_ON_CLOSE); f.setVisible(true); } catch
							 * (SQLException e1) {
							 * java.lang.System.out.println("异常" + e1); }
							 * finally { jdbcUtil.close(rs, st, conn); } } } });
							 * JPanel jp1 = new JPanel(); JPanel jp = new
							 * JPanel(); jp1.add(jl1); jp1.add(jt1);
							 * jp.add(jb1); framestaff.setUndecorated(true);
							 * framestaff.getRootPane().setWindowDecorationStyle
							 * (JRootPane.FRAME); JPanel imagePanel = new
							 * JPanel(); imagePanel = (JPanel)
							 * framestaff.getContentPane();
							 * imagePanel.setOpaque(false);
							 * 
							 * imagePanel.setLayout(new GridLayout(7, 3));
							 * imagePanel.add(jp1); jp1.setOpaque(false);
							 * jp.setOpaque(false);
							 * framestaff.getLayeredPane().setLayout(null);
							 * framestaff.add(jp, BorderLayout.SOUTH);
							 * 
							 * framestaff.setDefaultCloseOperation(JFrame.
							 * DISPOSE_ON_CLOSE); framestaff.setVisible(true); }
							 * });
							 */

							JPanel cp = new JPanel();
							cp.setLayout(new FlowLayout(FlowLayout.LEFT));
							framestaff.setContentPane(cp);
							cp.add(jb1);
							cp.add(jb2);
							cp.add(jb3);
							cp.add(jb4);
							// cp.add(jb5);
							framestaff.setUndecorated(true);
							framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
							framestaff.setSize(600, 100);
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

}
