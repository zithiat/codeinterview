package the100challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class C008GradingStudents {

	/**
	 * Problem:		HackerLand University has the following grading policy:
	 * 				Every student receives a grade in the inclusive range from 0 to 100.
	 * 				Any less than 40 is a failing grade. Sam is a professor at the university and 
	 * 				likes to round each student’s grade according to these rules:
	 * 				- If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
	 * 				- If the value of is less than 38 , no rounding occurs as the result will still be a failing grade.
	 * 				For example grade=84, will be rounded to 85 but grade=29 will not be rounded 
	 * 				because the rounding would result in a number that is less than 40.
	 * 				Given the initial value of grade for each of Sam’s n students, write code to automate the rounding process.
	 * 				Complete the function solve that takes an integer array of all grades, and return an integer array consisting of the rounded grades.
	 * 				For each grade , round it according to the rules above and print the result on a new line.
	 * Input:		Each line i of the n subsequent lines contains a single integer, grade , denoting student ‘s grade.
	 * Output:		For each of the n grades, print the rounded grade on a new line
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 40;
		int rn = 100;
		Random r = new Random();
		int[] arr = new int[n];
		IntStream.range(0,  n).forEach(i -> arr[i] = r.nextInt(rn));
		System.out.println(Arrays.toString(arr));
		
		gradingStudents(arr, n);
	}

	private static void gradingStudents(int[] arr, int n) {
		int g = 0;
		int[] gradedArr = new int[n];
		for (int i = 0; i < n; i++) {
			g = arr[i];
			if (g < 40) {
//				System.out.println(arr[i] + ": failed");
				gradedArr[i] = 0;
			}
			else {
				int roundup = (int) (Math.ceil(g / 5) * 5);
//				System.out.println(roundup + " -- " + g + " == " + Math.abs(roundup - g));
				if (Math.abs(roundup - g) >= 3)  {
					gradedArr[i] = roundup + 5;
				} else {
					gradedArr[i] = arr[i];
				}
			}
		}
		System.out.println(Arrays.toString(gradedArr));
	}
}
