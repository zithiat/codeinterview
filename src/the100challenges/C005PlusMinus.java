package the100challenges;

import java.util.Arrays;
import java.util.Random;

public class C005PlusMinus {

	/**
	 * Problem:		Given an array of integers, calculate the fractions of its elements 
	 * 				that are positive, negative, and are zeros. 
	 * 				Print the decimal value of each fraction on a new line.
	 * Input:		Array of integer
	 * Output:		1. A decimal representing the fraction of positive numbers in the array compared to its size.
	 * 				2. A decimal representing the fraction of negative numbers in the array compared to its size.
	 * 				3. A decimal representing the fraction of zeros in the array compared to its size.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100;
		int rn = 1000;
		Random r = new Random();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = r.nextInt(rn) * (r.nextInt(2) == 0 ? 0 : (r.nextBoolean() ? 1 : -1));
		System.out.println(Arrays.toString(arr));
		
		CalculateFraction(arr, n);
	}

	public static void CalculateFraction(int[] arr, int n) {
		int p = 0, ne = 0, z = 0;
		for (int i : arr) {
			if (i == 0) z++;
			else if (i < 0) ne++;
			else p++;
		}
		System.out.println("Fraction of positive numbers " + p + "/" + n + " : " + (double) p/n);
		System.out.println("Fraction of negative numbers " + ne + "/" + n + " : " + (double) ne/n);
		System.out.println("Fraction of zero numbers " + z + "/" + n + " : " + (double) z/n);
	}

}
