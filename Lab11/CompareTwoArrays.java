import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.SeparateChainingHashST;


public class CompareTwoArrays
{

    private static boolean compareWithHeap (In inA, In inB, int size) {
        
        boolean match = true;
        Integer[] aItems = new Integer[size];
        Integer[] bItems = new Integer[size];
        int count = 0;

        while (!inA.isEmpty()) {
            int itemA = inA.readInt();
            int itemB = inB.readInt();
            aItems[count] = itemA;
            bItems[count] = itemB;
            count++;
        }

        Heap.sort(aItems);
        Heap.sort(bItems);

        for (int i = 0; i < size; i++ ){
            if (aItems[i].equals(bItems[i])) {
                continue;
            }
            else {
                match = false;
                break;
            }
        }
        
        return match;
    }
    
    private static boolean compareWithHash (In inA, In inB, int size) {

        boolean match = true;
        SeparateChainingHashST<Integer, Integer> aST = new SeparateChainingHashST<>();
        int aCount = 1;
        int hold = 0;

        while (!inA.isEmpty()) {
            int item = inA.readInt();
            if (!aST.contains(item)){
                aCount = 1;
                aST.put(item, aCount);
                continue;
            }
            if (aST.contains(item)){
                aCount++;
                aST.put(item, aCount);
            }
        }

        int holder = 0;
        while (!inB.isEmpty()){

            int item = inB.readInt();

            if (aST.contains(item)){
                if (holder == 0 || holder == item) {
                    int value = aST.get(item);
                    aST.put(item, value - 1);
                    holder = item;
                }
                else{
                    holder = 0;
                    int value = aST.get(item);
                    aST.put(item, value - 1);
                }

            }
            else {
                match = false;
            }

        }
        for (int i = 0; i <= size; i++){
            if (aST.contains(i)) {
                int value = aST.get(i);
                if (value == 0) {
                    aST.delete(i);
                }
            }
        }
        if (aST.size() != 0){
            match = false;
        }

        return match;
    }
    
    public static void main(String[] args) {
        
        if (args.length < 3) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        String filenameA = args[0];
        String filenameB = args[1];
        String method    = args[2];
        
        if ( !method.equals("heap") && !method.equals("hash") ) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        
        In inA = new In(filenameA);
        int nA = inA.readInt();

        In inB = new In(filenameB);
        int nB = inB.readInt();

        if (nA != nB) {
            StdOut.println("Arrays are not the same size, so not equivalent");
            System.exit(0);
        }
        
        boolean match = false;
        
        StopwatchCPU sw = new StopwatchCPU();
        if (method.equals("heap")) {
            match = compareWithHeap(inA, inB, nA);
        } else {
            match = compareWithHash(inA, inB, nA);
        }
        
        
        double elapsed = sw.elapsedTime();
        
        
        StdOut.println("The two input arrays do " + (match?"":"not ") + "match" );
        StdOut.println("elapsed time: " + elapsed + " seconds");
        
    }

   
}

