package the100challenges;

import java.util.Random;
import java.util.stream.IntStream;

public class C020ElectronicsShop {

	/**
	 * Problem:		Monica wants to buy a keyboard and a USB drive from her favorite electronics store.
	 * 				The store has several models of each. Monica wants to spend as much as possible 
	 * 				for the 2 items, given her budget.  Given the price lists for the store’s keyboards 
	 * 				and USB drives, and Monica’s budget, find and print the amount of money Monica will spend. 
	 * 				If she doesn’t have enough money for both a keyboard and a USB drive, print -1 instead. 
	 * 				She will buy only the two required items.
	 * Input:		The first line contains three space-separated integers b, n, and m, 
	 * 				- b: her budget, 
	 * 				- n: the number of keyboard models and 
	 * 				- m: the number of USB drive models.
	 * 				The second line contains n space-separated integers keyboard[i], the prices of each keyboard model.
	 * 				The third line contains m space-separated integers drives, the prices of the USB drives.
	 * Output:		Print a single integer denoting the amount of money Monica will spend. 
	 * 				If she doesn’t have enough money to buy one keyboard and one USB drive, print -1instead.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int b = r.nextInt(1000);
		int n = 10;
		int m = 15;
		int rn = 100;
		int[] kArr = new int[n];
		int[] uArr = new int[m];
		IntStream.range(0, n).forEach(i -> kArr[i] = r.nextInt(rn));
		IntStream.range(0, m).forEach(i -> uArr[i] = r.nextInt(rn));
		findSpentAmount(b, kArr, n, uArr, m);
	}

	private static void findSpentAmount(int b, int[] kArr, int n, int[] uArr, int m) {
		// TODO Auto-generated method stub
		
	}
}
