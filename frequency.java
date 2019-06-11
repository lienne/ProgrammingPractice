import java.io.*;
import java.util.*;

public class frequency
{
  public static int maxFrequency(int [] array)
  {
    // Variable count keeps count of how many times each number appears in array
    int count = 1;
    int maxValue = 0;
    HashMap<Integer,Integer> hashyHash = new HashMap<>();

    for(int i = 0; i < array.length; i++)
    {
      // Check if the hashmap contains a key first; if it does,
      // increment that key's value by 1 by overriding it
      if(hashyHash.containsKey(array[i]) == true)
      {
        hashyHash.put(array[i], hashyHash.get(array[i])+1);

        // If the value is greater than our current maxValue, the key is now
        // the most frequently appearing number
        if(hashyHash.get(array[i]) > maxValue)
        {
          maxValue = array[i];
        }
      }
      // If the hashmap does not yet contain the key, put it in
      else
      {
        hashyHash.put(array[i], count);
      }
    }

    return maxValue;
  }

  public static void main(String [] args)
  {
    int [] array1 = new int [] {3,5,5,3,3,5};
    int [] array2 = new int [] {2, 26, 7, 5, 26, 26, 29, 30, 2, 7};

    System.out.println("The most frequent value in the array is: ");
    System.out.println(maxFrequency(array2));
  }
}
