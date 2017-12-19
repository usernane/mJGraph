/**
 * @(#)Queue.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/27
 */

package ics202.project.util;

import ics202.project.exceptions.QueueException;


/**

 * @param <Type> the type of elements that will be added to the queue.
 */
public class Queue<Type> implements DataStructure<Type>{
	
	private LinkedNode<Type> head,tail;
	private int size = 0;
	
    /**
     * Creates new instance of <code>Queue</code>.
     */
    public Queue() {
    	this.head = this.tail = null;
    }
    public void addElement(Type el){
    	this.enqueue(el);
    }
    /**
     * Checks if the queue is empty or not.
     * @return <code>true</code> if the queue is empty.
     */
    public boolean isEmpty(){
    	return this.head == null;
    }
    
    /**
     *  Returns the top element on the queue.
     * @return the top element on the queue.
     */
    public Type peek(){
    	return this.head.data;
    }
    
    /**
     *  Adds new element to the end of the queue.
     * @param el the element that will be added to the queue.
     */
    public void enqueue(Type el){
    	if(!this.isEmpty()){
    		size++;
    		this.tail.nextNode = new LinkedNode<>(el,null);
    		this.tail = this.tail.nextNode;
    		if(head.nextNode == null){
    			head.nextNode = tail;
    		}
    		return;
    	}
    	size++;
    	head = tail = new LinkedNode<>(el,null);
    }

    /**
     *  Removes the first element that is in the queue.
     * @return the first element on the queue.
     * @throws QueueException if the queue is empty.
     */
    public Type dequeue() throws QueueException{
    	if(!this.isEmpty()){
    		Type data = head.data;
    		head = head.nextNode;
    		size--;
    		return data;
    	}
    	throw new QueueException("Queue is empty");
    }
    /**
     *	Returns a linked list.
     *	@return a linked list.
     */
    public LinkedList<Type> getLinkedList(){
    	LinkedList<Type> tmpList = new LinkedList<>();
    	for(LinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		tmpList.add(tmp.data);
    	}
    	return tmpList;
    }
    /**
     *	Returns a data structure object.
     *	@return data structure object.
     */
    public DataStructure<Type> getDataStructure(){
    	return this;
    }
    /**
     *	Returns a stack data structure.
     *	@return stack data structure.
     */
    public Stack<Type> getStack(){
    	Stack<Type> tmpStack = new Stack<>();
    	for(LinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		tmpStack.push(tmp.data);
    	}
    	return tmpStack;
    }
    /**
     *	Returns a queue data structure.
     *	@return queue data structure.
     */
    public Queue<Type> getQueue(){
    	return this;
    }
	@Override
	public Type removeElement(){
		return this.dequeue();
	}
    /**
     *  Returns the current size of the queue.
     * @return the current size of the queue
     */
    public int size(){
    	return this.size;
    }
        @Override
    public String toString(){
    	if(this.isEmpty()){
    		return "[ Empty ]";
    	}
    	String ret = "";
    	for(LinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		ret += tmp.data + " ";
    	}
    	return ret;
    }
}