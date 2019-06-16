package person;

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

public class staffInquire implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("教师信息查询")) {
			final JFrame framestaff = new JFrame("教师信息查询");
			framestaff.setBounds(200, 100, 500, 500);

			JLabel jl1 = new JLabel("要查询的教师编号");
			jl1.setToolTipText("例如:1401");
			final JTextField jt1 = new JTextField(8);
			JLabel jl2 = new JLabel("要查询的教师姓名");
			final JTextField jt2 = new JTextField(6);

			JButton jb1 = new JButton("查询");
			jb1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String c1 = jt1.getText().toString();
					String c2 = jt2.getText().toString();
					if (c1.equals("") && c2.equals("")) {
						javax.swing.JOptionPane.showMessageDialog(null, "请输入查询条件");
					}
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
						String sql = "select * from 教师信息";
						st = conn.createStatement();
						rs = st.executeQuery(sql);
						int count = 0;
						while (rs.next()) {

							// count++;
							// System.out.println(count);
							if (c1.equals(rs.getString(1))) {
								// System.out.println(rs.getString(1));
								Object[][] obj = new Object[1][10];
								// rs=st.executeQuery("select * from 教师信息");
								// System.out.println(rs);
								int i = 0;
								// i=count-1;
								// System.out.println(i);

								obj[i][0] = rs.getObject(1);
								// System.out.println(rs.getObject(1));
								obj[i][1] = rs.getObject(2);
								obj[i][2] = rs.getObject(3);
								obj[i][3] = rs.getObject(4);
								obj[i][4] = rs.getObject(5);
								obj[i][5] = rs.getObject(6);
								obj[i][6] = rs.getObject(7);
								obj[i][7] = rs.getObject(8);
								obj[i][8] = rs.getObject(9);
								obj[i][9] = rs.getObject(10);
								// i++;

								final JFrame f = new JFrame("教师信息查询结果");
								String[] Names = { "编号", "姓名", "性别", "学历", "职务", "职称", "毕业院校", "奖惩", "在职信息", "部门编号" };
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
								column = table.getColumnModel().getColumn(3);
								column.setPreferredWidth(80);
								column = table.getColumnModel().getColumn(4);
								column.setPreferredWidth(80);
								column = table.getColumnModel().getColumn(5);
								column.setPreferredWidth(80);
								column = table.getColumnModel().getColumn(6);
								column.setPreferredWidth(60);
								column = table.getColumnModel().getColumn(7);
								column.setPreferredWidth(60);
								column = table.getColumnModel().getColumn(8);
								column.setPreferredWidth(60);
								column = table.getColumnModel().getColumn(9);
								column.setPreferredWidth(150);

								f.setBounds(300, 200, 800, 200);
								f.setUndecorated(true);
								f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
								f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								f.setVisible(true);

							}
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

			jp1.add(jl1);
			jp1.add(jt1);

			jp2.add(jl2);
			jp2.add(jt2);
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

			jp1.setOpaque(false);
			jp2.setOpaque(false);
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
