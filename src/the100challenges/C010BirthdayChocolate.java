package the100challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class C010BirthdayChocolate {

	/**
	 * Problem:		Lily has a chocolate bar that she wants to share with Ron for his birthday. 
	 * 				Each of the squares has an integer on it. 
	 * 				She decides to share a contiguous segment of the bar selected 
	 * 				such that the length of the segment matches Ron’s birth month 
	 * 				and the sum of the integers on the squares is equal to his birthday.
	 * 				You must determine how many ways she can divide the chocolate.
	 * Input:		n is number of squares in the chocolate bar.
	 * 				Array contains n space-separated integers s[i], the numbers on the chocolate squares where 0 <= i <n.
	 * 				d is Ron's birth day
	 * 				m is Ron's birth month
	 * Output:		Print an integer denoting the total number of ways that Lily can portion her chocolate bar to share with Ron.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 20;
		int rn = 20;
		Random r = new Random();
		int d = r.nextInt(30);
		int m = r.nextInt(12);
		int[] arr = new int[n];
		IntStream.range(0, n).forEach(i -> arr[i] = r.nextInt(rn));
		System.out.println(Arrays.toString(arr));
		System.out.println("d=" + d + ", m=" + m);
		countPortionWays(arr, n, d, m);
		int[] arr1 = { 2, 23, 12, 4, 13, 2, 4, 2, 8, 21 };
		countPortionWays(arr1, 10, 25, 5);
	}

	private static void countPortionWays(int[] arr, int n, int d, int m) {
		int sum = 0;
		int count = 0;
		int index = 0;
		int[] tmp = new int[m];
		if (n > m)
			for (int i = 0; i < n - m; i++) {
				for (int j = i; j < i + m; j++) {
					sum += arr[j];
					tmp[index] = arr[j];
					index++;
				}
				if (sum == d) {
					count++;
					System.out.println(Arrays.toString(tmp));
				}
				index = 0;
				sum = 0;
			}
		else 
			System.out.println("Wrong data");
		System.out.println("Portion ways: " + count);
	}
}
