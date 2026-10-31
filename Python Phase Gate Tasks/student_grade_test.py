from unittest import TestCase

from student_grade import *

class StudentGradeTest(TestCase):

	def test_that_list_is_sorted_in_descending_order(self):
		numbers = [4, 6, 10, 8, 2]

		sorted_numbers = [10, 8, 6, 4, 2]

		actual = sort(numbers)
		expected = sorted_numbers

		self.assertEqual(actual, expected)


	def test_that_a_score_in_a_list_of_ordered_scores_has_the_correct_position(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_sorted_position(78, scores)
		expected = 3

		self.assertEqual(actual, expected)

	
	def test_that_inputted_scores_are_between_one_and_hundred(self):
		self.assertTrue(is_score_valid(98))



	def test_that_the_position_of_score_in_a_list_of_unordered_scores_is_correct(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_unsorted_position(78, scores)
		expected = 5

		self.assertEqual(actual, expected)


	def test_that_the_highest_score_in_a_list_is_gotten(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_highest_score(scores)
		expected = 100

		self.assertEqual(actual, expected)



	def test_that_the_lowest_score_in_a_list_is_gotten(self):

		scores = [90, 100, 45, 68, 78, 8]

		actual = get_lowest_score(scores)
		expected = 8

		self.assertEqual(actual, expected)



	def test_that_the_position_of_the_student_with_the_highest_score_in_a_list_is_gotten(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_student_with_highest_score(scores)
		expected = 2

		self.assertEqual(actual, expected)


	def test_that_the_position_of_the_student_with_the_lowest_score_in_a_list_is_gotten(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_student_with_lowest_score(scores)
		expected = 6

		self.assertEqual(actual, expected)



	def test_that_the_total_of_scores_in_a_list_is_gotten(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_total(scores)
		expected = 389

		self.assertEqual(actual, expected)

	

	def test_that_the_average_of_scores_in_a_list_is_gotten(self):
		scores = [90, 100, 45, 68, 78, 9]

		actual = get_average(scores)
		expected = 65.0

		self.assertEqual(actual, expected)


	def test_that_the_number_of_scores_above_fifty_is_gotten(self):
		scores = [90, 100, 45, 68, 78, 8]

		actual = get_number_of_passes(scores)
		expected = 4

		self.assertEqual(actual, expected)
