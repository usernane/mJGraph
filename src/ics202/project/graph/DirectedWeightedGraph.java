/**
 * @(#)DirectedGraph.java
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/23
 */
package ics202.project.graph;

import ics202.project.exceptions.NoSuchEdgeException;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.edges.DirectedWeightedEdge;
import ics202.project.vertices.Vertex;
import ics202.project.edges.AbstractEdge;
/**
 *	The edges on this graph has weight and direction.
 *      @param <VType> the type of graph vertices.
 */
public class DirectedWeightedGraph<VType> extends DirectedGraph<VType> {
	
	/**
	 * Creates new instance of <code>DirectedWeightedGraph</code>.
	 *
	 *
	 */
	public DirectedWeightedGraph() {
		// TODO: Add your code here
	}
	@Override
	/**
	 *	Adds new edge to the graph.
	 *	@param from the source vertex.
	 *	@param to the target vertex.
	 *	@throws NoSuchVertexException if the source or the target is not on the graph.
	 */
	public void addEdge(VType from, VType to){
		if(super.containsVertex(from)){
			if(super.containsVertex(to)){
				if(super.containsEdge(from,to))
					return;
				super.getGraphAsList().get(new Vertex<>(from)).addEdge(new DirectedWeightedEdge<>(from,to));
				return;
			}
			throw new NoSuchVertexException("Vertex ("+to+") is not on the graph");
		}
		throw new NoSuchVertexException("Vertex ("+to+") is not on the graph");
	}
	/**
	 *	Adds new edge to the graph with specific weight.
	 *	@param from the source vertex.
	 *	@param to the target vertex.
     *  @param weight the weight of the edge that will be added.
	 *	@throws NoSuchVertexException if the source or the target is not on the graph.
	 */
	public void addEdge(VType from, VType to, double weight){
		if(super.containsVertex(from)){
			if(super.containsVertex(to)){
				if(this.containsEdge(from,to,weight))
					return;
					
				super.getGraphAsList().get(new Vertex<>(from)).addEdge(new DirectedWeightedEdge<>(from,to,weight));
				return;
			}
			throw new NoSuchVertexException("Vertex ("+to+") is not on the graph");
		}
		throw new NoSuchVertexException("Vertex ("+to+") is not on the graph");
	}
	
	 /**
	  *	Checks if the specified edge is on the graph or not
	  *	@param from the source vertex.
	 *	@param to the target vertex.
	 *	@param weight the weight of the edge.
          * @return <code>true</code> if the edge is on the graph.
	  */
	 public boolean containsEdge(VType from, VType to, double weight){
	 	if(super.containsVertex(from)){
	 		if(super.containsVertex(to)){
	 			return super.getGraphAsList().get(new Vertex<>(from)).getEdges().contains(new DirectedWeightedEdge<>(from,to,weight));
	 		}
	 		throw new NoSuchVertexException("Vertex ("+to+") is not on the graph");
	 	}
	 	throw new NoSuchVertexException("Vertex ("+from+") is not on the graph");
	 }	
	 /**
	 *	Removes a specific edge from the graph with specific weight.
	 *	@param from the source vertex.
	 *	@param to the target vertex.
	 *	@param weight the weight of the edge.
	 *	@return the edge after removal.
	 *	@throws NoSuchEdgeException if the edge is not on the graph.
	 *	@throws NoSuchVertexException if the source or the target is not on the graph.
	 */
	 public AbstractEdge<VType> removeEdge(VType from, VType to, double weight){
	 	if(this.containsEdge(from,to,weight)){
	 		return super.getGraphAsList().get(new Vertex<>(from)).removeEdge(new DirectedWeightedEdge<>(from,to,weight));
	 	}
	 	throw new NoSuchEdgeException("Edge "+from+"--["+weight+"]-->"+to+" is not on the graph");
	 }
}
