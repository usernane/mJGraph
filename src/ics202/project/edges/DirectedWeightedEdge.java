package ics202.project.edges;
/**
 *	An edge that has weight and direction.
 *  @param <VType> the type of the vertices that will be liked together.
 */
public class DirectedWeightedEdge<VType> extends DirectedEdge<VType> implements Comparable<DirectedWeightedEdge<VType>>{
	private double weight;
	/**
	 * Creates new instance of <code>DirectedWeightedEdge</code>. with specific weight. 
	 *
	 *
     * @param from the source vertex.
     * @param to the target vertex.
     * @param weight the weight of the edge.
	 */
	public DirectedWeightedEdge(VType from, VType to, double weight) {
		// TODO: Add your code here
		super(from,to);
		this.weight = weight;
	}
	/**
	 * Creates new instance of <code>DirectedWeightedEdge</code>. with initial weight equal to 0.
	 *
	 *
     * @param from the source vertex.
     * @param to the target vertex.
	 */
	public DirectedWeightedEdge(VType from, VType to) {
		// TODO: Add your code here
		this(from,to,0);
	}

    /**
     *  Creates an instance of <code>DirectedWeightedEdge</code>.
     *  @param e the edge that will be copied.
     */
     public DirectedWeightedEdge(AbstractEdge<VType> e) {
	 	this(e.getSource(),e.getTarget());
       	if(e instanceof DirectedWeightedEdge){
            DirectedWeightedEdge tmpE = (DirectedWeightedEdge)e;
            this.weight = tmpE.getWeight();
        }
        else{
            this.weight = 0;
        }
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
		return super.getSource();
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
		return super.getTarget();
	}
	/**
	 *	Returns the weight of the edge.
	 *	@return the weight of the edge.
	 */
	public double getWeight(){
		return this.weight;
	}
	/**
	 *	Checks if another edge is equal to this edge.
	 *
	 *  Two edges is equal if their sorces is equals and targets and their weight is equal.
	 *
	 *	@return <code>true</code> if the two are equals. else, <code>false</code>. 
	 */
	@Override
	public boolean equals(Object other){
		if(other instanceof DirectedWeightedEdge<?>){
			DirectedWeightedEdge<?> tmp = (DirectedWeightedEdge<?>)other;
			return super.equals(other) && this.weight == tmp.weight;
		}
		throw new ClassCastException(other.getClass()+" can not be casted to DirectedWeightedEdge");
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }
	@Override
	public String toString(){
		return super.from+"--["+this.weight+"]-->"+super.to;
	}
	/**
	 *	Returns string representation of <code>UndirectedEdge</code>.
     *  @param edge the edge that will be used for comparative.
	 *	@return <code>String</code> object.
	 */
    @Override
	public int compareTo(DirectedWeightedEdge<VType> edge){
		return (int)(this.weight*10000 - edge.weight*10000);
	}	
}
