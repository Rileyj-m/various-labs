/******************************************************************************
 *  Compilation:  javac LinkedQueue.java
 *  Execution:    java LinkedQueue < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A generic queue, implemented using a singly-linked list.
 *
 *  % java Queue < tobe.txt 
 *  to be or not to be (2 left on queue)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty queue.
     */
    public LinkedQueue() {
        n = 0;
        first = null;
        last  = null;
    }

    /**
     * Is this queue empty?
     */
    public boolean isEmpty() {
       return first == null;
    }

    /**
     * Returns the number of items in this queue.
     */
    public int size() {
        return n;
    }


    /**
     * Adds the item to this queue.
     */
    public void enqueue(Item item) {
       Node oldLast = last;
       last = new Node();
       last.item = item;
       last.next = null;
       if(isEmpty()){
           first = last;
       }
       else{
           oldLast.next = last;
       }
       n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()){
            last = null;
        }
        return item;
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    /* An iterator, mostly useful for interrogating the queue 
     * (aka linked list) to see if it's working as expected)
     * It doesn't implement remove() since it's optional
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public void remove()      { throw new UnsupportedOperationException();  }
        
        public boolean hasNext()  { 
           return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    /**
     * This isn't necessary for the data type, but it is useful to
     * unit test the LinkedQueue data type.
     * You don't need to change this code at all.
     */
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
