package the100challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.IntStream;

public class C013MigratoryBirds {
	
	/**
	 * Problem:		You have been asked to help study the population of birds migrating across the continent. 
	 * 				Each type of bird you are interested in will be identified by an integer value. 
	 * 				Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. 
	 * 				You would like to be able to find out which type of bird is most common given a list of sightings. 
	 * 				Your task is to print the type number of that bird and if two or more types of birds are equally common, 
	 * 				choose the type with the smallest ID number.
	 * Input:		Array with n space-separated integers representing the type numbers of each bird sighted.
	 * Output:		Print the type number of the most common bird; 
	 * 				if two or more types of birds are equally common, choose the type with the smallest ID number.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int n = 20;
		int rn = 10;
		int[] arr = new int[n];
		IntStream.range(0, n).forEach(i -> arr[i] = r.nextInt(rn));
		System.out.println(Arrays.toString(arr));
		findMostCommonBird(arr, n);
	}

	private static void findMostCommonBird(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
//		System.out.println(map);
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				int byValue = o2.getValue().compareTo(o1.getValue());
				int byKey = o1.getKey().compareTo(o2.getKey());
				return (byValue == 0) ? byKey : byValue;
			}
		});
//		System.out.println(list);
		System.out.println("Bird id: " + list.get(0).getKey() + ", occurred: " + list.get(0).getValue());
	}
}
