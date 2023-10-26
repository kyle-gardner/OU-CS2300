// implement MergeSort and compare it with BubbleSort using ArrayList<Integer> instead of int []
// export your Java project to a JAR file.
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> array1 = makeArray(1000);
		ArrayList<Integer> array2 = makeArray(1000);
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

	}
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {

	}
}