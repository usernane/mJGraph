/**
 * @(#)AbstractEdge.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */


package ics202.project.edges;

import java.util.Objects;

/**
 *	The base edge for all edges.
 *  @param <VType> the type of vertices that will be linked together.
 */

public abstract class AbstractEdge<VType> {
	/**
	 *	The vertex that the edge is coming from.
	 */
	protected VType from = null;
	/**
	 *	The vertex that the edge is going to.
	 */
	protected VType to = null;	
	/**
	 * Creates new instance of <code>AbstractEdge</code>
	 *
	 * @param from The vertex that the edge is coming from.
	 *
	 * @param to The vertex that the edge is going to.
	 */
	public AbstractEdge(VType from, VType to) {
		// TODO: Add your code here
		this.from = from;
		this.to = to;
	}
	public AbstractEdge() {
		// TODO: Add your code here
		this(null,null);
	}
	/**
	 * Returns the source of that edge.
	 *
	 *
	 * @return An object that represents the source.
	 *
	 */
	public abstract VType getSource();

	/**
	 * Returns the target of that edge
	 *
	 *
	 * @return An object that represents the target
	 *
	 */
	public abstract VType getTarget();
	/**
	 *	Checks if another object is equal to this object.
	 *
	 *	Two edges are equal if the source of the edge is equal to the source of the other edge.
	 *	The same thing applies to the target and vice versa.
     * @param other the edge that will be checked.
     * @return <code>true</code> if the edges are equal. else,<code>false</code>.
	 */
    @Override
	public boolean equals(Object other){
		if(other instanceof AbstractEdge){
			AbstractEdge e = (AbstractEdge)other;
			return (e.from.equals(this.from) && e.to.equals(this.to)) ||  (e.from.equals(this.to) && e.to.equals(this.from));
		}
		throw new ClassCastException(other.getClass()+" Can not be casted to "+this.getClass());
	}	

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.from);
        hash = 59 * hash + Objects.hashCode(this.to);
        return hash;
    }
}
