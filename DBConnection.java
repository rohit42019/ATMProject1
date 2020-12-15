import java.sql.*;
public class DBConnection {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/atm";
	private static DBConnection obj;//private reference variable of DBConnection class.
	   private DBConnection()//private default constructor.
	   {  }
	   
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static DBConnection getInstance()
	   {
		   if(obj==null)
		   {
			   obj=new DBConnection();
		   }
		   
		   return(obj);
	   }
	   
	   public Connection callingDBConnection()
	   {
		  Connection conn=null;
		  if(conn==null)
		  {
			  try
			  {
				//Loading the class Driver into the memory (Platform/Extension class loader).
				  Class.forName(JDBC_DRIVER);

				  //STEP 3: Open a connection
				  conn = DriverManager.getConnection(DB_URL,USER,PASS);
				  
				  //System.out.println("Connecting to database...");
				      
			  }
			  catch(Exception se)
			   {
			      //Handle errors for JDBC
				  System.out.println(se.fillInStackTrace());
			   }
		  }
		  
		   return conn;
	   }
}
