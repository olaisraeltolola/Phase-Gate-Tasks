const prompt = require("prompt-sync")();

function displayStudentTable(studentGrades, studentsNumber, subjectNumber){

	temporaryTotals = [];	
	subjects = [];
	output = "";
	secondOutput = "";
	
	output += "==============================================================================\n";
	output += "STUDENT		";

	for (let counter = 1; counter <= subjectNumber; counter++){
		output += "SUB " + counter + "	";
	}
	output += "TOT" + "	";
	output += "AVG" + "	";
	output += "POS\n";


	output += "==============================================================================";
	console.log(output);


	for (let index = 0; index < studentsNumber; index++){ 
		total = 0

		for (let secondIndex = 0; secondIndex < subjectNumber; secondIndex++){
			total += studentGrades[index][secondIndex]
		}
		temporaryTotals.push(total);
	}

	for (let index = 0; index < subjectNumber; index++){ 
		temporarySubjects = [];

		for (let secondIndex = 0; secondIndex < studentsNumber; secondIndex++){

			temporarySubjects.push(studentGrades[secondIndex][index]);
		}

		subjects.push(temporarySubjects);
	}


	for (let index = 0; index < temporaryTotals.length; index++){
		singleTotal = temporaryTotals[index];
		average = 0;

		secondOutput += "Student" + (index + 1) + ":	";

		for (let secondIndex = 0; secondIndex < subjectNumber; secondIndex++){
			secondOutput += `${studentGrades[index][secondIndex].toString().padStart(2, '0')}`;
			secondOutput += "      ";
		}

		secondOutput += `${singleTotal}	`;

		average = singleTotal / subjectNumber;
		secondOutput += `${parseFloat(average.toFixed(2))}`;

		position = getSortedPosition(singleTotal, temporaryTotals);
		secondOutput += `	${position}`;

		console.log(secondOutput);
			
	}
	console.log("===============================================================================")
	console.log("===============================================================================")

	console.log()
	console.log("SUBJECT SUMMARY")
	highestScore = 0
	lowestScore = 0

	for (let index = 0; index < subjectNumber; index++){ 
		for (let secondIndex = 0; secondIndex < studentsNumber; secondIndex++){

			highestScore = getHighestScore(subjects[index]);
			lowestScore = getLowestScore(subjects[index]);
		}

		console.log()
		console.log("Subject",(index + 1))

		console.log("The highest scoring student: Student", getStudentWithHighestScore(subjects[index]),"scoring",highestScore)
		console.log("The lowest scoring student: Student", getStudentWithLowestScore(subjects[index]),"scoring",lowestScore)
		console.log("Total Score is:",getTotal(subjects[index]))
		console.log(`Average Score is: ${parseFloat(getAverage(subjects[index]).toFixed(2))}`);
		console.log()
		console.log("Number of passes:",getNumberOfPasses(subjects[index]));
		console.log("Number of fails:",(subjects[index].length - getNumberOfPasses(subjects[index])));


		console.log()
		console.log()
	}

	console.log("CLASS SUMMARY")			

	sortedList = sort(temporaryTotals)
	highestTotal = sortedList[0]
	lowestTotal = sortedList[sortedList.length - 1]


	console.log("Best Graduating Student is: Student", getUnsortedPosition(highestTotal, temporaryTotals), "scoring", highestTotal)
	console.log("Worst Graduating Student is: Student", getUnsortedPosition(lowestTotal, temporaryTotals), "scoring", lowestTotal)
	console.log("Class Total Score:", getTotal(temporaryTotals))
	console.log("Class Average Score:", getAverage(temporaryTotals))
	console.log()
	console.log()
}		


function sort(totals){
	temporaryStore = 0;

	sortedList = [];

	for (let total of totals){
		sortedList.push(total);
	}

	for (let index = 0; index < sortedList.length; index++){
		for (let secondIndex = index + 1; secondIndex < sortedList.length; secondIndex++){
			if (sortedList[index] < sortedList[secondIndex]){

				temporaryStore = sortedList[index];
				sortedList[index] = sortedList[secondIndex];
				sortedList[secondIndex] = temporaryStore;
			}
		}
	}
	return sortedList;
}

	
function getSortedPosition(total, totals){
	sortedList = sort(totals);
	position = 0;

	for (let index = 0; index < totals.length; index++){
		if (total == sortedList[index]){
			position = index + 1;
		}
	}
	return position;
}


function getUnsortedPosition(total, totals){
	position = 0

	for (let index = 0; index < totals.length; index++){
		if (total == totals[index]){
			position = index + 1;
		}
	}
	return position;
}


function isScoreValid(score){
	return score <= 100 && score >= 0;
}


function getHighestScore(subjects){
	largest = subjects[0];

	for (let index = 0; index < subjects.length; index++){
		if (subjects[index] > largest){
			largest = subjects[index];
		}
	}
	return largest;
}


function getLowestScore(subjects){
	lowest = subjects[0];

	for (let index = 0; index < subjects.length; index++){
		if (subjects[index] < lowest){
			lowest = subjects[index];
		}
	}
	return lowest;
}


function getStudentWithHighestScore(subjects){

	highestScore = getHighestScore(subjects);
	student = 0;

	for (let index = 0; index < subjects.length; index++){
		if (highestScore == subjects[index]){
			student = index + 1;
		}
	}
	return student;
}


function getStudentWithLowestScore(subjects){

	lowestScore = getLowestScore(subjects);
	student = 0;

	for (let index = 0; index < subjects.length; index++){
		if (lowestScore == subjects[index]){
			student = index + 1;
		}
	}
	return student;
}


function getTotal(subjects){
	total = 0;

	for (let index = 0; index < subjects.length; index++){
		total += subjects[index];
	}
	return total;
}


function getAverage(subjects){
	average = 0;

	total = getTotal(subjects);

	average = total / subjects.length;

	return average;
}


function getNumberOfPasses(subjects){
	passes = 0;

	for (let index = 0; index < subjects.length; index++){
		if (subjects[index] >= 50){
			passes ++;
		}
	}
	return passes;
}












let numberOfClasses = Number(prompt("How many classes do you want to record?: "));

for (let counter = 1; counter <= numberOfClasses; counter++){
	studentGrades = [];

	console.log("Class",counter);
	
	let studentsNumber = Number(prompt("How many students do you have?: "));

	let subjectNumber = Number(prompt("How many subjects do they offer?: "));

	for (let index = 0; index < studentsNumber; index++){
		temporaryList = [];

		console.log();
		console.log("Entering score for student",(index + 1));

		for (let secondIndex = 0; secondIndex < subjectNumber; secondIndex++){

			score = Number(prompt(`Enter score for subject ${secondIndex + 1}: `));

			while (isScoreValid(score) == false){

				console.log("Please enter a valid score");

				score = Number(prompt(`Enter score for subject ${secondIndex + 1}: `));
			}

			temporaryList.push(score);
		}

		studentGrades.push(temporaryList);
	}

	displayStudentTable(studentGrades, studentsNumber, subjectNumber);

}
