package Inquire;

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

import Update.Update_chaxun;

public class revise extends JDialog implements ActionListener {
	private JTextField setbianhao, setname, setxingbie, setxueli, setzhiwu, setchicheng, setschool, setjiangc, setzaiz,
			setbum;
	private JLabel 编号, 姓名, 性别, 学历, 职务, 职称, 毕业院校, 奖惩, 在职信息, 部门编号;

	private JButton Addyes, Addno;
	private Connection con = null;
	private Statement sql = null;
	private ResultSet rs = null;
	private String SQLbianhao, SQLname, SQLxingbie, SQLxueli, SQLzhiwu, SQLchicheng, SQLschool, SQLjiangc, SQLzaiz,
			SQLpbum;

	public revise(Frame fck, String ckm, Boolean msck, Update_chaxun xx, int j) {

		super(fck, ckm, msck);
		System.out.println(j);
		if (j == -1) {
			JOptionPane.showMessageDialog(null, "请选中要修改的行");
			return;

		}

		setbianhao = new JTextField(5);
		setbianhao.setText((String) xx.getValueAt(j, 0));
		setbianhao.setEditable(false);// 设置为不能修改，防止出错
		setname = new JTextField(5);
		setname.setText((String) xx.getValueAt(j, 1));
		setxingbie = new JTextField(5);
		setxingbie.setText((String) xx.getValueAt(j, 3));
		setxueli = new JTextField(5);
		setxueli.setText((String) xx.getValueAt(j, 2));
		setzhiwu = new JTextField(5);
		setzhiwu.setText((String) xx.getValueAt(j, 4));
		setchicheng = new JTextField(5);
		setchicheng.setText((String) xx.getValueAt(j, 5));
		setschool = new JTextField(5);
		setschool.setText((String) xx.getValueAt(j, 6));
		setjiangc = new JTextField(5);
		setjiangc.setText((String) xx.getValueAt(j, 7));
		setzaiz = new JTextField(5);
		setzaiz.setText((String) xx.getValueAt(j, 8));
		setbum = new JTextField(5);
		setbum.setText((String) xx.getValueAt(j, 9));

		编号 = new JLabel("编号");
		姓名 = new JLabel("姓名");
		性别 = new JLabel("性别");
		学历 = new JLabel(" 学历");
		职务 = new JLabel("职务");
		职称 = new JLabel("职称");
		毕业院校 = new JLabel("毕业院校"); // 职务,职称,毕业院校,奖惩,在职信息,部门编号;
		奖惩 = new JLabel("奖惩");
		在职信息 = new JLabel("在职信息");
		部门编号 = new JLabel("部门编号");

		Addyes = new JButton("确定");
		Addno = new JButton("取消");
		this.add(编号);
		this.add(setbianhao);
		this.add(姓名);
		this.add(setname);
		this.add(性别);
		this.add(setxingbie);
		this.add(学历);
		this.add(setxueli);
		this.add(职务);
		this.add(setzhiwu);
		this.add(职称);
		this.add(setchicheng);
		this.add(毕业院校);
		this.add(setschool);
		this.add(奖惩);
		this.add(setjiangc);
		this.add(在职信息);
		this.add(setzaiz);
		this.add(部门编号);
		this.add(setbum);

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

				String recode = " update 教师信息 set 姓名=?,性别=?,学历=?,职务=?,职称=?,毕业院校=?,奖惩=?,在职信息=?,部门编号=? where 编号=?";

				PreparedStatement input = con.prepareStatement(recode);

				input.setString(1, setname.getText());
				input.setString(2, setxingbie.getText());
				input.setString(3, setxueli.getText());
				input.setString(4, setzhiwu.getText());
				input.setString(5, setchicheng.getText());
				input.setString(6, setschool.getText()); // setschool,setjiangc,setzaiz,setbum;
				input.setString(7, setjiangc.getText());
				input.setString(8, setzaiz.getText());
				input.setString(9, setbum.getText());
				input.setString(10, setbianhao.getText());

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
