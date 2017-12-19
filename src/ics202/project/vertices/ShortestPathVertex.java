package ics202.project.vertices;

import ics202.project.edges.DirectedWeightedEdge;

/**
 *
 * @author Ibrahim
 * @param <VType> the data that will be stored on the vertex.
 */
public class ShortestPathVertex<VType> extends TraversalVertex<VType> implements Comparable<ShortestPathVertex<VType>>{
	
	private double distance = Double.MAX_VALUE;	
	private DirectedWeightedEdge<VType> edge = null;
	/**
	 * Creates new instance of <code>DirectedWeightedEdge</code>.
	 *
	 *
         * @param v the source <code>Vertex</code> object.
         * @param edge edge that will be added to the vertex.
         * @param distance the distance to that vertex.
	 */
	public ShortestPathVertex(Vertex<VType> v,DirectedWeightedEdge<VType> edge, double distance) {
		super(v);
		// TODO: Add your code here
		this.distance = distance;
		this.edge = edge;
	}
	public ShortestPathVertex(Vertex<VType> v, double distance) {
		super(v);
		this.distance = distance;
	}
	public ShortestPathVertex(VType v) {
		super(v);
	}
	public ShortestPathVertex(Vertex<VType> v){
		super(v);
	}
	
        @Override
	public int compareTo(ShortestPathVertex<VType> obj){
		//there was a bug in here 
		return (int)(this.distance*100000 - obj.distance*100000);
	}
	/**
	 * Method getPrevVertex
	 *
	 *
	 * @return the edge on that vertex.
	 *
	 */
	public DirectedWeightedEdge<VType> getEdge() {
		// TODO: Add your code here
		return this.edge;
	}	

    /**
     *  Returns the distance that is stored on the vertex.
     * @return the distance that is stored on the vertex.
     */
    public double getDistance() {
		// TODO: Add your code here
		return this.distance;
	}

    /**
     *  Sets the edge on the vertex.
     * @param edge the edge that will be added to the vertex.
     */
    public void setEdge(DirectedWeightedEdge<VType> edge) {
		// TODO: Add your code here
		this.edge = edge;
	}	

    /**
     *  Sets the distance to the vertex.
     * @param d the distance that will be set.
     */
    public void setDistance(double d) {
		// TODO: Add your code here
		this.distance = d;
	}
        @Override
	public String toString(){
		return super.toString()+"["+this.distance+"]";
	}
}
