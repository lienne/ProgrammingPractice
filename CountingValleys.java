import java.lang.*;
import java.util.*;

public class CountingValleys {
  static int countingValleys(String s) {
    int valleyCount = 0, elevation = 0; // # of valleys & current level

    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'U') elevation += 1;
      if(s.charAt(i) == 'D') elevation -= 1;

      // If we just came UP to sea level
      if(elevation == 0 && s.charAt(i) == 'U') valleyCount += 1;
    }

    return valleyCount;
  }

  public static void main(String [] args) {
    String s1 = "UDDDUDUU"; // should return 1
    String s2 = "DDUUDDUDUUUD"; // should return 2
    String s3 = "DDUU"; // should return 1
    String s4 = "UUDD"; // should return 0
    String s5 = "UUUUUUDDDDDD"; // should return 0
    String s6 = "UDDU"; // should return 1

    System.out.println("s1 = " + countingValleys(s1));
    System.out.println("s2 = " + countingValleys(s2));
    System.out.println("s3 = " + countingValleys(s3));
    System.out.println("s4 = " + countingValleys(s4));
    System.out.println("s4 = " + countingValleys(s5));
    System.out.println("s4 = " + countingValleys(s6));
  }
}
