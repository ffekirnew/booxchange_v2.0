package dependencies;

import java.sql.*;

public class DBConnect {
	
	public Connection conn;
	public Statement st;
	// Constructor
	public DBConnect(){
		String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/booxchange";
        String user = "root";
        String password = "";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
	}

	public ResultSet query(String q) {
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
}