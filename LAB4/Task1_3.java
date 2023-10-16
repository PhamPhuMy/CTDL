import java.util.Arrays;

public class Task1_3 {
	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp > arr[j]) {
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 24, 3, 2, 15, 9, 5, 4, 10 };
		int[] arr2 = { 7, 1, 13, 2, 19, 35, 24, 35 };
		System.out.println(Arrays.toString(insertionSort(arr)));
		System.out.println(Arrays.toString(insertionSort(arr2)));
	}
}
