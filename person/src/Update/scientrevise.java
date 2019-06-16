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

class scientrevise extends JDialog implements ActionListener {
	private JTextField setjsbh, setzlbh, setfangx, setqingk;
	private JLabel ��ʦ���, ר�����ı��, �о�����, �о����;
	private JButton Addyes, Addno;
	private Connection con = null;
	private Statement sql = null;
	private ResultSet rs = null;
	private String SQLjsbh, SQLzlbh, SQLfangx, SQLqingk;

	scientrevise(Frame fck, String ckm, Boolean msck, scientchaxun xx, int j) {

		super(fck, ckm, msck);

		if (j == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");
			return;

		}
		setjsbh = new JTextField(5);
		setjsbh.setText((String) xx.getValueAt(j, 0));
		// setbianhao.setEditable(false);//����Ϊ�����޸ģ���ֹ����
		setzlbh = new JTextField(5);
		setzlbh.setText((String) xx.getValueAt(j, 1));
		setfangx = new JTextField(5);
		setfangx.setText((String) xx.getValueAt(j, 2));
		setqingk = new JTextField(5);
		setqingk.setText((String) xx.getValueAt(j, 3));

		��ʦ��� = new JLabel("��ʦ���");
		ר�����ı�� = new JLabel(" ר�����ı��");
		�о����� = new JLabel("  �о�����");
		�о���� = new JLabel(" �о����");

		Addyes = new JButton("ȷ��");
		Addno = new JButton("ȡ��");
		this.add(��ʦ���);
		this.add(setjsbh);
		this.add(ר�����ı��);
		this.add(setzlbh);
		this.add(�о�����);
		this.add(setfangx);
		this.add(�о����);
		this.add(setqingk);

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

				String recode = " update ������Ϣ set ר�����ı��=?,�о�����=?,�о����=? where ��ʦ���=?";

				PreparedStatement input = con.prepareStatement(recode);

				input.setString(1, setzlbh.getText());
				input.setString(2, setfangx.getText());
				input.setString(3, setqingk.getText());
				input.setString(4, setjsbh.getText());
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