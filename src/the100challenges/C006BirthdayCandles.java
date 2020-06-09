package the100challenges;

import java.util.Arrays;
import java.util.Random;

public class C006BirthdayCandles {

	/**
	 * Problem: You are in-charge of the cake for your niece’s birthday and 
	 * 			have decided the cake will have one candle for each year of her total age. 
	 * 			When she blows out the candles, she’ll only be able to blow out the tallest ones. 
	 * 			Your task is to find out how many candles she can successfully blow out.
	 * 			For example, if your niece is turning 4 years old, 
	 * 			and the cake will have candles of height 3 , 2 ,1 , 3 
	 * 			she will be able to blow out 2 candles successfully, 
	 * 			since the tallest candle is of height 3 and there are 2 such candles.
	 * 			Complete the function birthdayCakeCandles that takes your niece's age 
	 * 			and an integer array containing height of each candle as input, 
	 * 			and return the number of candles she can successfully blow out.
	 * Input: 	Array contains n space-separated integers, where each integer i describes the height of candle i.
	 * Output:	Print the number of candles the can be blown out on a new line
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int rn = 100;
		int[] arr = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; i++)
			arr[i] = r.nextInt(rn);
		
		System.out.println(Arrays.toString(arr));
	}
}
