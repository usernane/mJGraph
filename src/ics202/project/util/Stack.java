/**
 * @(#)Stack.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/27
 */

package ics202.project.util;

import ics202.project.exceptions.StackException;

/**
 *
 * 
 * @param <Type> the type of elements that the stack will hold.
 */
public class Stack<Type> implements DataStructure<Type>{
	
	private DoublyLinkedNode<Type> head;
	private int size = 0;

    /**
     * Creates new instance of <code>Stack</code>.
     */
    public Stack() {
    	this.head = null;
    }
    @Override
    public void addElement(Type el){
    	this.push(el);
    }
	/**
     *	Returns a linked list.
     *	@return a linked list.
     */
    @Override
    public LinkedList<Type> getLinkedList(){
    	LinkedList<Type> tmpList = new LinkedList<>();
    	for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		tmpList.add(tmp.data);
    	}
    	return tmpList;
    }
    /**
     *	Returns a data structure object.
     *	@return data structure object.
     */
    @Override
    public DataStructure<Type> getDataStructure(){
    	return this;
    }
    /**
     *	Returns a queue data structure.
     *	@return queue data structure.
     */
    @Override
    public Queue<Type> getQueue(){
    	Queue<Type> tmpQueue = new Queue<>();
    	for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		tmpQueue.enqueue(tmp.data);
    	}
    	return tmpQueue;
    }
    /**
     *	Returns a stack data structure.
     *	@return stack data structure.
     */
    @Override
    public Stack<Type> getStack(){
    	return this;
    }

    /**
     *  Checks if the stack is empty or not.
     * @return <code>true</code> if the stack is empty.
     */
    public boolean isEmpty(){
    	return this.head == null;
    }
    public void push(Type el){
    	this.size++;
    	if(!this.isEmpty()){
    		this.head = new DoublyLinkedNode<>(el,null,head);
    		return;
    	}
    	this.head =  new DoublyLinkedNode<>(el,null,null);
    }
    public Type pop() throws StackException{
    	if(!this.isEmpty()){
    		this.size--;
    		Type data = this.head.data;
    		this.head = this.head.prevNode;
    		return data;
    	}
    	throw new StackException("Stack is empty");
    }
    @Override
    public Type removeElement(){
    	return this.pop();
    }
    public int size(){
    	return this.size;
    }
        @Override
    public String toString(){
    	if(this.isEmpty()){
    		return "[ Empty ]";
    	}
    	String ret = "";
    	for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.prevNode){
    		ret += tmp.data + " ";
    	}
    	return ret;
    }
}