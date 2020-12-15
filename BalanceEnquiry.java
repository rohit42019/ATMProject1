public class BalanceEnquiry {
	
	private BalanceEnquiry()
	{
		
	}
	private static BalanceEnquiry balance;
	public static BalanceEnquiry getInstance()
	{
		if(balance==null)
		{
			balance=new BalanceEnquiry();
		}
		return(balance);
	}
	
	public void checkCurrentBalance()
	{
		int i=DisplayScreen.getInstance().displayPinVerification();
		if(i==1)
		{
			BalanceData.setStatus(true);
		}
		else
		{
			BalanceData.setStatus(false);
		}
		
		if(BalanceData.getStatus())
		{
			DisplayScreen.getInstance().displayPinVerificationSuccess();
			DisplayScreen.getInstance().displayCurrentBalance();
		}
		else
		{
			DisplayScreen.getInstance().displayPinVerificationError();
		}
		
	}
	public void checkSavingBalance()
	{
		int i=DisplayScreen.getInstance().displayPinVerification();
		if(i==1)
		{
			BalanceData.setStatus(true);
		}
		else
		{
			BalanceData.setStatus(false);
		}
		
	    if(BalanceData.getStatus())
		{
			DisplayScreen.getInstance().displayPinVerificationSuccess();
			DisplayScreen.getInstance().displaySavingBalance();
		}
		else
		{
			DisplayScreen.getInstance().displayPinVerificationError();
		}
		
	}
	public void checkCreditBalance()
	{
		int i=DisplayScreen.getInstance().displayPinVerification();
		if(i==1)
		{
			BalanceData.setStatus(true);
		}
		else
		{
			BalanceData.setStatus(false);
		}
		if(BalanceData.getStatus())
		{
			DisplayScreen.getInstance().displayPinVerificationSuccess();
			DisplayScreen.getInstance().displayCreditBalance();
		}
		else
		{
			DisplayScreen.getInstance().displayPinVerificationError();
		}
	}
	
}
