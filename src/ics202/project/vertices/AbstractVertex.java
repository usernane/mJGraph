/**
 * @(#)AbstractVertex.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/18
 */

package ics202.project.vertices;
/**
 *	A simple vertex that has only data.
 */
import ics202.project.util.LinkedList;
import ics202.project.edges.AbstractEdge;
import java.util.Objects;

/**
 *
 * 
 * @param <VType> the data that will be stored on the vertex.
 */
public abstract class AbstractVertex<VType> {
	/**
	 *	The data that will be stored on the vertex.
	 */
	protected VType data;
	protected LinkedList<AbstractEdge<VType>> edges;
	/**
	 *	Creates a new graph node with specific element.
	 *	@param data The information that will be stored  on the vertex.
	 */
	public AbstractVertex(VType data){
		this.data = data;
		this.edges = new LinkedList<>();
	}
	/**
	 *	Creates a copy of another vertex.
	 *	@param v the vertex that will be copied.
	 */
	public AbstractVertex(AbstractVertex<VType> v){
		this.data = v.data;
		this.edges = v.edges;
	}
	/**
	 *	Checks if two graph vertices are equal.
	 *	Two vertices are equal if the information stored inside each vertex is equal.
	 *
	 *	@param other The node that will be checked for equally.
	 *	@return <code>true</code> if the two vertices are equal. else, <code>false</code>.
	 */
        @Override
	public boolean equals(Object other){
		if(other instanceof AbstractVertex<?>){
			AbstractVertex<?> tmp = (AbstractVertex<?>)other;
			return this.data == tmp.data;
		}
		return false;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.data);
        return hash;
    }
	/**
	 *	Returns the information stored on the vertex.
	 *	@return the information stored on the vertex.
	 */
	public VType getData(){
		return this.data;
	}
	/**
	 *	Returns the number of edges on that vertex.
	 *	@return the number of edges on that vertex.
	 */
	public abstract int getDegree();
	/**
	 *	Returns a <code>LinkedList</code> that contains all the edges.
	 *	@return A <code>LinkedList</code> that contains all the edges.
	 */
	public abstract LinkedList<AbstractEdge<VType>> getEdges();
	/**
	 *	Checks whether the vertex has edges or not.
	 *	@return <code>true</code> if there is an edge that is coming from that node. else, <code>false</code>.
	 */
	public abstract boolean hasEdges();
	/**
	 *	Adds new edge to the vertex to other specific vertex.
	 *	@param e the edge that will be added to that vertex.
	 */

    /**
     * Adds new edge to the vertex to other specific vertex.
     * @param e the edge that will be added to that vertex.
     * @return the edge after removal.
     */
    public abstract AbstractEdge<VType> removeEdge(AbstractEdge<VType> e);
	/**
	 *	Returns a string representation of <code>Vertex</code>
         * @return <code>String</code> object.
	 */
        @Override
	public String toString(){
		return this.data+"";
	}
}
