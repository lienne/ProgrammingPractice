import java.util.*;

public class ReverseArray {

  public static void main(String [] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // size of array
    int [] A = new int[n];

    for(int i = 0; i < n; i++) {
      A[i] = in.nextInt();
    }

    in.close();

    for(int j = n-1; j >= 0; j--) {
      System.out.print(A[j] + " ");
    }
}
