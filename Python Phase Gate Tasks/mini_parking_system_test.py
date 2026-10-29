from unittest import TestCase

from mini_parking_system import *

class MiniParkingSystemTest(TestCase):

	def test_thatPosition_chosenIsReserved(self):

		reserve_position(3)	

		self.assertFalse(is_position_empty(3))


	def test_thatPosition_chosenIs_unreserved(self):

		reserve_position(3)

		remove_reservation(3)

		self.assertTrue(is_position_empty(3))

	def test_thatInput_is_between_one_andTwenty(self):
	
		self.assertFalse(is_input_valid(25))	
		self.assertFalse(is_input_valid(-9))	

