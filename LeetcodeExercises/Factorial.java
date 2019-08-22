import java.util.*;
import java.lang.*;

public class Factorial {

    public static int factorial(int n) {
        return (n == 0) ? 1 : (n * factorial(n-1));
    }

    public static void main(String [] args) {
        int result = factorial(5);

        System.out.println(result);
    }
}