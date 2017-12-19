/**
 * @(#)DirectedGraph.java
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/22
 */
package ics202.project.graph;

import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchEdgeException;
import ics202.project.util.LinkedList;
import ics202.project.edges.DirectedEdge;
import ics202.project.edges.AbstractEdge;
import ics202.project.vertices.Vertex;
import ics202.project.traversals.TopologicalOrder;
import ics202.project.exceptions.GraphHasCycleException;
/**
 *	Each edge on that graph can have only one direction.
 *  @param <VType> the type of graph vertices.
 */
public class DirectedGraph<VType> extends AbstractGraph<VType> {
	
	
	/**
	 * Creates new instance of <code>DirectedGraph</code>
	 *
	 *
	 */
	public DirectedGraph() {
		super.graphList = new LinkedList<>();
	}
	/**
	 * Creates new instance of <code>DirectedGraph</code> from a base graph.
	 *
	 *
     * @param g the graph that will be copied.
	 */
	public DirectedGraph(DirectedGraph<VType> g) {
		super.graphList = g.graphList;
	}
	public void addElement(VType el){
		this.addVertex(el);
	}
	/**
	 * Adds new vertex to the graph.
	 *
	 * If the vertex is already on the graph it will not be added to the graph.
	 *
	 * @param v the vertex that will be added to the graph.
	 *
	 */
        @Override
	public void addVertex(VType v) {
		if(this.containsVertex(v))
			return;
			
		super.graphList.add(new Vertex<>(v));
	}
	/**
	 * Adds new edge to the graph between two vertices.
	 *
	 * If the edge that will be added to the graph is already added, it will not be added.
	 *
	 * @param from the source vertex.
	 * @param to the target vertex.
	 *
	 @throws NoSuchVertexException if one of the two vertices is not on the graph.
	 *
	 */
    @Override
	public void addEdge(VType from, VType to) throws NoSuchVertexException {
		if(this.containsVertex(from)){
			if(this.containsVertex(from)){
				if(this.containsEdge(from,to))
					return;
					
				super.graphList.get(new Vertex<>(from)).addEdge(new DirectedEdge<>(from,to));
				return;
			}
			throw new NoSuchVertexException("("+to+") is not on the graph");
		}
		throw new NoSuchVertexException("("+from+") is not on the graph");
	}
	/**
	 * Checks if a specific edge is on the graph or not.
	 *
	 *
	 * @param from the source vertex.
	 * @param to the target vertex.
	 *
	 @throws NoSuchVertexException if one of the vertices is not on the graph.
	 *
	 * @return <code>true</code> if the edge is on the graph. else <code>false</code>.
	 *
	 */
    @Override
	public boolean containsEdge(VType from, VType to) throws NoSuchVertexException {
		if(this.containsVertex(from)){
			if(this.containsVertex(to)){
				LinkedList<AbstractEdge<VType>> edgeList = super.graphList.get(new Vertex<>(from)).getEdges();
				DirectedEdge<VType> edge = new DirectedEdge<>(from,to);
				for(int i = 0, n = edgeList.size() ; i < n ; i++){
					if(edge.equals(edgeList.get(i))){
						return true;
					}
				}
			}
			else{
				throw new NoSuchVertexException("("+to+") is not on the graph");
			}
		}
		else{
			throw new NoSuchVertexException("("+from+") is not on the graph");
		}
		return false;
	}
	/**
	 * Checks if a specific vertex is on the graph or not.
	 *
	 *
	 * @param v the vertex that will be checked.
	 *
	 * @return <code>true</code> if the vertex is on the graph. else, <code>false</code>.
	 *
	 */
    @Override
	public boolean containsVertex(VType v) {
		return super.graphList.contains(new Vertex<>(v));
	}

	/**
	 * Returns the specific vertex if it is on the graph.
	 *
	 *
	 * @param v the vertex that will be checked.
	 *
	 * @throws NoSuchVertexException if the vertex is not on the graph.
	 *
	 * @return the information of that vertex.
	 *
	 */
    @Override
	public VType getVertex(VType v) throws NoSuchVertexException {
		if(this.containsVertex(v)){
			return super.graphList.get(new Vertex<>(v)).getData();
		}
		throw new NoSuchVertexException("Vertex "+v+" is not on the graph");
	}

