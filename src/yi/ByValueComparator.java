package yi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
 
public class ByValueComparator {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new FileReader("F://source.txt"));
		List<String> lists = new ArrayList<String>(); // �洢���˺󵥴ʵ��б�
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			String[] wordsArr1 = readLine.split("[^a-zA-Z]"); // ���˳�ֻ������ĸ��
			for (String word : wordsArr1) {
				if (word.length() != 0) { // ȥ������Ϊ0����
					lists.add(word);
				}
			}
		}
 
		br.close();
 
		Map<String, Integer> wordsCount = new TreeMap<String, Integer>(); // �洢���ʼ�����Ϣ��keyֵΪ���ʣ�valueΪ������
 
		// ���ʵĴ�Ƶͳ��
		for (String li : lists) {
			if (wordsCount.get(li) != null) {
				wordsCount.put(li, wordsCount.get(li) + 1);
			} else {
				wordsCount.put(li, 1);
			}
 
		}
 
		// ��map����key����
		Map<String, Integer> resMap = sortMapByKey(wordsCount);
 
		for (Entry<String, Integer> entry : resMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
 
	/**
	 * �� Map��key��������
	 */
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}
}
 
// ʵ��һ���Ƚ�����
 
class MapKeyComparator implements Comparator<String> {
 
	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2); // ��С��������
	}
}