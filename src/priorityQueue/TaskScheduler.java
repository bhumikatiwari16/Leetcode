package priorityQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import priorityQueue.RearrangeStringKDistanceApart.Element;

public class TaskScheduler {

	public static void main(String[] args) {
		
		//char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		//char[] tasks = {'A','A','A','B','B','B'};
		char[] tasks = {'A','A','B'};
		int n = 3;
		
		System.out.println(leastInterval(tasks, n));

	}
	
	public static int leastInterval(char[] tasks, int n) {
        
		StringBuilder res = new StringBuilder();
		
		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		
		Map<Character, Integer> hm = new HashMap<>();
		
		int stLen = tasks.length;
		
		for (int i = 0; i < stLen; i++) {
			
			char curChar = tasks[i];
			
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
			
			Element cur = pq.peek();
			int resCurLen = res.length();
			
			System.out.println(res.lastIndexOf(cur.Elem + ""));
			System.out.println(resCurLen);
			
			if (resCurLen - res.lastIndexOf(cur.Elem + "") > n ) {
				cur = pq.poll();
				res.append(cur.Elem);
				cur.freq = cur.freq - 1;
				q.offer(cur);
			}
			else if (resCurLen - res.lastIndexOf(cur.Elem + "") <= n ) {
				res.append("!");
			}
			
			if (q.size() >= n) {
				Element e = q.poll();
				if (e.freq > 0) {
					pq.offer(e);
				}
			}
				
		}
		
		System.out.println(res.toString());
		return res.length();
		
		
		
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
