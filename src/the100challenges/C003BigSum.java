package the100challenges;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class C003BigSum {

	/**
	 * Problem: 	Calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.
	 * Input: 		Array of integer
	 * Output:		Sum of the array
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int rn = Integer.MAX_VALUE;
		Random r = new Random();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = r.nextInt(rn);
		System.out.println(Arrays.toString(arr));
		System.out.println("Total sum=" + BigSum(arr));
	}

	public static BigInteger BigSum(int[] arr) {
		BigInteger sum = new BigInteger("0");
		for (int i : arr) 
			sum = (sum).add(BigInteger.valueOf(i));
		return sum;
	}
}
