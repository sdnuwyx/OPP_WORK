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
		if (e.getActionCommand().equals("科研信息录入")) {
			final JFrame framestaff = new JFrame("科研信息录入");
			framestaff.setBounds(200, 100, 500, 500);
			JLabel jl1 = new JLabel("教师编号");
			jl1.setToolTipText("例如:1401");
			final JTextField jt1 = new JTextField(8);
			JLabel jl2 = new JLabel("专利论文编号");
			final JTextField jt2 = new JTextField(6);
			JLabel jl3 = new JLabel("研究方向");
			final JTextField jt3 = new JTextField(5);
			JLabel jl4 = new JLabel("研究情况");
			final JTextField jt4 = new JTextField(10);
			JButton jb1 = new JButton("添加");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("添加")) {
						String c1 = jt1.getText();
						if (c1.equals("")) {
							javax.swing.JOptionPane.showMessageDialog(null, "请输入教师编号！");
						} else {
							if (Integer.parseInt(c1) <= 1000 || Integer.parseInt(c1) >= 4000) {
								javax.swing.JOptionPane.showMessageDialog(null, "教师编号输入错误");
							} else {
								if (jdbcUtil.nunnumber(c1, "教师信息")) {
									javax.swing.JOptionPane.showMessageDialog(null, "教师不存在");
								} else {
									String c2 = jt2.getText();
									if (c2.equals("")) {
										javax.swing.JOptionPane.showMessageDialog(null, "请输入专利论文编号！");
									} else {
										if (Integer.parseInt(c2) <= 100 || Integer.parseInt(c2) >= 1000) {
											javax.swing.JOptionPane.showMessageDialog(null, "专利论文编号输入错误");
										} else {
											if (jdbcUtil.nunnumber(c2, "专利论文")) {
												javax.swing.JOptionPane.showMessageDialog(null, "专利论文不存在");
											} else {
												String c3 = jt3.getText();
												String c4 = jt4.getText();
												if (c3.equals("") || c4.equals("")) {
													javax.swing.JOptionPane.showMessageDialog(null, "请输入信息！");
												} else {
													Connection conn = null;
													java.sql.Statement st = null;
													ResultSet rs = null;
													try {
														conn = jdbcUtil.getSQLConn();
														conn.setAutoCommit(true);
														System.out.println("已经连接到数据库...");
														st = conn.createStatement();
														String sql = "insert into 科研信息(教师编号,专利论文编号,研究方向,研究情况)values('"
																+ c1 + "','" + c2 + "','" + c3 + "','" + c4 + "')";
														st.executeUpdate(sql.toString());
														javax.swing.JOptionPane.showMessageDialog(null, "录入成功！！");
													} catch (Exception e2) {
														e2.printStackTrace();
														javax.swing.JOptionPane.showMessageDialog(null, "录入失败！！");
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
