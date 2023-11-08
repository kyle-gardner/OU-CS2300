// Write a java program to count words in an input file and write the results to an output file.
// The input file is a .txt file with each line a single word.
// The words are not case-sensitive. That means, "Dictionary" and "dictionary" will be treated as the same word in the file

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
		String dir = args[0];
		Map<String, Integer> map = new HashMap<>();

		try {
			File file = new File(dir);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String key = scanner.nextLine();
				String newKey = key.toLowerCase();

				if (map.containsKey(newKey)) {
					int value = map.get(newKey);
					map.put(newKey, value + 1);
				} else {
					map.put(newKey, 1);
				}
			}
			scanner.close();
		} catch (Exception e) {
			System.err.println("Couldnt open file");
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}