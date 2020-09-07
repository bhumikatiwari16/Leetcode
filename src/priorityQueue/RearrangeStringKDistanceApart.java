package priorityQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import priorityQueue.ReorganizeString.Element;

public class RearrangeStringKDistanceApart {

	public static void main(String[] args) {
		
		String s = "aaabc";
		int k = 3;
		
		System.out.println(findReorganisedString(s, k));
		System.out.println(findReorganisedString(s, k).length());

	}
	
public static String findReorganisedString(String s, int k) {
		
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
			int hmFreq = entry.getValue();
			Element elem = new Element(hmChar, hmFreq);
			pq.offer(elem);
		}
		
		Queue<Element> q = new LinkedList<>();
		

		
		while (!pq.isEmpty() ) {
			
			Element cur = pq.poll();
			res.append(cur.Elem);
			cur.freq = cur.freq - 1;
			
			q.offer(cur);
			
			if (q.size() == k) {
				Element e = q.poll();
				if (e.freq > 0) {
					pq.offer(e);
				}
			}
				
		}
		
		return res.length() == s.length() ? res.toString() : "";
	
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
