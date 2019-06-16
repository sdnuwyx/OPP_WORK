package Inquire;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import DB.jdbcUtil;

public class teaInquire implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("教师教学信息查询")) {
			final JFrame framestaff = new JFrame("教师教学信息查询");
			framestaff.setBounds(200, 100, 500, 500);

			JLabel jl1 = new JLabel("要查询的教师编号");
			jl1.setToolTipText("例如:1401");
			final JTextField jt1 = new JTextField(8);
			JLabel jl2 = new JLabel("要查询的课程编号");
			final JTextField jt2 = new JTextField(6);
			JLabel jl3 = new JLabel("要查询的教师姓名");
			final JTextField jt3 = new JTextField(6);
			JButton jb1 = new JButton("查询");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String c1 = jt1.getText().toString();
					String c2 = jt2.getText().toString();
					String c3 = jt3.getText().toString();
					if (c1.equals("") && c2.equals("") && c3.equals("")) {
						javax.swing.JOptionPane.showMessageDialog(null, "请输入查询条件");
					}
					Connection conn = null;
					java.sql.Statement st = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					TableModel tablemodel = null;
					JTable table = new JTable(tablemodel);
					DefaultTableModel defaultTableModel = null;
					try {
						conn = jdbcUtil.getSQLConn();
						conn.setAutoCommit(true);
						System.out.println("已经连接到数据库...");
						String sql = "select * from 教师教学信息";
						String sql2 = "SELECT * FROM 教师教学信息  WHERE 教师编号 LIKE" + "'%" + c3 + "%'";
						st = conn.createStatement();
						rs = st.executeQuery(sql);
						rs2 = st.executeQuery(sql2);
						System.out.println(rs2);
						if (c1 != "") {
							rs = st.executeQuery(sql);

							while (rs.next()) {
								if (c1.equals(rs.getString(1))) {
									Object[][] obj = new Object[1][3];
									int i = 0;
									obj[i][0] = rs.getObject(1);
									obj[i][1] = rs.getObject(2);
									obj[i][2] = rs.getObject(3);

									// i++;
									final JFrame f = new JFrame("教师教学信息查询结果");
									String[] Names = { "教师编号", "课程编号", "教师姓名" };
									defaultTableModel = new DefaultTableModel(obj, Names);
									table = new JTable(defaultTableModel);
									table.setPreferredScrollableViewportSize(new Dimension(400, 800));
									JScrollPane scrollPane = new JScrollPane(table);
									f.add(scrollPane, BorderLayout.CENTER);
									table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
									TableColumn column = null;
									column = table.getColumnModel().getColumn(0);
									column.setPreferredWidth(60);
									column = table.getColumnModel().getColumn(1);
									column.setPreferredWidth(60);
									column = table.getColumnModel().getColumn(2);
									column.setPreferredWidth(60);

									f.setBounds(300, 200, 800, 200);
									f.setUndecorated(true);
									f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
									f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									f.setVisible(true);
								}
							}
						}
						if (c2 != "") {
							rs = st.executeQuery(sql);

							while (rs.next()) {
								if (c2.equals(rs.getString(1))) {
									Object[][] obj = new Object[1][3];
									int i = 0;
									obj[i][0] = rs.getObject(1);
									obj[i][1] = rs.getObject(2);
									obj[i][2] = rs.getObject(3);

									final JFrame f = new JFrame("教师教学信息查询结果");
									String[] Names = { "教师编号", "课程编号", "教师姓名" };
									defaultTableModel = new DefaultTableModel(obj, Names);
									table = new JTable(defaultTableModel);
									table.setPreferredScrollableViewportSize(new Dimension(400, 800));
									JScrollPane scrollPane = new JScrollPane(table);
									f.add(scrollPane, BorderLayout.CENTER);
									table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
									TableColumn column = null;
									column = table.getColumnModel().getColumn(0);
									column.setPreferredWidth(60);
									column = table.getColumnModel().getColumn(1);
									column.setPreferredWidth(60);
									column = table.getColumnModel().getColumn(2);
									column.setPreferredWidth(60);

									f.setBounds(300, 200, 800, 200);
									f.setUndecorated(true);
									f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
									f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									f.setVisible(true);
								}
							}
						}
						if (c3 != "") {
							int count = 0;
							rs2 = st.executeQuery(sql2);
							while (rs2.next()) {
								count++;
							}

							Object[][] obj = new Object[count][4];
							rs2 = st.executeQuery(sql2);
							int i = 0;
							while (rs2.next()) {

								obj[i][0] = rs2.getObject(1);
								obj[i][1] = rs2.getObject(2);
								obj[i][2] = rs2.getObject(3);

								i++;
							}
							final JFrame f = new JFrame("教师教学信息查询结果");
							String[] Names = { "教师编号", "课程编号", "教师姓名" };
							defaultTableModel = new DefaultTableModel(obj, Names);
							table = new JTable(defaultTableModel);
							table.setPreferredScrollableViewportSize(new Dimension(400, 800));
							JScrollPane scrollPane = new JScrollPane(table);
							f.add(scrollPane, BorderLayout.CENTER);
							table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
							TableColumn column = null;
							column = table.getColumnModel().getColumn(0);
							column.setPreferredWidth(60);
							column = table.getColumnModel().getColumn(1);
							column.setPreferredWidth(60);
							column = table.getColumnModel().getColumn(2);
							column.setPreferredWidth(60);

							column.setPreferredWidth(150);
							f.setBounds(300, 200, 800, 200);
							f.setUndecorated(true);
							f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
							f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							f.setVisible(true);

							// }
						}

					} catch (SQLException e1) {
						java.lang.System.out.println("异常" + e1);
					} finally {
						jdbcUtil.close(rs, st, conn);
					}

				}

			});

			JPanel jp = new JPanel();
			JPanel jp1 = new JPanel();
			JPanel jp2 = new JPanel();
			JPanel jp3 = new JPanel();

			jp1.add(jl1);
			jp1.add(jt1);

			jp2.add(jl2);
			jp2.add(jt2);
			jp3.add(jl3);
			jp3.add(jt3);

			jp.add(jb1);
			framestaff.setUndecorated(true);
			framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

			JPanel imagePanel = new JPanel();
			ImageIcon background;
			BufferedImage image = null;
			String path = "D:\\Pictures\\1-main-image";
			background = new ImageIcon(path);
			JLabel label = new JLabel(background);
			label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
			imagePanel = (JPanel) framestaff.getContentPane();
			imagePanel.setOpaque(false);

			imagePanel.setLayout(new GridLayout(7, 3));
			imagePanel.add(jp1);
			imagePanel.add(jp2);
			imagePanel.add(jp3);

			jp1.setOpaque(false);
			jp2.setOpaque(false);
			jp3.setOpaque(false);

			jp.setOpaque(false);
			framestaff.getLayeredPane().setLayout(null);
			framestaff.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			// framestaff.setSize(background.getIconWidth(),background.getIconHeight());
			// framestaff.setVisible(true);
			framestaff.add(jp, BorderLayout.SOUTH);

			framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			framestaff.setVisible(true);
		}

	}
}
