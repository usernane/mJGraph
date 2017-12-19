/**
 * @(#)NoSuchVertexException.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */
package ics202.project.exceptions;

import java.util.NoSuchElementException;
/**
 *	Thrown to indicate that a specific vertex is not on the graph.
 */
public class NoSuchVertexException extends NoSuchElementException {
	
	/**
	 * Creates new instance of <code>NoSuchVertexException</code> with specific message.
	 *
	 *
     * @param message the message that will be displayed.
	 */
	public NoSuchVertexException(String message) {
		super(message);
	}
	/**
	 * Creates new instance of <code>NoSuchVertexException</code>.
	 *
	 *
	 */
	public NoSuchVertexException() {
		this("");
	}	
}
