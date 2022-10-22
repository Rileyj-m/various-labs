import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;

public class CheckArraysForDuplicates
{
  
    
    public static void main(String[] args) {

        /* ===================================
         * No need to touch the next batch of code - it should just work.
         * Your changes will start after the StopwatchCPU object is created
         * ===================================
         */

        if (args.length < 1) {
            StdOut.println("Usage: java CheckArraysForDuplicates filename");
            System.exit(1);
        }
        String filename = args[0];
        
        In in = new In(filename);
        
        int k = in.readInt(); // how many arrays
        int[] sizes = new int[k];  
        int[][] vals = new int[k][];  

        /* Read in all numbers into a set of arrays */
        for (int i=0; i<k; i++) {
            int n = in.readInt();
            sizes[i] = n;
            vals[i] = new int[n];
        }
        for (int i=0; i<k; i++) {
            for (int j=0; j < sizes[i]; j++) {
                vals[i][j] = in.readInt();
            }
        }
        
        /* ===================================
         * Now it's your turn:  how to use a RedBlack tree (of size k) to solve this?
         */
        boolean duplicate = false; // set this to "true" if you find a duplicate!
        StopwatchCPU sw = new StopwatchCPU();

        RedBlackBST<Integer, Integer> rbt = new RedBlackBST<Integer, Integer>();
        int[] offsets = new int[k];
        for (int i=0; i<k; i++) {

            // anything here to check for duplicates?
            
            rbt.put(vals[i][0], i); // use the array entry as the key, and the array index as the value
        }

        while (!rbt.isEmpty()) {
            int min = rbt.min();
            int minIndex = rbt.get(min);
            rbt.deleteMin();

            if (!rbt.isEmpty()){
                if(min == rbt.min()){
                    duplicate = true;
                    break;
                }
                offsets[minIndex]++;
                if(offsets[minIndex] < vals[minIndex].length-1){
                    if (rbt.contains(vals[minIndex][offsets[minIndex]])){
                        duplicate = true;
                        break;
                    }
                    else{
                        rbt.put(vals[minIndex][offsets[minIndex]], minIndex);
                    }
                }
            }
        }
        /* now what? */

        double elapsed = sw.elapsedTime();
        StdOut.println("The arrays do " + (duplicate?"":"not ") + "contain a duplicate" );
        StdOut.println("elapsed time: " + elapsed + " seconds");
    }

   
}

