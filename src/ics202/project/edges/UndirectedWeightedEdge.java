
/**
 * @(#)UndirectedEdge.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */
package ics202.project.edges;
/**
 *	This class represents an edge that has only weight.
 *  @param <VType> Type of vertices that will be linked together.
 */

public class UndirectedWeightedEdge<VType> extends UndirectedEdge<VType> implements Comparable<UndirectedWeightedEdge<VType>>{
	private double weight = 1;	
	/**
	 * Creates new instance of <code>UndirectedWeightedEdge</code>.
	 *
	 *	@param from The vertex that the edge is coming from.
	 *	@param to The vertex that the edge is going to.
	 *	@param weight The weight that will be assigned to that edge.
	 */
	public UndirectedWeightedEdge(VType from, VType to,double weight) {
		super(from,to);
		this.weight = weight;
	}
	/**
	 * Creates new instance of <code>UndirectedWeightedEdge</code>.
	 *
	 *	@param from The vertex that the edge is coming from.
	 *	@param to The vertex that the edge is going to.
	 */
	public UndirectedWeightedEdge(VType from, VType to) {
		this(from,to,0);
	}
	/**
	 * Returns the weight of the edge.
	 *
	 *
	 * @return the weight of the edge as a <code>double</code>.
	 *
	 */
	public double getWeight() {
		return this.weight;
	}
	/**
	 *	Checks if another object is equal to this object.
	 *
	 *	Two weighted edges are equal if the weight is equal and the sources are equal and the targets are equal.
     *  @param other the edge that will be checked.
	 */
        @Override
	public boolean equals(Object other){
		if(other instanceof UndirectedWeightedEdge){
			UndirectedWeightedEdge tmp = (UndirectedWeightedEdge)other;
			return super.equals(other) && tmp.getWeight() == this.weight;
		}
		throw new ClassCastException(other.getClass()+" Can not be casted to "+this.getClass());
	}
        //this method is generated automatically in netbeans IDE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }
	/**
	 *	Returns string representation of <code>UndirectedEdge</code>.
     *  @param edge the edge that will be compared with the current edge.
	 *  @return <code>String</code> object.
	 */
    @Override
	public int compareTo(UndirectedWeightedEdge<VType> edge){
		return (int)(this.weight*10000 - edge.weight*10000);
	}
    @Override
	public String toString(){
		return super.from+"--["+this.weight+"]--"+super.to;
	}	
}
