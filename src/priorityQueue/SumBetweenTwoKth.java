package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumBetweenTwoKth {

	public static void main(String[] args) {
		
		int[] arr = {10, 2, 50, 12, 48, 13};
		int k1 = 2, k2 = 6;
		
		System.out.println(findSum(arr, k1, k2));
	}
	
	public static int findSum (int[] arr, int k1, int k2) {
		
		int n1 = findKthSmallestElem(arr, k1);
		int n2 = findKthSmallestElem(arr, k2);
		
		System.out.println(n1+ "   " + n2);
		int res = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > n1 && arr[i] < n2) {
				res += arr[i];	
			}
		}
		
		return res;	
	}
	
	public static int findKthSmallestElem(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		
		for (int i = 0; i < arr.length; i++) {
			
			pq.offer(arr[i]);
			
			if (pq.size() > k) {
				pq.poll();
			}		
		}
		
		return pq.peek();
			
	}

}
