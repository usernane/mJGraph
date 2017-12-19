package ics202.project.vertices;
/**
 *	This class is used for graph traversals.
 * @param <VType> the data that will be stored on the vertex.
 */
public class TraversalVertex<VType> extends Vertex<VType> {
	private boolean visited = false;	
	/**
	 *	Creates new instance of <code>TraversalVertex</code>.
         * @param v the data that will be stored on the vertex.
	 */
	public TraversalVertex(VType v){
		super(v);
	}
	/**
	 *	Creates a copy of <code>TraversalVertex</code>.
         * @param v the vertex that will be copied.
	 */
	public TraversalVertex(Vertex<VType> v){
		super(v);
	}
	/**
	 * Checks if the vertex is visited or not
	 *
	 *
	 * @return <code>true</code> if the vertex is visited. else, <code>false</code>.
	 *
	 */
	public boolean visited() {
		// TODO: Add your code here
		return this.visited;
	}
	/**
	 *	Mark the vertex as visited.
	 */
	public void visit(){
		this.visited = true;
	}	
}
