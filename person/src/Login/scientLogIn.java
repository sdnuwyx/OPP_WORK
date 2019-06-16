package Login;

import java.awt.BorderLayout;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import DB.jdbcUtil;

public class scientLogIn implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("������Ϣ¼��")) {
			final JFrame framestaff = new JFrame("������Ϣ¼��");
			framestaff.setBounds(200, 100, 500, 500);
			JLabel jl1 = new JLabel("��ʦ���");
			jl1.setToolTipText("����:1401");
			final JTextField jt1 = new JTextField(8);
			JLabel jl2 = new JLabel("ר�����ı��");
			final JTextField jt2 = new JTextField(6);
			JLabel jl3 = new JLabel("�о�����");
			final JTextField jt3 = new JTextField(5);
			JLabel jl4 = new JLabel("�о����");
			final JTextField jt4 = new JTextField(10);
			JButton jb1 = new JButton("���");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("���")) {
						String c1 = jt1.getText();
						if (c1.equals("")) {
							javax.swing.JOptionPane.showMessageDialog(null, "�������ʦ��ţ�");
						} else {
							if (Integer.parseInt(c1) <= 1000 || Integer.parseInt(c1) >= 4000) {
								javax.swing.JOptionPane.showMessageDialog(null, "��ʦ����������");
							} else {
								if (jdbcUtil.nunnumber(c1, "��ʦ��Ϣ")) {
									javax.swing.JOptionPane.showMessageDialog(null, "��ʦ������");
								} else {
									String c2 = jt2.getText();
									if (c2.equals("")) {
										javax.swing.JOptionPane.showMessageDialog(null, "������ר�����ı�ţ�");
									} else {
										if (Integer.parseInt(c2) <= 100 || Integer.parseInt(c2) >= 1000) {
											javax.swing.JOptionPane.showMessageDialog(null, "ר�����ı���������");
										} else {
											if (jdbcUtil.nunnumber(c2, "ר������")) {
												javax.swing.JOptionPane.showMessageDialog(null, "ר�����Ĳ�����");
											} else {
												String c3 = jt3.getText();
												String c4 = jt4.getText();
												if (c3.equals("") || c4.equals("")) {
													javax.swing.JOptionPane.showMessageDialog(null, "��������Ϣ��");
												} else {
													Connection conn = null;
													java.sql.Statement st = null;
													ResultSet rs = null;
													try {
														conn = jdbcUtil.getSQLConn();
														conn.setAutoCommit(true);
														System.out.println("�Ѿ����ӵ����ݿ�...");
														st = conn.createStatement();
														String sql = "insert into ������Ϣ(��ʦ���,ר�����ı��,�о�����,�о����)values('"
																+ c1 + "','" + c2 + "','" + c3 + "','" + c4 + "')";
														st.executeUpdate(sql.toString());
														javax.swing.JOptionPane.showMessageDialog(null, "¼��ɹ�����");
													} catch (Exception e2) {
														e2.printStackTrace();
														javax.swing.JOptionPane.showMessageDialog(null, "¼��ʧ�ܣ���");
													} finally {
														jdbcUtil.close(rs, st, conn);
													}

												}
											}
										}
									}
								}
							}
						}
					}
				}
			});
			JPanel jp = new JPanel();

			JPanel jp1 = new JPanel();
			JPanel jp2 = new JPanel();
			JPanel jp3 = new JPanel();
			JPanel jp4 = new JPanel();
			JPanel jp5 = new JPanel();
			jp1.add(jl1);
			jp1.add(jt1);

			jp2.add(jl2);
			jp2.add(jt2);
			jp2.add(jl3);
			jp2.add(jt3);
			jp2.add(jl4);
			jp2.add(jt4);

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
			imagePanel.add(jp4);
			imagePanel.add(jp5);

			jp1.setOpaque(false);
			jp2.setOpaque(false);
			jp3.setOpaque(false);
			jp4.setOpaque(false);
			jp5.setOpaque(false);
			jp.setOpaque(false);

			framestaff.getLayeredPane().setLayout(null);
			framestaff.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			framestaff.add(jp, BorderLayout.SOUTH);

			framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			framestaff.setVisible(true);

		}
	}

}
