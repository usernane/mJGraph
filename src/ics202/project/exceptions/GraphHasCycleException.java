/**
 * @(#)GraphHasCycleException.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/29
 */
package ics202.project.exceptions;
/**
 *	This exception is thrown when performing a topological sort to indicate that the graph has cycles.
 */
public class GraphHasCycleException extends RuntimeException{
	/**
	 *	Creates new instance of <code>GraphHasCycleException</code>.
	 *	@param message the message that will be displayed when the exception occurs.
	 */
    public GraphHasCycleException(String message) {
    	super(message);
    }
    /**
     *	Creates new instance of <code>GraphHasCycleException</code>.
     */
    public GraphHasCycleException() {
    	super("The given graph has cycles");
    }
    
}