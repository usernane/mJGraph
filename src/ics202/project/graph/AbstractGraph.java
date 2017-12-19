/**
 * @(#)AbstractGraph.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */

package ics202.project.graph;

import ics202.project.util.LinkedList;
import ics202.project.util.Stack;
import ics202.project.util.Queue;
import ics202.project.util.DataStructure;
import ics202.project.vertices.Vertex;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchEdgeException;


/**
 * An abstract class that contains the most common used methods on graphs.
 * @param <VType> the type of graph vertices.
 */
public abstract class AbstractGraph<VType> implements DataStructure<VType>{
	/**
	 *	The heart of the graph.
	 */
	protected LinkedList<Vertex<VType>> graphList;
	/**
	 *	Creates a new instance of <code>AbstractGraph</code>
	 */
	public AbstractGraph(){
		
	}
	@Override
	public void addElement(VType el){
		this.addVertex(el);
	}
	/**
	 * Adds a new edge between two vertices.
	 *
	 *
	 * @param from the vertex that the edge will come from.
	 * @param to the vertex that the edge will go to.
	 * 
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 */
	public abstract void addEdge(VType from, VType to)throws NoSuchVertexException;

	/**
	 * Adds new vertex to the graph.
	 * @param v the vertex that will be added to the graph.
	 * 
	 */
	public abstract void addVertex(VType v);
	/**
	 *	Checks if the graph has an edge between two vertices.
	 *	@param from the vertex that the edge come from.
	 *  @param to the vertex that the edge go to.
	 *	@return <code>true</code> if there is an edge.
	 *	
	 */
	public abstract boolean containsEdge(VType from,VType to)throws NoSuchVertexException;
	/**
	 *	Checks if a specific vertex is on the graph or not.
	 *	@param v The vertex that will be checked.
	 *	@return <code>true</code> if the vertex is on the graph. else, <code>false</code>.
	 */
	public abstract boolean containsVertex(VType v);
	/**
	 *	Returns the specific vertex if it is exist on the graph
	 *	@param v the vertex that will be returned.
	 *	@return the information on that vertex.
	 */
	public abstract VType getVertex(VType v)throws NoSuchVertexException;
	/**
	 *	Returns the specific edge if it is exist on the graph
	 *	@param e the edge that will be checked.
	 *	@return <code>AbstractEdge</code> object.
	 *	@throws NoSuchEdgeException if the edge is not on the graph.
	 */
	public abstract AbstractEdge<VType> getEdge(AbstractEdge<VType> e)throws NoSuchEdgeException;
	/**
	 *	Returns the edge that is linking between two specific vertices.
	 *	@param from the vertex that the edge is coming from.
	 *	@param to the vertex that the edge is going to.
	 *	@return An <code>AbstractEdge</code> object.
	 */
	public abstract AbstractEdge<VType> getEdge(VType from, VType to);
	/**
	 *	Returns the edges of the graph.
	 *	@return edges of the graph on a linked list.
	 */
	
	public abstract LinkedList<AbstractEdge<VType>> getEdges();
	/**
	 *	Returns a <code>LinkedList</code> that contains all the vertices on the graph.
	 *	@return a <code>LinkedList</code> that contains all the vertices on the graph.
	 */
	public abstract LinkedList<VType> getVertices();
	/**
	 *	Returns the graph as a linked list.
	 *	@return the graph as a linked list.
	 */
	public abstract LinkedList<Vertex<VType>> getGraphAsList();
	/**
     *	Returns a linked list that contains only the vertices of the graph.
     *	@return a linked list that contains only the vertices of the graph..
     */
    @Override
    public LinkedList<VType> getLinkedList(){
    	LinkedList<VType> tmpList = new LinkedList<>();
    	for(int i = 0 , n = this.graphList.size(); i < n ; i++){
    		tmpList.add(this.graphList.get(i).getData());
    	}
    	return tmpList;
    }
    /**
     *	Returns a data structure object.
     *	@return data structure object.
     */
    @Override
    public DataStructure<VType> getDataStructure(){
    	return this;
    }
    /**
     *	Returns a queue data structure that contains only the vertices of the graph.
     *	@return queue data structure that contains only the vertices of the graph.
     */
    @Override
    public Queue<VType> getQueue(){
    	Queue<VType> tmpQueue = new Queue<>();
    	for(int i = 0 , n = this.graphList.size(); i < n ; i++){
    		tmpQueue.enqueue(this.graphList.get(i).getData());
    	}
    	return tmpQueue;
    }
    /**
     *	Returns a stack data structure that contains only the vertices of the graph.
     *	@return stack data structure that contains only the vertices of the graph.
     */
    @Override
    public Stack<VType> getStack(){
    	Stack<VType> tmpStack = new Stack<>();
    	for(int i = 0 , n = this.graphList.size(); i < n ; i++){
    		tmpStack.push(this.graphList.get(i).getData());
    	}
    	return tmpStack;
    }
	/**
	 *	Checks if the graph has edges or not.
	 *	@return <code>true</code> if the graph has edges.
	 */
	public abstract boolean hasEdges();
	/**
	 *	Checks if the graph is empty or not.
	 *	@return <code>true</code> if the graph has vertices.
	 */
	public abstract boolean hasVertices();

	 
	public abstract int numberOfVertices();
	/**
	 *	Returns the number of edges on the graph.
	 *	@return number of edges on the graph
	 */
	public abstract int numberOfEdges();
	@Override
	public VType removeElement(){
		return this.removeVertex(this.graphList.get(0).getData());
	}
	/**
	 * Removes an edge from the graph.
	 *
	 *
	 * @param from the vertex that the edge coming from.
	 * @param to the vertex that the edge go to.
	 * @return The edge after removal.
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 * @throws NoSuchEdgeException if there is no edge between the given vertices.
	 *
	 */
	public abstract AbstractEdge<VType> removeEdge(VType from, VType to)throws NoSuchEdgeException,NoSuchVertexException;
	/**
	 * Removes a specific vertex from the graph.
	 * @param v the vertex that will be removed from the graph.
	 * @return the information on that vertex after removal.
	 * @throws NoSuchVertexException if the vertex is not on the graph.
	 */
	public abstract VType removeVertex(VType v)throws NoSuchVertexException;	
	
}
