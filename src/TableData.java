import java.sql.*;
public class TableData {
	private static TableData data;
	private TableData()
	{  }
	
	public static TableData getInstance()
	{
		if(data==null)
		{
			data=new TableData();
		}
		
		return(data);
	}
	
	public ResultSet dataFetch(Connection conn)
	{
		ResultSet set=null;
		try
		{
			DBQueries.setQ("select* from table1");
			PreparedStatement prst=conn.prepareStatement(DBQueries.getQ());
			set=prst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(set);
	}
	
}
