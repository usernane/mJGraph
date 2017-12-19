/**
 * @(#)LinkedList.java
 *
 *
 * @author Ibrahim Ali
 * @version 1.00 2014/4/13
 */
package ics202.project.util;
/**
 *	The class is used to build the basic structure of the graph library.
 * @param <Type> the type of elements that will be added to the list.
 */
import java.util.NoSuchElementException;
public class LinkedList<Type> implements DataStructure<Type>{

	protected DoublyLinkedNode<Type> head,tail;
	protected int size;
	/**
	 *	Creates a new instance of <code>LinkedList</code>.
	 */
    public LinkedList() {
    	this.head = this.tail = null;
    	size = 0;
    }
    public LinkedList(LinkedList<Type> list) {
    	this.head = list.head;
    	this.tail = list.tail;
    	size = list.size();
    }
    public boolean replace(Type el, Type replace){
    	if(el.equals(this.head.data)){
    		this.head.data = replace;
    		return true;
    	}
    	if(el.equals(this.tail.data)){
    		this.tail.data = replace;
    		return true;
    	}
    	for(DoublyLinkedNode<Type> tmp = head; tmp != null ; tmp = tmp.nextNode){
    		if(tmp.data.equals(el)){
    			tmp.data = replace;
    			return true;
    		}
    		
    	}
    	return false;
    }
    /**
     *	Adds new element to the list.
     *	@param el The element that will be added to the list.
     */
    public void add(Type el){
    	if(!isEmpty()){
    		DoublyLinkedNode<Type> tmp = new DoublyLinkedNode<>(el,null,tail);
    		tail.nextNode = tmp;
    		tail = tail.nextNode;
    		size++;
    		return;
    	}
    	size++;
    	head = tail = new DoublyLinkedNode<>(el,null,null);
    }
    public void addElement(Type el){
    	this.add(el);
    }
    /**
     *	Checks whether an element is on the list or not.
     *
     *	@param el The element that will be checked.
     * @return <code>true</code> if the element is on the list.
     */
    public boolean contains(Type el){
    	if(!isEmpty()){
    		for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    			if(el.equals(tmp.data)){
    				return true;
    			}		
    		}
    	}
    	return false;
    }
    /**
     *	Removes all the elements from the list.
     */
    public void clear(){
    	head = null;
    	tail = null;
    }
    /**
     *	Returns the element at the specific index.
     *
     *	@param index The index that we wants to get the element from.
     * @return the element at the specified index.
     *	@throws IndexOutOfBoundsException if the given index is less than zero or greater or equal to the size of the list.
     */
    public Type get(int index)throws IndexOutOfBoundsException{
    	if(!(index >= this.size()) && index >= 0){
    		int inIndex = 0;
    		for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    			if(inIndex == index)
    				return tmp.data;
    			inIndex++;
    		}
    	}
    	throw new IndexOutOfBoundsException("("+index+") size of the list is "+this.size());
    }
    /**
     *	Returns the first element on the list.
     *	@return the first element on the list.
     *	@throws NoSuchElementException if the list is empty.
     */
    public Type getFirst()throws java.util.NoSuchElementException{
    	if(!this.isEmpty()){
    		return this.head.data;
    	}
    	throw new java.util.NoSuchElementException();
    }
    /**
     *	Returns the last element on the list.
     *	@return the last element on the list.
     *	@throws NoSuchElementException if the list is empty.
     */
    public Type getLast()throws java.util.NoSuchElementException{
    	if(!this.isEmpty()){
    		return this.tail.data;
    	}
    	throw new java.util.NoSuchElementException();
    }
    //used for sorting
    protected DoublyLinkedNode<Type> getNodeAt(int index){
    	if(!isEmpty()){
    		int inIndex = 0;
    		for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    			if(inIndex == index)
    				return tmp;
    			inIndex++;
    		}
    	}
    	return null;
    }
    /**
     *	Returns the specific element if it is exist on the list.
     *
     *	@param el The element that will be checked.
     *	@throws NoSuchElementException if the element dose not exist on the list.
     *	@return the element if it is on the list.
     */
    public Type get(Type el)throws java.util.NoSuchElementException{
    	for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		if(el.equals(tmp.data)){
    			return tmp.data;
    		}
    	}
    	throw new java.util.NoSuchElementException(el+" is not in the list");
    }
    /**
     *	Returns a linked list.
     *	@return a linked list.
     */
    public LinkedList<Type> getLinkedList(){
    	return this;
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
    	for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		tmpStack.push(tmp.data);
    	}
    	return tmpStack;
    }
    /**
     *	Returns a queue data structure.
     *	@return queue data structure.
     */
    public Queue<Type> getQueue(){
    	Queue<Type> tmpQueue = new Queue<>();
    	for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    		tmpQueue.enqueue(tmp.data);
    	}
    	return tmpQueue;
    }
    /**
     *	Checks if the list is empty or not.
     *	@return <code>true</code> if the list is empty. else, it returns <code>false</code>
     */
    public boolean isEmpty(){
    	return head == null;
    }
    
    /**
     *	Removes the last element on the list.
     *	
     *	@return The data of the element that was removed
     *	@throws NoSuchElementException if the list is empty.
     */
    public Type removeFirst()throws java.util.NoSuchElementException{
    	if(!isEmpty()){
    		Type data = head.data;
    		head = head.nextNode;
    		size--;
    		return data;
    	}
    	throw new java.util.NoSuchElementException("Can not remove, list is empty.");
    }
    /**
     *	Removes the first element on the list.
     *	
     *	@return The data of the element that was removed
     *	@throws NoSuchElementException if the list is empty.
     */
    public Type removeLast()throws java.util.NoSuchElementException{
    	if(!isEmpty()){
    		Type data = tail.data;
    		tail = tail.prevNode;
    		tail.nextNode = null;
    		size--;
    		return data;
    	}
    	throw new java.util.NoSuchElementException("Can not remove, list is empty.");
    }
    @Override
    public Type removeElement(){
    	return this.removeFirst();
    }
    /**
     *	Remove a specific element from the list.
     *	
     * @param el the element that will be removed.
     *	@return The data of the element that was removed
     *	@throws NoSuchElementException if the list is empty or if the element is not in the list.
     */
    public Type remove(Type el)throws java.util.NoSuchElementException{
    	if(!this.isEmpty()){
    		if(this.contains(el)){	
    			if(el.equals(head.data)){
    				return removeFirst();
    			}
    			if(el.equals(tail.data)){
    				return removeLast();
    			}
    			for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode){
    				if(el.equals(tmp.data)){
    					tmp.nextNode.prevNode = tmp.prevNode;
    					tmp.prevNode.nextNode = tmp.nextNode;
    					size--;
    					
    					return el;
    				}
    			}
    		}
    		throw new java.util.NoSuchElementException(el+" is not in the list");
    	}
    	throw new java.util.NoSuchElementException("List is empty");
    }
    /**
     *	Returns the size of the list.
     *
     *	@return the size of the list.
     */
    public int size(){
    	return this.size;
    }
    
    /*public void sortA(){
    	DoublyLinkedNode<Type> tmp = head;
    	for(int i = 0 , n = this.size() ; i < n ; i++){
    		DoublyLinkedNode<Type> tmp2 = getNodeAt(i);
    		for(int j = i ; j < n ; j++){
    			if(tmp.data.compareTo(tmp2.data) > 0){
    				Type tmpData = tmp2.data;
    				tmp2.data = tmp.data;
    				tmp.data = tmpData;
    			}
    			tmp2 = tmp2.nextNode;
    		}
    		tmp = tmp.nextNode;
    	}
    }
    public void sortB(){
    	DoublyLinkedNode<Type> tmp = head;
    	for(int i = 0 , n = this.size() ; i < n ; i++){
    		DoublyLinkedNode<Type> tmp2 = getNodeAt(i);
    		for(int j = i ; j < n ; j++){
    			if(tmp.data.compareTo(tmp2.data) < 0){
    				Type tmpData = tmp2.data;
    				tmp2.data = tmp.data;
    				tmp.data = tmpData;
    			}
    			tmp2 = tmp2.nextNode;
    		}
    		tmp = tmp.nextNode;
    	}
    }*/
    /**
     *	Returns string representation of <code>LinkedList</code>.
     *
     *	@return A <code>String</code> Object.
     */
        @Override
    public String toString(){
    	if(!isEmpty()){
    		String ret ="";
    		for(DoublyLinkedNode<Type> tmp = head ; tmp != null ; tmp = tmp.nextNode)
    			ret += tmp.data+" ";
    		return ret;
    	}
    	return "[ Empty List ]";
    }
}