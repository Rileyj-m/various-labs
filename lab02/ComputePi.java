/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Last modified:     October 16, 1842
 **************************************************************************** */
import java.util.Random;
public class ComputePi {
    public static void main(String[] args) {
        int n = 0;

        try { // Parse the string argument into an integer value.
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            // The first argument isn't a valid integer.  Print
            // an error message, then exit with an error code.
            System.out.println("The first argument must be an integer.");
            System.exit(1);
        }

        double pi = compute_pi(n);

        System.out.printf("%.2f %n", pi);
    }

    // I decided to index at zero in the loop, in the lab the example was 1.
    // I didn't see any issue with this. If there is I would like a comment as to why.
    // Thank you
    private static double compute_pi (int n) {
        double pi = 0.0, inside = 0, forPi = n;
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if ((x*x+y*y) <= 1.0D)
            {
                inside++;
            }
        }
        pi = ((4*inside)/forPi);

        return pi;
    }
}
