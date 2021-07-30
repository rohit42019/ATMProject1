public class BalanceData {
	
	private static long currentBalance,savingBalance,creditBalance;
	private static boolean  status;
	public static boolean getStatus() {
		return status;
	}
	public static void setStatus(boolean status) {
		BalanceData.status = status;
	}

	private static BalanceData balanceData;
	private BalanceData()
	{
		
	}
	public static BalanceData getInstance()
	{
		if(balanceData==null)
		{
			balanceData=new BalanceData();
		}
		return(balanceData);
	}
	public static long getCurrentBalance() {
		return currentBalance;
	}

	public static void setCurrentBalance(long currentBalance) {
		BalanceData.currentBalance = currentBalance;
	}

	public static long getSavingBalance() {
		return savingBalance;
	}

	public static void setSavingBalance(long savingBalance) {
		BalanceData.savingBalance = savingBalance;
	}

	public static long getCreditBalance() {
		return creditBalance;
	}

	public static void setCreditBalance(long creditBalance) {
		BalanceData.creditBalance = creditBalance;
	}
}
