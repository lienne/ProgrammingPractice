import java.util.*;
import java.lang.*;

public class BinaryGap {

  // Solve using a while loop
  // This has best space complexity, since you're not storing the binary digits anywhere
  static void whileLoop() {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a decimal number to be converted to binary: ");

    int n = in.nextInt();

    int remainder = 0, counter = 0, maxStreak = 0;

    // You don't need to keep the digits if all you're doing is counting the 1's
    while(n != 0) {
      remainder = n % 2;

      if(remainder == 1) counter += 1;
      if(counter > maxStreak) maxStreak = counter;
      if(remainder == 0) counter = 0;

      n = n/2;
    }

    in.close();

    System.out.println("The maximum number of consecutive 1's in the binary representation of " + n + " is:");
    System.out.println(maxStreak);
  }

  // Solve using an Integer List and for loop
  // Kinda overkill but w/e
  // Lets you print out the binary number, so that's nice
  static void integerList() {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a decimal number to be converted to binary: ");

    int n = in.nextInt();

    List<Integer> binary = new ArrayList<Integer>();

    int remainder = 0, counter = 0, maxStreak = 0;

    while(n != 0) {
      binary.add(remainder = n % 2);
      n = n/2;
    }

    System.out.println("Your number's binary representation is: ");

    for(int i = binary.size() - 1; i >= 0; i--) {
      System.out.print(binary.get(i));
    }

    System.out.println();

    for(int i = 0; i < binary.size(); i++) {
      if(binary.get(i) == 1) counter += 1;
      if(counter > maxStreak) maxStreak = counter;
      if(binary.get(i) == 0) counter = 0;
    }

    in.close();

    System.out.println("The maximum number of consecutive 1's in the binary representation of " + n + " is:");
    System.out.println(maxStreak);
  }

  public static void main(String [] args) {

    // whileLoop();
    integerList();

  }
}
