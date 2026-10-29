import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MiniParkingSystemTest{
	@Test
	public void testThatPositionChosenIsReserved(){

		MiniParkingSystemFunctions.reservePosition(3);	

		Assertions.assertFalse(MiniParkingSystemFunctions.isPositionEmpty(3));

	}

	@Test
	public void testThatPositionChosenIsUnreserved(){

		MiniParkingSystemFunctions.reservePosition(3);	

		MiniParkingSystemFunctions.removeReservation(3);	

		Assertions.assertTrue(MiniParkingSystemFunctions.isPositionEmpty(3));

	}

	@Test
	public void testThatInputIsBetweenOneAndTwenty(){
	
		Assertions.assertFalse(MiniParkingSystemFunctions.isInputValid(25));	
		Assertions.assertFalse(MiniParkingSystemFunctions.isInputValid(-9));	

	}	
}