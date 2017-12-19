package ics202.project.util;

/**
 *
 * @author Ibrahim
 * @param <Type> the type of elements that will be added to the list.
 */
public class SortableLinkedList<Type extends Comparable<Type>> extends LinkedList<Type> {
	
	/**
	 * Creates new instance of <code>SortableLinkedList</code>.
	 *
	 *
	 */
	public SortableLinkedList() {
		// TODO: Add your code here
	}

    /**
     *  Creates a copy from another list.
     * @param list the list that will be copied.
     */
    public SortableLinkedList(SortableLinkedList<Type> list) {
		// TODO: Add your code here
		super.head = list.head;
		super.tail = list.tail;
		super.size = list.size;
	}

    /**
     * Sort the elements of the list in increasing order.
     */
    public void sortIncreasing(){
    	DoublyLinkedNode<Type> tmp = super.head;
    	for(int i = 0 , n = this.size() ; i < n ; i++){
    		DoublyLinkedNode<Type> tmp2 = super.getNodeAt(i);
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

    /**
     * Sort the elements of the list in decreasing order.
     */
    public void sortDecreasing(){
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
    }	
}
