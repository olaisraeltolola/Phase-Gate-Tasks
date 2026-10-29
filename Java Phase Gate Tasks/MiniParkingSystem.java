import java.util.Scanner;
public class MiniParkingSystem{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean repeat = true;

		while(repeat){

			boolean tryAgain = true;

			while(tryAgain){

				System.out.println("Please enter a number for your parking space (1 - 20)");
				int parkingNumber = input.nextInt();

				if (MiniParkingSystemFunctions.isInputValid(parkingNumber)){

					if (MiniParkingSystemFunctions.isPositionEmpty(parkingNumber)){
						MiniParkingSystemFunctions.reservePosition(parkingNumber);

						System.out.println(MiniParkingSystemFunctions.displayParkingLot());

						System.out.println();
						System.out.printf("Parking slot %d has been reserved", parkingNumber);
						System.out.println();

					} else {
						MiniParkingSystemFunctions.removeReservation(parkingNumber);

						System.out.println(MiniParkingSystemFunctions.displayParkingLot());

						System.out.println();
						System.out.printf("Parking slot %d has been unreserved", parkingNumber);
						System.out.println();


					}

					tryAgain = false;

				} else {
					System.out.println("Please enter a valid number for parking");
				}
			}
			boolean respondAgain = true;

			while (respondAgain){
				System.out.println("Would you like to reserve another space?");
				String response = input.next().toLowerCase();

				if (MiniParkingSystemFunctions.isResponseValid(response)){
					respondAgain = false;

					if (response.equals("no")){
						System.out.println("Thank you for reserving a space");
						repeat = false;
					}
				} else {
					System.out.println("Please enter yes or no");
				}
			}
		}

	} 
}