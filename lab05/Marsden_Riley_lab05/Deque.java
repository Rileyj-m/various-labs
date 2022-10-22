/******************************************************************************
 *  Who are you?
 * ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    /**
     * Initializes an empty queue.
     */
    public Deque() {
        n = 0;
        first = null;
        last = null;
    }

    /**
     * Is this queue empty?
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     */
    public int size() {
        return n;
    }


    /**
     * Adds the item to the beginning
     */
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException("Item cannot be null.");
        if (isEmpty()){
            first = new Node(); //set a new node to first
            first.item = item; // set that node to the item
            last = first; // set last element to node because there is only one element.
        }
        else{
            Node inplace = first; //hold the first element
            first = new Node(); // create a new node for first
            first.item = item; // set first node to new item
            first.next = inplace; // have the next item be the prev first item
            inplace.prev = first; // point to the first element
        }
        n++;

    }

    
    /**
     * Adds the item to the end
     */
    // opposite of the one above
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException("Item cannot be null.");
        if (isEmpty()){
            last = new Node(); // new node bcas empty
            last.item = item; // last item == item
            first = last; // first == last bcas n = 1
        }
        else{
            Node inplace = last;
            last = new Node();
            last.item = item;
            last.prev = inplace;
            inplace.next = last;
        }
        n++;
    }

    /**
     * Removes and returns the item on the front (FIFO)
     */
    public Item removeFirst() {
        if (n == 0)
            throw new NoSuchElementException("Cannot remove an element from an empty queue.");
        Item inplace = first.item; //set the first
        if(n==1){ // if no other elements set the first and last to null. bcas nothing will be in the queue.
            first = null;
            last = null;
        }
        else{
            first = first.next; //first gets set to the next.
            first.prev = null; // and point to a null element because we have a prev pointer.
        }
        n--;
        return inplace;
    }

    /**
     * Removes and returns the item on the front (FIFO)
     */
    //opposite of the one above.
    public Item removeLast() {
        if (n == 0)
            throw new NoSuchElementException("Cannot remove an element from an empty queue.");
        Item inplace = last.item;
        if (n == 1){
            first = null;
            last = null;
        }
        else{
            last = last.prev;
            last.next = null;
        }
        n--;
        return inplace;
    }

    
    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, ours doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public void remove()      { throw new UnsupportedOperationException();  }
        
        public boolean hasNext()  {
            if (current != null)
                return true;
            else
                return false;
        }

        public Item next() {
            if (current.next == null)
                throw new NoSuchElementException("There are no more elements to return.");
            Item next = current.item;
            current = current.next;
            return next;
        }
    }


 
}
