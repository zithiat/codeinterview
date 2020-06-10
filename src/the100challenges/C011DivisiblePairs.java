package the100challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class C011DivisiblePairs {

	/**
	 * Problem:		You are given an array of n integers a0,a1, .. a(n-1)and a positive integer, k. 
	 * 				Find and print the number of pairs(i,j) where and i+j is divisible by k.
	 * Input:		Array contains space-separated integers describing the values of ar[a0,a1, .. a(n-1)], and k integer
	 * Output:		Print the number of (i,j)pairs where i<j and ai+aj is evenly divisible by k.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10; 
		int rn = 100;
		Random r = new Random();
		int[] arr = new int[n];
		int k = r.nextInt(n);
		IntStream.range(0, n).forEach(i -> arr[i] = r.nextInt(rn));
		System.out.println(Arrays.toString(arr));
		System.out.println("k=" + k);
		findDivisiblePairs(arr, k, n);
	}

	private static void findDivisiblePairs(int[] arr, int k, int n) {
		int count = 0;
		int a, b;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			a = arr[i];
			for (int j = i + 1; j < n; j++) {
				b = arr[j];
				if ((a + b) % k == 0) {
					count++;
					list.add(a);
					list.add(b);
				}
			}
		}
		System.out.println("Number of pairs: " + count);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i += 2) {
				System.out.println(list.get(i) + ", " + list.get(i + 1));
			}
		}
	}
}
