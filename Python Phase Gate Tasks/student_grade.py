def display_student_table(student_grades, students_number, subject_number):

	temporary_totals = []	
	subjects = []
	
	print("==============================================================================")
	print("STUDENT		", end ="");

	for counter in range (1, subject_number + 1):
		print("SUB",counter,"	", end="");

	print("TOT" + "	", end="")
	print("AVG" + "	", end="")
	print("POS")


	print("==============================================================================")


	for index in range (students_number): 
		total = 0

		for second_index in range (subject_number):
			total += student_grades[index][second_index]

		temporary_totals.append(total);


	for index in range (subject_number): 
		temporary_subjects = []

		for second_index in range (students_number):

			temporary_subjects.append(student_grades[second_index][index])

		subjects.append(temporary_subjects)


	for index in range (len(temporary_totals)): 
		single_total = temporary_totals[index]
		average = 0.0

		print("Student", (index + 1), ":	", end="")

		for second_index in range (subject_number):
			print(f"{student_grades[index][second_index]:>2}", end="")
			print("      ", end="")


		print(f"{single_total}	", end="")

		average = single_total / subject_number 
		print(f"{average:.2f}", end="");

		position = get_sorted_position(single_total, temporary_totals);
		print(f"	{position}")
			

	print("===============================================================================")
	print("===============================================================================")

	print()
	print("SUBJECT SUMMARY")
	highest_score = 0
	lowest_score = 0

	for index in range (subject_number): 
		for second_index in range (students_number):

			highest_score = get_highest_score(subjects[index]);
			lowest_score = get_lowest_score(subjects[index]);

		print()
		print("Subject",(index + 1))

		print("The highest scoring student: Student", get_student_with_highest_score(subjects[index]),"scoring",highest_score)
		print("The lowest scoring student: Student", get_student_with_lowest_score(subjects[index]),"scoring",lowest_score)
		print("Total Score is:",get_total(subjects[index]))
		print(f"Average Score is: {get_average(subjects[index]):.2f}")
		print()
		print("Number of passes:",get_number_of_passes(subjects[index]));
		print("Number of fails:",(len(subjects[index]) - get_number_of_passes(subjects[index])));


		print()
		print()

	print("CLASS SUMMARY")			

	sorted_list = sort(temporary_totals)
	highest_total = sorted_list[0]
	lowest_total = sorted_list[len(sorted_list) - 1]


	print("Best Graduating Student is: Student", get_unsorted_position(highest_total, temporary_totals), "scoring", highest_total)
	print("Worst Graduating Student is: Student", get_unsorted_position(lowest_total, temporary_totals), "scoring", lowest_total)
	print("Class Total Score:", get_total(temporary_totals))
	print("Class Average Score:", get_average(temporary_totals))
	print()
	print()
					


def sort(totals):
	temporary_store = 0

	sorted_list = []

	for total in totals:
		sorted_list.append(total)


	for index in range (len(sorted_list)):
		for second_index in range (index + 1, len(sorted_list)):
			if sorted_list[index] < sorted_list[second_index]:

				temporary_store = sorted_list[index]
				sorted_list[index] = sorted_list[second_index]
				sorted_list[second_index] = temporary_store
	return sorted_list


	
def get_sorted_position(total, totals):
	sorted_list = sort(totals)
	position = 0

	for index in range (len(totals)):
		if total == sorted_list[index]:
			position = index + 1

	return position



def get_unsorted_position(total, totals):
	position = 0

	for index in range (len(totals)):
		if total == totals[index]:
			position = index + 1

	return position



def is_score_valid(score):
	return 0 <= score <= 100


def get_highest_score(subjects):
	largest = subjects[0]

	for index in range (len(subjects)):
		if (subjects[index] > largest):
			largest = subjects[index]

	return largest


def get_lowest_score(subjects):
	lowest = subjects[0]

	for index in range (len(subjects)):
		if (subjects[index] < lowest):
			lowest = subjects[index]

	return lowest


def get_student_with_highest_score(subjects):

	highest_score = get_highest_score(subjects)
	student = 0;

	for index in range (len(subjects)):
		if (highest_score == subjects[index]):
			student = index + 1

	return student


def get_student_with_lowest_score(subjects):

	lowest_score = get_lowest_score(subjects)
	student = 0;

	for index in range (len(subjects)):
		if (lowest_score == subjects[index]):
			student = index + 1

	return student


def get_total(subjects):
	total = 0

	for index in range (len(subjects)):
		total += subjects[index]

	return total


def get_average(subjects):
	average = 0.0

	total = get_total(subjects)

	average = total / len(subjects)

	return average


def get_number_of_passes(subjects):
	passes = 0

	for index in range (len(subjects)):
		if (subjects[index] >= 50):
			passes += 1

	return passes












number_of_classes = int(input("How many classes do you want to record?: "))

for counter in range(1, number_of_classes + 1):
	student_grades = []

	print("Class",counter);
	
	students_number = int(input("How many students do you have?: "))

	subject_number = int(input("How many subjects do they offer?: "))

	for index in range (students_number):
		temporary_list = []

		print()
		print("Entering score for student",(index + 1))

		for second_index in range (subject_number):

			score = int(input(f"Enter score for subject {second_index + 1}: "))

			while is_score_valid(score) == False:

				print("Please enter a valid score")

				score = int(input(f"Enter score for subject {second_index + 1}: "));

			temporary_list.append(score)

		student_grades.append(temporary_list)

	display_student_table(student_grades, students_number, subject_number)
