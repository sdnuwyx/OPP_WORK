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

import DB.jdbcUtil;

public class statisJx implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("教师教学信息")) {
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
				rs = st.executeQuery("select 教师编号  from 教师教学信息");
				int count = 0;
				while (rs.next()) {
					count++;
				}
				Object[][] obj = new Object[count][10];
				rs = st.executeQuery("select * from 教师教学信息");
				int i = 0;
				while (rs.next()) {
					obj[i][0] = rs.getObject(1);
					obj[i][1] = rs.getObject(2);
					obj[i][2] = rs.getObject(3);
					i++;
				}
				final JFrame f = new JFrame("教师教学信息");
				String[] Names = { "教师编号", "课程编号", "教师姓名" };
				defaultTableModel = new DefaultTableModel(obj, Names);
				table = new JTable(defaultTableModel);
				table.setPreferredScrollableViewportSize(new Dimension(400, 800));
				JScrollPane scrollPane = new JScrollPane(table);
				f.add(scrollPane, BorderLayout.CENTER);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			
				JButton jb1 = new JButton("按条件统计");
				jb1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("按条件统计")) {
							final JFrame framestaff = new JFrame("按条件统计课程");
							framestaff.setBounds(200, 100, 500, 500);
							JButton jb1 = new JButton("按教师编号");
							jb1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									new staticJx_jsbh();
								}

							});
							JButton jb2 = new JButton("按课程编号");
							jb2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									new staticJx_kcbh();
								}

							});
							JButton jb3 = new JButton("按教师姓名");
							jb3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									new staticJx_jsxm();
								}

							});
							JPanel cp = new JPanel();
							cp.setLayout(new FlowLayout(FlowLayout.LEFT));
							framestaff.setContentPane(cp);
							cp.add(jb1);
							cp.add(jb2);
							cp.add(jb3);
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
