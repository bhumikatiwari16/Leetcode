package priorityQueue;

// https://leetcode.com/problems/reorganize-string/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

	public static void main(String[] args) {
		
		String s = "aaab";
		
		System.out.println(findReorganisedString(s));
		System.out.println(findReorganisedString(s).length());
	}
	
	public static String findReorganisedString(String s) {
		
		StringBuilder res = new StringBuilder();
		
		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		
		Map<Character, Integer> hm = new HashMap<>();
		
		int stLen = s.length();
		
		for (int i = 0; i < stLen; i++) {
			
			char curChar = s.charAt(i);
			
			if (hm.containsKey(curChar)) {
				int curFreq = hm.get(curChar);
				hm.put(curChar, curFreq + 1);
			} 
			else {
				hm.put(curChar, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry: hm.entrySet()) {
			char hmChar = entry.getKey();
			int hmFreq =entry.getValue();
			Element elem = new Element(hmChar, hmFreq);
			pq.offer(elem);
		}
		
		Element prev = null, cur = null;
		
		while (!pq.isEmpty() ) {
			
			cur = pq.poll();
			
			if (prev != null && prev.freq > 0) {
				pq.add(prev);
			}
			res.append(cur.Elem);
			cur.freq = cur.freq - 1;
			prev = cur;
				
		}
		
		if (prev != null && prev.freq > 0) {
			return "";
		}
		
		return res.toString();
	}
	
	public static class Element implements Comparable<Element> {
		
		char Elem;
		int freq;
		
		Element(char E, int f) {
			Elem = E;
			freq = f;
		}

		@Override
		public int compareTo(Element o) {
			
			if (this.freq < o.freq) {
				return 1;
			} 
			else if (this.freq > o.freq) {
				return -1;
			} 
			else {
				return 0;
			}
		}
	}

}
