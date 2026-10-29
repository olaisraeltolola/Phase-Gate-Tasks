function reverseArray(array){
	reversedArray = []

	for (let index = 0; index < array.length; index++){
		temporaryArray = [];
		for (let secondIndex = array[index].length - 1; secondIndex >= 0; secondIndex--){
			temporaryArray.push(array[index][secondIndex]);
		}
		reversedArray.push(temporaryArray);
	}
	return reversedArray;
}

numberArray = [[8, 6], [2, 4, 5], [3], [1, 4, 2, 8]]
console.log(reverseArray(numberArray));