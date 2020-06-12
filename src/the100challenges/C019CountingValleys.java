package the100challenges;

import java.util.Random;
import java.util.stream.IntStream;

public class C019CountingValleys {

	/**
	 * Problem:		Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. 
	 * 				During his last hike, he took exactly n steps. For every step he took, he noted if it was an uphill,U , 
	 * 				or a downhill D, step. Gary’s hikes start and end at sea level and each step up or down 
	 * 				represents a 1 unit change in altitude. We define the following terms:
	 * 				- A mountain is a sequence of consecutive steps above sea level, 
	 * 				  starting with a step up from sea level and ending with a step down to sea level.
	 * 				- A valley is a sequence of consecutive steps below sea level, 
	 * 				  starting with a step down from sea level and ending with a step up to sea level.
	 * 				Given Gary’s sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
	 * Input:		The first line contains an integer n, the number of steps in Gary’s hike.
	 * 				The second line contains a single string s, of n characters describing his path.
	 * Output:		Print a single integer denoting the number of valleys Gary walked through during his hike.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int n = r.nextInt(10) + 1;
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, n).forEach(i -> sb.append(genMountainValley(r.nextBoolean())));
		System.out.println("String generated: " + sb.toString());
		countValley(sb.toString());
	}
	
	private static void countValley(String str) {
		char[] arr = str.toCharArray();
		int n = arr.length;
		int level = 0;
		int valleyCount = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'U')
				level++;
			else
				level--;
			if (arr[i] == 'U' && level == 0) // at this step, we went up and come back to the sea level, meaning we had 1 valley.
				valleyCount++;
		}
		System.out.println("Valley count=" + valleyCount);
	}

	private static String genMountainValley(boolean f) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		int h = r.nextInt(10) + 1;
		System.out.println((f?"M":"V") + "-h=" + h);
		for (int i = 0; i < h * 2; i++)
			if (i < h) {
				sb.append(f ? "U" : "D");
			} else {
				sb.append(f ? "D" : "U");
			}
		return sb.toString();
	}
}
