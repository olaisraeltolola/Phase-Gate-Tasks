import java.util.ArrayList;

public class StudentGradeFunctions{

	public static void displayStudentTable(ArrayList<ArrayList<Integer>> studentGrades, int studentsNumber, int subjectNumber){

		ArrayList<Integer> temporaryTotals = new ArrayList<>();	
		ArrayList<ArrayList<Integer>> subjects = new ArrayList<>();

		for (int counter = 1; counter <= studentsNumber; counter++){
			subjects.add(new ArrayList<>());

		}
	
		System.out.println("==============================================================================");
		System.out.print("STUDENT		");

		for (int counter = 1; counter <= subjectNumber; counter++){
			System.out.print("SUB " + counter + "	");
		}
		System.out.print("TOT" + "	");
		System.out.print("AVG" + "	");
		System.out.println("POS");


		System.out.println("==============================================================================");


		for (int index = 0; index < studentsNumber; index++){ 
			int total = 0;

			for (int secondIndex = 0; secondIndex < subjectNumber; secondIndex++){
				total += studentGrades.get(index).get(secondIndex);

			}

			temporaryTotals.add(total);
		}


		for (int index = 0; index < subjectNumber; index++){ 

			for (int secondIndex = 0; secondIndex < studentsNumber; secondIndex++){

				subjects.get(index).add(studentGrades.get(secondIndex).get(index));
			}
		}


		for (int index = 0; index < temporaryTotals.size(); index++){ 
			int singleTotal = temporaryTotals.get(index);
			double average = 0;

			System.out.print("Student " + (index + 1) + ":	");

			for (int secondIndex = 0; secondIndex < subjectNumber; secondIndex++){
				System.out.printf("%02d",studentGrades.get(index).get(secondIndex));
				System.out.print("      ");

			}

			System.out.print(singleTotal + "	");

			average = (singleTotal + 0.0) / subjectNumber; 
			System.out.printf("%.2f",average);

			int position = getPosition(singleTotal, temporaryTotals);
			System.out.print("	" + position);
			
			System.out.println();
		}
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");

		System.out.println();
		System.out.println("SUBJECT SUMMARY");
		int highestScore = 0;
		int lowestScore = 0;

		for (int index = 0; index < subjectNumber; index++){ 
			for (int secondIndex = 0; secondIndex < studentsNumber; secondIndex++){

				highestScore = getHighestScore(subjects.get(index));
				lowestScore = getLowestScore(subjects.get(index));
			}
			System.out.println();
			System.out.println("Subject " + (index + 1));

			System.out.println("The highest scoring student: Student " + getStudentWithHighestScore(subjects.get(index)) + " scoring " + highestScore);
			System.out.println("The lowest scoring student: Student " + getStudentWithLowestScore(subjects.get(index)) + " scoring " + lowestScore);
			System.out.println("Total Score is: " + getTotal(subjects.get(index)));
			System.out.printf("Average Score is: %.2f",getAverage(subjects.get(index)));
			System.out.println();
			System.out.println("Number of passes: " + getNumberOfPasses(subjects.get(index)));
			System.out.println("Number of fails: " + (subjects.get(index).size() - getNumberOfPasses(subjects.get(index))));

		}
					
	}





	public static ArrayList<Integer> sort(ArrayList<Integer> totals){
		int temporaryStore = 0;

		ArrayList<Integer> sorted = new ArrayList<>();

		for (int index = 0; index < totals.size(); index++){
			sorted.add(totals.get(index));
		}

		for (int index = 0; index < sorted.size(); index++){
			for (int secondIndex = index + 1; secondIndex < sorted.size(); secondIndex++){
				if (sorted.get(index) < sorted.get(secondIndex)){

					temporaryStore = sorted.get(index);
					sorted.set(index, sorted.get(secondIndex));
					sorted.set(secondIndex, temporaryStore);
				}
			}
		}
		return sorted;
	}
	
	public static int getPosition(int total, ArrayList<Integer> totals){
		ArrayList<Integer> sortedArrayList = sort(totals);
		int position = 0;

		for (int index = 0; index < totals.size(); index++){
			if (total == sortedArrayList.get(index)){
				position = index + 1;
			}
		}
		return position;
	}

	public static boolean isScoreValid(int score){
		return score <= 100 && score >= 0;

	}

	public static int getHighestScore(ArrayList<Integer> subjects){
		int largest = subjects.get(0);

		for (int index = 0; index < subjects.size(); index++){
			if (subjects.get(index) > largest){
				largest = subjects.get(index);
			}
		}
		return largest;
	}

	public static int getLowestScore(ArrayList<Integer> subjects){
		int lowest = subjects.get(0);

		for (int index = 0; index < subjects.size(); index++){
			if (subjects.get(index) < lowest){
				lowest = subjects.get(index);
			}
		}
		return lowest;
	}

	public static int getStudentWithHighestScore(ArrayList<Integer> subjects){
		int highestScore = getHighestScore(subjects);
		int student = 0;

		for (int index = 0; index < subjects.size(); index++){
			if (highestScore == subjects.get(index)){
				student = index + 1;
			}
		}
		return student;	
	}

	public static int getStudentWithLowestScore(ArrayList<Integer> subjects){
		int lowestScore = getLowestScore(subjects);
		int student = 0;

		for (int index = 0; index < subjects.size(); index++){
			if (lowestScore == subjects.get(index)){
				student = index + 1;
			}
		}
		return student;	
	}

	public static int getTotal(ArrayList<Integer> subjects){
		int total = 0;

		for (int index = 0; index < subjects.size(); index++){
			total += subjects.get(index);
		}
		return total;
	}

	public static double getAverage(ArrayList<Integer> subjects){
		double average = 0;

		int total = getTotal(subjects);

		average = (total + 0.0) / subjects.size();

		return average;

	}

	public static int getNumberOfPasses(ArrayList<Integer> subjects){
		int passes = 0;

		for (int index = 0; index < subjects.size(); index++){
			if (subjects.get(index) >= 50){
				passes++;
			}
		}
		return passes;
	}

}