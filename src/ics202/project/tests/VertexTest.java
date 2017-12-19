package ics202.project.tests;

import ics202.project.vertices.*;
import ics202.project.edges.*;

public class VertexTest {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO: Add your code here
		DirectedWeightedEdge<String> directedWeightedEdge1 = new DirectedWeightedEdge<String>("A","B",7);
		DirectedWeightedEdge<String> directedWeightedEdge2 = new DirectedWeightedEdge<String>("C","B",44);
		DirectedWeightedEdge<String> directedWeightedEdge3 = new DirectedWeightedEdge<String>("J","K",5);
		DirectedWeightedEdge<String> directedWeightedEdge4 = new DirectedWeightedEdge<String>("G","S",3);
		
		Vertex<String> v1 = new Vertex<String>("Hello World!");
		TraversalVertex<String> v2 = new TraversalVertex<String>("Hello World!");
		System.out.println("Normal Vertex = "+v1.getData());
		System.out.println("Traversal Vertex = "+v2.getData());
		System.out.println("Dose the normal vertex have edges? \""+v2.hasEdges()+"\"");
		System.out.println("Adding Edge \""+directedWeightedEdge1+"\" to the normal vertex");
		v1.addEdge(directedWeightedEdge1);
		System.out.println("Adding Edge \""+directedWeightedEdge2+"\" to the normal vertex");
		v1.addEdge(directedWeightedEdge2);
		System.out.println("Adding Edge \""+directedWeightedEdge3+"\" to the normal vertex");
		v1.addEdge(directedWeightedEdge3);
		System.out.println("Adding Edge \""+directedWeightedEdge3+"\" to the traversal vertex");
		v2.addEdge(directedWeightedEdge3);
		System.out.println("Edges on the normal vertex: "+v1.getEdges());
		System.out.println("Edges on the traversal vertex: "+v2.getEdges());
		System.out.println("How many edges is on the normal vertex? "+v1.getDegree());
		System.out.println("How many edges is on the traversal vertex? "+v2.getDegree());
		System.out.println("Dose the normal vertex contains the edge \""+directedWeightedEdge4+"\"? \""+v1.containsEdge(directedWeightedEdge4)+"\"");
		System.out.println("Dose the normal vertex contains the edge \""+directedWeightedEdge2+"\"? \""+v1.containsEdge(directedWeightedEdge2)+"\"");
		System.out.println("Removing Edge "+directedWeightedEdge2+" from the normal vertex");
		v1.removeEdge(directedWeightedEdge2);
		System.out.println("How many edges is on the normal vertex? "+v1.getDegree());
		System.out.println("Dose the normal vertex contains the edge \""+directedWeightedEdge2+"\"? \""+v1.containsEdge(directedWeightedEdge2)+"\"");
		System.out.println("Is traversal vertex visited or not? \""+v2.visited()+"\"");
		System.out.println("Now visiting the vertex");
		v2.visit();
		System.out.println("Is traversal vertex visited or not? \""+v2.visited()+"\"");
		System.out.println("Is the normal vertex equals to the traversal vertex? \""+v2.equals(v1)+"\"");
	}	
}
