import java.sql.*;
public class Pin {
	
	private static Pin pin;
	public static Pin getInstance()
	{
		if(pin==null)
		{
			pin=new Pin();
		}
		return(pin);
	}
	
	public boolean changePin(int newPin,int currentPin,Connection con)
	{
		boolean status=false;
		ResultSet result=TableData.getInstance().dataFetch(con);
		int count=0;
		try
		{
			while(result.next())
			{
				if(newPin==result.getInt(3))
				{
					System.out.println("\n\nError: PIN already taken, enter unique PIN");
					count++;
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		if(currentPin==PinData.getActivePin() && newPin!=PinData.getActivePin() && count==0)
		{
			PinData.setActivePin(newPin);
			DBQueries.setQ("update table1 set PIN=? where PIN=?");
			//update PIN in database
			DBQueries.getInstance().updatePin(con,currentPin);
			status=true;
		}
		
		return status;
	}

	public boolean verifyPin(int enteredPin)
	{
		boolean verify=false;
		
		if(enteredPin==PinData.getActivePin())
		{
			verify=true;
		}
		return verify;
	}
}
