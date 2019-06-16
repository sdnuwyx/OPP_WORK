package Update;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

class scientchaxun extends AbstractTableModel {
	Vector ziduan, jilu;
	Connection con = null;
	PreparedStatement sql = null;
	ResultSet rs = null;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.ziduan.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.jilu.size();
	}

	@Override
	public Object getValueAt(int hang, int lie) {
		// TODO Auto-generated method stub
		return ((Vector) this.jilu.get(hang)).get(lie);
	}

	public scientchaxun() {
		String nul = "select * from 科研信息";
		this.sqlly(nul);

	}

	public scientchaxun(String input) {
		this.sqlly(input);
	}

	public String getColumnName(int e) {
		return (String) this.ziduan.get(e);
	}

	public void sqlly(String ss) {
		ziduan = new Vector();

		ziduan.add("教师编号");
		ziduan.add("专利论文编号");
		ziduan.add("研究方向");
		ziduan.add("研究情况");
		jilu = new Vector();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=人事管理系统", "sa", "123456");

			sql = con.prepareStatement(ss);

			rs = sql.executeQuery();
			while (rs.next()) {
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				jilu.add(hang);

			}
		}

		catch (NumberFormatException nu) {
			JOptionPane.showMessageDialog(null, "你还没有输入哦", "错误", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
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

			} catch (Exception e) {
			}
		}

	}

}