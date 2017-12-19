/**
 * @(#)DoublyLinkedNode.java
 *
 * 
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/18
 */

package ics202.project.util;

/**
 *	A Doubly linked node that is used to build a <code>LinkedList</code> and <code>Stack</code>.
 * @param <Type> the type of data that will be stored on the node.
 */

public class DoublyLinkedNode<Type> {
	/**
	 *	The data that the node will hold.
	 */
	protected Type data;
	/**
	 *	The next node on the list.
	 */
	protected DoublyLinkedNode<Type> nextNode;
	/**
	 *	The previous node on the list.
	 */
	protected DoublyLinkedNode<Type> prevNode;
	
	/**
	 *	Creates a new instance of <code>DoublyLinkedNode</code>.
	 *	@param data the data that the node will hold.
	 *	@param nextNode the next node that will be linked with that node.
	 *	@param prevNode the previous node that will be linked with that node.
	 */
	public DoublyLinkedNode(Type data,DoublyLinkedNode<Type> nextNode,DoublyLinkedNode<Type> prevNode){
		this.data = data;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}
}
