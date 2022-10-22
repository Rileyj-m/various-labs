import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class HashProbing {
    
    public static void main(String[] args) {
        Random random = new Random();

        for (int N = 1000; N <=1000000; N*=10) {
            double count = 0;
            double n = N*1.25;
            boolean[] A = new boolean[(int) n];

            for(int i = 0; i <= N; i++){
                int randomprobe = random.nextInt(A.length-1) % N;
                if(A[randomprobe] == true){
                    continue;
                }
                else{
                    A[randomprobe] = true;
                }
            }
            for(int j = 0; j < 10000; j++){
                int randomprobe2 = random.nextInt(A.length-1) % N;
                int k = randomprobe2;
                do {
                    if(A[k] == false){
                        count++;
                        break;
                    }
                    count++;
                    k = (k+1) % N;
                    if(A[k] == false){
                        count++;
                        break;
                    }
                }while (A[k] != false);
            }
            double mean = count/10000;
            
            StdOut.println("Average probes for a miss with N="+N+" is: "+mean);
        }
    }
}