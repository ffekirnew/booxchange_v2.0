import java.sql.*;


class DBConnect {
	
	public static void main(String[] args) {
		try {
			// Class.forName("sun.jdbc.odbc.jdbcodbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://Booxchange:19112/booxchange", "User", "Booxchange!2345678");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SHOW TABLES;");
			while (rs.next()) {
				System.out.println("id = " + rs.getString(1));
			}
		}
		catch (SQLException e) {
			System.out.print("Not found");
		}
	}
	
}