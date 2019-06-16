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

public class statisYg implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("员工信息")) {
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
				rs = st.executeQuery("select 编号  from 教师信息");
				int count = 0;
				while (rs.next()) {
					count++;
				}
				Object[][] obj = new Object[count][10];
				rs = st.executeQuery("select * from 教师信息");
				int i = 0;
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
				final JFrame f = new JFrame("教师信息");
				String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩", "在职信息", "部门编号" };
				defaultTableModel = new DefaultTableModel(obj, Names);
				table = new JTable(defaultTableModel);
				table.setPreferredScrollableViewportSize(new Dimension(400, 800));
				JScrollPane scrollPane = new JScrollPane(table);
				f.add(scrollPane, BorderLayout.CENTER);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	

				JButton jb1 = new JButton("转出员工");
				jb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("转出员工")) {
							new statisYg_zc();
						}
					}
				});
				JButton jb2 = new JButton("辞退员工");
				jb2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("辞退员工")) {
							new statisYg_ct();
						}
					}
				});
				JButton jb3 = new JButton("退休员工");
				jb3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("退休员工")) {
							new statisYg_tx();
						}
					}
				});
				JButton jb4 = new JButton("在职员工");
				jb4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("在职员工")) {
							new statisYg_zz();
						}
					}
				});
				JPanel jp = new JPanel();
				jp.add(jb1);
				jp.add(jb2);
				jp.add(jb3);
				jp.add(jb4);
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
