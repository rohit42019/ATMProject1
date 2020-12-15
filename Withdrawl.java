import java.util.Scanner;

public class Withdrawl {
	
	Scanner sc=new Scanner(System.in);
	private static Withdrawl w;
	private Withdrawl()
	{
		
	}
	public static Withdrawl getInstance()
	{
		if(w==null)
		{
			w=new Withdrawl();
		}
		return(w);
	}
	public int currentWithdrawl()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		try
		{
			System.out.println("\n\t\t---------------------------------");
			System.out.println("\t\t\tCURRENT WITHDRWAL");
			System.out.println("\t\t---------------------------------");
			System.out.println("\n\t\tNote : Their are only 100, 200 and 2000 rupee notes available. ");
			System.out.println("\n\t\tMaximum Withdrwal Limit at a time : Rs. 1,00,000.00 ");
			System.out.println("\n\t\t(1% tax will be deducted from your account on transaction");
			System.out.print("\n\t\tEnter Amount (in 100's) : ");
			WithdrawlData.setAmount(sc.nextInt());
			WithdrawlData.setResult(WithdrawlData.getAmount());
			if(WithdrawlData.getResult()==0 && WithdrawlData.getAmount()<=100000)
			{
				WithdrawlData.setNetBalance(BalanceData.getCurrentBalance(),WithdrawlData.getAmount());
				int i=DisplayScreen.getInstance().displayPinVerification();
				
				if(i==1)
				{
					DisplayScreen.getInstance().displayPinVerificationSuccess();
					if(WithdrawlData.getNetBalance()<0)
					{
						WithdrawlData.setStatus(0);
					}
					else
					{
						System.out.println("\n\t\tPlease wait Transaction is being Processed...");						
						Thread.sleep(9000);
						BalanceData.setCurrentBalance(WithdrawlData.getNetBalance());
						WithdrawlData.setStatus(1);
					}
				}
				else
				{
					WithdrawlData.setStatus(i);
				}					
				
			}
			else
			{
				WithdrawlData.setStatus(-1);
			}
		}
		catch(InterruptedException e)
		{}
		catch(Exception ex1)
		{
			WithdrawlData.setStatus(-2);
		}
		return(WithdrawlData.getStatus());
		
	}
	public int savingWithdrawl()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		
		try
		{
			System.out.println("\n\t\t---------------------------------");
			System.out.println("\t\t\tSAVING WITHDRWAL");
			System.out.println("\t\t---------------------------------");
			System.out.println("\n\t\tNote : Their are only 100, 200 and 2000 rupee notes available. ");
			System.out.println("\n\t\tMaximum Withdrwal Limit at a time : Rs. 25,000.00 ");
			System.out.println("\n\t\t(1% tax will be deducted from your account on transaction");
			System.out.print("\n\t\tEnter Amount (in 100's) : ");
			WithdrawlData.setAmount(sc.nextInt());
			WithdrawlData.setResult(WithdrawlData.getAmount());
			if(WithdrawlData.getResult()==0 && WithdrawlData.getAmount()<=25000)
			{
				WithdrawlData.setNetBalance(BalanceData.getSavingBalance(),WithdrawlData.getAmount());
				int i=DisplayScreen.getInstance().displayPinVerification();
				if(i==1)
				{
					if(WithdrawlData.getNetBalance()<0)
					{
						WithdrawlData.setStatus(0);
					}
					else
					{
						DisplayScreen.getInstance().displayPinVerificationSuccess();
						System.out.println("\n\t\tPlease wait Transaction is being Processed...");
						Thread.sleep(9000);
						BalanceData.setSavingBalance(WithdrawlData.getNetBalance());
						WithdrawlData.setStatus(1);
					}	
				}
				else
				{
					WithdrawlData.setStatus(i);
				}
			}
			else
			{
				WithdrawlData.setStatus(-1);
			}
			
		}
		catch(InterruptedException e)
		{}
		catch(Exception ex2)
		{
			WithdrawlData.setStatus(-2);
		}
		
		return(WithdrawlData.getStatus());
	}
	
	public int creditWithdrawl()
	{

		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		
		try
		{
			System.out.println("\n\t\t---------------------------------");
			System.out.println("\t\t\tCREDIT WITHDRWAL");
			System.out.println("\t\t---------------------------------");
			System.out.println("\n\t\tNote : Their are only 100, 200 and 2000 rupee notes available. ");
			System.out.println("\n\t\tMaximum Withdrwal Limit at a time : Rs. 25,000.00 ");
			System.out.println("\n\t\t(1% tax will be deducted from your account on transaction");
			System.out.print("\n\t\tEnter Amount (in 100's) : ");
			WithdrawlData.setAmount(sc.nextInt());
			WithdrawlData.setResult(WithdrawlData.getAmount());
			if(WithdrawlData.getResult()==0 && WithdrawlData.getAmount()<=25000)
			{
				WithdrawlData.setNetBalance(BalanceData.getCreditBalance(),WithdrawlData.getAmount());
				int i=DisplayScreen.getInstance().displayPinVerification();
				if(i==1)
				{
					if(WithdrawlData.getNetBalance()<0)
					{
						WithdrawlData.setStatus(0);
					}
					else
					{
						
						DisplayScreen.getInstance().displayPinVerificationSuccess();
						System.out.println("\n\t\tPlease wait Transaction is being Processed...");
						Thread.sleep(9000);
						BalanceData.setCreditBalance(WithdrawlData.getNetBalance());
						WithdrawlData.setStatus(1);
					}
				}
				else
				{
					WithdrawlData.setStatus(i);
				}
			}
			else
			{
				WithdrawlData.setStatus(-1);
			}
			
		}
		catch(InterruptedException e)
		{}
		catch(Exception ex3)
		{
			WithdrawlData.setStatus(-2);
		}
		return(WithdrawlData.getStatus());
	}
}
