package Delete;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class clear_staff {
	deletestaff_chaxun xx;

	public clear_staff(Frame fck, String ckm, Boolean msck, deletestaff_chaxun xx, int i) {
		// TODO Auto-generated constructor stub
		// xx=new deletestaff_chaxun();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
			return;
		}
		Connection con = null;
		PreparedStatement sql = null;
		ResultSet rs = null;
		java.sql.Statement st1;
		java.sql.Statement st2;
		java.sql.Statement st3;
		java.sql.Statement st4;
		String sr = (String) xx.getValueAt(i, 0);
		System.out.println(sr);
		String a = (String) xx.getValueAt(i, 1);
		String b = (String) xx.getValueAt(i, 2);
		String c = (String) xx.getValueAt(i, 3);
		String d = (String) xx.getValueAt(i, 4);
		String m = (String) xx.getValueAt(i, 5);
		String f = (String) xx.getValueAt(i, 6);
		String g = (String) xx.getValueAt(i, 7);
		String h = (String) xx.getValueAt(i, 8);
		String k = (String) xx.getValueAt(i, 9);

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=���¹���ϵͳ", "sa", "123456");
			// ������ѯ����

			String c2 = "insert into ���ݽ�ʦ(���,����,�Ա�,ѧ��,ְ��,ְ��,��ҵԺУ,����,��ְ��Ϣ,���ű��) values('" + sr + "','" + a + "','" + b
					+ "','" + c + "','" + d + "','" + m + "','" + f + "','" + g + "','" + h + "','" + k + "')";
			String c3 = "insert into ת����ʦ(���,����,�Ա�,ѧ��,ְ��,ְ��,��ҵԺУ,����,��ְ��Ϣ,���ű��) values('" + sr + "','" + a + "','" + b
					+ "','" + c + "','" + d + "','" + m + "','" + f + "','" + g + "','" + h + "','" + k + "')";
			String c4 = "insert into ��ְ��ʦ(���,����,�Ա�,ѧ��,ְ��,ְ��,��ҵԺУ,����,��ְ��Ϣ,���ű��) values('" + sr + "','" + a + "','" + b
					+ "','" + c + "','" + d + "','" + m + "','" + f + "','" + g + "','" + h + "','" + k + "')";
			String c5 = "insert into ���˽�ʦ(���,����,�Ա�,ѧ��,ְ��,ְ��,��ҵԺУ,����,��ְ��Ϣ,���ű��) values('" + sr + "','" + a + "','" + b
					+ "','" + c + "','" + d + "','" + m + "','" + f + "','" + g + "','" + h + "','" + k + "')";

			if (h.equals("����")) {
				st1 = con.createStatement();
				st1.executeUpdate(c2);
				System.out.println(st1);

			}

			if (h.equals("ת��")) {

				st2 = con.createStatement();
				st2.executeUpdate(c3.toString());
				System.out.println(st2);
			}
			if (h.equals("��ְ")) {
				st3 = con.createStatement();
				st3.executeUpdate(c4.toString());
			}
			if (h.equals("����")) {
				st4 = con.createStatement();
				st4.executeUpdate(c5.toString());
			}

			String cl = "delete  from ��ʦ��Ϣ   where ���=?";
			sql = con.prepareStatement(cl);
			sql.setString(1, sr);
			sql.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
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

			} catch (Exception e3) {
			}
		}

	}
}
