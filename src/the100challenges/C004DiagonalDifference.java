package the100challenges;

import java.util.Arrays;
import java.util.Random;

public class C004DiagonalDifference {

	/**
	 * Problem: 	Given a square matrix, calculate the absolute difference between the sums of its diagonals.
	 * Input:		Square matrix with n integers
	 * Output:		Print the absolute difference between the sums of the matrix’s two diagonals as a single integer.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int[][] arr = new int[n][n];
		Random r = new Random();
		int rn = 100;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] = r.nextInt(rn);
			System.out.println(Arrays.toString(arr[i]));
		}
		
		DiagonalDifference(arr, n);
	}

	public static void DiagonalDifference(int[][] arr, int n) {
		int topLeftBottomRight = 0;
		int topRightBottomLeft = 0;
		for (int i = 0; i < n; i++) {
			topLeftBottomRight += arr[i][i];
			topRightBottomLeft += arr[n-1 - i][i];
		}
		System.out.println("topLeftBottomRight=" + topLeftBottomRight + ", topRightBottomLeft=" + topRightBottomLeft);
		System.out.println("Difference=" + Math.abs(topLeftBottomRight - topRightBottomLeft));
	}
}
