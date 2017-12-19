/**
 * @(#)ShortestPath.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/30
 */
package ics202.project.traversals;

import ics202.project.graph.DirectedWeightedGraph;
import ics202.project.edges.DirectedWeightedEdge;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchPathException;
import ics202.project.util.SortableLinkedList;
import ics202.project.util.LinkedList;
import ics202.project.util.Queue;
import ics202.project.vertices.ShortestPathVertex;
import ics202.project.vertices.Vertex;

public class ShortestPath<VType extends Comparable> implements Traversal<DirectedWeightedEdge<VType>>{
	
	private DirectedWeightedGraph<VType> shortGraph = null;
	private Queue<DirectedWeightedEdge<VType>> path;
	/**
	 *	Creates new instance of <code>ShortestPath</code> with specific starting and ending point.
	 *	@param g the graph that the algorithm will be performed on.
	 *	@param startingV the starting vertex.
	 *	@param endingV the end point of the path
	 *	@throws NoSuchVertexException if the starting or the ending vertex is not on the graph.
	 */
    public ShortestPath(DirectedWeightedGraph<VType> g,VType startingV,VType endingV)throws NoSuchVertexException {
    	if(!g.containsVertex(startingV)){
    		throw new NoSuchVertexException("Vertex ("+startingV+") is not on the graph");
    	}
    	if(endingV != null){
    		if(!g.containsVertex(endingV)){
	    		throw new NoSuchVertexException("Vertex ("+endingV+") is not on the graph");	
	    	}
    	}
	   	this.shortGraph = this.buildPath(g,startingV,endingV);
	   	this.path = addPathToQueue(this.shortGraph);
    }
    /**
	 *	Creates new instance of <code>ShortestPath</code> with specific starting point.
	 *	@param g the graph that the algorithm will be performed on.
	 *	@param startingV the starting vertex.
	 */
    public ShortestPath(DirectedWeightedGraph<VType> g,VType startingV){
    	this(g,startingV,null);
    }
    /**
     *	Returns a graph representation of the path that was found.
     *	@return graph representation of the path that was found.
     */
	public DirectedWeightedGraph<VType> getGraph(){
		return this.shortGraph;
	}
	/**
	 *	Returns a traversal object 
	 *	@return <code>Traversal</code> object.
	 */
	public Traversal getTraversal(){
		return this;
	}
	/**
	 *	Returns the next path to go to.
	 *	@return the next path to go to.
	 */
        @Override
	public DirectedWeightedEdge<VType> next()throws NoSuchPathException{
		if(this.hasNext()){
			return this.path.dequeue();
		}
		throw new NoSuchPathException();
	}
        @Override
	public boolean hasNext(){
		return !this.path.isEmpty();
	}
	/**
	 *	The algorithm to build the graph is as follows:
	 *	1- set the distance for all vertices to the max value except for the starting vertex;
	 *	2- loop as long as the new graph has less vertices than the original graph
	 *	
	 */
	private DirectedWeightedGraph<VType> buildPath(DirectedWeightedGraph<VType> graph, VType start,VType end){
		//no need to do any thing if the source has no edges
		if(graph.getGraphAsList().get(new Vertex<>(start)).getDegree() == 0){
			return new DirectedWeightedGraph<> ();
		}
		DirectedWeightedGraph<VType> subGraph = new DirectedWeightedGraph<> ();
		
    	LinkedList<Vertex<VType>> tmpVertexList = graph.getGraphAsList();
    	LinkedList<ShortestPathVertex<VType>> shortestPathVertexList = new LinkedList<>();
    	
    	for(int i = 0, n = tmpVertexList.size() ; i < n ; i++){
    		if(start.equals(tmpVertexList.get(i).getData())){
    			shortestPathVertexList.add(new ShortestPathVertex<>(tmpVertexList.get(i),0));
    		}
    		else{
    			shortestPathVertexList.add(new ShortestPathVertex<>(tmpVertexList.get(i)));
    		}
    	}
    	
    	SortableLinkedList<ShortestPathVertex<VType>> sortList = new SortableLinkedList<>();
    	sortList.add(shortestPathVertexList.get(new ShortestPathVertex<>(start)));
    	
    	while(subGraph.numberOfVertices() < graph.numberOfVertices()){
    		
    		//if there is no more vertices to visit
    		if(sortList.isEmpty()){
    			
    			//check if the target is on the graph or not, if not throw exception
    			if(!subGraph.containsVertex(end) && end != null)
    				throw new NoSuchPathException("No path was found to vertex ("+end+")");
    			return subGraph;
    		}
    		
    		sortList.sortIncreasing();
    		ShortestPathVertex<VType> tmpV = sortList.removeFirst();
    		
    		//if we visit inside the loop we get a bug
    		shortestPathVertexList.get(new ShortestPathVertex<VType>(tmpV.getData())).visit();
    		if(!subGraph.containsVertex(tmpV.getData())){
    			subGraph.addVertex(tmpV.getData());
    			
    			//Adding new path
	    		if(tmpV.getEdge() != null){
	    			DirectedWeightedEdge<VType> tmpE = tmpV.getEdge();
	    			subGraph.addEdge(tmpE.getSource(),tmpE.getTarget(),tmpE.getWeight());
	    			//enqueuing shold be done later.
	    			//this.path.enqueue(tmpE);
	    		}
    		}
    		
    		//did we reach the end or not?(if we have end)
    		if(end != null){
    			if(tmpV.getData().equals(end)){
    				subGraph = this.clearGraph(subGraph);
    				return subGraph;
    			}
    		}
    		LinkedList<AbstractEdge<VType>> tmpEdgelist = tmpV.getEdges();
    		
    		for(int i = 0, n =  tmpEdgelist.size(); i < n ; i++){
    			DirectedWeightedEdge<VType> tmpE = (DirectedWeightedEdge<VType>)tmpEdgelist.get(i);
    			Vertex<VType> tmpVer = tmpVertexList.get(new Vertex<>(tmpE.getTarget()));
    			ShortestPathVertex<VType> tmpSortV = new ShortestPathVertex<VType>(tmpVer,tmpE,tmpV.getDistance()+tmpE.getWeight());
    			//if not visited add it and visite
    			if(!shortestPathVertexList.get(new ShortestPathVertex<VType>(tmpSortV.getData())).visited()){
    				sortList.add(tmpSortV);
    			}
    		}
    	}
    	
	    return subGraph;
	}
	/**
	 *	This method is used when we only wants the distance between two vertices
	 */
	private DirectedWeightedGraph<VType> clearGraph(DirectedWeightedGraph<VType> g){
		for(int i = 0 ; i < g.numberOfVertices() ; i++){
			if(g.getGraphAsList().get(i).getEdges().size() > 1){
				LinkedList<AbstractEdge<VType>> tmpList = g.getGraphAsList().get(i).getEdges();
				for(int j = 0 ; j < tmpList.size() ; j++){
					VType target = tmpList.get(j).getTarget();
					if(g.getGraphAsList().get(new Vertex<>(target)).getEdges().isEmpty()){
						
						g.removeVertex(target);
					}
				}
				
			}		
		}
		
		return g;
	}
	//this method used to resolve the extra pathes that might be added to the graph.
	public Queue<DirectedWeightedEdge<VType>> addPathToQueue(DirectedWeightedGraph<VType> g){
		Queue<DirectedWeightedEdge<VType>> queue = new Queue<>();
		for(int i = 0, n = g.numberOfVertices() ; i < n ; i++ ){
			LinkedList<AbstractEdge<VType>> list = g.getGraphAsList().get(i).getEdges();
			for(int j = 0, h = list.size() ; j < h ; j++){
				queue.enqueue((DirectedWeightedEdge<VType>)list.get(j));
			}
		}
		return queue;
	}
}