import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int arraySize = Integer.parseInt(args[0]);

		ArrayList<Integer> arr1 = makeArray(arraySize);
		ArrayList<Integer> arr2 = makeArray(arraySize);

		Sorter<Integer> mergeSorter = new Sorter<>(arr1);
		Sorter<Integer> bubSorter = new Sorter<>(arr2);
		
		System.out.println("mergesort array");
		System.out.println(arr1);
		mergeSorter.mergeSort(0, arraySize);
		mergeSorter.displayObj();
		System.out.println("");

		System.out.println("bubblesort array");
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
	public void mergeSort(int left, int right) {
		if (left < right) {
			int middle = left + (right - 1) /2;
			//left side
			mergeSort(left, middle);
			//right side 
			mergeSort(middle + 1, right);

			merge(left, middle, right);
		}
	}
	private void merge(int left, int middle, int right) {
		ArrayList<T> leftArray = new ArrayList<T>();
		int leftSize = middle - left + 1;

		ArrayList<T> rightArray = new ArrayList<T>();
		int rightSize = right - middle;

		for (int i = 0; i < leftSize; i++) {
			leftArray.add(newArr.get(left + i));
		}
		for (int i = 0; i < rightSize; i++) {
			rightArray.add(newArr.get(middle + 1 + i));
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < leftSize && j < rightSize) {
			if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
				newArr.set(k, leftArray.get(i));
				i++;;
			} else {
				newArr.set(k, rightArray.get(j));
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			newArr.set(k, leftArray.get(i));
			i++;
			k++;
		}
		while (j < rightSize) {
			newArr.set(k, rightArray.get(j));
			j++;
			k++;
		}
	}
}