import java.io.*;

public class Fibonacci
{
	// This recursive approach has exponential runtime - O(2^n).
	// The space complexity is O(n), since at any given time there are at
	// most n function calls active, each of which takes up a constant amount
	// of space in memory.
	static int fib(int n)
	{
		// Base cases: fib(0) = 0, fib(1) = 1
		if(n < 2) return n;

		return fib(n-1) + fib(n-2);
	}

	// Bottom-up approach that starts from F_0 and F_1 and builds towards Fn.
	// Basically, store answers in an array instead.
	// The runtime and space complexity of this solution are both O(n).
	static int fib2(int n)
	{
		int [] array = new int[n+1];

		if(n < 2) return n;

		array[0] = 0;
		array[1] = 1;

		for(int i = 2; i <= n; i++)
			array[i] = array[i-1] + array[i-2];

		return array[n];
	}

	// static int array(int n)
	// {
	// 	int [] array = new int[n+1];
	//
	// 	int len = array.length;
	//
	// 	return len;
	// }

	// A faster approach:
	// Keep just the last two numbers and add them.
	static int hooray_fib(int n)
	{
		if(n < 2) return n;

		int prev1 = 0;
		int prev2 = 1;

		for(int i = 2; i <= n; i++)
		{
			int current = prev1 + prev2;
			prev1 = prev2;
			prev2 = current;
		}

		return prev2;
	}

	// An even faster and more optimized approach exists!
	// This solution has O(n) runtime but O(1) space complexity.
	// With each iteration through the for-loop, the (n%2) term toggles
	// between 0 and 1, allowing it to overwrite whichever one of the two
	// previous values is no longer needed in its ascent toward F_n.
	static int faster_fib(int n)
	{
		// an array of 2 elements
		int [] array = new int[2];

		array[0] = 0;
		array[1] = 1;

		for(int i = 2; i <= n; i++)
			array[i%2] = array[0] + array[1];

		return array[n%2];
	}

	public static void main(String [] args)
	{
		int n = Integer.parseInt(args[0]);

		// System.out.println("Array's length is: " + array(n));

		// System.out.println( "F(" + n + ") = " + fib(n) ); // O(2^n)

		// System.out.println( "F(" + n + ") = " + fib2(n) ); // O(n)

		// System.out.println( "F(" + n + ") = " + hooray_fib(n) );

		System.out.println( "F(" + n + ") = " + faster_fib(n) );
	}
}
