import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class StudentGradeTest{
	@Test
	public void testThatArrayListIsSortedInDescendingOrder(){
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(4);
		numbers.add(6);
		numbers.add(10);
		numbers.add(8);
		numbers.add(2);

		ArrayList<Integer> sortedNumbers = new ArrayList<>();
		sortedNumbers.add(10);
		sortedNumbers.add(8);
		sortedNumbers.add(6);
		sortedNumbers.add(4);
		sortedNumbers.add(2);

		ArrayList<Integer> actual = StudentGradeFunctions.sort(numbers);
		ArrayList<Integer> expected = sortedNumbers;

		Assertions.assertEquals(actual, expected);
	}


}