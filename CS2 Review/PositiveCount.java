import java.io.*;

// Write an efficient method that takes as its input a sorted array of n elements
// and returns true if the array contains at least k positive integers.
// Otherwise, return false.

public class PositiveCount {

  static boolean posCountBruteForce(int [] array, int k) {
    int count = 0;

    for(int i = 0; i < array.length; i++) {
      if(array[i] > 0)
      count++;
    }

    return (count >= k);
  }

  // Worst Case: O(n), Best case: O(1)
  // Just move if statement to for loop statement instead
  static boolean posCountSlightlyBetter(int [] array, int k) {
    int count = 0;

    for(int i = array.length - 1; i >= 0 && array[i] > 0; i--) {
      count++;
    }

    return (count >= k);
  }

  // O(1) solution:
  static boolean posCountBest(int [] array, int k) {
    if(array.length < k) return false;
    if (k <= 0) return false;

    // Skip to the kth element from the end of the array.
    // If it contains a positive integer, then we have at least
    // k positive integers in the array (since it is sorted).
     // Otherwise, we have fewer than k positive integers.
    return (array[array.length - k] > 0);
  }


  public static void main(String [] args) {

    int [] array1 = {-2,-1,0,1,2,3,4,5,6,7,8,9};
    int [] array2 = {-2,-1,0,1,2,3,4,5,6,7,8,9};

    System.out.println(posCountBest(array1, 5));
    System.out.println(posCountBest(array2, 13));
  }
}
