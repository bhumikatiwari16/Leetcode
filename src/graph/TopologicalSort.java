package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		Vertex v3 = new Vertex("D");
		Vertex v4 = new Vertex("E");
	
		
		g.addVertex(v0);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		
		
		g.addEdge(v0, v1, 0);
		g.addEdge(v0, v2, 0);
		g.addEdge(v1, v3, 0);
		g.addEdge(v2, v3, 0);
		g.addEdge(v3, v4, 0);
		

		sortTopological(g);

	}

	public static void sortTopological(Graph g) {
		
		Stack<Vertex> stack = new Stack<Vertex>();
		Set<Vertex> seen = new HashSet<Vertex>();
		
		// First traverse all unvisited nodes.
		
		for (Vertex v: g.getVertices()) {
			
			// Check if each vertex is visited or not
			// If visited, do nothing
			// If not visited, call utility method.
			
			if (seen.contains(v)) {
				continue;
			}
			
			topSortUtil(v, stack, seen);
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getName() + " --->");
		}
		
	}

	private static void topSortUtil(Vertex v, Stack<Vertex> stack, Set<Vertex> seen) {
		
		// add vertex to seen 
		seen.add(v);
		
		// process all neighbors of the vertex
		for (Edge e: v.getEdges()) {
			
			// Check if each vertex is visited or not
			// If visited, do nothing
			// If not visited, call utility method.
						
			if (seen.contains(e.getDest())) {
				continue;
			}
			
			topSortUtil(e.getDest(), stack, seen);
		}
		
		stack.add(v);
	}
	
}
