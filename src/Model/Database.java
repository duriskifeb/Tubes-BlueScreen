
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static Connection getconnection() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/shop_management", "root", "");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

}
