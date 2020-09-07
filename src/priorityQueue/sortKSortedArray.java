package priorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Data structure for Min Heap
public class sortKSortedArray
{
	// Function to sort a K-Sorted Array
	public static void sortKSortedArray(List<Integer> list, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		
		int i = 0, j = 0;
		
		while (i < list.size()) {
			
			pq.offer(list.get(i));
			
			if (pq.size() > k) {
			
				int temp = pq.poll();
				
				list.set(j, temp);
				
				j++;
				
			} 
		
			i++;
		}
		
		while (pq.size() > 0) {
			
			list.set(j, pq.poll());
			
			j++;
			
		}
		
		
		
		
	}

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(96,98,95,99,97);
		int k = 2;

		sortKSortedArray(list, k);
		System.out.println(list);
	}
}
