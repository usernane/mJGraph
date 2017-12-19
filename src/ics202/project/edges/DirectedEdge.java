package ics202.project.edges;
/**
 *	An edge that has only one direction. Used to build directed graphs.
 *	The direction is specified by "<code>equals()</code>" method
 *  @param <VType> the type of vertices that will be linked together.
 */
public class DirectedEdge<VType> extends AbstractEdge<VType> {
	
	/**
	 * Creates new instance of <code>DirectedEdge</code> with specific starting point and ending point.
	 *
	 *	@param from the source vertex
	 *	@param to the target vertex
	 */
	public DirectedEdge(VType from, VType to) {
		// TODO: Add your code here
		super(from,to);
	}
	/**
	 * Creates new instance of <code>DirectedEdge</code> with <code>null</code> starting and ending point.
	 *
	 */
	public DirectedEdge() {
		// TODO: Add your code here
		this(null,null);
	}
	/**
	 * Returns the source of the edge.
	 *
	 *
	 * @return the source of the edge.
	 *
	 */
    @Override
	public VType getSource() {
		// TODO: Add your code here
		return super.from;
	}

	/**
	 * Returns the target of the edge.
	 *
	 *
	 * @return the target of the edge.
	 *
	 */
    @Override
	public VType getTarget() {
		// TODO: Add your code here
		return super.to;
	}
	/**
	 *	Returns string representation of edge.
	 *	@return <code>String</code> object.
	 */
    @Override
	public String toString(){
		return super.from+"---->"+super.to;
	}
	/**
	 *	Checks if two edges are equal.
	 *	Two directed edges are equal if their source vertices are the same and their target vertices are the same.
     *  @param other the edge that will be checked.
     *  @return <code>true</code> if the edges are equal. else, <code>false</code>.
	 */ 
    @Override
	public boolean equals(Object other){
		if(other instanceof AbstractEdge){
			AbstractEdge tmp = (AbstractEdge)other;
			return this.getSource() == tmp.getSource() && this.getTarget() == tmp.getTarget();
		}
		return false;
	}	

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
