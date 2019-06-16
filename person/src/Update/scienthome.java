package Update;

import java.awt.GridLayout;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;

public class scienthome extends JFrame implements ActionListener {

	JScrollPane scpDemo;
	JFrame Add;
	JTableHeader jth;
	JTable tabDemo;
	JTextField text, Addjsbh, Addzlbh, Addfangx, Addqingk;
	JLabel 教师编号, 专利论文编号, 研究方向, 研究情况;
	JButton anShow, anSet, anSelsct, anClear, Addyes, Addno;
	String SQLjsbh, SQLzlbh, SQLfangx, SQLqingk;
	String a[] = { SQLjsbh, SQLzlbh, SQLfangx, SQLqingk };

	public scienthome() {
		super("人事管理系统");
		this.setSize(400, 500);
		this.setLayout(null);
		this.setLocation(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);// 钉死
		JLabel a = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\1.jpg"));
		a.setBounds(new Rectangle(0, 0, 1500, 680));

		this.text = new JTextField();
		this.text.setBounds(10, 20, 200, 25);
		this.anSelsct = new JButton("查询");
		this.anSelsct.setBounds(230, 20, 70, 25);
		this.anShow = new JButton("刷新");
		this.anShow.setBounds(310, 20, 70, 25);
		this.anSet = new JButton("修改");
		this.anSet.setBounds(100, 435, 70, 25);

		this.anClear = new JButton("删除");
		this.anClear.setBounds(180, 435, 70, 25);

		this.scpDemo = new JScrollPane(); // 滚动条
		this.scpDemo.setBounds(10, 50, 365, 380);
		Addjsbh = new JTextField();
		Addzlbh = new JTextField();
		Addfangx = new JTextField();
		Addqingk = new JTextField();

		教师编号 = new JLabel("教师编号");
		专利论文编号 = new JLabel(" 专利论文编号");
		研究方向 = new JLabel("研究方向");
		研究情况 = new JLabel("研究情况");

		Addyes = new JButton("确定");
		Addno = new JButton("取消");
		// 添加窗口的创建
		Add = new JFrame();
		Add.setTitle("添加");
		Add.setSize(350, 400);
		Add.setLocation(100, 260);
		Add.setLayout(new GridLayout(8, 2));

		Add.add(教师编号);
		Add.add(Addjsbh);
		Add.add(专利论文编号);
		Add.add(Addzlbh);
		Add.add(研究方向);
		Add.add(Addfangx);
		Add.add(研究情况);
		Add.add(Addqingk);

		Add.add(Addyes);
		Add.add(Addno);
		Addyes.addActionListener(this);
		Addno.addActionListener(this);

		anShow.addActionListener(this);
		anSet.addActionListener(this);
		anSelsct.addActionListener(this);
		anClear.addActionListener(this);
		this.scpDemo.getViewport().add(tabDemo); // 给控件，滚动条、、 设置可见、、增加配件

		add(this.scpDemo);
		add(this.text);
		add(this.anSelsct);
		add(this.anShow);

		add(this.anSet);
		add(this.anClear);
		this.remove(this);// 刷新
		this.repaint();// 重绘component的方法，component中已有的图形发生变化后不会立刻显示，须使用repaint方法

		try {
			// 获得连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=人事管理系统", "sa",
					"123456");
			// 建立查询条件
			String sql = "select * from 科研信息";
			// 从chapiao表中寻找相关信息

			PreparedStatement pstm = conn.prepareStatement(sql);
			// 执行查询
			ResultSet rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			Object[][] info = new Object[count][10];
			count = 0;
			while (rs.next()) {

				info[count][0] = rs.getString("教师编号");
				info[count][1] = rs.getString("专利论文编号");
				info[count][2] = rs.getString("研究方向");
				info[count][3] = rs.getString("研究情况");

				count++;
			}
			// 定义表头
			String[] title = { "教师编号", "专利论文编号", "研究方向", "研究情况" };
			// 创建JTable
			this.tabDemo = new JTable(info, title);
			// 显示表头
			this.jth = this.tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			this.scpDemo.getViewport().add(tabDemo);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}

	}

	scientchaxun re = new scientchaxun();
	int f = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == (anSelsct)) {// 查询
			f = 1;
			System.out.println(f);
			String 教师编号 = this.text.getText().trim();
			String sql = "select * from 科研信息  where " + "教师编号='" + 教师编号 + "'";
			scientchaxun aa = new scientchaxun(sql);

			tabDemo.setModel(aa);

		}
		if (e.getSource() == anShow) {// 刷新
			scientchaxun re = new scientchaxun();
			tabDemo.setModel(re);
			f = 0;
		} else if (e.getSource() == (anClear)) {
			int i = this.tabDemo.getSelectedRow();
			re = new scientchaxun();
			tabDemo.setModel(re);

		}

		else if (e.getSource() == anSet && f == 0) {// 修改

			int j = this.tabDemo.getSelectedRow();
			// System.out.println("wei");
			scientchaxun re = new scientchaxun();
			scientrevise a = new scientrevise(this, "修改教师", true, re, j);
			re = new scientchaxun();
			tabDemo.setModel(re);
		} else if (e.getSource() == anSet && f == 1) {
			int j = this.tabDemo.getSelectedRow();
			// System.out.println("yi");
			String 教师编号 = this.text.getText().trim();
			String sql = "select * from 科研信息  where 教师编号='" + 教师编号 + "'";
			re = new scientchaxun(sql);
			scientrevise a = new scientrevise(this, "修改教师", true, re, j);
			tabDemo.setModel(re);

		}
	}

}
