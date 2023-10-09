package LAB2;

public class Task1_2 {
	// get the nth value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return getFibonacci(n - 2) + getFibonacci(n - 1);
	}
//Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
	public static void main(String[] args) {
		System.out.println(getFibonacci(6));
	}

}
