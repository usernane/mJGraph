/**
 * @(#)AbstractEdge.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */

package ics202.project.edges;
/**
 *	A simple edge with no direction or weight.
 *  @param <VType> The type of vertices that will be linked together.
 */
public class UndirectedEdge<VType> extends AbstractEdge<VType> {
	/**
	 * 
	 *
	 *	Creates a new instance of <code>UndirectedEdge</code>.
     *  @param from the source vertex.
     *  @param to the target vertex.
	 */
	public UndirectedEdge(VType from, VType to) {
		// TODO: Add your code here
		super(from,to);
	}

    /**
     * Creates a new instance of <code>UndirectedEdge</code>.
     */
    public UndirectedEdge() {
    	this(null,null);
	}	
	/**
	 * Returns the source of that edge.
	 *
	 *
	 * @return An object that represents the source.
	 *
	 */
    @Override
	public VType getSource() {
		// TODO: Add your code here
		return super.from;
	}

	/**
	 * Returns the target of that edge
	 *
	 *
	 * @return An object that represents the target
	 *
	 */
    @Override
	public VType getTarget() {
		// TODO: Add your code here
		return super.to;
	}
	/**
	 *	Returns string representation of <code>UndirectedEdge</code>.
	 *	@return <code>String</code> object.
	 */
    @Override
	public String toString(){
		return this.from+"----"+this.to; 
	}
}
