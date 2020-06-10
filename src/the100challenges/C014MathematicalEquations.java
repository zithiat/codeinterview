package the100challenges;

import java.util.Random;

public class C014MathematicalEquations {

	/**
	 * Kangaroo problem
	 * Problem:		You are choreographing a circus show with various animals. 
	 * 				For one act, you are given two kangaroos on a number line ready 
	 * 				to jump in the positive direction (i.e, toward positive infinity).
	 * 				- The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
	 * 				- The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
	 * 				You have to figure out a way to get both kangaroos at the same location as part of the show.
	 * Input:		A single line of four space-separated integers denoting the respective values of x1,v1 ,x2 , and v2.
	 * Output:		Print YES if they can land on the same location at the same time; otherwise, print NO.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int x1 = r.nextInt(20);
		int x2 = r.nextInt(20);
		int v1 = r.nextInt(10);
		int v2 = r.nextInt(10);
		System.out.println("x1=" + x1 + ", x2=" + x2 + ", v1=" + v1 + ", v2=" + v2);
		checkKangaroosMet(x1, x2, v1, v2);
	}

	// Y is the jumping counts
	//     x1 + v1 * y = x2 + v2 * y
	// <=> x1 - x2 = (v2 - v1) * y
	// <=> (x1 - x2) % (v2 - v1) = 0 (divisible, or (x2 - x1) % (v1 - v2)) 
	// If we can find y, 2 kangaroos meet, otherwise, no meeting.
	private static void checkKangaroosMet(int x1, int x2, int v1, int v2) {
		if (((v2 > v1) && (x1 > x2)) || ((v1 > v2) && (x2 > x1))){
			if (((x1 - x2) % (v2 - v1) == 0) || ((x2 - x1) % (v1 - v2) == 0)) 
				System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
