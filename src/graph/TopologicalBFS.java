package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;


/*
 * https://www.educative.io/courses/grokking-the-coding-interview/m25rBmwLV00
 * 
 * Topological Sort of a directed graph (a graph with unidirectional edges) 
 * is a linear ordering of its vertices such that for every directed edge (U, V) 
 * from vertex U to vertex V, U comes before V in the ordering.

	Given a directed graph, find the topological ordering of its vertices.
	
	Example:
	
Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0

 */


public class TopologicalBFS {

	public static void main(String[] args) {
		
		List<Integer> result = TopologicalBFS.sortTopological(4,
		        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		    System.out.println(result);

		    result = TopologicalBFS.sortTopological(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
		        new int[] { 2, 1 }, new int[] { 3, 1 } });
		    System.out.println(result);

		    result = TopologicalBFS.sortTopological(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
		        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		    System.out.println(result);
		

	}

	public static List<Integer> sortTopological(int vertices, int[][] edges) {
		
		List<Integer> res = new ArrayList<Integer>();
		
		if (vertices == 0) {
			return res;
		}
		
		// Create two HashMaps
		// 1_Hashmap to store key = node name, value =  count of incoming edges for the node
		// 2_Hashmap to store key = node name, value = list of nodes adjacent to key node
		// Edge (n1,n2) generally implies directed node from n1 to n2
		// So, for n1, its list of neighbors will contain n2.
		
		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> neighbors = new HashMap<>();
		
		// Initialize both the HashMaps
		for (int i = 0; i < vertices; i++) {
			indegree.put(i, 0);
			neighbors.put(i,new ArrayList<>());
		}
		
		// Enter values for both HashMaps from edge list available as input
		
		for (int i = 0; i < edges.length; i++) {
			
			int n1 = edges[i][0];
			int n2 = edges[i][1];
			int curInDegree = indegree.get(n2);
			curInDegree++;
			indegree.put(n2, curInDegree);
			List<Integer> cur = neighbors.get(n1);
			cur.add(n2);
			neighbors.put(n1, cur);
			
		}
		
		// Initialize a queue for BFS
		
		Queue<Integer> q = new LinkedList<>();
		
		// Add the nodes to BFS queue whose indegree is 0 
		
		for (Entry<Integer, Integer> e: indegree.entrySet()) {
			if (e.getValue() == 0) {
				q.add(e.getKey());
			}
		}
	
		// Run BFS loop
		
		while (!q.isEmpty()) {
			
			// Pop a node from queue
			int curNode = q.poll();
			
			// Add popped node to result list
			res.add(curNode);
			
			// Find all neighbors of the popped node
			List<Integer> curNodeNeighbors = neighbors.get(curNode);
			
			// Traverse through all neighbor nodes of popped node one by one
			for (int i: curNodeNeighbors) {
				
				// Update indegree of each neighbor node by current value - 1 
				// if it is greater than 0
				
				int curChildDegree = indegree.get(i);
				if (curChildDegree > 0) {
					curChildDegree--;
					indegree.put(i, curChildDegree);
				}
				
				// if (indegree of neighbor node after reducing by 1) = 0
				// add the neighbor node to queue
				if (curChildDegree == 0) {
					q.add(i);
				}
			}	
		}
		
		// check if result list size = vertex count
		// if not, then return blank list
		
		if (res.size() != vertices) {
			return new ArrayList<>();
		}
		
		
		return res;
	}
}
