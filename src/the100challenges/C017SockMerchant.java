package the100challenges;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class C017SockMerchant {

	/**
	 * Problem:		Dummy values are temporary changes in the given input. 
	 * 				There are certain problems, which involve inputs after visiting once, 
	 * 				it becomes redundant.These inputs if not changed will change 
	 * 				the after effect of the problem. In order to ensure that there are no changes 
	 * 				in the outcome due to these redundant variables. You have to know dummy values.
	 * 				Coming back to my question. Yes, Dummy values surely can and will expedite 
	 * 				the process of problem solving. The use of Dummy Values are elucidated with the following problem.
	 * 				John works at a clothing store. He has a large pile of socks that he must pair them by color for sale.
	 * 				You will be given an array of integers representing the color of each sock.
	 * 				Determine how many pairs of socks with matching colors there are.
	 * 				John works at a clothing store and he’s going through a pile of socks to find 
	 * 				the number of matching pairs. More specifically, he has a pile of n loose socks 
	 * 				where each sock i is labeled with an integer,ci , denoting its color. 
	 * 				He wants to sell as many socks as possible, but his customers will only buy them in matching pairs.
	 * 				Two socks, i and j, are a single matching pair if they have the same color (ci==cj).
	 * 				Given n and the color of each sock, how many pairs of socks can John sell?
	 * Input:		Array n space-separated integers describing the colors ci of the socks in the pile.
	 * Output:		Print the total number of matching pairs of socks that John can sell.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int rn = 10;
		Random r = new Random();
		int[] arr = new int[n];
		IntStream.range(0, n).forEach(i -> arr[i] = r.nextInt(rn));
		System.out.println(Arrays.toString(arr));
		countMatchingPairs(arr);
	}

	/**
	 * We will use a hash table for this problem. If the count of each key (as a color) is 1, then we ignore.
	 * If the count of each key is > 2, then we add up the division of 2 to the count.
	 * @param arr
	 */
	private static void countMatchingPairs(int[] arr) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for (int i : arr) {
			table.put(i, table.getOrDefault(i, 0) + 1);
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> en : table.entrySet()) {
//			System.out.println(en);
			int val = en.getValue();
			if (val % 2 == 0 || val > 2) {
				count += en.getValue() / 2;
			}
		}
		System.out.println("Number of matching pairs: " + count);
	}
}
