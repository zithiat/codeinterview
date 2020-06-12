package the100challenges;

import java.util.Random;

public class C018DrawingBook {

	/**
	 * Problem:		Brie’s Drawing teacher asks her class to open their books to a page number.
	 * 				Brie can either start turning pages from the front of the book or from the back of the book.
	 * 				She always turns pages one at a time. When she opens the book, page 1 is always on the right side:
	 * 				When she flips page 1 , she sees pages 2 and 3. Each page except the last page will 
	 * 				always be printed on both sides. The last page may only be printed on the front, given the length of the book. 
	 * 				If the book is n pages long, and she wants to turn to page p, what is the minimum number of pages she will turn?
	 * 				She can start at the beginning or the end of the book.
	 * 				Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at page p.
	 * Input:		The first line contains an integer n, the number of pages in the book.
	 * 				The second line contains an integer, p, the page that Brie’s teacher wants her to turn to.
	 * Output:		Print an integer denoting the minimum number of pages Brie must turn to get to page p.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int max = 100;
		int n = r.nextInt(max);
		int p = r.nextInt(n) + n / 10; 
		System.out.println("Total pages: " + n + ", to page: " + p);
		countPageTurn(n, p);
	}

	private static void countPageTurn(int n, int p) {
		int mid = n / 2;
		int turns = 0;
		if (p <= n) {
			if (p < mid) {
				turns = p / 2;
				System.out.println("Turning from the BEGINNING of the book: to page=" + p + ", turns=" + turns);
			} else {
				turns = (n - p) / 2;
				System.out.println("Turning from the END of the book: to page=" + p + ", turns=" + turns);
			}
		} else {
			System.out.println("Invalid page and total page values");
		}
	}
}
