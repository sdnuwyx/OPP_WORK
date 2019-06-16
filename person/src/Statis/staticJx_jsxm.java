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

public class staticJx_jsxm extends JFrame {
	public staticJx_jsxm() {
		final JFrame framestaff = new JFrame("��ʦ����ͳ��");
		framestaff.setBounds(200, 100, 500, 500);
		JLabel jl1 = new JLabel("Ҫͳ�ƵĽ�ʦ����");
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
						String sql = "SELECT * FROM ��ʦ��ѧ��Ϣ  WHERE ��ʦ���� LIKE" + "'%" + c1 + "%'";
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

							i++;
						}
						final JFrame f = new JFrame("��ʦ��ѧ��Ϣͳ�ƽ��");
						String[] Names = { "��ʦ���", "�γ̱��", "��ʦ����" };
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

						column.setPreferredWidth(150);*/
						f.setBounds(300, 200, 800, 200);
						f.setUndecorated(true);
						f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
						f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						f.setVisible(true);
						rs = st.executeQuery(sql);
						Vector columnName = new Vector(); // ����
						columnName.add("��ʦ���");
						columnName.add("�γ̱��");
						columnName.add("��ʦ����");
						new DBtoExcel().WriteExcel(rs, "E://statisJx_jsxm.xls", "��ʦ��ѧ��Ϣ_��ʦ���", columnName);
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
}
