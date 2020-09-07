package priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFreqNumbers {

	public static void main(String[] args) {
		
		int[] arr = {1,1,1,1,2,2,2,3,4,5,5,5,5,5,5,5,0};
		int k = 3;
		
		int[] res = findElem(arr, k);
		
		for(int i = 0; i < res.length; i++) {
			
			System.out.println(res[i]);
			
		}

	}
	
	public static int[] findElem(int[] arr, int k) {
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if (hm.containsKey(arr[i])) {
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp + 1);
			}
			
			else {
				hm.put(arr[i], 1);
			}
			
		}
		
		PriorityQueue<keyValue> pq = new PriorityQueue<keyValue>(k);
		
		for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
			
			int key = entry.getKey();
			int value = entry.getValue();
			
			keyValue kv = new keyValue(key, value);
			
			pq.offer(kv);
			
			if (pq.size() > k) {
				pq.poll();
			}
			
		}
		
		int[] res = new int[k];
		
		int l = 0;
		
		while (pq.size() > 0) {
			
			res[l] = pq.poll().key;
			l++;
		}
		
		return res;
		
	}
	
	public static class keyValue implements Comparable<keyValue>{
		
		int key;
		int value;
		
		keyValue(int k, int v) {
			key = k;
			value = v;
		}

		// ascending order 
	
		@Override
		public int compareTo(keyValue o2) {
			if (this.value > o2.value) {
				return 1;
			} 
			else if (this.value < o2.value) {
				return -1;
			} 
			else {
				return 0;
			}
					}
	}

}
