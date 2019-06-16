package Update;

import java.awt.Frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class tearevise extends JDialog implements ActionListener {
	private JTextField setbianhao, setname, setkc;
	private JLabel 教师编号, 教师姓名, 课程编号;
	private JButton Addyes, Addno;
	private Connection con = null;
	private Statement sql = null;
	private ResultSet rs = null;
	private String SQLbianhao, SQLname, SQLkc;

	tearevise(Frame fck, String ckm, Boolean msck, teachaxun xx, int j) {

		super(fck, ckm, msck);

		if (j == -1) {
			JOptionPane.showMessageDialog(null, "请选中要修改的行");
			return;

		}
		setbianhao = new JTextField(5);
		setbianhao.setText((String) xx.getValueAt(j, 0));
		// setbianhao.setEditable(false);//设置为不能修改，防止出错
		setname = new JTextField(5);
		setname.setText((String) xx.getValueAt(j, 1));
		setkc = new JTextField(5);
		setkc.setText((String) xx.getValueAt(j, 2));

		教师编号 = new JLabel("编号");
		教师姓名 = new JLabel("教师姓名");
		课程编号 = new JLabel("性别");

		Addyes = new JButton("确定");
		Addno = new JButton("取消");
		this.add(教师编号);
		this.add(setbianhao);
		this.add(教师姓名);
		this.add(setname);
		this.add(课程编号);
		this.add(setkc);

		this.add(Addyes);
		this.add(Addno);
		this.Addyes.addActionListener(this);
		this.Addno.addActionListener(this);
		this.setSize(350, 400);
		this.setLocation(100, 260);
		this.setLayout(new GridLayout(8, 2));
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Addyes) {
			try {
				// 获得连接
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=人事管理系统", "sa",
						"123456");
				// 建立查询条件

				String recode = " update 教师教学信息 set 教师姓名=?,课程编号=? where 教师编号=?";

				PreparedStatement input = con.prepareStatement(recode);

				input.setString(1, setname.getText());
				input.setString(2, setkc.getText());
				// input.setString(3,setxueli.getText());
				input.setString(3, setbianhao.getText());

				// input.setString(11,setbum.getText());
				input.executeUpdate();
				JOptionPane.showMessageDialog(null, "修改成功");
				this.dispose();
			} catch (NumberFormatException nu) {
				JOptionPane.showMessageDialog(null, "你还没有输入哦", "错误", JOptionPane.ERROR_MESSAGE);
			}

			catch (ClassNotFoundException cnfe) {
				JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (sql != null) {
						sql.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (Exception e1) {
				}
			}
		}

		if (e.getSource() == Addno) {
			this.dispose();
		}
	}

}