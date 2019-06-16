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
		if (e.getActionCommand().equals("��ʦ��ѧ��Ϣ")) {
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
				rs = st.executeQuery("select ��ʦ���  from ��ʦ��ѧ��Ϣ");
				int count = 0;
				while (rs.next()) {
					count++;
				}
				Object[][] obj = new Object[count][10];
				rs = st.executeQuery("select * from ��ʦ��ѧ��Ϣ");
				int i = 0;
				while (rs.next()) {
					obj[i][0] = rs.getObject(1);
					obj[i][1] = rs.getObject(2);
					obj[i][2] = rs.getObject(3);
					i++;
				}
				final JFrame f = new JFrame("��ʦ��ѧ��Ϣ");
				String[] Names = { "��ʦ���", "�γ̱��", "��ʦ����" };
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
							JButton jb1 = new JButton("����ʦ���");
							jb1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									new staticJx_jsbh();
								}

							});
							JButton jb2 = new JButton("���γ̱��");
							jb2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									new staticJx_kcbh();
								}

							});
							JButton jb3 = new JButton("����ʦ����");
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
				java.lang.System.out.println("�쳣" + e1);
			} finally {
				jdbcUtil.close(rs, st, conn);
			}

		}
	}
}
