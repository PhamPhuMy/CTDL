package LAB3;


public class Task1_1 {
	private int[] arr;

	public Task1_1(int[] arr) {
		this.arr = arr;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public int support(int target, int n) {
		if (arr[n] == target) {
			return n;
		}
		if (n > arr.length - 1) {
			return -1;
		}
		return support(target, n + 1);
	}

	public int recursiveLinearSearch(int target) {
		return support(target, 0);
	}

	public static void main(String[] args) {
		int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] arr1 = { 10, 12, 13, 20, 21, 26, 48 };
		int[] arr2 = { 10, 12, 13, 25, 11, 48 };
		int[] arr3 = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90 };
		Task1_1 t1 = new Task1_1(arr);
		System.out.println(t1.iterativeLinearSearch(26));
		System.out.println(t1.iterativeLinearSearch(45));
		System.out.println(t1.iterativeLinearSearch(0));
		System.out.println(t1.recursiveLinearSearch(9));

	}
}
