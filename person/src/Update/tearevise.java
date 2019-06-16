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
	private JLabel ��ʦ���, ��ʦ����, �γ̱��;
	private JButton Addyes, Addno;
	private Connection con = null;
	private Statement sql = null;
	private ResultSet rs = null;
	private String SQLbianhao, SQLname, SQLkc;

	tearevise(Frame fck, String ckm, Boolean msck, teachaxun xx, int j) {

		super(fck, ckm, msck);

		if (j == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");
			return;

		}
		setbianhao = new JTextField(5);
		setbianhao.setText((String) xx.getValueAt(j, 0));
		// setbianhao.setEditable(false);//����Ϊ�����޸ģ���ֹ����
		setname = new JTextField(5);
		setname.setText((String) xx.getValueAt(j, 1));
		setkc = new JTextField(5);
		setkc.setText((String) xx.getValueAt(j, 2));

		��ʦ��� = new JLabel("���");
		��ʦ���� = new JLabel("��ʦ����");
		�γ̱�� = new JLabel("�Ա�");

		Addyes = new JButton("ȷ��");
		Addno = new JButton("ȡ��");
		this.add(��ʦ���);
		this.add(setbianhao);
		this.add(��ʦ����);
		this.add(setname);
		this.add(�γ̱��);
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
				// �������
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=���¹���ϵͳ", "sa",
						"123456");
				// ������ѯ����

				String recode = " update ��ʦ��ѧ��Ϣ set ��ʦ����=?,�γ̱��=? where ��ʦ���=?";

				PreparedStatement input = con.prepareStatement(recode);

				input.setString(1, setname.getText());
				input.setString(2, setkc.getText());
				// input.setString(3,setxueli.getText());
				input.setString(3, setbianhao.getText());

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