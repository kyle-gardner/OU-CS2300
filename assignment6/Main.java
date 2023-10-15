// it should be able to perform the following tasks based on users' keyboard input:
// (1) Generate an array of random integers and store it in a file
// (2) Read an existing file containing a list of integers (one integer per line), sort it and store the sorted array in another file.

import java.io.File;
import java.util.Random;

public class Main {
	// The main function will handle a user's keyboard input specified in the next session
	// --rand length file
	// --read file1 -> file2
	public static void main(String[] args) {
		switch (args.length) {
			case 0: System.out.println("0 parameters entered, exiting");
				break;
			case 3: programMode(args);
				break;
			default: System.out.println("Incorrect input, exiting");
				break;
		}
	}
	// if you input correct # of args you go here.
	public static void programMode(String[] args) {
		switch (args[0]) {
			case "--rand": storeRandomArr(args);
				break;
			case "--read": readFileAndSort(args);
				break;
			default: System.out.println("Incorrect first parameter, exiting");
				break;
		}
	}
	// Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
	public static int[] createRandomArray(int arrayLength) {
		int[] randArray = new int[arrayLength];
		Random randGen = new Random();

		for (int i = 0; i < arrayLength; i++) {
			randArray[i] = randGen.nextInt(100);
			System.out.println(randArray[i]);
		}
		return randArray;
	}
	// Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
	public static void writeArrayToFile(int[] array, String filename) {
		File newFile = new File(filename);

		try {
			newFile.createNewFile();
		} catch (Exception e) {
			System.out.println("File couldnt be created");
		}
	}
	// This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
	public static int[] readFileToArray(String filename) {
		int[] a = {};
		return a;
	}
	// Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
	public static void bubbleSort(int[] array) {

	}


	// first 
	public static void storeRandomArr(String[] args) {
		int length = Integer.parseInt(args[1]);
		String fileLocation = args[2];

		int[] randomArr = createRandomArray(length);
		writeArrayToFile(randomArr, fileLocation);
	}
	// second
	public static void readFileAndSort(String[] args) {

	}

	
}