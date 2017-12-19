/**
 *
 *	@author Ibrahim Ali
 *	@version 1.0
 *	
 */
package ics202.project.util;


/**
 *An interface that is used to link all data structures.
 *@param <T> the type of the elements on that data structure.
 */

public interface DataStructure<T> {
	
	/**
	 *	Adds new element to the data structure.
	 *	@param el the element that will be added.
	 */
	 public void addElement(T el);
	 /**
	 *	Removes the first element from the data structure.
	 *	@return the element after removal.
	 */
	 public T removeElement();
	/**
	 * Returns  a <code>Stack</code> representation of the data structure.
	 *
	 *
	 * @return a <code>Stack</code> representation of the data structure.
	 *
	 */
	public Stack<T> getStack();

	/**
	 * Returns  a <code>Queue</code> representation of the data structure.
	 *
	 *
	 * @return a <code>Queue</code> representation of the data structure.
	 *
	 */
	public Queue<T> getQueue();


	/**
	 * Returns  a <code>LinkedList</code> representation of the data structure.
	 *
	 *
	 * @return a <code>LinkedList</code> representation of the data structure.
	 *
	 */
	public LinkedList<T> getLinkedList();

	/**
	 * Returns  an <code>DataStructure</code> object.
	 *
	 *
	 * @return an <code>AbstractGraph</code> object.
	 *
	 */
	public DataStructure<T> getDataStructure();	
}
