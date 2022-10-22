/******************************************************************************
 *  Lab 6 template - PQTester
 *  Compilation:  javac PQtester.java
 *  Execution:    java PQtester
 ******************************************************************************/
import edu.princeton.cs.algs4.MaxPQ;
import java.util.Random;
public class PQtester {

    private Random r = new Random();

    public long runTrial(int n) {
        MaxPQ<Integer> mpq = new MaxPQ<Integer>(n);
        long start = System.nanoTime();
        int count = 0;
        while(n > count){
            int random = r.nextInt(100);
            mpq.insert(random);
            count++;
        }
        count = 0;
        while(n/2 > count){
            mpq.delMax();
            count++;
        }
        count = 0;
        while(n/2 > count){
            int random = r.nextInt(100);
            mpq.insert(random);
            count++;
        }
        if(!mpq.isEmpty()){
            mpq.delMax();
        }

        long end = System.nanoTime();
        return end-start;
    }

    public static void main(String[] args) {
        PQtester t = new PQtester();
        int trials = 10;
        int n = Integer.parseInt(args[0]);

        long total = 0;
        System.out.println("Trials: " + trials);
        System.out.println("-----------------------------------------------");
        for (; n <= 1e8; n*=10) { //test with n=10,100,1000,...,1e8
            for (int i = 0; i < trials; i++) {
                total += t.runTrial(n);
            }
            System.out.println("Average run time for " + n +": " + total/trials + " nanoseconds");
        }
        System.out.println("-----------------------------------------------");

    }
}