import java.util.*;

public class StringOperations {

	// Abondoned!!!
	public static int stringSum(String s) {
		int len = s.length();
		int sum = 0;

		for(int i = 0; i < len; i += 2) {
			sum += Integer.parseInt(String.valueOf(s.charAt(i)));
		}

		return sum;
	}

	// Abondoned!!!! :(
	public static int stringMult(String s) {

		char [] charArray = s.toCharArray();
		List<Integer> bucket = new ArrayList<>();
		int len = charArray.length;
		int result = 0;

		// Subtract '0' from an integer char to get its integer value?

		for(int i = 1; i < len; i += 2) {

			if(charArray[i] == '*') {
				int mult = (Integer.parseInt(String.valueOf(charArray[i-1])) * Integer.parseInt(String.valueOf(charArray[i+1])));
				charArray[i+1] = (char) mult;
				// charArray[i+1] = (charArray[i-1] - '0') * (charArray[i+1] - '0');
			}

			if(charArray[i] == '+') {
				bucket.add(Integer.parseInt(String.valueOf(charArray[i-1])));
			}
		}

		bucket.add(Integer.parseInt(String.valueOf(charArray[len-1])));

		for(int i = 0; i < bucket.size(); i++) {
			result += bucket.get(i);
		}

		return result;
	}

	public static int stringParse(String s) {
		
	}


	public static void main(String [] args) {

		// String add1 = "1+9+3+4";
		// int add1Result = stringSum(add1);
		// System.out.println("Result of " + add1 + " is: " + add1Result);

		// String add2 = "1+2+1+1";
		// int add2Result = stringSum(add2);
		// System.out.println("Result of " + add2 + " is: " + add2Result);

		// String add3 = "1+15+4";
		// int add3Result = stringSum(add3);
		// System.out.println("Result of " + add3 + " is: " + add3Result);

		// String test = "2*2*2+3*5+2*4";
		// int testResult = stringMult(test);
		// System.out.println("Result of " + test + " is: " + testResult);

		// String mult1 = "1+2";
		// int mult1Result = stringMult(mult1);
		// System.out.println("Result of " + mult1 + " is: " + mult1Result);

		// String mult2 = "1+2+3";
		// int mult2Result = stringMult(mult2);
		// System.out.println("Result of " + mult2 + " is: " + mult2Result);

		// String mult3 = "1+2+3+4";
		// int mult3Result = stringMult(mult3);
		// System.out.println("Result of " + mult3 + " is: " + mult3Result);

		// String mult4 = "1*2";
		// int mult4Result = stringMult(mult4);
		// System.out.println("Result of " + mult4 + " is: " + mult4Result);


	}
}