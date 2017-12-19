package ics202.project.tests;

import ics202.project.graph.DirectedWeightedGraph;
import ics202.project.traversals.DepthFirst;
import ics202.project.traversals.BreadthFirst;
import ics202.project.traversals.ShortestPath;

public class DirectedWeightedGraphTest {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	//when testing using numbers less than 1, it dose not give correct graph
	public static void main(String[] args) {
		// TODO: Add your code here
		System.out.print("-----------Testing DirectedGraph-----------\n");
    	DirectedWeightedGraph<String> g = new DirectedWeightedGraph<String>();
    	g.addVertex("A");
    	g.addVertex("B");
    	g.addVertex("C");
  		g.addVertex("D");
    	g.addVertex("E");
    	g.addVertex("F");

    	
    	g.addEdge("B","A",3);
    	g.addEdge("B","C",5);
    	g.addEdge("D","A",5);
    	g.addEdge("A","C",1);
    	g.addEdge("C","D",2);
    	g.addEdge("C","E",4);
    	//g.addEdge("D","E");
    	g.addEdge("D","F",5);
    	g.addEdge("E","F",1);
    	
    	System.out.println("graph :"+g);
    	System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	DepthFirst<String> df = new DepthFirst<String>(g,"A",DepthFirst.PRE_ORDER);
    	System.out.println("Depth First Starting from A");
    	while(df.hasNext()){
    		System.out.print(df.next()+" ");
    	}
    	System.out.println();
    	BreadthFirst<String> bf = new BreadthFirst<String>(g,"B");
    	System.out.println("\nBreadth First Starting from B:");
    	while(bf.hasNext()){
    		System.out.print(bf.next()+" ");
    	}
    	System.out.println();
    	ShortestPath<String> path = new ShortestPath<String>(g,"B");
    	System.out.println("Shortest Path from \"B\" to All vertices:");
    	while(path.hasNext()){
    		System.out.println(path.next());
    	}
    	System.out.println();
    	System.out.println("graph :"+g);
    	System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	System.out.println("Removing vertex \""+g.removeVertex("C")+"\" from the graph");
    	System.out.println("Removing vertex \""+g.removeVertex("F")+"\" from the graph");
    	System.out.println("Removing Edge \""+g.removeEdge("B","A")+"\" from the graph");
    	System.out.println("graph :"+g);
    	System.out.println("Adding vertices \"X\" ,\"K\" and \"z\" to the graph");
    	g.addVertex("X");
    	g.addVertex("K");
    	g.addVertex("Z");
    	System.out.println("Adding edges to the graph");
    	g.addEdge("X","B",5);
    	g.addEdge("B","E",3);
    	g.addEdge("K","D",6);
    	g.addEdge("E","Z",2);
    	g.addEdge("E","K",1);
    	g.addEdge("A","X",2);
    	g.addEdge("Z","X",20);
    	g.addEdge("Z","B",10);
    	g.addEdge("Z","K",55);
    	g.addEdge("Z","D",2);
    	System.out.println("graph :"+g);
    	System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	ShortestPath<String> path2 = new ShortestPath<String>(g,"B");
    	System.out.println("Shortest Path from \"B\" to All");
    	while(path2.hasNext()){
    		System.out.println(path2.next());
    	}
    	System.out.println("Shortest Path from \"X\" to \"A\"");
    	path2 = new ShortestPath<String>(g,"X","A");
    	
    	while(path2.hasNext()){
    		System.out.println(path2.next());
    	}
    	System.out.println("Shortest Path from \"A\" to \"D\"");
    	path2 = new ShortestPath<String>(g,"A","D");
    	
    	while(path2.hasNext()){
    		System.out.println(path2.next());
    	}
    	DirectedWeightedGraph<Integer> intsGraph = new DirectedWeightedGraph<>();
        for(int i = 0 ; i < 10 ; i++){
        	intsGraph.addVertex(i);
        }
        intsGraph.addEdge(0,1,0.4);
        intsGraph.addEdge(0,2,0.3);
        intsGraph.addEdge(0,3,0.8);
        intsGraph.addEdge(1,2,0.2);
        intsGraph.addEdge(1,6,0.7);
        intsGraph.addEdge(2,4,0.1);
        intsGraph.addEdge(2,5,0.2);
        intsGraph.addEdge(2,6,0.9);
        intsGraph.addEdge(3,5,0.1);
        intsGraph.addEdge(3,6,0.4);
        intsGraph.addEdge(3,7,0.5);
        intsGraph.addEdge(4,9,0.3);
        intsGraph.addEdge(5,4,0.05);
        intsGraph.addEdge(5,9,0.4);
        intsGraph.addEdge(5,8,0.7);
        intsGraph.addEdge(6,8,0.1);
        intsGraph.addEdge(6,7,0.2);
        intsGraph.addEdge(8,7,0.1);
        intsGraph.addEdge(8,9,0.8);
        ShortestPath<Integer> sp = new ShortestPath<>(intsGraph,0);
        System.out.println();
        while(sp.hasNext())
        	System.out.print(sp.next()+" ");
	}	
}
