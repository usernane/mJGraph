 /**
 * @(#)Traversal.java
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/29
 */
package ics202.project.traversals;

import java.util.NoSuchElementException;

/**
 *
 * @param <VType> the type of graph vertices.
 */
public interface Traversal<VType> {
	
	/**
	 *	Checks if there are more elements left to visit.
	 *
	 *	@return <code>true</code> if there are more elements left to visit. else, <code>false</code>.
	 *
	 */
	public boolean hasNext();

	/**
	 *	Returns the next element to visit on the graph.
	 *	@return the next element to visit.
	 *	@throws NoSuchElementException if there are no more elements to visit.
	 */
	public VType next() throws NoSuchElementException;	
}
