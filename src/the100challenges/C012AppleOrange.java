package the100challenges;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class C012AppleOrange {

	/**
	 * Problem:		Sam’s house has an apple tree and an orange tree that yield an abundance of fruit. 
	 * 				In the diagram below, the red region denotes his house, where is the start point, 
	 * 				and is the endpoint. The apple tree is to the left of his house, 
	 * 				and the orange tree is to its right. You can assume the trees are located on a single point, 
	 * 				where the apple tree is at point , and the orange tree is at point.
	 * 				When a fruit falls from its tree, it lands d units of distance 
	 * 				from its tree of origin along the x -axis. 
	 * 				A negative value of d means the fruit fell d units to the tree’s left, 
	 * 				and a positive value of d means it falls d units to the tree’s right.
	 * 				where,
	 * 				- s: Starting point of Sam’s house location.
	 * 				- t: Ending location of Sam’s house location.
	 * 				- a: Location of the Apple tree.
	 * 				- b: Location of the Orange tree.
	 * 				- m: Number of apples that fell from the tree.
	 * 				- apples: Distance at which each apple falls from the tree.
	 * 				- n: Number of oranges that fell from the tree.
	 * 				- oranges: Distance at which each orange falls from the tree.
	 * 				Given the value of d for m apples and n oranges, 
	 * 				can you determine how many apples and oranges will fall on Sam’s house 
	 * 				(i.e., in the inclusive range [s,t])? Print the number of apples 
	 * 				that fall on Sam’s house as your first line of output, 
	 * 				then print the number of oranges that fall on Sam’s house as your second line of output.
	 * Input:		The first line contains two space-separated integers denoting the respective values of s and t.
	 * 				The second line contains two space-separated integers denoting the respective values of a and b.
	 * 				The third line contains two space-separated integers denoting the respective values of m and n.
	 * 				The fourth line contains m space-separated integers denoting the respective distances that each apple falls from point a.
	 * 				The fifth line contains n space-separated integers denoting the respective distances that each orange falls from point b.
	 * Output:		1. The first integer: the number of apples that fall on Sam’s house. 
	 * 				2. The second integer: the number of oranges that fall on Sam’s house
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int n = 10, m = 12;
		int rn = 15;
		int s = r.nextInt(10), t = s + r.nextInt(30);
		int a = r.nextInt(5), b = t + r.nextInt(20);
		int[] apples = new int[n];
		int[] oranges = new int[m];
		IntStream.range(0, n).forEach(i -> apples[i] = r.nextInt(rn) * (r.nextBoolean() ? 1 : -1));
		IntStream.range(0, m).forEach(i -> oranges[i] = r.nextInt(rn) * (r.nextBoolean() ? 1 : -1));
		countApplesOranges(s, t, a, b, n, m, apples, oranges);
	}

	private static void countApplesOranges(int s, int t, int a, int b, int n, int m, int[] apples, int[] oranges) {
		System.out.println("Start=" + s + ", end=" + t);
		System.out.println("A=" + a + ", B=" + b);
		System.out.println("Apples: n=" + n + ", array=" + Arrays.toString(apples));
		System.out.println("Oranges: m=" + m + ", array=" + Arrays.toString(oranges));
		int countApples = 0;
		int countOranges = 0;
		List<Integer> appleList = new ArrayList<>();
		List<Integer> orangeList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int apple = apples[i];
			if (apple > 0 && (apple + a) >= s && (apple + a) <= t) {
				countApples++;
				appleList.add(apple);
			}
		}
		for (int i = 0; i < m; i++) {
			int orange = oranges[i];
			if (orange < 0 && (b + orange) >= s && (b + orange) <= t) {
				countOranges++;
				orangeList.add(orange);
			}
		}
		if (countApples > 0) {
			System.out.print("Apples falling to the house: " + countApples + ", apple list=");
			printList(appleList);
		}
		if (countOranges > 0) {
			System.out.print("Oranges falling to the house: " + countOranges + ", orange list=");
			printList(orangeList);
		}
	}
	
	private static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ((i == list.size() - 1) ? "\n" : ","));
		}
	}
}
