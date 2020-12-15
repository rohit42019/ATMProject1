public class DisplayData {
private static int choice,pin,currentPin,newPin;
static boolean status;
private DisplayData()
{  }

public static boolean isStatus() {
	return status;
}

public static void setStatus(boolean status) {
	DisplayData.status = status;
}

public static int getCurrentPin() {
	return currentPin;
}

public static void setCurrentPin(int currentPin) {
	DisplayData.currentPin = currentPin;
}
public static int getNewPin() {
	return newPin;
}
public static void setNewPin(int newPin) {
	DisplayData.newPin = newPin;
}
	
public static int getPin() {
		return pin;
}
	
public static void setPin(int pin) {
	DisplayData.pin = pin;
}

public static int getChoice() {
		return choice;
}

public static void setChoice(int choice) {
	DisplayData.choice = choice;
}
	
private static DisplayData disp;
	

public static DisplayData getInstance()
	{
		if(disp==null)
		{
			disp=new DisplayData();
		}
		return(disp);
	}
		
}
