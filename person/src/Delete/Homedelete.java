package Delete;

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

public class Homedelete extends JFrame implements ActionListener {

	JScrollPane scpDemo;
	JFrame Add;
	JTableHeader jth;
	JTable tabDemo;
	JTextField text, Addbh, Addlwbh, Addyjfx, Addyjqk;
	JLabel ��ʦ���, ר�����ı��, �о�����, �о����;
	JButton anShow, anSet, anSelsct, Addyes, Addno;
	String SQLbh, SQLlwbh, SQLyjfx, SQLyjqk;
	String a[] = { SQLbh, SQLlwbh, SQLyjfx, SQLyjqk };

	public Homedelete() {
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

		this.anSet = new JButton("ɾ��");
		this.anSet.setBounds(100, 435, 70, 25);

		this.scpDemo = new JScrollPane(); // ������
		this.scpDemo.setBounds(10, 50, 365, 380);
		Addbh = new JTextField();
		Addlwbh = new JTextField();
		Addyjfx = new JTextField();
		Addyjqk = new JTextField();

		��ʦ��� = new JLabel(" ��ʦ���");
		ר�����ı�� = new JLabel("ר�����ı��");
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
		Add.add(Addbh);
		Add.add(ר�����ı��);
		Add.add(Addlwbh);
		Add.add(�о�����);
		Add.add(Addyjfx);
		Add.add(�о����);
		Add.add(Addyjqk);

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

	Delete_chaxun re = new Delete_chaxun();
	int f = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == (anSelsct)) {// ��ѯ
			f = 1;
			// System.out.println(f);
			String ��� = this.text.getText().trim();
			String sql = "select * from ������Ϣ  where ר�����ı��='" + ר�����ı�� + "'";
			Delete_chaxun aa = new Delete_chaxun(sql);

			tabDemo.setModel(aa);

		}
		if (e.getSource() == anShow) {// ˢ��
			Delete_chaxun re = new Delete_chaxun();
			tabDemo.setModel(re);
			f = 0;
		}

		else if (e.getSource() == anSet && f == 0) {// �޸�

			int j = this.tabDemo.getSelectedRow();
			// System.out.println("wei");
			Delete_chaxun re = new Delete_chaxun();
			clear_scient a = new clear_scient(0);
			re = new Delete_chaxun();
			tabDemo.setModel(re);
		} else if (e.getSource() == anSet && f == 1) {
			int j = this.tabDemo.getSelectedRow();
			// System.out.println("yi");
			String ��� = this.text.getText().trim();
			String sql = "select * from ������Ϣ  where ר�����ı��='" + ר�����ı�� + "'";
			re = new Delete_chaxun(sql);
			clear_scient a = new clear_scient(0);
			tabDemo.setModel(re);

		}
	}

}
