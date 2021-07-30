import java.util.Scanner;
import java.sql.*;
public class Atm {
	private static char ch;
	private static int pin;
	public static int getPin() {
		return pin;
	}
	public static void setPin(int pin) {
		Atm.pin = pin;
	}
	public static char getCh() {
		return ch;
	}
	public static void setCh(char c) {
		ch = c;
	}
	public static void main(String... args) {
		Scanner sc=new Scanner(System.in);
		do
		{
			try
			{
				Connection con=DBConnection.getInstance().callingDBConnection();
				if(con!=null)
				{
					ResultSet set=TableData.getInstance().dataFetch(con);
					if(set==null)
					{
						System.out.println("\n\nTable not found");
						setCh('e');
					}
					else
					{
						
						DisplayScreen.getInstance().displayWelcome();
						System.out.print("\n\n\t\tEnter PIN : ");
						setPin(sc.nextInt());
						boolean b=DBQueries.getInstance().searchPin(set, getPin());
						if(b)
						{
							DisplayScreen.getInstance().displayMainScreen(con);	
						}
						else
						{
							System.out.println("\t\tWrong PIN");
						}
					
						
						DisplayScreen.getInstance().displayWelcome();
						System.out.println("\t\tEnter C to continue else any other charater to exit");
						setCh(sc.next().charAt(0));
								
					}
					con.close();
				}
				else
				{
					System.out.println("\n\nDatabase Not Connected");
					setCh('e');
				}
			}
			catch(Exception e)
			{
				System.out.println(e.fillInStackTrace());
			}
			
		}while(getCh()=='c' || getCh()=='C');
		
		DisplayScreen.getInstance().displayFinalMessage();
		sc.close();
	}

}
