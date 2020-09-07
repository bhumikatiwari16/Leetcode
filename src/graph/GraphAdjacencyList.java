package graph;

public class GraphAdjacencyList {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		Vertex v3 = new Vertex("D");
		g.addVertex(v0);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addEdge(v0, v1, 1);
		g.addEdge(v1, v2, 2);
		g.addEdge(v1, v3, 3);
		g.addEdge(v2, v0, 4);
		g.printGraph();
	}

}
