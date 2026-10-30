const prompt = require("prompt-sync")();


let parkingLot = ['0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0']; 

function reservePosition(parkingNumber){
	parkingLot[parkingNumber - 1] = '1';
}

function isPositionEmpty(parkingNumber){
	return parkingLot[parkingNumber - 1] == '0';
	
}

function displayParkingLot(){
	let output = "";
	for (let index = 0; index < parkingLot.length; index++){
		output += parkingLot[index] + " ";	

	}
	return output;
}

function removeReservation(parkingNumber){
	parkingLot[parkingNumber - 1] = '0';

}

function isInputValid(parkingNumber){
	return parkingNumber >= 1 && parkingNumber <= 20;
}

function isResponseValid(response){
	return response == "yes" || response == "no";
}







let repeat = true;

while(repeat){
let tryAgain = true;

	while(tryAgain){

		let parkingNumber = prompt("Please enter a number for your parking space (1 - 20): ");

		if (isInputValid(parkingNumber)){

			if (isPositionEmpty(parkingNumber)){
				reservePosition(parkingNumber);

				console.log(displayParkingLot());

				console.log();
				console.log(`Parking slot ${parkingNumber} has been reserved`);
				console.log();

			} else {
				removeReservation(parkingNumber);

				console.log(displayParkingLot());

				console.log();
				console.log(`Parking slot ${parkingNumber} has been unreserved`);
				console.log();


			}

			tryAgain = false;

		} else {
			console.log("Please enter a valid number for parking");
		}
	}
	let respondAgain = true;

	while (respondAgain){
		response = prompt("Would you like to reserve another space?: ");

		if (isResponseValid(response)){
			respondAgain = false;

			if (response == "no"){
				console.log("Thank you for reserving a space");
				repeat = false;
			}
		} else {
			console.log("Please enter yes or no");
		}
	}
}


