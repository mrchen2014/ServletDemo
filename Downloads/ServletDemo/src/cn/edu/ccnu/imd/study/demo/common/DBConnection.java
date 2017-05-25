package cn.edu.ccnu.imd.study.demo.common;

import java.sql.*;
import java.util.Locale;
import java.util.PropertyResourceBundle;

/**
 * @author study
 * 
 * 从给定的资源信息中得到数据库联接对象
 * 
 */   
public class DBConnection {
	Connection conn = null;

	/**
	 * 从给定的资源文件中获得连接数据库的参数
	 * 
	 */
	public boolean getConnect() {
		String str_URL = "";
		String str_userName = "";
		String str_passWord = ""; // the connect passWord
		String str_JdbcDriverName = ""; // the connect JDBCDriverName
		// Connection con = null;
		try {
			PropertyResourceBundle configBundle = (PropertyResourceBundle) PropertyResourceBundle
					.getBundle("cn.edu.ccnu.imd.study.demo.common.product",
							new Locale("cn", "CN"));

			if (configBundle == null) {
				System.out.println("文件product_cn_CN.properties读入错误");
				return false;
			}

			// the connect URL
			str_URL = configBundle.getString("ConnectString");
			// the connect userName
			str_userName = configBundle.getString("UserID");
			// the connect passWord
			str_passWord = configBundle.getString("Password");
			// the connect JDBCDriverName
			str_JdbcDriverName = configBundle.getString("JdbcDriverName");
			try {
				// 加载驱动程序
				Class.forName(str_JdbcDriverName).newInstance();
			} catch (ClassNotFoundException e) {
				System.out.println("Driver not found");
			}

			// DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			// DriverManager.registerDriver(null);

			this.conn = DriverManager.getConnection(str_URL, str_userName,
					str_passWord);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Returns the conn.
	 * 
	 * @return Connection
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Sets the conn.
	 * 
	 * @param conn
	 *            The conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}