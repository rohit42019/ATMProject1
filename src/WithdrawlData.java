public class WithdrawlData {
	private static int amount,result,status;
	private static long netBalance;
	static WithdrawlData data;
	private WithdrawlData()
	{
		
	}
	public static WithdrawlData getInstance()
	{
		if(data==null)
		{
			data=new WithdrawlData();
		}
		return(data);
	}
	public static int getAmount() {
		return amount;
	}

	public static void setAmount(int amount) {
		WithdrawlData.amount = amount;
	}

	public static int getResult() {
		return result;
	}

	public static void setResult(int amount) {
		WithdrawlData.result = amount%100;
	}

	public static long getNetBalance() {
		return netBalance;
	}

	public static void setNetBalance(long Balance,int amount) {
		WithdrawlData.netBalance = (Balance-(amount+(amount/100)));//including 1% tax.;
	}

	public static int getStatus() {
		return status;
	}

	public static void setStatus(int status) {
		WithdrawlData.status = status;
	}
}
