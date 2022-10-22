/******************************************************************************
 *  Compilation:  javac ResizingArrayStack.java
 *  Execution:    java ResizingArrayStack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  
 *  Stack implementation with a resizing array.
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;         // array of items
    private int n;            // number of elements on stack


    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
       a = (Item[]) new Object[4];
       n = 0;
    }

    /**
     * Is this stack empty?
     */
    public boolean isEmpty() {
       return n == 0;
    }

    /**
     * Returns the number of items in the stack.
     */
    public int size() {
       return n;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++){
            copy[i] = a[i];
        }
        a = copy;
    }



    /**
     * Adds the item to this stack.
     */
    public void push(Item item) {
       if(n == a.length){
           resize(2 * a.length);
       }
       a[n++] = item;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[--n];
        a[n] = null;
        if(n > 0 && n == a.length/4){
            resize(a.length/2);
        }
        return item;
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /* An iterator, mostly useful for interrogating the queue 
     * (aka linked list) to see if it's working as expected)
     * It doesn't implement remove() since it's optional
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            return a[i--];
        }
    }

    /**
     * This isn't necessary for the data type, but it is useful to
     * unit test the ResizingArrayStack data type.
     * You don't need to change this code at all.
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
