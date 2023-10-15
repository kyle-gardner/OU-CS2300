// it should be able to perform the following tasks based on users' keyboard input:
// (1) Generate an array of random integers and store it in a file
// (2) Read an existing file containing a list of integers (one integer per line), sort it and store the sorted array in another file.

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
	// The main function will handle a user's keyboard input specified in the next session
	public static void main(String[] args) {
		switch (args.length) {
			case 0: System.out.println("0 parameters entered, exiting");
				break;
			case 3: programMode(args);
				break;
			default: System.out.println("Incorrect number of parameters, exiting");
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

		// create file
		try {
			newFile.createNewFile();
		} catch (Exception e) {
			System.out.println("File couldnt be created");
		}

		//write to file
		try {
			FileWriter writer = new FileWriter(filename);

			for (int i = 0; i < array.length; i++) {
				if (i == array.length - 1) {
					writer.write(Integer.toString(array[i]));
				} else if (i < array.length) {
					writer.write(Integer.toString(array[i]) + "\n");
				}
			}

			writer.close();
			System.out.println("Written to file " + filename);
		} catch (Exception e) {
			System.out.println("Error writing to file.");
		}
	}
	// This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
	public static int[] readFileToArray(String filename) {
		try {
			File fileToRead = new File(filename);
			Scanner reader = new Scanner(fileToRead);

			// finds file length
			int fileLength = 0;
			while (reader.hasNextLine()) {
				fileLength++;
				reader.nextLine();
			}
			reader.close();
			// reads file to array
			Scanner reader2 = new Scanner(fileToRead);
			int[] array = new int[fileLength];
			for (int i = 0; i < fileLength; i++) {
				array[i] = reader2.nextInt();

				System.out.println(array[i]);
			}
			reader2.close();

			return array;
		} catch (Exception e) {
			System.out.println("Error reading file into array,");
			int[] a = {};
			return a;
		}
	}
	// Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	// first requirement
	public static void storeRandomArr(String[] args) {
		int length = Integer.parseInt(args[1]);
		String fileName = args[2];

		int[] randomArray = createRandomArray(length);
		writeArrayToFile(randomArray, fileName);
	}
	// second requirement
	public static void readFileAndSort(String[] args) {
		String fileName1 = args[1];
		String fileName2 = args[2];

		int[] array = readFileToArray(fileName1);
		bubbleSort(array);
		writeArrayToFile(array, fileName2);
	}
}