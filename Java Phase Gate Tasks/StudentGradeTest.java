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

	@Test
	public void testThatAScoreInAnArrayListOfOrderedScoresHasTheCorrectPosition(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getSortedPosition(78, scores);
		int expected = 3;

		Assertions.assertEquals(actual, expected);
	}
	
	@Test
	public void testThatInputtedScoresAreBetweenOneAndHundred(){
		Assertions.assertTrue(StudentGradeFunctions.isScoreValid(98));

	}

	@Test
	public void testThatThePositionOfAScoreInAnArrayListOfUnorderedScoresIsCorrect(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getUnsortedPosition(78, scores);
		int expected = 5;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatTheHighestScoreInAnArrayListIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getHighestScore(scores);
		int expected = 100;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatTheLowestScoreInAnArrayListIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getLowestScore(scores);
		int expected = 9;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatThePositionOfTheStudentWithTheHighestScoreInAnArrayListIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getStudentWithHighestScore(scores);
		int expected = 2;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatThePositionOfTheStudentWithTheLowestScoreInAnArrayListIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getStudentWithLowestScore(scores);
		int expected = 6;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatTheTotalOfScoresInAnArrayListIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getTotal(scores);
		int expected = 390;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatTheAverageOfScoresInAnArrayListIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		double actual = StudentGradeFunctions.getAverage(scores);
		double expected = 65.0;

		Assertions.assertEquals(actual, expected);

	}

	@Test
	public void testThatTheNumberOfScoresAboveFiftyIsGotten(){
		ArrayList<Integer> scores = new ArrayList<>();

		scores.add(90);
 		scores.add(100);
		scores.add(45);
		scores.add(68);
		scores.add(78);
		scores.add(9);

		int actual = StudentGradeFunctions.getNumberOfPasses(scores);
		int expected = 4;

		Assertions.assertEquals(actual, expected);

	}

}
