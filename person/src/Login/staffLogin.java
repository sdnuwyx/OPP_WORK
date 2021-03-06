package Login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import DB.jdbcUtil;

public class staffLogin implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("教师信息录入")) {
			final JFrame framestaff = new JFrame("教师信息录入");
			framestaff.setBounds(200, 100, 500, 500);
			JLabel jl1 = new JLabel("编号");
			jl1.setToolTipText("例如:1401");
			final JTextField jt1 = new JTextField(8);
			JLabel jl2 = new JLabel("姓名");
			final JTextField jt2 = new JTextField(6);
			JLabel jl3 = new JLabel("性别");
			final JTextField jt3 = new JTextField(5);
			JLabel jl4 = new JLabel("学历");
			jl4.setToolTipText("大专，本科，研究生...");
			final JTextField jt4 = new JTextField(10);
			JLabel jl5 = new JLabel("职务");
			final JTextField jt5 = new JTextField(10);
			JLabel jl6 = new JLabel("职称");
			final JTextField jt6 = new JTextField(10);
			JLabel jl7 = new JLabel("毕业院校");
			// jl1.setToolTipText("差，良好...");
			final JTextField jt7 = new JTextField(5);
			JLabel jl8 = new JLabel("奖惩");
			final JTextField jt8 = new JTextField(10);
			JLabel jl9 = new JLabel("在职信息");
			final JTextField jt9 = new JTextField(10);
			JLabel jl10 = new JLabel("部门编号");
			final JTextField jt10 = new JTextField(30);

			JButton jb1 = new JButton("添加");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("添加")) {
						String c1 = jt1.getText().toString();
						if (c1.equals("")) {
							javax.swing.JOptionPane.showMessageDialog(null, "请输入编号！");
						} else if (Integer.parseInt(c1) <= 1000 || Integer.parseInt(c1) >= 4000) {
							javax.swing.JOptionPane.showMessageDialog(null, "编号输入错误!");
						} else {
							if (jdbcUtil.samenumber(c1, "教师信息")) {

								javax.swing.JOptionPane.showMessageDialog(null, "此编号已经存在！");
							} else {
								if (jdbcUtil.nunnumber(c1, "教师信息")) {
									String c2 = jt2.getText().toString();
									String c3 = jt3.getText().toString();
									System.out.println(c3);
									if (!c3.equals("女")&&!c3.equals("男")) {
										javax.swing.JOptionPane.showMessageDialog(null, "性别输入错误!请输入男或女。");
									} else {
										String c4 = jt4.getText().toString();
										if (!c4.equals("大专")&&!c4.equals("本科")&&!c4.equals("研究生")) {
											javax.swing.JOptionPane.showMessageDialog(null, "学历输入错误!请输入大专、本科、研究生");
										} else {
											String c5 = jt5.getText().toString();
											if (!c5.equals("无")&&!c5.equals("主任")&&!c5.equals("副主任")) {
												javax.swing.JOptionPane.showMessageDialog(null, "职务输入错误!请输入无、主任、副主任");
											} else {
												String c6 = jt6.getText().toString();
												if (!c6.equals("讲师")&&!c6.equals("教授")&&!c6.equals("副教授")) {
													javax.swing.JOptionPane.showMessageDialog(null,
															"职称输入错误!请输入讲师、教授、副教授");
												} else {

													String c7 = jt7.getText().toString();
													String c8 = jt8.getText().toString();
													String c9 = jt9.getText().toString();
													if (!c9.equals("在职")&&!c9.equals("转出")&&!c9.equals("退休")&&!c9.equals("辞退")) {
														javax.swing.JOptionPane.showMessageDialog(null,
																"在职信息输入错误!请输入在职、转出、退休、辞退");
													} else {
														String c10 = jt10.getText().toString();
														if (jdbcUtil.nunnumber(c10, "部门编号")) {
															javax.swing.JOptionPane.showMessageDialog(null, "部门不存在");
														} else {

															Connection conn = null;
															java.sql.Statement st = null;
															ResultSet rs = null;
															try {
																conn = jdbcUtil.getSQLConn();
																conn.setAutoCommit(true);
																System.out.println("已经连接到数据库...");

																String sql = "insert into 教师信息(编号,姓名,性别,学历,职务,职称,毕业院校,奖惩,在职信息,部门编号)values('"
																		+ c1 + "','" + c2 + "','" + c3 + "','" + c4
																		+ "','" + c5 + "','" + c6 + "','" + c7 + "','"
																		+ c8 + "','" + c9 + "','" + c10 + "')";
																st = conn.createStatement();
																st.executeUpdate(sql);
																javax.swing.JOptionPane.showMessageDialog(null,
																		"录入成功！！");
															} catch (Exception e2) {
																e2.printStackTrace();
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

			jp3.add(jl5);
			jp3.add(jt5);
			jp3.add(jl6);
			jp3.add(jt6);

			jp4.add(jl7);
			jp4.add(jt7);
			jp4.add(jl8);
			jp4.add(jt8);
			jp4.add(jl9);
			jp4.add(jt9);

			jp5.add(jl10);
			jp5.add(jt10);

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
