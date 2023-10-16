import java.util.Arrays;

public class Task1_1 {
	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] selectionSort2(int[] arr) {
		int index = 1;
		while (arr[index - 1] < arr[index] && index < arr.length) {
			int temp = arr[index - 1];
			arr[index - 1] = arr[index];
			arr[index] = temp;
			index++;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 15, 3, 2, 24, 9, 5, 4, 10 };
		int[] arr2 = { 7, 1, 13, 2, 19, 35, 24, 35 };
		System.out.println(Arrays.toString(selectionSort(arr)));
//		System.out.println(Arrays.toString(selectionSort(arr2)));
//		System.out.println(Arrays.toString(selectionSort2(arr)));

	}
}
