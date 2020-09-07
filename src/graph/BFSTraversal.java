package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BFSTraversal {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		Vertex v3 = new Vertex("D");
		Vertex v4 = new Vertex("E");
		Vertex v5 = new Vertex("F");
		Vertex v6 = new Vertex("G");
		Vertex v7 = new Vertex("H");
		
		g.addVertex(v0);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addVertex(v7);
	
		g.addEdge(v0, v1, 1);
		g.addEdge(v0, v2, 2);
		g.addEdge(v0, v3, 3);
		g.addEdge(v0, v4, 4);
		g.addEdge(v1, v2, 2);
		g.addEdge(v1, v6, 6);
		g.addEdge(v2, v3, 3);
		g.addEdge(v3, v4, 4);
		g.addEdge(v3, v7, 7);
		g.addEdge(v4, v5, 5);
		g.addEdge(v5, v6, 6);
		g.addEdge(v5, v7, 7);

		traverseDFS(v0);
		traverseBFS(v0);

	}
	
	public static void traverseDFS(Vertex start) {
		
		Stack<Vertex> stack = new Stack<Vertex>();
		Set<Vertex> seen = new HashSet<Vertex>();
		
		System.out.println("DFS :");
		stack.push(start);
		
		while(!stack.isEmpty()) {
			
			Vertex temp = stack.pop();
			
			if (!seen.contains(temp)) {
				seen.add(temp);
				System.out.println(temp.getName());
			}
			
			for(Edge e: temp.getEdges()) {
				
				Vertex dest = e.getDest();
				if (!seen.contains(dest)) {
				  stack.push(dest);
				}
				
			}
			
		}
		
	}
	
	public static void traverseBFS(Vertex start) {
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		Set<Vertex> seen = new HashSet<Vertex>();
		
		System.out.println("BFS :");
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			
			Vertex temp = queue.poll();
			
			if (!seen.contains(temp)) {
				seen.add(temp);
				System.out.println(temp.getName());
			}
			
			for(Edge e: temp.getEdges()) {
				
				Vertex dest = e.getDest();
				if (!seen.contains(dest)) {
					queue.offer(dest);
				}
				
			}
			
		}
		
	}
	

}
