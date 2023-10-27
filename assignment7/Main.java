// implement MergeSort and compare it with BubbleSort using ArrayList<Integer> instead of int []
// export your Java project to a JAR file.
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> array1 = makeArray(1000);
		ArrayList<Integer> array2 = makeArray(1000);

//		System.out.println("Unsorted array1");
//		System.out.println(array1);

//		System.out.println("Unsorted array2");
//		System.out.println(array2);

		long time1 = System.nanoTime();
		mergeSort(array1, 0, 10);
		long time2 = System.nanoTime();
		System.out.println("Time for mergesort: " + ((time2-time1)));


		long time3 = System.nanoTime();
		bubbleSort(array2);
		long time4 = System.nanoTime();
		System.out.println("Time for bubblesort: " + ((time4-time3)));

//		System.out.println("Sorted array1");
//		System.out.println(array1);
//		System.out.println("Sorted array2");
//		System.out.println(array2);
	}

	public static ArrayList<Integer> makeArray(int length) {
		ArrayList<Integer> array = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i <= length; i++) {
			int x = random.nextInt(1000);
			Integer integer = Integer.valueOf(x);

			array.add(i, integer);
		}

		return array;
	}

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> array, int i, int j) {
		if (i < j) {
			int middle = (i + (j-1)) / 2;

			//first half
			var first = mergeSort(array, i, middle);
			//second half
			var second = mergeSort(array, middle + 1, j);
			
			return merge(first, second);
		}
		return array;
	}
	public static ArrayList<Integer> merge(ArrayList<Integer> first, ArrayList<Integer> second) {
		ArrayList<Integer> array = new ArrayList<>();


		int i = 0;
		int j = 0;
		while (i < first.size() && j < second.size()) {
			if (first.get(i) < second.get(i)) {
				array.add(first.get(i)); 
				i++;
			} else {
				array.add(second.get(j));
				j++;
			}
		}
		while (i < first.size()) {
			array.add(i);
			i++;
		}
		while (j < second.size()) {
			array.add(second.get(j));
			j++;
		}
		return array;
	}

	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size() - 1; j++) {
				if (array.get(j) > array.get(j + 1)) {
					Integer temp = array.get(j + 1);

					array.set(j + 1, array.get(j));
					array.set(j, temp);
				}
			}
		}
		return array;
	}
	public static boolean isSorted(ArrayList<Integer> array) {
		for (int i = 0; i < array.size() - 1; i++) {
			if (array.get(i) > array.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
	public static void printArray(ArrayList<Integer> array) {
		for (Integer integer : array) {
			System.out.println(integer);
		}
	}
}