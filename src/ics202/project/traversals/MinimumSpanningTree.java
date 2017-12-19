/**
 * @(#)MinimumSpanningTree.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/5/3
 */
package ics202.project.traversals;
import ics202.project.graph.UndirectedWeightedGraph;
import ics202.project.util.LinkedList;
import ics202.project.util.Queue;
import ics202.project.vertices.TraversalVertex;
import ics202.project.vertices.Vertex;
import ics202.project.util.SortableLinkedList;
import ics202.project.edges.UndirectedWeightedEdge;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchPathException;
import java.util.NoSuchElementException;
/**
 *	A class that generates the minimum spanning tree for the Undirected Weighted graphs.
 *	
 * @param <VType> the type of graph vertices.
 */
public class MinimumSpanningTree<VType> implements Traversal<UndirectedWeightedEdge<VType>>{
	
	private UndirectedWeightedGraph<VType> subGraph;
	private Queue<UndirectedWeightedEdge<VType>> path;
	private int cost;
	/**
	 *	Creates new instance if <code>MinimumSpanningTree</code> with specific starting point.
	 *	@param g the graph that the algorithm will be berformed on.
	 *	@param startingV the starting point.
	 */
    public MinimumSpanningTree(UndirectedWeightedGraph<VType> g, VType startingV)throws NoSuchVertexException {
    	
    	if(g.containsVertex(startingV)){
    		
    		this.subGraph = new UndirectedWeightedGraph<>();
    		this.path = new Queue<>();
	    	this.subGraph.addVertex(startingV);
	    	
	    	this.subGraph = this.buildTree(this.subGraph,g);
    		return;
    	}
    	throw new NoSuchVertexException("Vertex ("+startingV+") is not on the graph");		
    }
    /**
     *	Creates new instance if <code>MinimumSpanningTree</code> with specific starting point.
     *	The traversal will begin from the first vertex that the user added to the graph.
	 *	@param g the graph that the algorithm will be berformed on.
	 *
     */
    public MinimumSpanningTree(UndirectedWeightedGraph<VType> g){
    	if(g.numberOfVertices() == 0)
    		throw new NoSuchVertexException("The graph has no vertices");
    	MinimumSpanningTree<VType> tmpTree = new MinimumSpanningTree<>(g,g.getGraphAsList().get(0).getData());
    	this.subGraph = tmpTree.subGraph;
    	this.path = tmpTree.path;
    	this.cost = tmpTree.cost;
    	tmpTree = null;
    }
    /**
     *	Checks if there are more locations to visit on the tree.
     *	@return <code>true</code> if there are more locations. else <code>false</code>.
     */
        @Override
    public boolean hasNext(){
    	return !this.path.isEmpty();
    }
    /**
     *	Returns the total cost of the path that was found.
     *	@return total cost of the path that was found.
     */
    public int getTotalCost(){
    	return this.cost;
    }
    /**
     *	Returns a complete graph of the minimum spanning tree.
     *	@return a complete graph of the minimum spanning tree.
     */
    public UndirectedWeightedGraph<VType> getGraph(){
    	return this.subGraph;
    }
    /**
     *	Returns a traversal object that can be used to visit the graph.
     *	@return a traversal object that can be used to visit the graph.
     */
    public Traversal<UndirectedWeightedEdge<VType>> getTraversal(){
    	return this;
    }
        @Override
    public UndirectedWeightedEdge<VType> next() throws NoSuchPathException{
    	if(!this.path.isEmpty()){
    		return this.path.dequeue();
    	}
    	throw new NoSuchPathException();
    }
    
    private UndirectedWeightedGraph<VType> buildTree(UndirectedWeightedGraph<VType> subGraph,UndirectedWeightedGraph<VType> g){
    	LinkedList<Vertex<VType>> tmpVertexList = g.getGraphAsList();
	    	
	    LinkedList<TraversalVertex<VType>> traversalVertexList = new LinkedList<>();
	    for(int i = 0 , n = tmpVertexList.size() ; i < n ; i++){
	    	traversalVertexList.add(new TraversalVertex<>(tmpVertexList.get(i)));
	   	}
    	//trace the location of V
    	//if the location is a negative number, then there must be a vertex with no edges
    	int index = 0;
    	SortableLinkedList<UndirectedWeightedEdge<VType>> sortList = new SortableLinkedList<>();
    	while(subGraph.numberOfVertices() < traversalVertexList.size()){
    		if(index < 0){
    			throw new NoSuchPathException("No path was found to some vertices");
    		}
    		
    		//throws no such element exception here
    		LinkedList<AbstractEdge<VType>> tmpEdgesList = traversalVertexList.get(new TraversalVertex<>(subGraph.getGraphAsList().get(index).getData())).getEdges();
    		
    		for(int i = 0 , n = tmpEdgesList.size() ; i < n ; i++){
    			
    			UndirectedWeightedEdge<VType> tmpEdge = (UndirectedWeightedEdge<VType>)tmpEdgesList.get(i);
    			//add the edge to the list if it is not on the tree.
    			if(!subGraph.containsVertex(tmpEdge.getTarget())){
    				sortList.add(tmpEdge);
    			}
    			
    		}
    		//sort the list.
    		sortList.sortIncreasing();
    		UndirectedWeightedEdge<VType> tmpEdge;
    		try{
    			//if the list is empty it will throw an exception
    			tmpEdge = sortList.removeFirst();
    			
	    		if(!subGraph.containsVertex(tmpEdge.getTarget()) && !traversalVertexList.get(new TraversalVertex<>(tmpEdge.getTarget())).visited()){
	    			traversalVertexList.get(new TraversalVertex<>(tmpEdge.getTarget())).visit();
	    			subGraph.addVertex(tmpEdge.getTarget());
	    			subGraph.addEdge(tmpEdge.getSource(),tmpEdge.getTarget(),tmpEdge.getWeight());
	    			subGraph.addEdge(tmpEdge.getTarget(),tmpEdge.getSource(),tmpEdge.getWeight());
	    			this.path.enqueue(tmpEdge);	
	    			cost += tmpEdge.getWeight();
	    			index++;		
	    		}
    		}
    		catch(NoSuchElementException e){
    			
    			index--;
    			
    		}	
    	}
    	return subGraph;
    }
    
}