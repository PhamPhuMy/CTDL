import java.util.Arrays;

public class Task1_2 {
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j - 1] < arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 24, 3, 2, 15, 9, 5, 4, 10 };
		int[] arr2 = { 7, 1, 13, 2, 19, 35, 24, 35 };
		System.out.println(Arrays.toString(bubbleSort(arr)));
		System.out.println(Arrays.toString(bubbleSort(arr2)));
	}
}
