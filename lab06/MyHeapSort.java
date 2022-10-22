import edu.princeton.cs.algs4.MinPQ;

import java.util.Random;

public class MyHeapSort {

    public static void simpleSort(Integer[] A) {
        int N = A.length;
        //create a heap, insert N things
        StdOut.println("  Simple sort");
        StdOut.print("    Construct:");
        MinPQ<Integer> heap = new MinPQ<Integer>();

        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++){
            heap.insert(A[i]);
        }
        StdOut.println("\t\t" + (System.nanoTime() - startTime));

        StdOut.print("    Sort:");
        startTime = System.nanoTime();
        int count = A.length;
        while(count > 0){
            heap.delMin();
            count--;
        }
        StdOut.println("\t\t" + (System.nanoTime() - startTime));
    }

    public static void heapSort(Integer[] A) {
        int n = A.length;

        StdOut.println("  Heap sort");
        StdOut.print("    Construct:");
        long startTime = System.nanoTime();

        for(int i = n/2; i >= 1; i--){
            MyHeapSort.sink(A, i, n);
        }
        // Add code to heapify.  You can find this in Heap.class (sort function)

        StdOut.println("\t\t" + (System.nanoTime() - startTime));


        StdOut.print("    Sort:");
        startTime = System.nanoTime();
        int k = n;
        while(k > 1){
            MyHeapSort.exch(A, 1, k--);
            MyHeapSort.sink(A, 1, k);
        }
        // Add code to sort from that heap.  You can find this in Heap.class (sort function)
        StdOut.println("\t\t" + (System.nanoTime() - startTime));
    }

    private static Integer[] randomArray(int size) {
        Integer[] result = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            int randomint = random.nextInt(100);
            result[i] = randomint;
        }
        return result;
    }



    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }




    public static void main(String args[]) {

        Integer[] arr;

        StdOut.println("Input size\t\tTime total");

        arr = randomArray((int)Math.pow(10, 3));
        StdOut.println(arr.length);
        simpleSort(arr);
        heapSort(arr);

        arr = randomArray((int)Math.pow(10, 5));
        StdOut.println(arr.length);
        simpleSort(arr);
        heapSort(arr);

        arr = randomArray((int)Math.pow(10, 7));
        StdOut.println(arr.length);
        simpleSort(arr);
        heapSort(arr);

    }

    /* from Heap class */
    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }
}