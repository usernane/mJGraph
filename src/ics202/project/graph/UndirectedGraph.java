/**
 * @(#)UndirectedGraph.java
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */
package ics202.project.graph;

import ics202.project.vertices.Vertex;
import ics202.project.util.LinkedList;
import ics202.project.edges.UndirectedEdge;
import ics202.project.edges.AbstractEdge;
import ics202.project.exceptions.NoSuchVertexException;
import ics202.project.exceptions.NoSuchEdgeException;
/**
 *	The edges of this class dose not have specific direction.
 *      @param <VType> the type of graph vertices.
 */
public class UndirectedGraph<VType> extends AbstractGraph<VType> {
	
	/**
	 * Creates new instance of <code>UndirectedGraph</code>.
	 *
	 *
	 */
	public UndirectedGraph() {
		// TODO: Add your code here
		super.graphList = new LinkedList<>();
	}

	/**
	 * Adds new vertex to the graph.
	 *	If the vertex is on the graph, it will not be added to the graph.
	 * @param v the vertex that will be added.
	 */
    @Override
	public void addVertex(VType v) {
		if(this.containsVertex(v))
			return;
			
		super.graphList.add(new Vertex<>(v));
	}
    /**
	 * Adds a new edge to the graph between two specific vertices.
	 * @param from the vertex that the edge will come from.
	 * @param to the vertex that the edge will go to.
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 *
	 */
    @Override
	public void addEdge(VType from, VType to) throws NoSuchVertexException{
		if(this.containsVertex(from)){
			if(this.containsVertex(to)){
				if(this.containsEdge(from,to))
					return;
					
				super.graphList.get(new Vertex<>(from)).addEdge(new UndirectedEdge<>(from,to));
				//since the graph is undirected, we have to add an edge to the other vertex
				super.graphList.get(new Vertex<>(to)).addEdge(new UndirectedEdge<>(to,from));
				return;
			}
			throw new NoSuchVertexException("Vertex ("+to+") is not in the graph");	
		}
		throw new NoSuchVertexException("Vertex ("+from+") is not in the graph");
	}
	/**
	 * Checks if a specific vertex is on the graph or not.
	 * @param v the vertex that will be checked.
	 * @return <code>true</code>if the vertex is on the graph. else, <code>false</code>.
	 */
    @Override
	public boolean containsVertex(VType v) {
		return super.graphList.contains(new Vertex<>(v));
	}
	
