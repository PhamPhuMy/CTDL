package LAB3;


public class Task1_2 {
	private int[] arr;

	public Task1_2(int[] arr) {
		this.arr = arr;
	}

	public int iterativeBinarySearch(int target) {
		int mid = arr.length / 2;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			if (target > arr[mid]) {
				left = mid + 1;
				mid = arr.length - 1 - ((right - left) / 2);
			}
			if (target < arr[mid]) {
				right = mid - 1;
				mid = (right - left) / 2;
			}
			if (target == arr[mid]) {
				return mid;
			}
			if (right == left && target == arr[mid]) {
				return right;
			}
		}
		return -1;
	}

	public int binarySearchRecursion(int[] arr, int target, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			} else {
				if (target < arr[mid]) {
					return binarySearchRecursion(arr, target, low, mid - 1);
				} else {
					return binarySearchRecursion(arr, target, mid + 1, high);
				}
			}
		}
	}

	public int recursiveBinarySearch(int target) {
		int low = 0;
		int high = arr.length - 1;
		return binarySearchRecursion(arr, target, low, high);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 13, 17, 28, 29, 34, 37, 46, 50 };
		Task1_2 t1 = new Task1_2(arr);
		System.out.println(t1.iterativeBinarySearch(0));
		System.out.println(t1.recursiveBinarySearch(10));
	}
}
