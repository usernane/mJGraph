package ics202.project.exceptions;

import java.util.NoSuchElementException;

/**
 *
 * @author Ibrahim Ali
 */
public class QueueException extends NoSuchElementException {
	
	/**
	 * Creates new instance of <code>QueueException</code> with specific message.
	 *
	 *
     * @param message the message that will be displayed.
	 */
	public QueueException(String message) {
		super(message);
	}

    /**
     *  Creates new instance of <code>QueueException</code>.
     */
    public QueueException(){
	     this("");
	}
}
