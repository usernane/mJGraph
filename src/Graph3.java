/**
 * @(#)Graph3.java
 *
 * Graph3 application
 *
 * @author 
 * @version 1.00 2014/5/12
 */
import ics202.project.util.DataStructure;
import ics202.project.graph.DirectedGraph;
import ics202.project.graph.DirectedWeightedGraph;
import ics202.project.traversals.ShortestPath;
import ics202.project.util.*;

public class Graph3 {
    
    public static void main(String[] args) {
    	
    	// TODO, add your application code
    	System.out.println("Hello World!");
    	System.out.println("Testing the interface \"DataStructure\"");
    	
    	DataStructure<String>  g = new Stack<>();
    	
    	g.addElement("A");
    	g.addElement("B");
    	g.addElement("C");
  		g.addElement("D");
    	g.addElement("E");
    	g.addElement("F");
    	System.out.println("Data Structure type :"+g.getClass());
    	System.out.println("Data inside : " +g);
    	System.out.println("Removing element "+g.removeElement());
    	
    	
    	DirectedWeightedGraph<String> g2 = new DirectedWeightedGraph<>();
    	
    	g2.addVertex("A");
    	g2.addVertex("B");
    	g2.addVertex("C");
  		g2.addVertex("D");
    	g2.addVertex("E");
    	g2.addVertex("F");

    	g2.addEdge("A","C",1);
    	g2.addEdge("B","C",5);
    	g2.addEdge("B","A",3);
    	g2.addEdge("D","A",5);
    	g2.addEdge("C","D",2);
    	g2.addEdge("C","E",4);
    	g2.addEdge("E","F",1);
    	g2.addEdge("D","F",5);
		System.out.println("new  graph :"+g2);
		ShortestPath<String> path = new ShortestPath<>(g2,"B");
		System.out.println("Shortest path:");
		while(path.hasNext())
			System.out.println(path.next());
    }
}
