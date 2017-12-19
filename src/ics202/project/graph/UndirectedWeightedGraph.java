/**
 * @(#)UndirectedWeightedGraph.java
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */
package ics202.project.graph;

import ics202.project.edges.UndirectedWeightedEdge;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchEdgeException;
import ics202.project.vertices.Vertex;
/**
 *	The edges of this graph has weight but no direction.
 * @param <VType> the type of graph vertices.
 */
public class UndirectedWeightedGraph<VType> extends UndirectedGraph<VType> {
	
	/**
	 * Creates a new instance of <code>UndirectedWeightedGraph</code>
	 *
	 *
	 */
	public UndirectedWeightedGraph() {
		// TODO: Add your code here
	}

	/**
	 * Adds a new edge to the graph with specific weight.
	 *
	 *If the edge is already on the graph, it will not be added.
	 *
	 * @param from the vertex that the edge will come from.
	 * @param to the vertex that the edge will go to.
	 * @param weight the weight that will be assigned to that edge
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 *
	 */
	public void addEdge(VType from, VType to, double weight) throws NoSuchVertexException{
		if(super.containsVertex(from)){
			if(super.containsVertex(to)){
				if(this.containsEdge(from,to,weight))
					return;
				super.getGraphAsList().get(new Vertex<>(from)).addEdge(new UndirectedWeightedEdge<>(from,to,weight));
				//since the graph is undirected, we have to add an edge to the other vertex
				super.getGraphAsList().get(new Vertex<>(to)).addEdge(new UndirectedWeightedEdge<>(to,from,weight));
				return;
			}
			throw new NoSuchVertexException(to+" is not in the graph");	
		}
		throw new NoSuchVertexException(from+" is not in the graph");
	}
	/**
	 * Adds a new edge to the graph.
	 *
	 *If the edge is already on the graph, it will not be added.
	 *
	 * @param from the vertex that the edge will come from.
	 * @param to the vertex that the edge will go to.
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 *
	 */
	@Override
	public void addEdge(VType from, VType to) throws NoSuchVertexException{
		if(super.containsVertex(from)){
			if(super.containsVertex(to)){
				if(super.containsEdge(from,to))
					return;
				
				super.getGraphAsList().get(new Vertex<>(from)).addEdge(new UndirectedWeightedEdge<>(from,to));
				super.getGraphAsList().get(new Vertex<>(to)).addEdge(new UndirectedWeightedEdge<>(to,from));
				return;
			}
			throw new NoSuchVertexException(to+" is not in the graph");	
		}
		throw new NoSuchVertexException(from+" is not in the graph");
	}
	/**
	 * Checks if a specific edge that is linking between two vertices is on the graph or not.
	 * @param from the vertex that the edge is coming from.
	 * @param to the vertex that the edge is going to.
	 * @param weight the weight of the edge.
	 * @return <code>true</code> if the edge exist. Else, <code>false</code>.
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 */
	public boolean containsEdge(VType from, VType to,double weight) throws NoSuchVertexException{
		if(super.containsVertex(from)){
			if(super.containsVertex(to)){
				Vertex<VType> tmp = super.getGraphAsList().get(new Vertex<>(from));
				for(int i = 0, n = tmp.getDegree() ; i < n ; i++){
					UndirectedWeightedEdge tmpEdge = (UndirectedWeightedEdge)tmp.getEdge(i);
					if(tmpEdge.equals(new UndirectedWeightedEdge<>(from,to,weight))){
						return true;
					}
				}
				tmp = super.getGraphAsList().get(new Vertex<>(to));
				for(int i = 0, n = tmp.getDegree() ; i < n ; i++){
					UndirectedWeightedEdge tmpEdge = (UndirectedWeightedEdge)tmp.getEdge(i);
					if(tmpEdge.equals(new UndirectedWeightedEdge<>(from,to,weight))){
						return true;
					}
				}
				return false;
			}
			throw new NoSuchVertexException(to+" is not in the graph");
		}
		throw new NoSuchVertexException(from+" is not in the graph");
	}
	/**
	 *	Removes a specific edge from the graph.
	 *	@param from the source vertex.
	 *	@param to the target vertex.
	 *	@param weight the weight of the edge.
         *      @return the edge after removal.
	 *	@throws NoSuchEdgeException if there is no such edge on the graph.
	 */
	public AbstractEdge<VType> removeEdge(VType from,VType to,double weight)throws NoSuchEdgeException{
		if(this.containsEdge(from,to,weight)){
			return super.removeEdge(from,to);
		}
		throw new NoSuchEdgeException(from+"--["+weight+"]--"+to);
	}
}