	/**
	 * Checks if a specific edge that is linking between two vertices is on the graph or not.
	 * @param from the vertex that the edge is coming from.
	 * @param to the vertex that the edge is going to.
	 * @return <code>true</code> if the edge exist. Else, <code>false</code>.
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 */
    @Override
	public boolean containsEdge(VType from, VType to) throws NoSuchVertexException{
		if(this.containsVertex(from)){
			if(this.containsVertex(to)){
				
				Vertex<VType> tmp = this.getGraphAsList().get(new Vertex<>(from));
				for(int i = 0, n = tmp.getDegree() ; i < n ; i++){
					AbstractEdge<VType> tmpEdge = (AbstractEdge<VType>)tmp.getEdge(i);
					//class cast
					UndirectedEdge tmpEdge2 = new UndirectedEdge<>(from,to);
					if(tmpEdge2.equals(tmpEdge)){
						return true;
					}
				}
				tmp = this.getGraphAsList().get(new Vertex<>(to));
				for(int i = 0, n = tmp.getDegree() ; i < n ; i++){
					AbstractEdge<VType> tmpEdge = (AbstractEdge<VType>)tmp.getEdge(i);
					UndirectedEdge tmpEdge2 = new UndirectedEdge<>(from,to);
					if(tmpEdge2.equals(tmpEdge)){
						return true;
					}
				}
				return false;
			}
			throw new NoSuchVertexException("Vertex ("+to+") is not in the graph");
		}
		throw new NoSuchVertexException("Vertex ("+from+") is not in the graph");
	}
	/**
	 * Checks if a specific edge that is linking between two vertices is on the graph or not.
	 * @param e the edge that will be checked.
	 * @return <code>true</code> if the edge exist. Else, <code>false</code>.
	 */
	public boolean containsEdge(AbstractEdge<VType> e){
		for(int i = 0, n = super.graphList.size() ; i < n ; i++){
			Vertex<VType> tmp = super.graphList.get(i);
			for(int j = 0, h = tmp.getDegree() ; j < h ; j++){
				if(e.equals(tmp.getEdge(i)))
					return true;
			}
		}
		return false;
	}
	/**
	 *	Returns the specific edge from the graph.
	 *	@param e the edge that will be checked.
	 *	@return <code>AbstractEdge</code> object.
	 *	@throws NoSuchEdgeException if the edge is not in the graph.
	 */
    @Override
	public AbstractEdge<VType> getEdge(AbstractEdge<VType> e) throws NoSuchEdgeException {
		if(e instanceof UndirectedEdge){
			if(this.containsEdge(e.getSource(),e.getTarget())){
				return super.graphList.get(new Vertex<>(e.getSource())).getEdges().get(e);
			}
			throw new NoSuchEdgeException("Edge ("+e+" is not on the graph");
		}
		throw new ClassCastException(e.getClass()+" can not be casted to "+new UndirectedEdge<VType>().getClass());
	}
	/**
	 *	Returns the specific vertex from the graph.
	 *	@param v the vertex that will be checked.
	 *	@return the information on that vertex.
	 *	@throws NoSuchVertexException if the vertex is not in the graph.
	 */
        @Override
	public VType getVertex(VType v)throws NoSuchVertexException{
		if(this.containsVertex(v)){
			return super.graphList.get(new Vertex<>(v)).getData();
		}
		throw new NoSuchVertexException(v+" is not on the graph");
	}
	/**
	 *	Returns a <code>LinkedList</code> that contains all the vertices on the graph.
	 *	@return a <code>LinkedList</code> that contains all the vertices on the graph.
	 */
        @Override
	public LinkedList<VType> getVertices(){
		LinkedList<VType> list = new LinkedList<>();
		for(int i = 0, n = super.graphList.size() ; i <n ; i++){
			list.add(super.graphList.get(i).getData());
		}
		return list;
	}
    @Override
	public AbstractEdge<VType> getEdge(VType from, VType to){
		if(this.containsVertex(from) && this.containsVertex(to)){
			return this.getEdge(new UndirectedEdge<>(from,to));
		}
		throw new NoSuchVertexException();
	}
	/**
	 *	Returns a <code>LinkedList</code> that contains all the edges on the graph.
	 *	@return a <code>LinkedList</code> that contains all the edges on the graph.
	 */
    @Override
	public LinkedList<AbstractEdge<VType>> getEdges(){
		LinkedList<AbstractEdge<VType>> list = new LinkedList<>();
		for(int i = 0, n = super.graphList.size() ; i <n ; i++){
			Vertex<VType> tmp = super.graphList.get(i);
			for(int j = 0, h = tmp.getDegree(); j < h ; j++){
				list.add(tmp.getEdges().get(j));
			}
		}
		return list;
	}
	/**
	 *	Returns a <code>LinkedList</code> that represents the graph.
	 *	@return <code>LinkedList</code> that represents the graph
	 */
    @Override
	public LinkedList<Vertex<VType>> getGraphAsList(){
		return new LinkedList<>(super.graphList);
	}
	
    @Override
	public boolean hasVertices(){
		return !super.graphList.isEmpty();
	}
    @Override
	public boolean hasEdges(){
		for(int i = 0, n = super.graphList.size() ; i < n ; i++){
			if(!super.graphList.get(i).getEdges().isEmpty())
				return true;
		}
		return false;
	}
	/**
	 * Checks if the graph is emtpty or not.
	 *
	 *
	 * @return <code>true</code>if the graph is empty. Else, <code>false</code>
	 *
	 */
	public boolean isEmpty() {
		return super.graphList.isEmpty();
	}
	