	/**
	 * Returns the specified edge.
	 *
	 *
	 * @param e the edge that will be checked.
	 *
	 *	@throws NoSuchEdgeException if the edge is not on the graph.
	 *
	 * @return the edge.
	 *
	 */
    @Override
	public AbstractEdge<VType> getEdge(AbstractEdge<VType> e) throws NoSuchEdgeException {
		if(e instanceof DirectedEdge){
			if(this.containsEdge(e.getSource(),e.getTarget())){
				return super.graphList.get(new Vertex<>(e.getSource())).getEdges().get(e);
			}
			throw new NoSuchEdgeException("Edge ("+e+" is not on the graph");
		}
		throw new ClassCastException(e.getClass()+" can not be casted to "+new DirectedEdge<VType>().getClass());
	}

	/**
	 * Returns the edge that is linking between the two vertices.
	 *
	 *
	 * @param from the source vertex.
	 * @param to the target vertex.
	 *
	 * @return the edge that is linking between the two vertices.
	 *	@throws NoSuchVertexException if one of the two vertices is not on the graph.
	 *	@throws NoSuchEdgeException if there is no edge that links the two vertices. 
	 *
	 */
    @Override
	public AbstractEdge<VType> getEdge(VType from, VType to)throws NoSuchVertexException,NoSuchEdgeException{
		if(this.containsVertex(from)){
			if(this.containsVertex(to)){
				if(this.containsEdge(from,to)){
					return this.getEdge(new DirectedEdge<>(from,to));
				}
				throw new NoSuchEdgeException("Edge ("+from+"-->"+to+") is not on the graph");
			}
			throw new NoSuchVertexException("Vertex "+to+" is not on the graph");
		}
		throw new NoSuchVertexException("Vertex "+from+" is not on the graph");
	}
	/**
	 * Returns the whole edges on the graph.
	 *
	 *
	 * @return <code>LinkedList</code> that contains all of the edges that is on the graph.
	 *
	 */
    @Override
	public LinkedList<AbstractEdge<VType>> getEdges() {
		LinkedList<AbstractEdge<VType>> edgeList = new LinkedList<>();
		for(int i = 0 , n = super.graphList.size() ; i < n ; i++){
			Vertex<VType> tmp = super.graphList.get(i);
			for(int j = 0, h = tmp.getDegree() ; j < h ; j++){
				edgeList.add(tmp.getEdge(j));
			}
		}
		return edgeList;
	}

	/**
	 * Returns the whole vertices on the graph.
	 *
	 *
	 * @return <code>LinkedList</code> that contains all the vertices that is on the graph.
	 *
	 */
    @Override
	public LinkedList<VType> getVertices() {
		LinkedList<VType> vertexList = new LinkedList<>();
		for(int i = 0 , n = super.graphList.size() ; i < n ; i++){
			vertexList.add(super.graphList.get(i).getData());
		}
		return vertexList;
	}
	/**
	 *	Returns a <code>LinkedList</code> that represents the graph.
	 *	@return <code>LinkedList</code> that represents the graph
	 */
    @Override
	public LinkedList<Vertex<VType>> getGraphAsList(){
		return super.graphList;
	}
	/**
	 *	Checks if the graph has vertices or not.
	 *	@return <code>true</code> if the graph has vertices. else, <code>false</code>.
	 */
    @Override
	public boolean hasVertices(){
		return !super.graphList.isEmpty();
	}
	/**
	 *	Checks if the graph has edges or not.
	 *	@return <code>true</code> if the graph has edges. else, <code>false</code>.
	 */
    @Override
	public boolean hasEdges(){
		for(int i = 0, n = super.graphList.size() ; i < n ; i++){
			if(!super.graphList.get(i).getEdges().isEmpty())
				return true;
		}
		return false;
	}
	/**
	 *	Checks if the graph has cycles or not.
	 *
	 *	In order to check, we have to perform topological sort on the graph.
	 *	If an exception accrues, then there must be a cycle on the graph.
	 *	@return <code>true</code> if the graph has cycles. else, <code>false</code>.
	 */
	public boolean hasCycles(){
		try{
                         new TopologicalOrder<>(this);
			 return false;
		}
		catch(GraphHasCycleException e){
			return true;
		}
	}
	/**
	 *	Returns the number of edges that is coming ino a specific vertex.
	 *	@return number of edges that is coming ino a specific vertex.
	 *	@throws NoSuchVertexException if the vertex is not on the graph.
	 *	@param v the vertex that the method will return its degree.
	 */
	public int inDegreeOf(VType v)throws NoSuchVertexException{
		if(this.containsVertex(v)){
			int inDeg = 0;
			for(int i = 0 , n = super.graphList.size() ; i < n ; i++){
				Vertex<VType> tmpV = super.graphList.get(i);
				for(int j = 0, h = tmpV.getEdges().size() ; j < h ; j++){
					if(v.equals(tmpV.getEdges().get(j).getTarget()))
						inDeg++;
				}
			}
			return inDeg;
		}
		throw new NoSuchVertexException("Vertex ("+v+") is not on the graph");
	}
	/**
	 * Checks if the graph is empty or not.
	 *
	 *
	 * @return <code>true</code> if the graph is empty. else <code>false</code>.
	 *
	 */
	public boolean isEmpty() {
		// TODO: Add your code here
		return super.graphList.isEmpty();
	}
	

