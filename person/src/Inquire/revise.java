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
	private JLabel ���, ����, �Ա�, ѧ��, ְ��, ְ��, ��ҵԺУ, ����, ��ְ��Ϣ, ���ű��;

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
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");
			return;

		}

		setbianhao = new JTextField(5);
		setbianhao.setText((String) xx.getValueAt(j, 0));
		setbianhao.setEditable(false);// ����Ϊ�����޸ģ���ֹ����
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

		��� = new JLabel("���");
		���� = new JLabel("����");
		�Ա� = new JLabel("�Ա�");
		ѧ�� = new JLabel(" ѧ��");
		ְ�� = new JLabel("ְ��");
		ְ�� = new JLabel("ְ��");
		��ҵԺУ = new JLabel("��ҵԺУ"); // ְ��,ְ��,��ҵԺУ,����,��ְ��Ϣ,���ű��;
		���� = new JLabel("����");
		��ְ��Ϣ = new JLabel("��ְ��Ϣ");
		���ű�� = new JLabel("���ű��");

		Addyes = new JButton("ȷ��");
		Addno = new JButton("ȡ��");
		this.add(���);
		this.add(setbianhao);
		this.add(����);
		this.add(setname);
		this.add(�Ա�);
		this.add(setxingbie);
		this.add(ѧ��);
		this.add(setxueli);
		this.add(ְ��);
		this.add(setzhiwu);
		this.add(ְ��);
		this.add(setchicheng);
		this.add(��ҵԺУ);
		this.add(setschool);
		this.add(����);
		this.add(setjiangc);
		this.add(��ְ��Ϣ);
		this.add(setzaiz);
		this.add(���ű��);
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
				// �������
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=���¹���ϵͳ", "sa",
						"123456");
				// ������ѯ����

				String recode = " update ��ʦ��Ϣ set ����=?,�Ա�=?,ѧ��=?,ְ��=?,ְ��=?,��ҵԺУ=?,����=?,��ְ��Ϣ=?,���ű��=? where ���=?";

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
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.dispose();
			} catch (NumberFormatException nu) {
				JOptionPane.showMessageDialog(null, "�㻹û������Ŷ", "����", JOptionPane.ERROR_MESSAGE);
			}

			catch (ClassNotFoundException cnfe) {
				JOptionPane.showMessageDialog(null, "����Դ����", "����", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
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
