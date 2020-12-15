import java.util.Scanner;

public class Receipt {
	Scanner sc=new Scanner(System.in);
	private static Receipt receipt;
	private Receipt()
	{
		
	}
	public static Receipt getInstance()
	{
		if(receipt==null)
		{
			receipt=new Receipt();
		}
		return(receipt);
	}
	public void printReceiptCurrentWithdrawl()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\tCURRENT WITHDRAWL RECEIPT");
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\tPUBLIC UNION BANK");
		System.out.println("\n\t\t\tDATE : "+java.time.LocalDate.now()+"\t\tTIME : "+java.time.LocalTime.now());
		System.out.println("\n\t\t\tWITHDRAWL AMOUNT :\t\t\t\tRs. "+WithdrawlData.getAmount());
		System.out.println("\n\t\t\tTOTAL TAX :\t\t\t\t\tRs. "+(WithdrawlData.getAmount()/100));
		System.out.println("\n\t\t\tTOTAL BALANCE :\t\t\t\t\tRs. "+BalanceData.getCurrentBalance());
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
	}
	
	public void printReceiptSavingWithdrawl()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\tSAVING WITHDRAWL RECEIPT");
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\tPUBLIC UNION BANK");
		System.out.println("\n\t\t\tDATE : "+java.time.LocalDate.now()+"\t\tTIME : "+java.time.LocalTime.now());
		System.out.println("\n\t\t\tWITHDRAWL AMOUNT :\t\t\t\tRs. "+WithdrawlData.getAmount());
		System.out.println("\n\t\t\tTOTAL TAX :\t\t\t\t\tRs. "+(WithdrawlData.getAmount()/100));
		System.out.println("\n\t\t\tTOTAL BALANCE :\t\t\t\t\tRs. "+BalanceData.getSavingBalance());
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
	}
	
	public void printReceiptCreditWithdrawl()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\tCREDIT WITHDRAWL RECEIPT");
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\tPUBLIC UNION BANK");
		System.out.println("\n\t\t\tDATE : "+java.time.LocalDate.now()+"\t\tTIME : "+java.time.LocalTime.now());
		System.out.println("\n\t\t\tWITHDRAWL AMOUNT :\t\t\t\tRs. "+WithdrawlData.getAmount());
		System.out.println("\n\t\t\tTOTAL TAX :\t\t\t\t\tRs. "+(WithdrawlData.getAmount()/100));
		System.out.println("\n\t\t\tTOTAL BALANCE :\t\t\t\t\tRs. "+BalanceData.getCreditBalance());
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
	}
	
}
