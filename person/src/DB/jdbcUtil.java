package DB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtil {

	public static Connection getSQLConn() {
		Connection dbConn = null;
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=人事管理系统";
		String userName = "sa";
		String userPwd = "123456";

		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("Succeed in Connect to your Database!");
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbConn;
	}

	public static void close(ResultSet rs, java.sql.Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			if (conn != null) {
				conn.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Boolean nunnumber(String num, String tablename) {
		Boolean nu = true;
		Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtil.getSQLConn();
			conn.setAutoCommit(true);
			st = conn.createStatement();
			String sql = "select * from" + " " + tablename.toString();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String num2 = rs.getString(1).trim();
				if (num.equals(num2)) {
					nu = false;

				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			jdbcUtil.close(rs, st, conn);
		}
		return nu;

	}

	public static Boolean samenumber(String num, String tablename) {
		Boolean nu = false;
		Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtil.getSQLConn();
			conn.setAutoCommit(true);
			System.out.println("已连接到数据库...");
			st = conn.createStatement();
			String sql = "select * from " + tablename.toString();
			// sql.append(tablename);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String num2 = rs.getString(1).trim();
				if (num.equals(num2)) {
					nu = true;
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			jdbcUtil.close(rs, st, conn);
		}
		return nu;
	}
}
