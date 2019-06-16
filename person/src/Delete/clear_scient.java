package Delete;

import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class clear_scient {
	Delete_chaxun xx;

	public clear_scient(int i) {
		// TODO Auto-generated constructor stub
		xx = new Delete_chaxun();

		if (i == -1) {
			JOptionPane.showMessageDialog(null, "请选中要删除的行");
			return;
		}
		Connection con = null;
		PreparedStatement sql = null;
		ResultSet rs = null;
		Statement sm = null;

		String sr = (String) xx.getValueAt(i, 1);
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=人事管理系统", "sa", "123456");
			// 建立查询条件

			String cl = "delete  from 科研信息  where 专利论文编号=?";

			sql = con.prepareStatement(cl);
			// int ii=Integer.valueOf(sr).intValue();
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
