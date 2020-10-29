package amazon.jun062020;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReviewCompetitors {

	public static void main(String[] args) {
		List<String> competitors = new ArrayList<String>();
		competitors.add("adidas");
		competitors.add("nike");
		competitors.add("rebok");
		competitors.add("abce");
		int topNCompetitors = 2;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("facebook nike adidas wokd rebok adidas algorithm internet google apple");
		reviews.add("abce adidas wokd rebok adidas adidas anna gucci");
		reviews.add("nike adidas abce nike rebok adidas adidas never start");
		reviews.add("walmart nike abce wokd rebok abce rebok rebok dhl");
		reviews.add("kroger ups nike adidas abce nike nike rebok adidas kile mickey");
		ArrayList<String> topCompetitors = getMostCompetitors(competitors, topNCompetitors, reviews);
		System.out.println(Arrays.asList(topCompetitors));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> getMostCompetitors(List<String> competitors, int topNCompetitors, ArrayList<String> reviews) {
		ArrayList<String> res = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String review : reviews) {
			for (String word : review.split("\\s+")) {
				if (competitors.contains(word)) {
					map.put(word, map.getOrDefault(word, 0) + 1);
				}
			}
		}
		System.out.println(Arrays.asList(map));
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				int byKey = ((String) ((Map.Entry) o1).getKey()).compareTo((String) ((Map.Entry) o2).getKey());
				int byValue = ((Integer) ((Map.Entry) o2).getValue()).compareTo((Integer) ((Map.Entry) o1).getValue());
				return byValue == 0 ? byKey : byValue ;
			}
		});
		
		HashMap sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(Arrays.asList(sortedMap));
		
		Iterator<Map.Entry<String, Integer>> it = sortedMap.entrySet().iterator();
		while (it.hasNext() && topNCompetitors > 0) {
			res.add(it.next().getKey());
			topNCompetitors--;
		}
		return res;
	}

}
