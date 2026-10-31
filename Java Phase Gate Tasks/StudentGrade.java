import java.util.Scanner;
import java.util.ArrayList;

public class StudentGrade{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("How many classes do you want to record?");
		int numberOfClasses = input.nextInt();

		for (int counter = 1; counter <= numberOfClasses; counter++){

			ArrayList<ArrayList<Integer>> studentGrades = new ArrayList<>();

			System.out.println("Class " + counter);
	
			System.out.println("How many students do you have?");
			int studentsNumber = input.nextInt();

			System.out.println("How many subjects do they offer?");
			int subjectNumber = input.nextInt();


			for (int index = 0; index < studentsNumber; index++){ 
				studentGrades.add(new ArrayList<>());
			}


			for (int index = 0; index < studentsNumber; index++){

				System.out.println();
				System.out.println("Entering score for student " + (index + 1));

				for (int secondIndex = 0; secondIndex < subjectNumber; secondIndex++){

					System.out.println("Enter score for subject " + (secondIndex + 1));
					int score = input.nextInt();

					while (StudentGradeFunctions.isScoreValid(score) == false){

						System.out.println("Please enter a valid score");

						System.out.println("Enter score for subject " + (secondIndex + 1));
						score = input.nextInt();

					}


					studentGrades.get(index).add(score);

				}
			}
			StudentGradeFunctions.displayStudentTable(studentGrades, studentsNumber, subjectNumber);
		}
	}

}