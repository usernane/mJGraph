package ics202.project.tests;

import ics202.project.graph.UndirectedGraph;
import ics202.project.traversals.DepthFirst;
import ics202.project.traversals.BreadthFirst;

public class UndirectedGraphTest {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO: Add your code here
		System.out.println("\n-----------Testing UndirectedGraph-----------\n");
    	UndirectedGraph<String> g = new UndirectedGraph<String>();
    	g.addVertex("A");
    	g.addVertex("B");
    	g.addVertex("C");
  		g.addVertex("D");
    	g.addVertex("E");
    	g.addVertex("F");
    	//g.addVertex("G");
    	//g.addVertex("H");
    	//g.addVertex("I");
    	
    	//g.addEdge("A","B",13);
    	g.addEdge("A","D");
    	g.addEdge("A","C");
    	g.addEdge("B","C");
    	g.addEdge("B","A");
    	g.addEdge("C","D");
    	g.addEdge("D","E");
    	g.addEdge("D","F");
    	g.addEdge("E","F");
    	g.addEdge("E","C");
    	
    	System.out.println("\nOriginal graph :"+g);
    	System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	//Traversal testing
    	DepthFirst<String> df = new DepthFirst<String>(g,"A",DepthFirst.PRE_ORDER);
    	System.out.println("Depth First Starting from A");
    	while(df.hasNext()){
    		System.out.print(df.next()+" ");
    	}
    	System.out.println();
    	BreadthFirst<String> bf = new BreadthFirst<String>(g,"A");
    	System.out.println("\nBreadth First Starting from A:");
    	while(bf.hasNext()){
    		System.out.print(bf.next()+" ");
    	}

		//Testing remove and add methods
		System.out.println("\nGraph :\n"+g);
    	System.out.println("\nRemoving edge : A----B");
		System.out.println(g.removeEdge("A","B")+"\n");
		System.out.println("\nGraph :\n"+g);
		System.out.println("Removing vertex A ");
		System.out.println(g.removeVertex("A"));
		System.out.println("\nGraph :\n"+g);
		System.out.println("Removing vertex C ");
		System.out.println(g.removeVertex("C"));
		System.out.println("\nGraph :\n"+g);
		System.out.println("Adding vertex \"Z\" to the graph");
		g.addVertex("Z");
		
		System.out.println("\nGraph :"+g);
		System.out.println("adding 4 new edges: Z--[3]--B Z--[1]--D B--[4]--D B--[4]--E");
		g.addEdge("Z","B");
		g.addEdge("Z","D");
		g.addEdge("B","D");
		g.addEdge("B","E");
		System.out.println("\nGraph :"+g);
		System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	System.out.println();
    	System.out.println();
		System.out.println("\n-----------End Of Testing UndirectedGraph-----------\n");
	}	
}