	/**
	 * Returns the number of edges that is coming out from a specific vertex.
	 *
	 *
	 * @param v the vertex that will be checked.
	 *
	 * @return number of edges that is coming out from the vertex.
	 * @throws NoSuchVertexException if the vertex is not on the graph.
	 *
	 */
	public int degreeOf(VType v) throws NoSuchVertexException{
		if(this.containsVertex(v)){
			return super.graphList.get(new Vertex<VType>(v)).getDegree();
		}
		throw new NoSuchVertexException(v+" is not in the graph");
	}
	
	/**
	 * Removes a specific vertex from the graph.
	 * @param v the vertex that will be removed.
	 * @return the information on that vertex after removal.
	 * @throws NoSuchVertexException if the vertex dose not exist on the graph.
	 *
	 */
    @Override
	public VType removeVertex(VType v) throws NoSuchVertexException{
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
		throw new NoSuchVertexException("Vertex ("+v+") is not in the graph");
	}

	/**
	 * Returns the number of vertices on the graph.
	 * @return the number of vertices on the graph.
	 */
    @Override
	public int numberOfVertices() {
		return super.graphList.size();
	}

	/**
	 * Returns the number of edges on the graph.
	 * @return the number of edges on the graph.
	 */
    @Override
	public int numberOfEdges() {
		int numEd = 0;
		for(int i = 0, n = super.graphList.size() ; i < n ; i++){
			numEd += super.graphList.get(i).getDegree();
		}
		return (int)numEd/2;
	}
	public AbstractEdge<VType> removeEdge(VType v)throws NoSuchVertexException,NoSuchEdgeException{
		if(this.containsVertex(v)){
			return super.graphList.get(new Vertex<>(v)).removeEdge(); 
		}
		throw new NoSuchVertexException("Vertex +("+v+") is not on the graph");
	}
	/**
	 * Removes a specific edge that is linking between two vertices.
	 *
	 *
	 * @param from the vertex that the edge is coming from.
	 * @param to the vertex that the edge is going to.
	 * @return the edge after removal.
	 * @throws NoSuchVertexException if one of the vertices is not on the graph.
	 * @throws NoSuchEdgeException if there is no edge between the two vertices.
	 *
	 */
    @Override
	public AbstractEdge<VType> removeEdge(VType from, VType to)throws NoSuchEdgeException {
		if(this.containsEdge(from,to)){
			super.graphList.get(new Vertex<>(to)).removeEdge(new UndirectedEdge<>(to,from));
			return super.graphList.get(new Vertex<>(from)).removeEdge(new UndirectedEdge<>(from,to));
		}
		throw new NoSuchEdgeException("Edge ("+from+"----"+to+") is not on the graph");
	}
	
	/**
	 *	Returns <code>String</code> representation of the graph.
     * @return <code>String</code> object.
	 */
    @Override
	public String toString(){
		String ed = " Edges: ";
		String vrt = "";
		if(isEmpty()){
			return "Vertices: No verteses Edges : No edges";
		}
		vrt += "Vertices: "+super.graphList;
		LinkedList<AbstractEdge<VType>> edgesList = new LinkedList<>();
		
		for(int i = 0, n = super.graphList.size() ; i < n ; i++){
			if(!super.graphList.get(i).getEdges().isEmpty()){
				LinkedList<AbstractEdge<VType>> tmpEdgesList = super.graphList.get(i).getEdges();
				for(int j = 0 , h = tmpEdgesList.size(); j < h ; j++){
					if(!edgesList.contains(tmpEdgesList.get(j))){
						edgesList.add(tmpEdgesList.get(j));
					}
						
				}
			}
		}
		if(edgesList.isEmpty()){
			ed += "No edges";
		}
		else
			ed += edgesList;
		return vrt + ed;
	}
		
}
