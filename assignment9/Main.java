import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr = makeArray(100);

		var sorter = new Sorter<>(arr);
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

class Sorter <T extends Collection<? extends Comparable>> {
	T obj;

	public Sorter(T obj) {
		this.obj = obj;
	}

	public void displayObj() {
		System.out.println(obj);
	}

	public T  bubbleSort() {
		return obj;
	}
	public T mergeSort() {
		return obj;
	}
}