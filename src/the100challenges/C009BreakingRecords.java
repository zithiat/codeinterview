package the100challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class C009BreakingRecords {

	/**
	 * Problem:		Maria plays college basketball and wants to go pro. 
	 * 				Each season she maintains a record of her play. She tabulates the number of times 
	 * 				she breaks her season record for most points and least points in a game. 
	 * 				Points scored in the first game establish her record for the season, and she begins counting from there.
	 * Input: 		An array of scores
	 * Output:		Print two space-separated integers describing the respective numbers of times her best (highest) score increased 
	 * 				and her worst (lowest) score decreased.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int rn = 100;
		Random r = new Random();
		int[] arr = new int[n];
		IntStream.range(0, n).forEach(i -> arr[i] = r.nextInt(rn));
		System.out.println(Arrays.toString(arr));
		countBreakingRecords(arr, n);
	}

	private static void countBreakingRecords(int[] arr, int n) {
		int max = arr[0], min = arr[0], maxCount = 0, minCount = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minCount++;
//				System.out.println("New min: " + min);
			}
			if (arr[i] > max) {
				max = arr[i];
				maxCount++;
//				System.out.println("New max: " + max);
			}
		}
		System.out.println("Breaking highest records count: " + maxCount);
		System.out.println("Breaking lowest records count: " + minCount);
	}

}
