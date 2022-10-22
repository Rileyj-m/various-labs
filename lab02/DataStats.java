/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class DataStats
{
    // array to handle the data
    double[] dataStatsArray;

    //constructor for the array
    public DataStats(int N) {
        dataStatsArray = new double[N];
    }

    //method to calculate the mean of the data
    public double mean()
    {
        double meanCount = 0;
        int meanLength = 0;
        for (int i = 0; i < dataStatsArray.length; i++){
            meanCount += dataStatsArray[i];
            if (dataStatsArray[i] != 0){
                meanLength += 1;
            }
        }
        return meanCount/meanLength;
    }

    //method to append the numbers to the array that was created.
    public void append(double in)
    {
        try
        {
            for (int i = 0; i <= dataStatsArray.length+1; i++)
            {
                if(dataStatsArray[i] == 0)
                {
                    dataStatsArray[i] = in;
                    break;
                }
                else
                {
                    continue;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException error)
        {
            System.out.println("More than N numbers added to the array.");
            throw error;
        }
    }
}
