public class PinData {
	
	private static int activePin;
	
	private static PinData pin;

	 private PinData()
	{	}
	 
	 public static PinData getInstance()
	 {
		 
		 if(pin==null)
		 {
			 pin=new PinData();
		 }
		 
		 return pin;
	 }
	public static int getActivePin() {
		return activePin;
	}
	public static void setActivePin(int activePin) {
		PinData.activePin = activePin;
	}

}
