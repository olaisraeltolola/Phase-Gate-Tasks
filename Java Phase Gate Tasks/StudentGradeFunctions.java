import java.util.ArrayList;
public class StudentGradeFunctions{

	public static void displayClassSummary(ArrayList<ArrayList<Integer>> studentGrades, int studentsNumber, int subjectNumber){

		ArrayList<Integer> temporary = new ArrayList<>();	
	
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
			double average = 0;

			System.out.print("Student " + (index + 1) + ":	");

			for (int secondIndex = 0; secondIndex < subjectNumber; secondIndex++){
				System.out.printf("%02d",studentGrades.get(index).get(secondIndex));
				System.out.print("      ");
				total += studentGrades.get(index).get(secondIndex);

			}

			temporary.add(total);

			System.out.print(total + "	");

			average = (total + 0.0) / subjectNumber; 
			System.out.printf("%.2f",average);

			int position = getPosition(total, temporary);
			System.out.print("	" + position);
			
			System.out.println();
		}
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
	}

	public static ArrayList<Integer> sort(ArrayList<Integer> totals){
		int temporaryStore = 0;

		for (int index = 0; index < totals.size(); index++){
			for (int secondIndex = index + 1; secondIndex < totals.size(); secondIndex++){
				if (totals.get(index) < totals.get(secondIndex)){

					temporaryStore = totals.get(index);
					totals.set(index, totals.get(secondIndex));
					totals.set(secondIndex, temporaryStore);
				}
			}
		}
		return totals;
	}
	
	public static int getPosition(int total, ArrayList<Integer> totals){
		ArrayList<Integer> sortedArrayList = sort(totals);
		int position = 0;

		for (int index = 0; index < totals.size(); index++){
			if (total == totals.get(index)){
				position = index + 1;
			}
		}
		return position;
	}

}