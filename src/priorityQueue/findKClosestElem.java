package priorityQueue;

import java.util.PriorityQueue;

public class findKClosestElem {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int k = 4, x = 3;
		
		int[] res = findElem(arr, k, x);
		
		for(int i = 0; i < res.length; i++) {
			
			System.out.println(res[i]);
			
		}

	}
	
	
	// find diff of each array element from x
	// sort heap on the basis of min diff 
	
	
	public static int[] findElem(int[] arr, int k, int x) {
		
		// create maxHeap for class keyValue
		PriorityQueue<keyValue> pq = new PriorityQueue<keyValue>();
		
		for(int i = 0; i < arr.length; i++) {
			keyValue kv = new keyValue(arr[i], Math.abs(arr[i] - x));
			pq.offer(kv);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		int[] res = new int[k];
		int i = 0;
		
		while (pq.size() > 0) {
			res[i] = pq.poll().key;
			i++;
		}
		
		return res;
		
	}

	//create class with 2 attributes
			// key = arr[i]
			// val = arr[i] -  x
			
			// sort heap on the basis of difference(arr[i] - x)
			// we want to find k elements with least difference value.
			// so we use max heap
			
	static class keyValue implements Comparable<keyValue> {
		
		int key;
		int val;
		
		keyValue(int k, int v) {
			key = k;
			val = v;
		}

		
		// for max heap, we need to do descending order sorting
		
		@Override
		public int compareTo(keyValue o) {
			
			if (this.val > o.val) {
				return -1;
			} 
			
			else if (this.val < o.val) {
				return 1;
			}
			
			else  {
				return 0;
			}	
		}
	}
}
