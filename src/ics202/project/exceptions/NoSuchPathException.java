/**
 * @(#)GraphHasCycleException.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/5/5
 */

package ics202.project.exceptions;

import java.util.NoSuchElementException;

/**
 *
 * @author Ibrahim
 * thrown to indicate that a specific path is not on the graph.
 */
public class NoSuchPathException extends NoSuchElementException {
	
    /**
     *  Creates new instance of <code>NoSuchPathException </code> with specific message.
     *  @param message the message that will be displayed.
     */
    public NoSuchPathException(String message){
		super(message);
	}

    /**
     * Creates new instance of <code>NoSuchPathException </code>.
     */
    public NoSuchPathException(){
		this("");
	}
}
