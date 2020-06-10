package the100challenges;

public class C007Staircase {

	/**
	 * Problem:		Write a program that prints a staircase of size n.
	 * Input:		A single integer, n , denoting the size of the staircase.
	 * Output: 		Print a staircase of size using # symbols and spaces.
	 * 				1. head is on top, left to right
	 * 				2. head is on top, right to left
	 * 				3. head is bottom, left to right
	 * 				4. head is bottom, right to left
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		drawTopLeft2Right(n);
		drawTopRight2Left(n);
		drawBottomLeft2Right(n);
		drawBottomRight2Left(n);
	}

	private static void drawBottomRight2Left(int n) {
		System.out.println("=======drawBottomRight2Left=======");
		char c = '#';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= i)
					System.out.print(c);
				else 
					System.out.print(' ');
			}
			System.out.println();
		}
	}

	private static void drawBottomLeft2Right(int n) {
		System.out.println("=======drawBottomLeft2Right=======");
		char c = '#';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j <= n - 1 - i) 
					System.out.print(c);
				else 
					System.out.print(' ');
			}
			System.out.println();
		}
	}

	private static void drawTopRight2Left(int n) {
		System.out.println("=======drawTopRight2Left=======");
		char c = '#';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= n - 1 - i)
					System.out.print(c);
				else 
					System.out.print(' ');
			}
			System.out.println();
		}
	}

	private static void drawTopLeft2Right(int n) {
		System.out.println("=======TopLeft2Right=======");
		char c = '#';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) 
				System.out.print(c);
			System.out.println();
		}
	}
}
