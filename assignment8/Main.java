public class Main {
	public static void main(String[] args) {
		int x = fib(30);
		System.out.println(x);
	}

	public static int fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n-1) + fib(n - 2);
	}
}
