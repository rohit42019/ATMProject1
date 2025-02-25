import java.sql.*;

public class DBQueries {
	private static String q;
	private static DBQueries obj;
	private DBQueries()
	{ }
	
	public static DBQueries getInstance()
	{
		if(obj==null)
		{
			obj=new DBQueries();
		}
		return(obj);
	}
	
	public static String getQ() {
		return q;
	}

	public static void setQ(String q) {
		DBQueries.q = q;
	}
	
	public boolean searchPin(ResultSet result,int enteredPin)
	{
		boolean b=false;
		try
		{
			while(result.next())
			{
				if(enteredPin==result.getInt(3))
				{
					b=true;
					FillDetail.getInstance().Fill(result);
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return(b);
	}
	public void updateCurrentBalance(Connection con)
	{
		try
		{
			PreparedStatement prst=con.prepareStatement(getQ());
			prst.setLong(1,BalanceData.getCurrentBalance());
			prst.setInt(2,PinData.getActivePin());
			prst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}
	public void updateSavingBalance(Connection con)
	{
		try
		{
			PreparedStatement prst=con.prepareStatement(getQ());
			prst.setLong(1,BalanceData.getSavingBalance());
			prst.setInt(2,PinData.getActivePin());
			prst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}
	public void updateCreditBalance(Connection con)
	{
		try
		{
			PreparedStatement prst=con.prepareStatement(getQ());
	
			prst.setLong(1,BalanceData.getCreditBalance());
			prst.setInt(2,PinData.getActivePin());
			prst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}
	public void updatePin(Connection con,int oldPin)
	{
		try
		{
			PreparedStatement prst=con.prepareStatement(getQ());
			prst.setInt(1,PinData.getActivePin());
			prst.setInt(2, oldPin);
			prst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
