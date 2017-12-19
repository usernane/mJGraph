/**
 * @(#)NoSuchEdgeException.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/21
 */

package ics202.project.exceptions;
import java.util.NoSuchElementException;

/**
 *	Thrown to indicate that a specific edge is not exist on a graph.
 */
 
public class NoSuchEdgeException extends NoSuchElementException {
	
	/**
	 * Creates new instance of <code>NoSuchEdgeException</code> with specific message.
	 *
	 *
     * @param message the message that will be displayed.
	 */
	public NoSuchEdgeException(String message) {
		// TODO: Add your code here
		super(message);
	}
	/**
	 * Creates new instance of <code>NoSuchEdgeException</code>.
	 *
	 *
	 */
	public NoSuchEdgeException() {
		// TODO: Add your code here
		super("");
	}	
}
