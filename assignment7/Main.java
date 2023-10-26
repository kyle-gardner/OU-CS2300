// implement MergeSort and compare it with BubbleSort using ArrayList<Integer> instead of int []
// export your Java project to a JAR file.
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> array1 = makeArray(1000);
		ArrayList<Integer> array2 = makeArray(10);

		bubbleSort(array2);
	}

	public static ArrayList<Integer> makeArray(int length) {
		ArrayList<Integer> array = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int x = random.nextInt(1000);
			Integer integer = Integer.valueOf(x);

			array.add(i, integer);
		}

		return array;
	}

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
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