import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = makeArray(Integer.parseInt(args[0]));
		ArrayList<Integer> arr2 = makeArray(Integer.parseInt(args[0]));

		Sorter<Integer> mergeSorter = new Sorter<>(arr1);
		Sorter<Integer> bubSorter = new Sorter<>(arr2);
		
		System.out.println("unsorted");
		System.out.println(arr1);
		mergeSorter.mergeSort();
		mergeSorter.displayObj();

		System.out.println(arr2);
		bubSorter.bubbleSort();
		bubSorter.displayObj();
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
}

class Sorter <T extends Comparable<T>> {
	ArrayList<T> newArr;

	public Sorter(ArrayList<T> obj) {
		this.newArr = obj;
	}

	public void displayObj() {
		System.out.println(newArr);
	}

	public void bubbleSort() {
		for (int i = 0; i < newArr.size() - 1; i++) {
			for (int j = 0; j < newArr.size() - 1; j++) {
				if (newArr.get(j).compareTo(newArr.get(j + 1)) > 0) {
					T temp = newArr.get(j);

					newArr.set(j, newArr.get(j + 1));
					newArr.set(j + 1, temp);
				}
			}
		}
	}
	public void mergeSort() {
		int middle = newArr.size();

	}
	private ArrayList<T> merge(int left, int right) {
		return newArr;
	}
}