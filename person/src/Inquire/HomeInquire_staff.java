package Inquire;

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

import Update.Update_chaxun;
import Update.revise;

public class HomeInquire_staff extends JFrame implements ActionListener {

	JScrollPane scpDemo;
	JFrame Add;
	JTableHeader jth;
	JTable tabDemo;
	JTextField text, Addbh, Addname, Addxingbie, Addxl, Addzw, Addzc, Addschool, Addjc, Addzzxx, Addbmbh;
	JLabel ���, ����, �Ա�, ѧ��, ְ��, ְ��, ��ҵԺУ, ����, ��ְ��Ϣ, ���ű��;
	JButton anShow, anSet, anSelsct, Addyes, Addno;
	String SQLbh, SQLname, SQLxingbie, SQLxl, SQLzw, SQLzc, SQLschool, SQLjc, SQLzzxx, SQLbmbh;
	String a[] = { SQLbh, SQLname, SQLxingbie, SQLxl, SQLzw, SQLzc, SQLschool, SQLjc, SQLzzxx, SQLbmbh };

	public HomeInquire_staff() {
		super("���¹���ϵͳ");
		this.setSize(400, 500);
		this.setLayout(null);
		this.setLocation(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);// ����
		JLabel a = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\1.jpg"));
		a.setBounds(new Rectangle(0, 0, 1500, 680));

		this.text = new JTextField();
		this.text.setBounds(10, 20, 200, 25);
		this.anSelsct = new JButton("��ѯ");
		this.anSelsct.setBounds(230, 20, 70, 25);
		this.anShow = new JButton("ˢ��");
		this.anShow.setBounds(310, 20, 70, 25);

		this.anSet = new JButton("�޸�");
		this.anSet.setBounds(100, 435, 70, 25);

		this.scpDemo = new JScrollPane(); // ������
		this.scpDemo.setBounds(10, 50, 365, 380);
		Addbh = new JTextField();
		Addname = new JTextField();
		Addxingbie = new JTextField();
		Addxl = new JTextField();
		Addzw = new JTextField();
		Addzc = new JTextField();
		Addschool = new JTextField();
		Addjc = new JTextField();
		Addzzxx = new JTextField();
		Addbmbh = new JTextField();

		��� = new JLabel(" ���");
		���� = new JLabel("����");
		�Ա� = new JLabel("�Ա�");
		ѧ�� = new JLabel("ѧ��");
		ְ�� = new JLabel("ְ��");
		ְ�� = new JLabel("ְ��");
		��ҵԺУ = new JLabel("��ҵԺУ");
		���� = new JLabel("����");
		��ְ��Ϣ = new JLabel("��ְ��Ϣ");
		���ű�� = new JLabel("���ű��");

		Addyes = new JButton("ȷ��");
		Addno = new JButton("ȡ��");
		// ��Ӵ��ڵĴ���
		Add = new JFrame();
		Add.setTitle("���");
		Add.setSize(350, 400);
		Add.setLocation(100, 260);
		Add.setLayout(new GridLayout(8, 2));

		Add.add(���);
		Add.add(Addbh);
		Add.add(����);
		Add.add(Addname);
		Add.add(�Ա�);
		Add.add(Addxingbie);
		Add.add(ѧ��);
		Add.add(Addxl);
		Add.add(ְ��);
		Add.add(Addzw);
		Add.add(ְ��);
		Add.add(Addzc);
		Add.add(��ҵԺУ);
		Add.add(Addschool);
		Add.add(����);
		Add.add(Addjc);
		Add.add(��ְ��Ϣ);
		Add.add(Addzzxx);
		Add.add(���ű��);
		Add.add(Addbmbh);

		Add.add(Addyes);
		Add.add(Addno);
		Addyes.addActionListener(this);
		Addno.addActionListener(this);

		anShow.addActionListener(this);
		anSet.addActionListener(this);
		anSelsct.addActionListener(this);

		this.scpDemo.getViewport().add(tabDemo); // ���ؼ������������� ���ÿɼ������������

		add(this.scpDemo);
		add(this.text);
		add(this.anSelsct);
		add(this.anShow);

		add(this.anSet);
		this.remove(this);// ˢ��
		this.repaint();// �ػ�component�ķ�����component�����е�ͼ�η����仯�󲻻�������ʾ����ʹ��repaint����

		try {
			// �������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=���¹���ϵͳ", "sa",
					"123456");
			// ������ѯ����
			String sql = "select * from ��ʦ��Ϣ";

			// ��chapiao����Ѱ�������Ϣ

			PreparedStatement pstm = conn.prepareStatement(sql);
			// ִ�в�ѯ
			ResultSet rs = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][10];
			count = 0;
			while (rs.next()) {

				info[count][0] = rs.getString("���");
				info[count][1] = rs.getString("����");
				info[count][2] = rs.getString("�Ա�");
				info[count][3] = rs.getString("ѧ��");
				info[count][4] = rs.getString("ְ��");
				info[count][5] = rs.getString("ְ��");
				info[count][6] = rs.getString("��ҵԺУ");
				info[count][7] = rs.getString("����");
				info[count][8] = rs.getString("��ְ��Ϣ");
				info[count][9] = rs.getString("���ű��");

				count++;
			}
			// �����ͷ
			String[] title = { "���", "����", "�Ա�", "ѧ��", "ְ��", "ְ��", "��ҵԺУ", "����", "��ְ��Ϣ", "���ű��" };
			// ����JTable
			this.tabDemo = new JTable(info, title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "����Դ����", "����", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}

	}

	Update_chaxun re = new Update_chaxun();
	int f = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == (anSelsct)) {// ��ѯ
			f = 1;
			// System.out.println(f);
			String ��� = this.text.getText().trim();
			String sql = "select * from ��ʦ��Ϣ  where ���='" + ��� + "'";
			Update_chaxun aa = new Update_chaxun(sql);

			tabDemo.setModel(aa);

		}
		if (e.getSource() == anShow) {// ˢ��
			Update_chaxun re = new Update_chaxun();
			tabDemo.setModel(re);
			f = 0;
		}

		else if (e.getSource() == anSet && f == 0) {// �޸�

			int j = this.tabDemo.getSelectedRow();
			// System.out.println("wei");
			Update_chaxun re = new Update_chaxun();
			revise a = new revise(this, "�޸Ľ�ʦ", true, re, j);
			re = new Update_chaxun();
			tabDemo.setModel(re);
		} else if (e.getSource() == anSet && f == 1) {
			int j = this.tabDemo.getSelectedRow();
			// System.out.println("yi");
			String ��� = this.text.getText().trim();
			String sql = "select * from ��ʦ��Ϣ  where ���='" + ��� + "'";
			re = new Update_chaxun(sql);
			revise a = new revise(this, "�޸Ľ�ʦ", true, re, j);
			tabDemo.setModel(re);

		}
	}

}
