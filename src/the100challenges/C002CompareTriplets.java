package the100challenges;

import java.util.Arrays;
import java.util.Random;

public class C002CompareTriplets {

	/**
	 * Problem: Your task is to find their comparison points by comparing a[0] with b[0], a[1]with b[1], and c[0]with c[1]
	 * 	- If a[i]>b[i], then Alice is awarded a point.
	 * 	- If a[i]<b[i], then Bob is awarded a point.
	 * 	- If a[i]=b[i], then neither person receives a point.
	 * Input: 2 arrays of integer with length 3.
	 * Output: A point and B point
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int rn = 100;
		int n = 3;
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(rn);
			b[i] = r.nextInt(rn);
		}
		System.out.println("Array A: " + Arrays.toString(a));
		System.out.println("Array B: " + Arrays.toString(b));
		CompareTriplets(a, b, n);
	}

	public static void CompareTriplets(int[] a, int[] b, int n) {
		int A = 0;
		int B = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > b[i]) A++;
			else if (a[i] < b[i]) B++;
		}
		System.out.println("A=" + A + ", B=" + B);
	}

}
