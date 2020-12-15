import java.util.Scanner;
import java.sql.*;
public class DisplayScreen {

	Scanner sc=new Scanner(System.in);
	private static DisplayScreen display;
	private DisplayScreen()
	{
		
	}
	
	public static DisplayScreen getInstance()
	 {
		 
		 if(display==null)
		 {
			 display=new DisplayScreen();
		 }
		 
		 return display;
	 }
	public void displayWelcome()
	{

		System.out.println("\t\t-----------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t***************WELCOME TO PUBLIC UNION ATM****************");
		System.out.println("\t\t-----------------------------------------------------------------------------------------------");
		
	}
	public void displayMainScreen(Connection con)
	{
		try
		{
			do
			{
				DisplayScreen.getInstance().spaceGenerator();
				DisplayScreen.getInstance().displayWelcome();
				System.out.println("\n\t\t1. Withdrawal");
				System.out.println("\n\t\t2. BalanceEnquiry");
				System.out.println("\n\t\t3. PIN Change");
				System.out.println("\n\t\t4. Main Menu");
				System.out.print("\n\t\tEnter your choice : ");
				DisplayData.setChoice(sc.nextInt());
				switch(DisplayData.getChoice())
				{
					case 1: displayWithdrawl();
					break;
					
					case 2: displayBalanceEnquiry();	
					break;
					
					case 3: displayPinchange(con);
					break;
					
					case 4: Atm.setCh('e');
					break;
					default:System.out.println("\n\t\tWrong Choice");
				}
				
				
			}while(Atm.getCh()=='c' || Atm.getCh()=='C');
			

		}
		catch(Exception e1)
		{
			System.out.println("\n\t\tInvalid Input, only number");
			sc.nextLine();
		}
		DisplayScreen.getInstance().spaceGenerator();
		
	}
	public void displayWithdrawl()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		try
		{	
			System.out.println("\n\t\t1. Current Account");
			System.out.println("\n\t\t2. Saving Account");
			System.out.println("\n\t\t3. Credits");
			System.out.print("\n\t\tEnter your choice : ");
			DisplayData.setChoice(sc.nextInt());
			switch(DisplayData.getChoice())
			{
			case 1: Withdrawl.getInstance().currentWithdrawl();
					if(WithdrawlData.getStatus()>0)
						displayWithdrawlSuccess("Current");
					else
						displayWithdrawlError(WithdrawlData.getStatus());
			break;
			
			case 2: Withdrawl.getInstance().savingWithdrawl();
					if(WithdrawlData.getStatus()>0)
						displayWithdrawlSuccess("Saving");
					else
						displayWithdrawlError(WithdrawlData.getStatus());
			break;
			
			case 3: Withdrawl.getInstance().creditWithdrawl();
					if(WithdrawlData.getStatus()>0)
						displayWithdrawlSuccess("Credit");
					else
						displayWithdrawlError(WithdrawlData.getStatus());
			break;
			
			default:System.out.println("\n\t\tWrong Choice");
			}
		}
		catch(Exception e2)
		{
			System.out.println("\n\t\tInvalid Input, only number");
			sc.nextLine();
		}
		
