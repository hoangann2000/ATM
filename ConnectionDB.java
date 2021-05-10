package ATM;

import java.sql.DriverManager;

public class ConnectionDB {
	public static java.sql.Connection connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		return 	 DriverManager.getConnection("jdbc:mysql://localhost/atm", "root", "");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           java.sql.Connection conn = connectDB();
           if(conn != null ) System.out.println("success!!");
           else System.out.println("false");
	}

}
