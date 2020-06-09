package amazon.jun062020;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderLogs {

	public static void main(String[] args) {
		String[] logs = { "d1 8 1 5 1", "l1 art can", "di2 3 6", "le2 own kit dig", "le3 art zero" };
		// expected output: 
		// "l1 art can","le3 art zero","le2 own kit dig","d1 8 1 5 1","d2 3 6"
		String[] result = reorderLogs(logs);
		System.out.println(Arrays.toString(result));
	}

	public static String[] reorderLogs(String[] logs) {
		if (logs == null || logs.length == 0)
			return logs;

		List<String> letterList = new ArrayList<>();
		List<String> digitList = new ArrayList<>();
		for (String log : logs) {
			if (log.split(" ")[1].charAt(0) < 'a') {
				digitList.add(log);
			} else {
				letterList.add(log);
			}
		}
		Collections.sort(letterList, (o1, o2) -> {
			String[] s1 = o1.split(" ");
			String[] s2 = o2.split(" ");
			int len1 = s1.length;
			int len2 = s2.length;
			for (int i = 1; i < Math.min(len1, len2); i++) {
				if (!s1[i].equals(s2[i])) {
					return s1[i].compareTo(s2[i]);
				}
			}
			return s1[0].compareTo(s2[0]);
		});

		int count = 0;

		while (count < letterList.size()) {
			logs[count] = letterList.get(count);
			count++;
		}

		int i = 0;

		while (i < digitList.size()) {
			logs[count] = digitList.get(i);
			count++;
			i++;
		}

		return logs;
	}

}
