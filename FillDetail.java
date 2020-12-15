import java.sql.*;
public class FillDetail {
	private static FillDetail obj;
	private FillDetail()
	{  }
	public static FillDetail getInstance()
	{
		if(obj==null)
		{
			obj=new FillDetail();
		}
		return(obj);
	}
	public void Fill(ResultSet result)
	{
		try
		{
			PinData.setActivePin(result.getInt(3));
			BalanceData.setCurrentBalance(result.getLong(4));
			BalanceData.setSavingBalance(result.getLong(5));
			BalanceData.setCreditBalance(result.getLong(6));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
