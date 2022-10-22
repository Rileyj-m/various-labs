

public class Subset {
 

    public static void main(String[] args) {
        
        int k = Integer.parseInt(args[0]);
        RandomizedBag<String> bag = new RandomizedBag<String>();
        while(!StdIn.isEmpty()){
            String bagitem = StdIn.readString();
            bag.put(bagitem);
        }
        while (k > 0){
            String bagget = bag.get();
            if (bagget == null){
                continue;
            }
            else{
                StdOut.println(bagget);
                k--;
            }

        }
        return;
    }
    
    
}