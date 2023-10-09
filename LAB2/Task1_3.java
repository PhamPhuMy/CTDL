package LAB2;

import java.util.Arrays;

public class Task1_3 {
	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows

	public static int[] generateNextRow(int[] prevRow) {
		int res[] = new int[prevRow.length + 1];
		for (int i = 1; i < res.length - 1; i++) {
			res[i] = prevRow[i - 1] + prevRow[i];
		}
		res[0] = 1;
		res[res.length - 1] = 1;

		return res;
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };
		} else if (n == 2) {
			return new int[] { 1, 1 };
		} else {
			int prevRow[] = getPascalTriangle(n - 1);
			return generateNextRow(prevRow);
		}
	}

	public static void printPascalTriangle(int row) {
		printPascalTriangleHepler(row, 1);
	}

	public static void printPascalTriangleHepler(int row, int current) {
		if (row < current) {
			return;
		}
		System.out.println(Arrays.toString(getPascalTriangle(current)));
		printPascalTriangleHepler(row, current + 1);
	}

	public static void main(String[] args) {
		printPascalTriangle(6);
	}

}