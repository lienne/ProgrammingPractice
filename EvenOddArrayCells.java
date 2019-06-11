import java.util.*;

public class EvenOddArrayCells {
  public static void main(String [] args) {
    String s;
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // doesn't read EOL char

    for(int i = 0; i < n; i++) {
      s = in.next(); // reads complete next token

      for(int j = 0; j < s.length(); j += 2)
        System.out.print(s.charAt(j));

      System.out.print(" ");

      for(int j = 1; j < s.length(); j += 2)
        System.out.print(s.charAt(j));

      System.out.println();
    }

    in.close();
  }
}
