package hbtu.com.connection;

import java.sql.*;

public final class ProjectConnection {

	private ProjectConnection() {
		
	}
    
	private static final String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME="system";
	private static final String PASSWORD="root";
	
	private static boolean isDriverLoaded=false;
	
	static{
        try{
        	Class.forName(DRIVER_CLASS);
        	isDriverLoaded=true;
        }catch(ClassNotFoundException e){
        	e.printStackTrace();
        }
	}
    
	public static Connection getConnection() throws SQLException{
		Connection con=null;
		if(isDriverLoaded){
			
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		return con;
	}
	public static void closeConnection(Connection con) throws SQLException{
	if(con!=null){
      con.close();
	}
	}
}
