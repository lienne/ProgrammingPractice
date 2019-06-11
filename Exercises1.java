import java.util.*;
import java.util.Arrays;

public class Exercises1
{
	
	// Write an efficient function that takes as its input a sorted array of n
	// elements and returns true if there are any duplicate values in the array.
	// Otherwise, return false.
	static boolean duplicates(int [] array)
	{
		// Here, it must be length-1 because we're counting ti i+1 in the for loop
		for(int i = 0; i < array.length - 1; i++)
		{
			if(array[i] == array[i+1])
			{
				return true;
			}
		}
		
		return false;
	}
	
	// Write an efficient function that takes a sorted array of n integers and
	// returns the number of times key appears in the array.
	static int keyCount(int [] array, int key)
	{
		int count = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == key)
				count++;
		}
		
		return count;
		
		// O(n) run time?
	}
	
	static int keyCountBinary(int [] array, int key)
	{
		int lo = 0;
		int hi = array.length - 1;
		int mid = 0; // Start mid at 0 because we'll set it later
		
		int count = 0;
		
		while(lo <= hi)
		{
			// Important to set mid here b/c it will change
			mid = lo + (hi-lo)/2;
			
			// Check if key is on lower half of array, and cut the search in half
			if(array[mid] > key)
				hi = mid - 1;
			// Check if key is on upper half of array, and cut the search in half
			else if(array[mid] < key)
				lo = mid + 1;
			// Found one instance of key
			else if(array[mid] == key)
			{
				// Store mid so we don't lose it
				int temp = mid;
				while(temp < array.length && array[temp] == key)
				{
					count++;
					//System.out.println("Printing count going up:");
					//System.out.println(count);
					temp++;
				}
				
				while(mid > 0 && array[mid-1] == key)
				{
					count++;
					//System.out.println("Printing count going down:");
					//System.out.println(count);
					mid--;
				}
				
				return count;
			}
		}
		
		return count;
	}
	
	static int keyCountBinaryMethod(int [] array, int key)
	{
		int count = 0;
		int index = Arrays.binarySearch(array, key);
		
		//System.out.println("Index of key is: " + index);
		// binarySearch() returns -(insertion point - 1) if key is not in the array
		if(index >= 0)
		{
			int temp = index;
			while(temp < array.length && array[temp] == key)
			{
				count++;
				temp++;
			}
			while(index > 0 && array[index-1] == key)
			{
				count++;
				index--;
			}
		}
		
		return count;
	}
	
	// Given a sorted array of integers, determine whether any two elements add up to
	// some particular target integer.
	static boolean canHazTargetSum(int [] array, int target)
	{
		// i is at the beginning of the array, j is at the end
		int i = 0, j = array.length - 1;
		
		
		while(i < j)
		{
			// If the sum of the smallest and largest elements is too big, decrement j
			if(array[i] + array[j] > target)
				--j;
			// Otherwise, if the sum is too small, increment i
			else if(array[i] + array[j] < target)
				++i;
			// The sum is exactly the target!
			else
				return true;
		}
		
		// Nothing sums up to target
		return false;
	}
	
	static boolean canHazTargetSumBetter(int [] array, int target)
	{
		for(int i = 0; i < array.length; i++)
		{
			int temp = array[i];
			array[i] = Integer.MAX_VALUE;
			
			if(Arrays.binarySearch(array, target - temp) >= 0)
			{
				// We have to set array[i] back to temp before returning.
				// Otherwise, we're corrupting the array each time we return true!
				array[i] = temp;
				return true;
			}
			
			array[i] = temp;
		}
		
		return false;
	}
	
	static boolean canHazTargetSumBest(int [] array, int target)
	{
		int i = 0, j = array.length - 1;
		
		while(j > i)
		{
			int sum = array[i] + array[j];
			
			// If sum is too small, array[i] is bringing us down... increment i!
			if(sum < target)
				++i;
			// If sum is too larget, array[j] is causing major bloat... decrement j!
			else if(sum > target)
				--j;
			// Otherwise, we found our target!
			else
				return true;
		}
		
		// We never found a pair of integers that sum to target
		return false;
	}
	
	// Write an efficient method that takes in as its input a sorted array of n elements and 
	// returns true if the array contains at least k positive integers. Otherwise, return false.
	static boolean posCountSlow(int [] array, int k)
	{
		int count = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] > 0)
				count++;
		}
		
		// This will return true if count >= k, and false otherwise
		return (count >= k);
		
		// O(n) brute force solution
	}
	
	static boolean postCountBetter(int [] array, int k)
	{
		int count = 0;
		
		// Take advantage of the fact the array is already sorted in increasing order,
		// and count backwards. If the last array is negative, we'll know immediately
		for(int i = array.length - 1; i >= 0 && array[i] > 0; i--)
			count++;
		
		return (count >= k);
		
		// O(n) worst-case, O(1) best-case
	}
	
	static boolean posCountBest(int [] array, int k)
	{
		if(array.length < k)
			return false;
		
		if(k <=0)
			return true;
		
		// Skip to the kth element of the array. If it contains a pos integer, then we have
		// at least k pos integers in the array. Otherwise, we have fewer than k pos.ints.
		return(array[array.length - k] > 0);
	}
	
	// Write an O(1) method that takes a single integer n and returns the sum of all integers
	// from 0 through n. Note: n could be negative.
	static int sum(int n)
	{
		if(n < 0)
			return -1 * sum(-n);
		
		return n*(n+1)/2;
		
		// Best and Worst case is O(1)
		// Space complexity is also O(1)
	}
	
	public static void main(String [] args)
	{
		int [] array =  new int [] {0, 1, 2, 3, 3, 4, 5, 6}; // 8 elements
		int [] array2 =  new int [] {0, 1, 2, 3, 4, 5, 6, 7};
		int [] array3 =  new int [] {0, 0, 1, 2, 3, 3, 3, 4, 4, 5, 6, 7, 7, 7, 7, 7};
		int [] array4 = new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
		int [] array5 = new int [] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		//int len = array.length;
		//System.out.println(len); // returns 8
		
		/*
		System.out.println(duplicates(array));
		System.out.println(duplicates(array2));
		System.out.println(duplicates(array4));
		*/
		
		System.out.println(Arrays.toString(array3));
	
		System.out.println("keyCount O(n):");
		System.out.println(keyCount(array3, 3));
		System.out.println(keyCount(array3, 4));
		System.out.println(keyCount(array3, 7));
		System.out.println(keyCount(array3, 9));
		System.out.println(keyCount(array3, 0));
		System.out.println(keyCount(array5, 1));
		
		System.out.println("keyCount Binary Search:");
		System.out.println(keyCountBinary(array3, 3));
		System.out.println(keyCountBinary(array3, 4));
		System.out.println(keyCountBinary(array3, 7));
		System.out.println(keyCountBinary(array3, 9));
		System.out.println(keyCountBinary(array3, 0));
		System.out.println(keyCountBinary(array5, 1));
		
		System.out.println("keyCount Java method binarySearch():");
		System.out.println(keyCountBinaryMethod(array3, 3));
		System.out.println(keyCountBinaryMethod(array3, 4));
		System.out.println(keyCountBinaryMethod(array3, 7));
		System.out.println(keyCountBinaryMethod(array3, 9));
		System.out.println(keyCountBinaryMethod(array3, 0));
		System.out.println(keyCountBinaryMethod(array5, 1));
		
	}
}