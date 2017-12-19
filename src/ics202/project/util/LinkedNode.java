/**
 * @(#)LinkedNode.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/27
 */
package ics202.project.util;
/**
 *	A Linked node that is used to build a queue.
 * @param <Type> the type of data that will be stored on the node.
 */
public class LinkedNode<Type> {
	/**
	 *	The next node.
	 */
	protected LinkedNode<Type> nextNode;
	/**
	 *	The data that will be heald by that node.
	 */
	protected Type data;
	/**
	 *	Creates new instance of <code>LinkedNode</code>
	 *	@param data The data that will be heald by that node.
	 *	@param nextNode The next node.
	 */
    public LinkedNode(Type data,LinkedNode<Type> nextNode) {
    	this.data = data;
    	this.nextNode = nextNode;
    }
    
    
}