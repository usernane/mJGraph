package ics202.project.tests;

import ics202.project.graph.UndirectedWeightedGraph;
import ics202.project.traversals.MinimumSpanningTree;
import ics202.project.traversals.DepthFirst;
import ics202.project.traversals.BreadthFirst;
import ics202.project.traversals.Traversal;



public class UndirectedWightedGraphTest {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		System.out.print("-----------Testing UndirectedWeightedGraph-----------\n");
    	UndirectedWeightedGraph<String> g = new UndirectedWeightedGraph<String>();
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
    	g.addEdge("A","D",7);
    	g.addEdge("A","C",5);
    	g.addEdge("B","C",4);
    	g.addEdge("B","A",1);
    	g.addEdge("C","D",9);
    	g.addEdge("D","E",6);
    	g.addEdge("D","F",55);
    	g.addEdge("E","F",5);
    	g.addEdge("E","C",3);
    	
    	System.out.println("Original graph :"+g);
    	System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
    	//Traversal testing
    	DepthFirst<String> df = new DepthFirst<String>(g,"A",DepthFirst.PRE_ORDER);
    	Traversal tr = df.getTraversal();
    	System.out.println("Depth First Starting from A");
    	while(tr.hasNext()){
    		System.out.print(tr.next()+" ");
    	}
    	System.out.println();
    	BreadthFirst<String> bf = new BreadthFirst<String>(g,"A");
    	//Testing using the inteface "Traversal"
    	Traversal tr2 = bf.getTraversal();
    	System.out.println("\nBreadth First Starting from A:");
    	while(tr2.hasNext()){
    		System.out.print(tr2.next()+" ");
    	}
    	
		MinimumSpanningTree<String> tree = new MinimumSpanningTree<String>(g,"C");
		//Testing using the inteface "Traversal"
		Traversal trTree = tree.getTraversal();
		System.out.println("\nSpanning tree :");
		while(trTree.hasNext()){
			System.out.print(trTree.next()+" ");
		}
		System.out.println("\nTotal Cost "+tree.getTotalCost());
		//Testing remove and add methods
		System.out.println("\nGraph :"+g);
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
		g.addEdge("Z","B",3);
		g.addEdge("Z","D",1);
		g.addEdge("B","D",4);
		g.addEdge("B","E",4);
		System.out.println("\nGraph :"+g);
		System.out.println("Number of vertices: "+g.numberOfVertices());
    	System.out.println("Number of edges: "+g.numberOfEdges());
		MinimumSpanningTree<String> tree2 = new MinimumSpanningTree<String>(g,"B");
		//Testing using the inteface "Traversal"
		Traversal trTree2 = tree2.getTraversal();
		System.out.println("\nSpanning tree :");
		while(trTree2.hasNext()){
			System.out.print(trTree2.next()+" ");
		}
		System.out.println("\nTotal Cost "+tree2.getTotalCost());
		DepthFirst<String> df2 = new DepthFirst<String>(g,"Z",DepthFirst.PRE_ORDER);
    	System.out.println("\nDepth First Starting At Z:");
    	while(df2.hasNext()){
    		System.out.print(df2.next()+" ");
    	}
		System.out.println("\n-----------End Of Testing DirectedWeightedGraph-----------\n");
	}	
}
