package LAB1;

import java.util.Arrays;

public class MyArray {
	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public static int[] mirror(int[] arr) {
		int[] result = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
			result[result.length - 1 - i] = arr[i];
		}
		return result;
	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public static int removeDuplicatesHelp(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					result++;
				}
			}
		}
		return arr.length - result;
	}

	public static int[] removeDuplicates(int[] arr) {
		int[] result = new int[removeDuplicatesHelp(arr)];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = 0;
				}
			}
		}
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[index++] = arr[i];
			}
		}
		return result;
	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public static int[] getMissingValues(int[] arr2) {
		int count = 0, index = 0;
		for (int z = 1; z < arr2.length; z++) {
			if (arr2[z] - arr2[z - 1] >= 1) {
				count += arr2[z] - arr2[z - 1] - 1;
			}
		}
		int[] result = new int[count];
		for (int i = 1; i < arr2.length; i++) {
			if (arr2[i] - arr2[i - 1] >= 1) {
				for (int j = 1; j < arr2[i] - arr2[i - 1]; j++) {
					result[index++] = arr2[i - 1] + j;

				}
			}
		}
		return result;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public static int[] fillMissingValues(int[] arr3, int k) {
		int[] result = arr3.clone();
		int y = 0;
		for (int i = 0; i < arr3.length; i++) {
			int index1 = i - ((k + 1) / 2); 
			int index2 = i + ((k + 1) / 2); 
			if (arr3[0] == -1 && i == 0) {
				for (int a = 1; a <= k; a++) {
					y += arr3[a];
				}
				result[0] = y / k;
			}
			if (arr3[i] == -1 && i == arr3.length - 1) {
				for (int b = arr3.length - 1; b >= arr3.length - 1 - k; b--) {
					y += arr3[b];
				}
				result[arr3.length - 1] = y / k;
			}
			if (arr3[i] == -1 && arr3[0] != -1 && arr3[arr3.length - 1] != -1) {
				if (k % 2 == 0) {
					for (int j = index1; j <= index2; j++) {
						if (arr3[j] != -1) {
							y += arr3[j];
						}
					}
				} else {
					if (arr3[index1] < arr3[index2]) {
						for (int z = index1; z < index2; z++) {
							if (arr3[z] != -1) {
								y += arr3[z];
							}
						}
					}
					if (arr3[index1] > arr3[index2]) {
						for (int z = index2; z > index1; z--) {
							if (arr3[z] != -1) {
								y += arr3[z];
							}
						}
					}
				}
				result[i] = y / k;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("mirror() {");
		int[] arr = { 1, 2, 3 };
		System.out.println(Arrays.toString(mirror(arr)));
		System.out.println("removeDuplicates() {");
		int[] arr1 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		System.out.println(Arrays.toString(removeDuplicates(arr1)));
		System.out.println("getMissingValues() {");
		int[] arr2 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		System.out.println(Arrays.toString(getMissingValues(arr2)));
		System.out.println("fillMissingValues() {");
		int[] arr3 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		System.out.println(Arrays.toString(fillMissingValues(arr3, 3)));
	}
}
