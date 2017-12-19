package ics202.project.tests;

import ics202.project.graph.DirectedGraph;
import ics202.project.traversals.DepthFirst;
import ics202.project.traversals.BreadthFirst;
import ics202.project.traversals.TopologicalOrder;

public class DirectedGraphTest {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO: Add your code here
		System.out.print("-----------Testing DirectedGraph-----------\n");
    	DirectedGraph<String> g = new DirectedGraph<>();
    	g.addVertex("A");
    	g.addVertex("B");
    	g.addVertex("C");
  		g.addVertex("D");
    	g.addVertex("E");
    	g.addVertex("F");

    	//g.addEdge("D","D");
    	g.addEdge("B","A");
    	g.addEdge("B","C");
    	g.addEdge("A","D");
    	g.addEdge("C","A");
    	g.addEdge("C","D");
    	g.addEdge("C","E");
    	g.addEdge("D","E");
    	g.addEdge("D","F");
    	g.addEdge("E","F");
    	System.out.println("Original graph :"+g);
    	System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	//Traversal testing
    	BreadthFirst<String> bf = new BreadthFirst<>(g);
    	System.out.println("\nBreadth First Starting from A:");
    	while(bf.hasNext()){
    		System.out.print(bf.next()+" ");
    	}
    	System.out.println();
    	DepthFirst<String> df = new DepthFirst<>(g,"A",DepthFirst.PRE_ORDER);
    	System.out.println("Depth First Starting from A");
    	while(df.hasNext()){
    		System.out.print(df.next()+" ");
    	}
    	System.out.println();
    	TopologicalOrder<String> topo = new TopologicalOrder<>(g);
    	System.out.println("Topological sorting :");
    	while(topo.hasNext()){
    		System.out.print(topo.next()+" ");
    	}
		//Testing remove and add methods
		System.out.println();
		System.out.println("Graph :"+g);
    	System.out.println("\nRemoving edge : A----D");
		System.out.println(g.removeEdge("A","D")+"\n");
		System.out.println("Graph :\n"+g);
		System.out.println("Removing vertex A ");
		System.out.println(g.removeVertex("A"));
		System.out.println("Graph :\n"+g);
		System.out.println("Removing vertex C ");
		System.out.println(g.removeVertex("C"));
		System.out.println("Graph :\n"+g);
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
    	
		DepthFirst<String> df2 = new DepthFirst<>(g,"Z",DepthFirst.PRE_ORDER);
    	System.out.println("\nDepth First Starting At Z:");
    	while(df2.hasNext()){
    		System.out.print(df2.next()+" ");
    	}
    	System.out.println();
    	TopologicalOrder<String> topo2 = new TopologicalOrder<>(g);
    	System.out.println("\nTopological sorting :");
    	while(topo2.hasNext()){
    		System.out.print(topo2.next()+" ");
    	}
	}	
}
