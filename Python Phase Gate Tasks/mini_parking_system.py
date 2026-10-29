parking_lot = ['0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0']

def display_parking_lot():
	output = ""
	for spaces in parking_lot:
		output += spaces + " "
	return output

def reserve_position(parking_number):
	parking_lot[parking_number - 1] = '1'


def remove_reservation(parking_number):
	parking_lot[parking_number - 1] = '0'


def is_position_empty(parking_number):
	return parking_lot[parking_number - 1] == '0'

def is_input_valid(parking_number):
	return 1 <= parking_number <= 20

def is_response_valid(response):
	return response == "yes" or response == "no"

repeat = True

while(repeat):

	try_again = True

	while(try_again):

		parking_number = int(input("Please enter a number for your parking space (1 - 20):\n"))

		if is_input_valid(parking_number):
			if is_position_empty(parking_number):
				print()
				reserve_position(parking_number)
				print(display_parking_lot())
				print()
				print(f"Parking slot {parking_number} has been reserved")
		
			else:
				print()
				remove_reservation(parking_number)
				print(display_parking_lot())
				print()
				print(f"Parking slot {parking_number} has been unreserved")

			try_again = False

		else:
			print("Please enter a valid number")

	respond_again = True
	
	while (respond_again):
		response = input("Would you like to reserve another space:\n")

		if is_response_valid(response):
			respond_again = False
			if response == "no":
				repeat = False

		else:
			print("Please enter yes or no")

			





