package the100challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class C015BonAppetit {

	/**
	 * Problem:		Anna and Brian are sharing a meal at a restaurant and they agree to split the bill equally.
	 * 				Brian wants to order something that Anna is allergic to though, 
	 * 				and they agree that Anna won’t pay for that item. Brian gets the check and calculates Anna’s portion.
	 * 				You must determine if his calculation is correct.
	 * 				You are given an array of prices, bill, the cost of each of the n items, 
	 * 				k, the item Anna doesn’t eat, 
	 * 				and b, the total amount of money that Brian charged Anna for her portion of the bill. 
	 * 				If the bill is fairly split, print Bon Appetit. 
	 * 				Otherwise, print the integer amount of money that Brian must refund to Anna.
	 * Input:		- The first line contains two space-separated integers n and k, 
	 * 				  the number of items ordered and the 0-based index of the item that Anna did not eat.
	 * 				- The second line contains n space-separated integers bill[i] where 0 <= i <n
	 * 				- The third line contains an integer, b, the amount of money that Brian charged Anna for her share of the bill.
	 * Output:		If Brian did not overcharge Anna, print Bon Appetit on a new line;
	 * 				otherwise, print the difference that Brian must refund to Anna. This will always be an integer.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int n = 10;
		int rn = 100;
		int k = r.nextInt(n);
		int[] bill = new int[n];
		IntStream.range(0, n).forEach(i -> bill[i] = r.nextInt(rn));
		int b = Arrays.stream(bill).sum() / 2;
		countRefund(n, bill, b, k);
		countRefund(n, bill, b, -1);
	}

	private static void countRefund(int n, int[] bill, int b, int k) {
		System.out.println(Arrays.toString(bill));
		if (k >= 0 && k < n) {
			System.out.println("Charged: total=" + Arrays.stream(bill).sum() + ", b=" + b + ", item k=" + k + " exclude: bill[k]=" + bill[k]);
			int realB = (Arrays.stream(bill).sum() - bill[k]) / 2;
			int diff = b - realB;
			if (diff == 0)
				System.out.println("Bon Appetit!");
			else
				System.out.println("Refund: " + diff + ", because real charges=" + realB);
		} else {
			System.out.println("Bon Appetit!");
		}
	}
}