		DisplayScreen.getInstance().spaceGenerator();
		
	}
	
	public  void displayBalanceEnquiry()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		try
		{
			int i;
			System.out.println("\n\t\t1. Current Account");
			System.out.println("\n\t\t2. Saving Account");
			System.out.println("\n\t\t3. Credits");
			System.out.print("\n\t\tEnter your choice : ");
			i=sc.nextInt();
			switch(i)
			{
			case 1: BalanceEnquiry.getInstance().checkCurrentBalance();
			break;
			case 2: BalanceEnquiry.getInstance().checkSavingBalance();
			break;
			case 3: BalanceEnquiry.getInstance().checkCreditBalance();
			break;
			default:System.out.println("\n\t\tWrong Choice");
			}
		}
		catch(Exception e3)
		{
			System.out.println("\n\t\tInvalid Input, only number");
			sc.nextLine();
		}
		
	}
	public int displayPinVerification()
	{
		int i=0;
		try
		{
			System.out.print("\n\t\tEnter PIN : ");
			DisplayData.setPin(sc.nextInt());
			if(Pin.getInstance().verifyPin(DisplayData.getPin()))
			{
				i=1;
			}
			else
			{
				i=-3;
			}
		}
		catch(Exception e4)
		{
			i=-2;
		}
		return(i);
	}
	public void displayPinVerificationError()
	{
		System.out.println("\n\t\tWrong PIN entered");
	}
	public void displayPinVerificationSuccess()
	{
		System.out.println("\n\t\tPIN successfully verified");
	}
	public void displayPinchange(Connection con)
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		try
		{
			
			System.out.print("\n\t\tEnter Current Pin : ");
			DisplayData.setCurrentPin(sc.nextInt());
			System.out.print("\n\t\tEnter New Pin : ");
			DisplayData.setNewPin(sc.nextInt());
			DisplayData.setStatus(Pin.getInstance().changePin(DisplayData.getNewPin(),DisplayData.getCurrentPin(),con));
			if(DisplayData.isStatus())
			{
				System.out.println("\n\t\t(Don't Press any key)");
				System.out.println("\n\t\tPlease wait...");
				Thread.sleep(7000);
				displayPinChangeSuccess();
			}
			else
			{	
				displayPinChangeError();
			}
		}
		catch(InterruptedException e)
		{ }
		catch(Exception e5)
		{
			System.out.println("\n\t\tInvalid Input, only number");
			sc.nextLine();
		}
	}
	
	public void displayPinChangeError()
	{
		System.out.println("\n\t\t!!Wrong PIN Entered!!");
		System.out.println("\n\t\t(PIN not Changed)");
	}
	public void displayPinChangeSuccess()
	{
		System.out.println("\n\t\tPIN successfully changed");
		System.out.println("\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
	}
	public void displayWithdrawlError(int a)
	{
		if(a==0)
			System.out.println("\n\t\t!!INSUFFICIENT AMOUNT (CANNOT MAKE TRANSACTION)");
		else if(a==-1)
			System.out.println("\n\t\t!!!Invalid Amount Entered!!!");
		else if(a==-2)
			System.out.println("\n\t\tInvalid Input, only numbers");
		else
		{
			displayPinVerificationError();
		}
	}
	public void displayWithdrawlSuccess(String str)
	{
		System.out.println("\n\t\t(Amount successfully withdrawled Please take the receipt)");
		if(str=="Current")
		{
			Receipt.getInstance().printReceiptCurrentWithdrawl();
		}
		else if(str=="Saving")
		{
			Receipt.getInstance().printReceiptSavingWithdrawl();
		}
		else
		{
			Receipt.getInstance().printReceiptCreditWithdrawl();
		}
	}
	
	
	public void spaceGenerator()
	{
		for(int i=0;i<5;i++)
		{
		System.out.println("");
		}
	
	}
	
	public void displayCurrentBalance()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t  CURRENT BALANCE DETAILS");
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\tPUBLIC UNION BANK");
		System.out.println("\n\t\t\tDATE : "+java.time.LocalDate.now()+"\t\t\tTIME : "+java.time.LocalTime.now());
		System.out.println("\n\t\t\tAVAILABLE BALANCE :\t\t\t\t\tRs. "+BalanceData.getCurrentBalance());
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
		
	}
	public void displaySavingBalance()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t  SAVING BALANCE DETAILS");
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\tPUBLIC UNION BANK");
		System.out.println("\n\t\t\tDATE : "+java.time.LocalDate.now()+"\t\t\tTIME : "+java.time.LocalTime.now());
		System.out.println("\n\t\t\tAVAILABLE BALANCE :\t\t\t\t\tRs. "+BalanceData.getSavingBalance());
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
		
	}
	public void displayCreditBalance()
	{
		DisplayScreen.getInstance().spaceGenerator();
		DisplayScreen.getInstance().displayWelcome();
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t  CREDIT BALANCE DETAILS");
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\tPUBLIC UNION BANK");
		System.out.println("\n\t\t\tDATE : "+java.time.LocalDate.now()+"\t\t\tTIME : "+java.time.LocalTime.now());
		System.out.println("\n\t\t\tAVAILABLE BALANCE :\t\t\t\t\tRs. "+BalanceData.getCreditBalance());
		System.out.println("\t\t---------------------------------------------------------------------------");
		System.out.println("\t\t\tPress C to continue or any other character for Main Menu ");
		Atm.setCh(sc.next().charAt(0));
		
	}
	public void displayFinalMessage()
	{
		System.out.println("\t\tTHANK YOU FOR USING THIS ATM, BYE");
	}
}
