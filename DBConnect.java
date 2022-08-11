import java.sql.*;


class DBConnect {
	
	public static void main(String[] args) {
		try {
      
	        String myDriver = "com.mysql.cj.jdbc.Driver";
	        String myUrl = "jdbc:mysql://localhost:3306/booxchange";
	        Class.forName(myDriver);
	        Connection conn = DriverManager.getConnection(myUrl, "User", "BooxchangE!2345678");
	      // Class.forName("sun.jdbc.odbc.jdbcodbcDriver");
	      //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Booxchange", "User", "Booxchange!2345678");
	      
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SHOW TABLES;");
	      while (rs.next()) {
	        System.out.println("id = " + rs.getString(1));
	      }
	      conn.close();
	    }
	    catch (Exception e) {
	      System.err.println("Got an exception!");
	      // printStackTrace method 
	      // prints line numbers + call stack
	      e.printStackTrace();
	      // Prints what exception has been thrown 
	      System.out.println(e); 
	      }
	}
	
}