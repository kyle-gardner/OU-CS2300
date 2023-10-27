public class Main {
	// idk if he wants all the numbers in the sequence or just the nth fibonaci number so im gonna go with the nth one 
	// sorry if wrong
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int nth = fib(n);

		System.out.println(nth);
	}

	public static int fib(int n) {
		// base
		if (n == 0) return 0;
		if (n == 1) return 1;

		// recurse
		return fib(n-1) + fib(n - 2);
	}
}
