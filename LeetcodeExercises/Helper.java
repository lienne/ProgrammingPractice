

public class Helper {

	static int sum(int n) {
		if(n <= 0)
			return 0;

		return n + sum(n-1);
	}

	// ================================================================================================================================

	static int pairSumSequence(int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += pairSum(i, i+1);
		}

		return sum;
	}

	static int pairSum(int a, int b) {
		return a + b;
	}

	// ================================================================================================================================

	public static String stringX(String str) {
	  
		if(str.length() < 2) return str;
	  
	  	StringBuilder sb = new StringBuilder(str);
	  
	  	for(int i = 1; i < sb.length()-1; i++) {
	    	if(sb.charAt(i) == 'x') {
	    	  	sb.deleteCharAt(i);
	    	  	i--;
	    	}
	  	}
	  
		return sb.toString();
	  
	}

	// ================================================================================================================================
	
	public static void main(String [] args) {

		String removedX1 = stringX("abxcd");
		System.out.println(removedX1);

		String removedX2 = stringX("xabxcdx");
		System.out.println(removedX2);

		String removedX3 = stringX("xKittenx");
		System.out.println(removedX3);

		String removedX4 = stringX("xKxixtxtxexnx");
		System.out.println(removedX4);

		String removedX5 = stringX("xxKixxtxxtexxnxx");
		System.out.println(removedX5);

		String removedX6 = stringX("xx");
		System.out.println(removedX6);

		System.out.println();

		// =========================== ===========================

		int result = sum(4);

		System.out.println("Result of sum(int 4): " + result);
		System.out.println();

		// =========================== ===========================

		int result2 = pairSumSequence(4);

		System.out.println("Result of pairSumSequence(4): " + result2);
		System.out.println();

		// =========================== ===========================

		String str = "abcxxxgh";

		int len = str.length();

		System.out.println("Length of a string starts counting from 1, not zero! : " + len);
		System.out.println();

		// =========================== ===========================

		int [] nums = new int [] {1, 2, 3, 4, 5, 6, 7};

		// Will return address of head of array
		// System.out.println(nums);

		System.out.println("Printing out an array using a for loop: ");
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

		System.out.println();

		System.out.println("Printing out an array in the same line using a for loop: ");
		for(int i = 1; i < nums.length; i++) {
			System.out.print(nums[i-1] + ", ");
		}

		System.out.println(nums[nums.length-1]);

		System.out.println();

		// =========================== ===========================

		int nums2 [] = new int [] { 2,7,11,15 };
		int target = 9;

		// for(int i = 0; i < nums.length - 1; i++) {
  //           if(nums[i] + nums[i+1] == target) {
  //               int [] result = new int [] {i, i+1};
  //               return result;
  //           }
  //       }

		// =========================== ===========================

        String str2 = "hixxhi";

        int len2 = str2.length();
  
  		String last2 = str2.substring(len2 - 2, len2);

  		System.out.println("Last two characters of a string: " + last2);
  		System.out.println();

  		// =========================== ===========================

  		System.out.println("A - a: " + ('A' - 'a'));
  		System.out.println("a - A: " + ('a' - 'A'));

  		if('c' < 'a') {
  			System.out.println("c is less than a");
  		}
  		else if('c' > 'a') {
  			System.out.println("c is more than a");
  		}

  		System.out.println('A' + 'a');

  		System.out.println();

  		// =========================== ===========================

  		char[] s = new char [] {'h', 'e', 'l', 'l', 'o'};
  		char[] s1 = new char [] {'t', 'e', 'l', 'e', 'v', 'i', 's', 'i', 'o', 'n'};
  		int slen = s.length;
  		int s1len = s1.length;

  		for(int i = slen-1; i >= 0; i--) {
  			System.out.print(s[i] + " ");
  		}
  		System.out.println();

  		for(int i = s1len-1; i >= 0; i--) {
  			System.out.print(s1[i] + " ");
  		}
  		System.out.println();
  		System.out.println();

  		// =========================== ===========================

  		String halfReverse = "abcdefg";

  		char [] newString = new char[halfReverse.length()];
        for(int i = 0; i < halfReverse.length(); i++) {
            newString[i] = halfReverse.charAt(i);
        }

        System.out.println("Original string: " + halfReverse);
        System.out.println("Character array's head address: " + newString);
        System.out.print("New char array: ");
        for(int i = 0; i < newString.length; i++) {
        	System.out.print(newString[i]);
        }
        System.out.println();
	}
}