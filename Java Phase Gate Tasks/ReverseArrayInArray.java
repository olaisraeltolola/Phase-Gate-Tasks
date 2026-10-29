import java.util.Arrays;
public class ReverseArrayInArray{

	public static void main(String[] args){
		int[][] numbers = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};

		int [][] numberList = {
				{8, 6},
				{2, 4, 5},
				{3},
				{1, 4, 2, 8}

		}; 
		int[][] reversedArray = reverseArray(numberList);
	
		for (int index = 0; index < numberList.length; index++){
			for (int secondIndex = 0; secondIndex < numberList[index].length; secondIndex++){
				System.out.print(reversedArray[index][secondIndex] + " ");	

			}
			System.out.println();
		}
	}


	public static int[][] reverseArray(int[][] array){

		int[][] newArray = array;

		for (int index = 0; index < array.length; index ++){
			for (int secondIndex = 0; secondIndex < array[index].length / 2; secondIndex++){

				int temporary = array[index][secondIndex];
				newArray[index][secondIndex] = array[index][(array[index].length) - 1 - secondIndex];
				newArray[index][(array[index].length) - 1 - secondIndex] = temporary;

			}

		}	
		return newArray;
	}


}


