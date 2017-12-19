/**
 * @(#)StackIsEmptyException.java
 *
 *
 * @author Ibrahim Ali 
 * @version 1.00 2014/4/27
 *
 */
 
package ics202.project.exceptions;

import java.util.NoSuchElementException;

/**
 *
 * An exception that can be thrown for any exception that can happen in stack.
 */
public class StackException extends NoSuchElementException{

    /**
     *  Creates new instance of <code>StackException</code> with specific message.
     *  @param message the message that will be displayed.
     */
    public StackException(String message) {
    	super(message);
    }
    
    /**
     * Creates new instance of <code>StackException</code>.
     */
    public StackException() {
    	this("");
    }
}