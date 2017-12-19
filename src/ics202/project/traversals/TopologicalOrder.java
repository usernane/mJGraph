/**
 * @(#)TopologicalOrder.java
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/29
 */
package ics202.project.traversals;

import ics202.project.graph.DirectedGraph;
import ics202.project.util.Queue;
import ics202.project.vertices.Vertex;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.GraphHasCycleException;
/**
 *	A Class that can be used to perform topological sort on directed graphs.
 * @param <VType> the type of graph vertices.
 */
public class TopologicalOrder<VType> implements Traversal<VType>{
	private final Queue<VType> elements;
	/**
	 *	Creates new instance of <code>TopologicalOrder</code>.
	 *
	 *	@param g the directed graph that the algorithm will be berformed on.
	 *	@see DirectedGraph
	 */
	public TopologicalOrder(DirectedGraph<VType> g)throws GraphHasCycleException{
		this.elements = new Queue<>();
		DirectedGraph<VType> tmpG = new DirectedGraph<VType>(g);
		this.perform(tmpG);		
	}
	/**
	 *	Checks if there are more elements to visit.
	 *	@return <code>true</code> if there are more elements to visit. else, <code>false</code>.
	 */
        @Override
	public boolean hasNext(){
		return !this.elements.isEmpty();
	}
	/**
	 *	Returns the next element on the topological order.
	 *	@return the next element on the topological order.
	 */
        @Override
	public VType next(){
		return this.elements.dequeue();
	}
	//this method will search fo all vertices on the graph that has 0 in-degree.
	private Queue<Vertex<VType>> get0InDegreeVertices(DirectedGraph<VType> g){
		Queue<Vertex<VType>> queue = new Queue<>();
		for(int i = 0, n = g.numberOfVertices() ; i < n ; i++){
			if(g.inDegreeOf(g.getGraphAsList().get(i).getData()) == 0){
				queue.enqueue(new Vertex<>(g.getGraphAsList().get(i)));
			}
		}
		if(!queue.isEmpty())
			return queue;
		throw new java.util.NoSuchElementException("No vertex with 0 in-degree");
	}
	/**
     *	Returns a traversal object that can be used to visit the graph.
     *	@return a traversal object that can be used to visit the graph.
     */
    public Traversal getTraversal(){
    	return this;
    }
	///performing topological sort.
	private void perform(DirectedGraph<VType> g)throws GraphHasCycleException{
		Queue<Vertex<VType>> travQueue = this.get0InDegreeVertices(g);
		Queue<AbstractEdge<VType>> edgesQueue = new Queue<>();
		while(!travQueue.isEmpty()){
			Vertex<VType> vertex = travQueue.dequeue();
			elements.enqueue(vertex.getData());
			for(int i = 0 , n = vertex.getDegree(); i < n ; i++){
				//problem with the edges
				//it seems that the methods removes directly from the graph
				AbstractEdge<VType> tmpEdge = g.removeEdge(vertex.getData());
				//to resolve the error
				edgesQueue.enqueue(tmpEdge);
				if(g.inDegreeOf(tmpEdge.getTarget()) == 0){
					travQueue.enqueue(new Vertex<>(g.getGraphAsList().get(new Vertex<>(tmpEdge.getTarget()))));
				}
			}
			
		}
		if(g.hasEdges())
			throw new GraphHasCycleException();
		else{
			while(!edgesQueue.isEmpty()){
				AbstractEdge<VType> tmpE = edgesQueue.dequeue();
				g.addEdge(tmpE.getSource(),tmpE.getTarget());
			}
		}
	}
	
}
