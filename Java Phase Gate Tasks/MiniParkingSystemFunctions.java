public class MiniParkingSystemFunctions{

	public static char[] parkingLot = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'}; 

	public static void reservePosition(int parkingNumber){
			parkingLot[parkingNumber - 1] = '1';
	}

	public static boolean isPositionEmpty(int parkingNumber){
		return parkingLot[parkingNumber - 1] == '0';
	
	}

	public static String displayParkingLot(){
		String output = "";
		for (int index = 0; index < parkingLot.length; index++){
			output += parkingLot[index] + " ";	

		}
		return output;
	}

	public static void removeReservation(int parkingNumber){
			parkingLot[parkingNumber - 1] = '0';

	}

	public static boolean isInputValid(int parkingNumber){
		return parkingNumber >= 1 && parkingNumber <= 20;
	}

	public static boolean isResponseValid(String response){
		return response.equals("yes") || response.equals("no");
	}

}