	/**
	 * Returns the number of vertices on the graph.
	 *
	 *
	 * @return the number of vertices on the graph.
	 *
	 */
    @Override
	public int numberOfVertices() {
		return super.graphList.size();
	}

	/**
	 * Returns the number of edges on the graph.
	 *
	 *
	 * @return the number of edges on the graph.
	 *
	 */
    @Override
	public int numberOfEdges() {
		int numOfEdges = 0;
		for(int i = 0 , n = super.graphList.size() ; i < n ; i++){
			numOfEdges += super.graphList.get(i).getDegree();
		}
		return numOfEdges;
	}

	
	/**
	 * Returns the out-degree of a specific vertex.
	 *
	 *
	 * @param v the vertex that will be checked.
	 *
	 @throws NoSuchVertexException if the vertex is not on the graph.
	 *
	 * @return the number of out-edges on a vertex.
	 *
	 */
	public int outDegreeOf(VType v) throws NoSuchVertexException {
		if(this.containsVertex(v)){
			super.graphList.get(new Vertex<>(v)).getDegree();
		}
		throw new NoSuchVertexException("Vertex ("+v+") is not on the graph");
	}
	
	/**
	 * Removes a specific edge from the graph.
	 *
	 *
	 * @param from the source vertex.
	 * @param to the target vertex.
	 *
	 @throws NoSuchEdgeException if there is no edge links the two vertices.
	 @throws NoSuchVertexException if one of the two vertices is not on the graph.
	 *
	 * @return the edge after removal.
	 *
	 */
    @Override
	public AbstractEdge<VType> removeEdge(VType from, VType to) throws NoSuchEdgeException, NoSuchVertexException {
		if(this.containsVertex(from)){
			if(this.containsVertex(to)){
				if(this.containsEdge(from,to)){
					return super.graphList.get(new Vertex<>(from)).removeEdge(new DirectedEdge<>(from,to));
				}
				throw new NoSuchEdgeException("Edge ("+from+"-->"+to+") is not on the graph");
			}
			throw new NoSuchVertexException("Vertex ("+to+") is not on the graph");
		}
		throw new NoSuchVertexException("Vertex ("+from+") is not on the graph");
	}
	public AbstractEdge<VType> removeEdge(VType v)throws NoSuchVertexException,NoSuchEdgeException{
		if(this.containsVertex(v)){
			return super.graphList.get(new Vertex<>(v)).removeEdge(); 
		}
		throw new NoSuchVertexException("Vertex +("+v+") is no on the graph");
	}
	/**
	 * Removes specific vertex from the graph.
	 *
	 *
	 * @param v the vertex that will be removed.
	 *
	 *	@throws NoSuchVertexException if the vertex is not on the graph.
	 *
	 * @return the vertex after removal.
	 *
	 */
    @Override
	public VType removeVertex(VType v) throws NoSuchVertexException {
		if(this.containsVertex(v)){
			VType tmp = super.graphList.remove(new Vertex<>(v)).getData();
			for(int i = 0, n = super.graphList.size() ; i < n ; i++){
				LinkedList<AbstractEdge<VType>> edges = super.graphList.get(i).getEdges();
				//we have to check the size regularly;
				for(int j = 0 ; j < edges.size() ; j++){
					if(edges.get(j).getTarget().equals(tmp)){
						super.graphList.get(i).removeEdge(edges.get(j));
					}
				}
			}
			return tmp;
		}
		throw new NoSuchVertexException(v+" is not on the graph");
	}
	
	

	
	/**
	 *	Returns <code>String</code> representation of the graph.
	 *	@return <code>String</code> object.
	 */
    @Override
	public String toString(){
		String ed = " Edges: ";
		String vrt = "";
		if(isEmpty()){
			return "Vertices: No verteses Edges : No edges";
		}
		vrt += "Vertices: "+super.graphList;
		for(int i = 0, n = super.graphList.size() ; i < n ; i++){
			if(!super.graphList.get(i).getEdges().isEmpty()){
				ed += super.graphList.get(i).getEdges() +" ";
			}
		}
		if(ed.equals(" Edges: ")){
			ed += "No edges";
		}
		return vrt + ed;
	}
			
}
