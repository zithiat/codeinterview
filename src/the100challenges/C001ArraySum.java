package the100challenges;

import java.util.Arrays;
import java.util.Random;

public class C001ArraySum {

	/**
	 * Problem: Given an array of integers, find the sum of its elements.
	 * Inputs: The second line contains n space-separated integers representing the array’s elements.
	 * Outputs: Print the sum of the array’s elements as a single integer.
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int n = 10;
		int rn = 100;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = r.nextInt(rn) ;
		System.out.println(Arrays.toString(arr));
		System.out.println("Sum=" + ArraySum(arr));
		
	}

	public static int ArraySum(int[] arr) {
		int sum = 0;
		for (int i : arr)
			sum += i;
		return sum;
	}
}
