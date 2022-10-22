/******************************************************************************
 *  Compilation:  javac RandomizedBag.java
 *  Execution:    java RandomizedBag < input.txt
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
import java.util.Random;


public class RandomizedBag<Item> implements Iterable<Item> {
    private Item[] a;         // array of items
    private int n;            // number of elements on stack
    Random rng;

    /**
     * Initializes an empty stack.
     */
    public RandomizedBag() {
        a = (Item[]) new Object[2];
        n = 0;
        rng = new Random();
    }

    /**
     * Is this stack empty?
     */
    public boolean isEmpty() {
        if(n == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns the number of items in the stack.
     */
    public int size() {
        return n;
    }


    /*
     * Resize the underlying array holding the elements
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++){
            copy[i] = a[i];
        }
        a = copy;
    }



    /**
     * Adds the item to this bag (which is an array).
     */
    public void put(Item item) {
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;
    }

    /**
     * Removes and returns a random item from the bag
     */
    public Item get() {
        Item item = null;
        int randomChoice = rng.nextInt(a.length);
        item = a[randomChoice];
        a[randomChoice] = a[a.length-1];
        a[a.length-1] = null;
        n--;
        return item;
    }
    public Item sample(){
        int randomChoice = rng.nextInt(a.length-1);
        return a[randomChoice];
    }


    /**
     * Returns an iterator to this bag that iterates through the items in random order.
     */
    public Iterator<Item> iterator() {
        return new RandomizedBagIterator();
    }

    // an iterator; ours doesn't implement remove() since it's optional
    private class RandomizedBagIterator implements Iterator<Item> {
        private int i;
        private Item itArr[];

        public RandomizedBagIterator() {
            i = 0;
            itArr = (Item[]) new Object[n];
            for(int j = 0; j < n; j++){
                int random = rng.nextInt(n);
                itArr[j] = a[random];
            }
            StdOut.println(n);
            StdOut.println(a.length);

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            return i < itArr.length;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = itArr[i];
            i++;
            return item;
        }
    }


    /**
     * Unit tests the RandomizeBag data type.
     */
    public static void main(String[] args) {
        RandomizedBag<String> bag = new RandomizedBag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) bag.put(item);
            else if (!bag.isEmpty()) StdOut.print(bag.get() + " ");
        }
        StdOut.println("(" + bag.size() + " left on bag)");
        

        Iterator<String> itr1 = bag.iterator();
        if  (!bag.isEmpty()) 
            bag.get(); // test removal of one
        Iterator<String> itr2 = bag.iterator();

        StdOut.println("Here's what was left before removing one (in random order):");
        while (itr1.hasNext())
        {
            String s = itr1.next();
            StdOut.println(s + " ");
        }
        StdOut.println("");
        
        StdOut.println("Here's what was left after removing one (in random order):");
        while (itr2.hasNext())
        {
            String s = itr2.next();
            StdOut.println(s + " ");
        }
        StdOut.println("");

        StdOut.println("I sure hope the second one is missing one entry, and in a different order.");


    }
    
    
    
}
