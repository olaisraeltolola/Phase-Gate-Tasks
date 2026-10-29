def reverse_list (number_list):
	reversed_list = []
	for index in range (len(number_list)):
		reversed_list.append(number_list[index][::-1])

	return reversed_list





number_list = [[6, 8], [5, 4, 2], [3], [8, 2, 4, 1]]
numbers = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(reverse_list(numbers))











#def reverse_list(number_list):
#	reversed_list = []

#	for index in range (len(number_list)):
#		temporary_list = []

#		for second_index in range (len(number_list[index])):
#			temporary_list.append(number_list[index][len(number_list[index]) - 1 - second_index]) 
	
#		reversed_list.append(temporary_list)

#	return reversed_list
