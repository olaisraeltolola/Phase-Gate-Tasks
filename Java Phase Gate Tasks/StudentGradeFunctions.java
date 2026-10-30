import java.util.ArrayList;

public class StudentGradeFunctions{

	public static void displayClassSummary(ArrayList<ArrayList<Integer>> studentGrades, int studentsNumber, int subjectNumber){

		ArrayList<Integer> temporaryTotals = new ArrayList<>();	
		//ArrayList<Integer> positions = new ArrayList<>();

	
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
		System.out.println("Totals = " + temporaryTotals);

		for (int index = 0; index < temporaryTotals.size(); index++){ 
			int singleTotal = temporaryTotals.get(index);
			System.out.println("Single total = " + singleTotal);
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
}