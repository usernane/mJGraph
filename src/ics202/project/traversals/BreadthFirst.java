/**
 * @(#)BreadthFirst.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/28
 */
package ics202.project.traversals;

import ics202.project.traversals.Traversal;
import ics202.project.graph.AbstractGraph;
import ics202.project.util.Queue;
import ics202.project.util.LinkedList;
import ics202.project.vertices.Vertex;
import ics202.project.vertices.TraversalVertex;
import ics202.project.exceptions.NoSuchVertexException;
import java.util.NoSuchElementException;

/**
 *	This class is used to perform breadth-first algorithm on any graph.
 *	
 *	In order to perform the algorithm, we need a queue to hold the elements after berforming the algorithm.
 *	The algorithm in general is as follows:
 *	1 - enqueue a vertex V into the queue.
 *	2 - Mark the V as visited.
 *	3 -Dequeue the vertex V and enqueue the data on that vertex to the main queue. 	
 *  4 - Enqueue any vertex that is adjacent to V.
 *  5 - Repeat again 
 * @param <VType> the type of graph vertices.
 */
public class BreadthFirst<VType> implements Traversal<VType>{
	private Queue<VType> elements;
	/**
	 *	Creates new instance of <code>BreadthFirst</code> with specific starting point.
	 *
	 *	@param g The graph that the algorithm will be performed on.
	 *	@param v Starting vertex.
	 *	@throws NoSuchVertexException if <code>v</code> is not on the graph.
	 */
	public BreadthFirst(AbstractGraph<VType> g, VType v)throws NoSuchVertexException{
		if(g.numberOfVertices() == 0)
			throw new NoSuchVertexException("The graph has no vertices");
			
		LinkedList<Vertex<VType>> tmp = g.getGraphAsList();
		if(tmp.contains(new Vertex<>(v))){
			elements = new Queue<>();
			LinkedList<TraversalVertex<VType>> travVertexList = new LinkedList<>();
			for(int i = 0, n = tmp.size() ; i < n ; i++){
				travVertexList.add(new TraversalVertex<>(tmp.get(i)));
			}
			Queue<TraversalVertex<VType>> queue = new Queue<>();
			queue.enqueue(travVertexList.get(new TraversalVertex<>(v)));
			travVertexList.get(new TraversalVertex<>(v)).visit();
			//this is the traversal part
			while(!queue.isEmpty()){
				TraversalVertex<VType> vertex = queue.dequeue();
				this.elements.enqueue(vertex.getData());
				for(int i = 0, n = vertex.getDegree()  ; i < n ; i++){
					if(!travVertexList.get(new TraversalVertex<>(vertex.getEdge(i).getTarget())).visited()){
						queue.enqueue(travVertexList.get(new TraversalVertex<>(vertex.getEdge(i).getTarget())));
						travVertexList.get(new TraversalVertex<>(vertex.getEdge(i).getTarget())).visit();	
					}
				}
				
			}
			
			return;
		}
		throw new NoSuchVertexException("Vertex ("+v+") is not on the graph");
	}
	/**
	 *	Creates new instance of <code>BreadthFirst</code>.
	 *	
	 *	The starting point will be the first vertex that was added to the graph.	
	 *
	 *	@param g The graph that the algorithm will be berformed on.
	 */
	public BreadthFirst(AbstractGraph<VType> g){
		if(g.numberOfVertices() == 0)
			throw new NoSuchVertexException("The graph has no vertices");
		this.elements = new BreadthFirst<>(g,g.getGraphAsList().get(0).getData()).elements;
	}
	/**
	 *	Checks if there are more elements left to visit.
	 *
	 *	@return <code>true</code> if there are more elements left to visit. else, <code>false</code>.
	 *
	 */
    @Override
	public boolean hasNext(){
		return !this.elements.isEmpty();
	}
	/**
	 *	Returns the next element to visit on the graph.
	 *	@return the next element to visit.
	 *	@throws NoSuchVertexException if there are no more elements to visit.
	 */
    @Override
	public VType next() throws NoSuchVertexException{
		if(!this.elements.isEmpty()){
			return this.elements.dequeue();
		}
		throw new NoSuchElementException("No more elements to visit");
	}
	/**
     *	Returns a traversal object that can be used to visit the graph.
     *	@return a traversal object that can be used to visit the graph.
     */
    public Traversal getTraversal(){
    	return this;
    }	
}
