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
	JLabel ��ʦ���, ר�����ı��, �о�����, �о����;
	JButton anShow, anSet, anSelsct, anClear, Addyes, Addno;
	String SQLjsbh, SQLzlbh, SQLfangx, SQLqingk;
	String a[] = { SQLjsbh, SQLzlbh, SQLfangx, SQLqingk };

	public scienthome() {
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

		this.anClear = new JButton("ɾ��");
		this.anClear.setBounds(180, 435, 70, 25);

		this.scpDemo = new JScrollPane(); // ������
		this.scpDemo.setBounds(10, 50, 365, 380);
		Addjsbh = new JTextField();
		Addzlbh = new JTextField();
		Addfangx = new JTextField();
		Addqingk = new JTextField();

		��ʦ��� = new JLabel("��ʦ���");
		ר�����ı�� = new JLabel(" ר�����ı��");
		�о����� = new JLabel("�о�����");
		�о���� = new JLabel("�о����");

		Addyes = new JButton("ȷ��");
		Addno = new JButton("ȡ��");
		// ��Ӵ��ڵĴ���
		Add = new JFrame();
		Add.setTitle("���");
		Add.setSize(350, 400);
		Add.setLocation(100, 260);
		Add.setLayout(new GridLayout(8, 2));

		Add.add(��ʦ���);
		Add.add(Addjsbh);
		Add.add(ר�����ı��);
		Add.add(Addzlbh);
		Add.add(�о�����);
		Add.add(Addfangx);
		Add.add(�о����);
		Add.add(Addqingk);

		Add.add(Addyes);
		Add.add(Addno);
		Addyes.addActionListener(this);
		Addno.addActionListener(this);

		anShow.addActionListener(this);
		anSet.addActionListener(this);
		anSelsct.addActionListener(this);
		anClear.addActionListener(this);
		this.scpDemo.getViewport().add(tabDemo); // ���ؼ������������� ���ÿɼ������������

		add(this.scpDemo);
		add(this.text);
		add(this.anSelsct);
		add(this.anShow);

		add(this.anSet);
		add(this.anClear);
		this.remove(this);// ˢ��
		this.repaint();// �ػ�component�ķ�����component�����е�ͼ�η����仯�󲻻�������ʾ����ʹ��repaint����

		try {
			// �������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=���¹���ϵͳ", "sa",
					"123456");
			// ������ѯ����
			String sql = "select * from ������Ϣ";
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

				info[count][0] = rs.getString("��ʦ���");
				info[count][1] = rs.getString("ר�����ı��");
				info[count][2] = rs.getString("�о�����");
				info[count][3] = rs.getString("�о����");

				count++;
			}
			// �����ͷ
			String[] title = { "��ʦ���", "ר�����ı��", "�о�����", "�о����" };
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

	scientchaxun re = new scientchaxun();
	int f = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == (anSelsct)) {// ��ѯ
			f = 1;
			System.out.println(f);
			String ��ʦ��� = this.text.getText().trim();
			String sql = "select * from ������Ϣ  where " + "��ʦ���='" + ��ʦ��� + "'";
			scientchaxun aa = new scientchaxun(sql);

			tabDemo.setModel(aa);

		}
		if (e.getSource() == anShow) {// ˢ��
			scientchaxun re = new scientchaxun();
			tabDemo.setModel(re);
			f = 0;
		} else if (e.getSource() == (anClear)) {
			int i = this.tabDemo.getSelectedRow();
			re = new scientchaxun();
			tabDemo.setModel(re);

		}

		else if (e.getSource() == anSet && f == 0) {// �޸�

			int j = this.tabDemo.getSelectedRow();
			// System.out.println("wei");
			scientchaxun re = new scientchaxun();
			scientrevise a = new scientrevise(this, "�޸Ľ�ʦ", true, re, j);
			re = new scientchaxun();
			tabDemo.setModel(re);
		} else if (e.getSource() == anSet && f == 1) {
			int j = this.tabDemo.getSelectedRow();
			// System.out.println("yi");
			String ��ʦ��� = this.text.getText().trim();
			String sql = "select * from ������Ϣ  where ��ʦ���='" + ��ʦ��� + "'";
			re = new scientchaxun(sql);
			scientrevise a = new scientrevise(this, "�޸Ľ�ʦ", true, re, j);
			tabDemo.setModel(re);

		}
	}

}
