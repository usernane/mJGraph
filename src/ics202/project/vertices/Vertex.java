package ics202.project.vertices;

import ics202.project.util.LinkedList;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.NoSuchEdgeException;
/**
 *	This class is used to build all types of graphs.
 * 
 * @param <VType> the data that will be stored on the vertex.
 */
public class Vertex<VType> extends AbstractVertex<VType> {
	/**
	 * Creates new instance of <code>Vertex</code> with specific initial value.
	 *
	 *
         * @param v the data that will be stored on the vertex.
	 */
	public Vertex(VType v) {
		super(v);
	}

    /**
     * Creates a copy of another vertex.
     * @param v the vertex that will be copied.
     */
    public Vertex(Vertex<VType> v){
		super(v);
	}
	/**
	 *	Adds new edge to the vertex.
	 *	@param edge the edge that will be added.
	 */
	public void addEdge(AbstractEdge<VType> edge){
		super.edges.add(edge);
	}
	/**
	 *	Checks if an edge is on the vertex or not.
	 *	@param edge the edge that will be checked.
	 *	@return <code>true</code> if the edge is on the graph. else, <code>false</code>.
	 */
	public boolean containsEdge(AbstractEdge<VType> edge){
		return super.edges.contains(edge);
	}
	/**
	 *	Returns the number of edges that is coming out of the vertex.
	 *	@return the number of edges that is coming out of the vertex.
	 */
        @Override
	public int getDegree() {
		// TODO: Add your code here
		return super.edges.size();
	}
	/**
	 *	Returns the edge on the specific index.
	 *	@param index the index that the edge is on
         * @return the edge if it is on the graph.
	 *	@throws IndexOutOfBoundsException if the specifide index is less than 0 or greater than the number of edges on the vertex.
	 */
	public AbstractEdge<VType> getEdge(int index)throws IndexOutOfBoundsException{
		if(index < 0 || index > super.edges.size())
			throw new IndexOutOfBoundsException(""+index);
		return super.edges.get(index);
	}
	/**
	 *	Returns a linked list that contains all the edges that are on the vertex.
	 *	@return a linked list that contains all the edges that are on the vertex.
	 */
        @Override
	public LinkedList<AbstractEdge<VType>> getEdges(){
		return super.edges;
	}
	/**
	 *	Checks if the vertex has edges or not.
	 *	@return <code>true</code> if the vertex has edges. else, <code>false</code>.
	 */
        @Override
	public boolean hasEdges() {
		// TODO: Add your code here
		return !super.edges.isEmpty();
	}
	
	
	
	/**
	 *	Removes a specific edge from the vertex.
	 *	@param e the edge that will be removed.
         * @return the edge after removal.
	 *	@throws NoSuchEdgeException if the edge is not on the vertex.
	 */
        @Override
	public AbstractEdge<VType> removeEdge(AbstractEdge<VType> e) throws NoSuchEdgeException{
		if(this.containsEdge(e)){
			AbstractEdge<VType> tmp = super.edges.remove(e);
			return tmp;
		}
		throw new NoSuchEdgeException("Edge ("+e+") is not linked to the vertex ("+this.data+")");
	}
	
	/**
	 *	Remove an edge from the vertex.
	 *	@return the edge after removal.
	 *	@throws NoSuchEdgeException if there are no edges on the vertex.
	 */
	public AbstractEdge<VType> removeEdge()throws NoSuchEdgeException{
		if(!this.edges.isEmpty()){
			return this.edges.removeFirst();
		}
		throw new NoSuchEdgeException("Vertex "+super.data+" have no edges");
	}
}
