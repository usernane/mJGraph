/**
 * @(#)DepthFirst.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/28
 * @version 1.20 2014/4/11
 */
package ics202.project.traversals;

import ics202.project.graph.AbstractGraph;
import ics202.project.util.LinkedList;
import ics202.project.vertices.TraversalVertex;
import ics202.project.vertices.Vertex;
import ics202.project.util.Stack;
import ics202.project.util.Queue;
import java.util.NoSuchElementException;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchTraversalOrderException;
/**
 *	A class that is using depth-first pre-order traversal algorithm to visite the vertices of the graph.
 *	If the user did not specify the beginning vertex, the traversal will begin from the first vertex that the user added to the graph.
 *	The algorithm is as follows:
 *	1 - Push vertex V to the stack.
 *	2 - Pop the vertex and mark it as visited.
 *	3 - Push all the vertices that are adjacent to V and marked as not visited
 *	4 - Repeat again.
 *
 *	There is no specific order in which the element is pushed to the stack. The result depends only on the way that the edges is added to the graph.
 * @param <VType> the type of graph vertices.
 */
public class DepthFirst<VType> implements Traversal<VType>{
	
	public static String PRE_ORDER = "PRE";
	public static String POST_ORDER = "POST";
	
	private Queue<VType> elements;
	
	/**
	 *	Creates new instance of <code>DepthFirst</code> whith specific starting point.
	 *
	 *	@param g The graph that the algorithm will be berformed on.
	 *	@param v Starting vertex.
	 *	@param traversalType the type should be only <code>DepthFirst.PRE_ORDER</code> or <code>DepthFirst.POST_ORDER</code>.
	 *	@throws NoSuchVertexException if <code>v</code> is not on the graph.
	 */
	public DepthFirst(AbstractGraph<VType> g, VType v, String traversalType)throws NoSuchVertexException{
		//special case.
		if(g.numberOfVertices() == 0)
			throw new NoSuchVertexException("The graph has no vertices");
			
		LinkedList<Vertex<VType>> tmp = g.getGraphAsList();
		if(tmp.contains(new Vertex<>(v))){
			if(traversalType.compareTo(this.PRE_ORDER) == 0){
				this.elements = preOrder(tmp,v);
			}
			else if(traversalType.compareTo(this.POST_ORDER) == 0){
				this.elements = postOrder(tmp,v);
			}
			else{
				throw new NoSuchTraversalOrderException("\""+traversalType+"\" is unknown traversal type");
			}
			
			//error without this 
			return;
		}
		throw new NoSuchVertexException("Vertex ("+v+") is not on the graph");	
	}
	/**
	 *	Creates new instance of <code>DepthFirst</code>.
	 *	
	 *	@param g The graph that the algorithm will be berformed on.
	 */
	public DepthFirst(AbstractGraph<VType> g){
		if(g.numberOfVertices() == 0)
			throw new NoSuchVertexException("The graph has no vertices");
		this.elements = new DepthFirst<VType>(g,g.getGraphAsList().get(0).getData(),DepthFirst.PRE_ORDER).elements;
	}
	/**
	 *	Creates new instance of <code>DepthFirst</code>.
	 *	
	 *	@param g The graph that the algorithm will be berformed on.
	 *	@param startV the starting vertex.
	 */
	public DepthFirst(AbstractGraph<VType> g,VType startV){
		if(g.numberOfVertices() == 0)
			throw new NoSuchVertexException("The graph has no vertices");
		this.elements = new DepthFirst<VType>(g,startV,DepthFirst.PRE_ORDER).elements;
	}	
	/**
	 *	Checks if there are more elements left to visit.
	 *
	 *	@return <code>true</code> if there are more elements left to visit. else, <code>false</code>.
	 *
	 */
        @Override
	public boolean hasNext() {
		// TODO: Add your code here
		return !this.elements.isEmpty();
	}

	/**
	 *	Returns the next element to visit on the graph.
	 *	@return the next element to visit.
	 *	@throws NoSuchElementException if there are no more elements to visit.
	 */
        @Override
	public VType next() throws NoSuchVertexException {
		if(this.hasNext()){
			return this.elements.dequeue();
		}
		throw new NoSuchVertexException("No Such vertex to visite");
	}
	/**
     *	Returns a traversal object that can be used to visit the graph.
     *	@return a traversal object that can be used to visit the graph.
     */
    public Traversal getTraversal(){
    	return this;
    }
    private Queue<VType> preOrder(LinkedList<Vertex<VType>> tmp, VType v){
    	LinkedList<TraversalVertex<VType>> travVertexList = new LinkedList<>();
    	Queue<VType> elQueue = new Queue<>();
    	//mark every vertex as unvisited
		for(int i = 0 , n = tmp.size(); i < n ; i++){
			travVertexList.add(new TraversalVertex<>(tmp.get(i)));
		}
		Stack<TraversalVertex<VType>> stack = new Stack<>();
		stack.push(travVertexList.get(new TraversalVertex<>(v)));
		while(!stack.isEmpty()){
			TraversalVertex<VType> vertex = stack.pop();
			if(!travVertexList.get(vertex).visited()){
				elQueue.enqueue(vertex.getData());
			}
			travVertexList.get(vertex).visit();
			//vertex = travVertexList.get(vertex);
			for(int i = 0 , n = vertex.getDegree() ; i < n ; i++){
				if(!travVertexList.get(new TraversalVertex<>(vertex.getEdge(i).getTarget())).visited()){
					stack.push(travVertexList.get(new TraversalVertex<>(vertex.getEdge(i).getTarget())));
				}
			}
		}
		return elQueue;
    }
    private Queue<VType> postOrder(LinkedList<Vertex<VType>> tmp, VType v){
    	LinkedList<TraversalVertex<VType>> travVertexList = new LinkedList<>();
    	Queue<VType> elQueue = new Queue<>();
    	LinkedList<VType> elLinkedList = new LinkedList<>();
    	//mark each vertex as unvisited
		for(int i = 0 , n = tmp.size(); i < n ; i++){
			travVertexList.add(new TraversalVertex<>(tmp.get(i)));
			
		}
		return postOrder(travVertexList,travVertexList.get(new TraversalVertex<VType>(v)),new Queue<VType>());
    }
    //helper method
    private Queue<VType> postOrder(LinkedList<TraversalVertex<VType>> traversalList,TraversalVertex<VType> vertex, Queue<VType> elements){
    	vertex.visit();
    	for(int i = 0, n = vertex.getDegree() ; i < n ; i++){
    		TraversalVertex<VType> tmpV = traversalList.get(new TraversalVertex<VType>(vertex.getEdges().get(i).getTarget()));
    		if(!tmpV.visited()){
    			postOrder(traversalList,tmpV,elements);
    		}
    	
    	}
    	elements.enqueue(vertex.getData());
    	return elements;
    }
    
}
