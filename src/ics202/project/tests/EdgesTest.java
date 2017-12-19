package ics202.project.tests;

import ics202.project.edges.*;


public class EdgesTest {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO: Add your code here
		UndirectedEdge<String> undirectedEdge1 = new UndirectedEdge<String>("A","B");
		UndirectedEdge<String> undirectedEdge2 = new UndirectedEdge<String>("C","B");
		System.out.println("-----------------UndirectedEdge Test-------------------\n");
		System.out.println("Undirected edge 1 = "+undirectedEdge1);
		System.out.println("Undirected edge 2 = "+undirectedEdge2);
		System.out.println("Source of edge 1 = \""+undirectedEdge1.getSource()+"\"");
		System.out.println("Target of edge 1 = \""+undirectedEdge1.getTarget()+"\"");
		System.out.println("Is Edge 1 equals to edge 2 ? \""+undirectedEdge1.equals(undirectedEdge2)+"\"");
		System.out.println("Is Edge 1 equals it self ? \""+undirectedEdge1.equals(undirectedEdge1)+"\"");
		System.out.println("-----------------End of UndirectedEdge Test-------------------\n");
		
		DirectedEdge<Integer> directedEdge1 = new DirectedEdge<Integer>(6,7);
		DirectedEdge<Integer> directedEdge2 = new DirectedEdge<Integer>(6,9);
		System.out.println("-----------------DirectedEdge Test-------------------\n");
		System.out.println("Directed edge 1 = "+directedEdge1);
		System.out.println("Directed edge 2 = "+directedEdge2);
		System.out.println("Source of edge 1 = \""+directedEdge1.getSource()+"\"");
		System.out.println("Target of edge 1 = \""+directedEdge1.getTarget()+"\"");
		System.out.println("Is Edge 1 equals to edge 2 ? \""+directedEdge1.equals(directedEdge2)+"\"");
		System.out.println("Is Edge 1 equals it self ? \""+directedEdge1.equals(directedEdge1)+"\"");
		System.out.println("-----------------End of DirectedEdge Test-------------------\n");
		
		UndirectedWeightedEdge<String> undirectedWeightedEdge1 = new UndirectedWeightedEdge<String>("S","W",8);
		UndirectedWeightedEdge<String> undirectedWeightedEdge2 = new UndirectedWeightedEdge<String>("K","B",6);
		System.out.println("-----------------UndirectedWeightedEdge Test-------------------\n");
		System.out.println("Undirected weighted edge 1 = "+undirectedWeightedEdge1);
		System.out.println("Undirected weighted edge 2 = "+undirectedWeightedEdge2);
		System.out.println("Source of edge 1 = \""+undirectedWeightedEdge1.getSource()+"\"");
		System.out.println("Target of edge 1 = \""+undirectedWeightedEdge1.getTarget()+"\"");
		System.out.println("Weight od edge 1 = "+undirectedWeightedEdge1.getWeight());
		System.out.println("Is Edge 1 equals to edge 2 ? \""+undirectedWeightedEdge1.equals(undirectedWeightedEdge2)+"\"");
		System.out.println("Is Edge 1 equals it self ? \""+undirectedWeightedEdge1.equals(undirectedWeightedEdge1)+"\"");
		System.out.println("-----------------End of UndirectedWeightedEdge Test-------------------\n");
		
		DirectedWeightedEdge<String> directedWeightedEdge1 = new DirectedWeightedEdge<String>("C","B",7);
		DirectedWeightedEdge<String> directedWeightedEdge2 = new DirectedWeightedEdge<String>("A","Z",60);
		System.out.println(String.format("%5s","-----------------DirectedWeightedEdge Test-------------------\n"));
		System.out.println("Undirected weighted edge 1 = "+directedWeightedEdge1);
		System.out.println("Undirected weighted edge 2 = "+directedWeightedEdge2);
		System.out.println("Source of edge 1 = \""+directedWeightedEdge1.getSource()+"\"");
		System.out.println("Target of edge 1 = \""+directedWeightedEdge1.getTarget()+"\"");
		System.out.println("Weight od edge 1 = "+directedWeightedEdge1.getWeight());
		System.out.println("Is Edge 1 equals to edge 2 ? \""+directedWeightedEdge1.equals(directedWeightedEdge2)+"\"");
		System.out.println("Is Edge 1 equals it self ? \""+directedWeightedEdge1.equals(directedWeightedEdge1)+"\"");
		System.out.println("-----------------End of DirectedWeightedEdge Test-------------------\n");
		
	}	
}
