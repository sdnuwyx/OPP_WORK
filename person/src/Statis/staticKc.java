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

public class staticKc implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("�γ�")) {
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
				// ��ȡ�����Ԫ��1
				rs = st.executeQuery("select �γ̱��  from �γ���Ϣ");
				int count = 0;
				while (rs.next()) {
					count++;
				}
				Object[][] obj = new Object[count][5];
				rs = st.executeQuery("select * from �γ���Ϣ");
				int i = 0;
				while (rs.next()) {
					obj[i][0] = rs.getObject(1);
					obj[i][1] = rs.getObject(2);
					obj[i][2] = rs.getObject(3);
					obj[i][3] = rs.getObject(4);
					obj[i][4] = rs.getObject(5);
					i++;
				}
				final JFrame f = new JFrame("�γ���Ϣ");
				String[] Names = { "�γ̱��", "�γ�����", "�γ�����", "�γ�ʱ��", "ѧ��" };
				defaultTableModel = new DefaultTableModel(obj, Names);

				table = new JTable(defaultTableModel);

				table.setPreferredScrollableViewportSize(new Dimension(400, 800));
				JScrollPane scrollPane = new JScrollPane(table);
				f.add(scrollPane, BorderLayout.CENTER);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				JButton jb1 = new JButton("������ͳ��");
				jb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("������ͳ��")) {
							final JFrame framestaff = new JFrame("������ͳ�ƿγ�");
							framestaff.setBounds(200, 100, 500, 500);
							JLabel jl1 = new JLabel("Ҫͳ�Ƶ�����");
							final JTextField jt1 = new JTextField(8);
							String c1 = jt1.getText().toString();
							JButton jb1 = new JButton("ͳ��");
							jb1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if (e.getActionCommand().equals("ͳ��")) {
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
												String sql = "SELECT * FROM �γ���Ϣ  WHERE �γ̱�� LIKE" + "'%" + c1 + "%'"
														+ "union select * from �γ���Ϣ  WHERE �γ����� LIKE" + "'%" + c1
														+ "%'"+ "union select * from �γ���Ϣ  WHERE �γ����� LIKE" + "'%" + c1
														+ "%'"+ "union select * from �γ���Ϣ  WHERE �γ�ʱ�� LIKE" + "'%" + c1
														+ "%'"+ "union select * from �γ���Ϣ  WHERE ѧ�� LIKE" + "'%" + c1
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
													obj[i][4] = rs.getObject(5);

													i++;
												}
												final JFrame f = new JFrame("�γ���Ϣͳ�ƽ��");
												String[] Names = { "�γ̱��", "�γ�����", "�γ�����", "�γ�ʱ��", "ѧ��" };
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
												
											} catch (SQLException e1) {
												java.lang.System.out.println("�쳣" + e1);
											} finally {
												jdbcUtil.close(rs, st, conn);
											}

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
}